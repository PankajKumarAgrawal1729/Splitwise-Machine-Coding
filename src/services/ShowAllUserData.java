package services;

import java.util.Map;

import model.User;

public class ShowAllUserData{
    public void show(Expense expense, User user) {
        Map<String, Map<String, Double>> expenseRecord = expense.getexpenseRecord();
        User[] users = user.getUsers();
        boolean isExpensionDataAvailable = false;

        for (User payer : users) {
            String userName = payer.getName();
            String userId = payer.getUserId();
            if (expenseRecord.containsKey(userId)) {
                Map<String, Double> expenseData = expenseRecord.get(userId);
                for (User owes : users) {
                    String owesId = owes.getUserId();
                    if (expenseData.containsKey(owesId) && expenseData.get(owesId) > 0) {
                        System.out.println(owes.getName() + " owes " + userName + ": " + expenseData.get(owesId));
                        isExpensionDataAvailable = true;
                    }
                }
            }
        }
        if(!isExpensionDataAvailable){
            System.out.println("No balances");
        }
    }

}