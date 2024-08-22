package services;

import java.util.Map;

import model.User;

/**
 * ShowForSingleUser
 */
public class ShowForSingleUser {
    public void show(Expense expense, User user, String userId) {
        Map<String, Map<String, Double>> expenseRecord = expense.getexpenseRecord();
        User[] users = user.getUsers();
        boolean isExpensionDataAvailable = false;

        for (User payer : users) {
            String userName = payer.getName(); // user1 
            String payerId = payer.getUserId(); // u1
            if (expenseRecord.containsKey(payerId)) {
                Map<String, Double> expenseData = expenseRecord.get(payerId);
                for (User owes : users) {
                    String owesId = owes.getUserId(); // u1 u2
                    if (payerId.equals(userId)) {
                        if (expenseData.containsKey(owesId) && expenseData.get(owesId) > 0) {
                            System.out.println(owes.getName() + " owes " + userName + ": " + expenseData.get(owesId));
                            isExpensionDataAvailable = true;
                        }
                    }else if(owesId.equals(userId)){
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