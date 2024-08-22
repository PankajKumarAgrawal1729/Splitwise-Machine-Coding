package services;

import java.util.HashMap;
import java.util.Map;

public class EqualExpense {
    public void updateExpenseData(Expense expense, String expendii, double expendAmount, int totalUser,
            String[] owesUser) {
        Map<String, Map<String, Double>> expenseRecord = expense.getexpenseRecord();
        double distributedAmount = expendAmount / totalUser;

        if (!expenseRecord.containsKey(expendii)) {
            expenseRecord.put(expendii, new HashMap<>());
        }
        for (String userId : owesUser) {
            if (!userId.equals(expendii)) {
                double amount = expenseRecord.get(expendii).getOrDefault(userId, 0.0) + distributedAmount;
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