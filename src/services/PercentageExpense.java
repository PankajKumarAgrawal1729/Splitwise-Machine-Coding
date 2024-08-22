package services;

import java.util.HashMap;
import java.util.Map;

public class PercentageExpense {
    public void updateExpenseData(Expense expense, String expendii, double expendAmount, int totalUser,
            String[] owesUser, String[] owesAmountPercentage) {
        Map<String, Map<String, Double>> expenseRecord = expense.getexpenseRecord();
        int[] distributedAmountPercentage = new int[totalUser];
        int sum = 0;
        for(int i = 0; i < totalUser; i++){
            int value = Integer.parseInt(owesAmountPercentage[i]);
            sum += value;
            distributedAmountPercentage[i] = value;
        }

        if(sum != 100){
            System.out.println("Expense Distribution Percentage is not correct. Check again");
            return;
        }


        if (!expenseRecord.containsKey(expendii)) {
            expenseRecord.put(expendii, new HashMap<>());
        }
        for (int i = 0; i < totalUser; i++) {
            String userId = owesUser[i];
            if (!userId.equals(expendii)) {
                double amount = expenseRecord.get(expendii).getOrDefault(userId, 0.0) + ((expendAmount * distributedAmountPercentage[i]) / 100);
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
