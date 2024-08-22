package services;

import java.util.HashMap;
import java.util.Map;

public class ExactExpense {
    public void updateExpenseData(Expense expense, String expendii, double expendAmount, int totalUser,
            String[] owesUser, String[] owesAmount) {
        Map<String, Map<String, Double>> expenseRecord = expense.getexpenseRecord();
        double[] distributedAmount = new double[totalUser];
        double sum = 0;
        for(int i = 0; i < totalUser; i++){
            double value = Double.parseDouble(owesAmount[i]);
            sum += value;
            distributedAmount[i] = value;
        }

        if(sum != expendAmount){
            System.out.println("Expense Distribution is not correct. Check again");
            return;
        }


        if (!expenseRecord.containsKey(expendii)) {
            expenseRecord.put(expendii, new HashMap<>());
        }
        for (int i = 0; i < totalUser; i++) {
            String userId = owesUser[i];
            if (!userId.equals(expendii)) {
                double amount = expenseRecord.get(expendii).getOrDefault(userId, 0.0) + distributedAmount[i];
                double remainAmount = expenseRecord.containsKey(userId)
                        ? expenseRecord.get(userId).getOrDefault(expendii, 0.0)
                        : 0.0;
                if (remainAmount > amount) {
                    expenseRecord.get(userId).put(expendii, remainAmount - amount);
                } else {
                    if (expenseRecord.containsKey(userId))
                        expenseRecord.get(userId).put(expendii, 0.0);
                    expenseRecord.get(expendii).put(userId, amount - remainAmount);
                }
            }
        }
    }
}
