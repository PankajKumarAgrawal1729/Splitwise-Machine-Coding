import java.util.Arrays;
import java.util.Scanner;

import model.User;
import services.EqualExpense;
import services.ExactExpense;
import services.Expense;
import services.PercentageExpense;
import services.ShowAllUserData;
import services.ShowForSingleUser;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        User user1 = new User("u1", "user1");
        User user2 = new User("u2", "user2");
        User user3 = new User("u3", "user3");
        User user4 = new User("u4", "user4");

        User[] users = new User[] { user1, user2, user3, user4 };
        User user = new User();
        user.setUsers(users);
        ShowAllUserData showAllUserData = new ShowAllUserData();
        ShowForSingleUser showForSingleUser = new ShowForSingleUser();
        Expense expense = new Expense();
        EqualExpense equalExpense = new EqualExpense();
        ExactExpense exactExpense = new ExactExpense();
        PercentageExpense percentageExpense = new PercentageExpense();

        boolean appOpen = true;

        while (appOpen) {
            String[] operation = sc.nextLine().split(" ");
            if (operation[0].equals("SHOW")) {
                if (operation.length > 1) {
                    showForSingleUser.show(expense, user, operation[1]);
                } else {
                    showAllUserData.show(expense, user);
                }
            } else if (operation[0].equals("EXPENSE")) {
                int numberOfUser = Integer.parseInt(operation[3]);
                String expenseType = operation[3 + numberOfUser + 1];
                double expendAmount = Double.parseDouble(operation[2]);
                int totalUser = Integer.parseInt(operation[3]);
                if (expenseType.equals("EQUAL")) {
                    equalExpense.updateExpenseData(expense, operation[1], expendAmount, totalUser,
                            Arrays.copyOfRange(operation, 4, 4 + numberOfUser));
                } else if (expenseType.equals("EXACT")) {
                    exactExpense.updateExpenseData(expense, operation[1], expendAmount, totalUser,
                            Arrays.copyOfRange(operation, 4, 4 + numberOfUser),
                            Arrays.copyOfRange(operation, 4 + numberOfUser + 1, operation.length));
                } else {
                    percentageExpense.updateExpenseData(expense, operation[1], expendAmount, totalUser,
                            Arrays.copyOfRange(operation, 4, 4 + numberOfUser),
                            Arrays.copyOfRange(operation, 4 + numberOfUser + 1, operation.length));
                }
            } else {
                sc.close();
                appOpen = false;
                System.out.println("Thanks for using  our Service!!");
            }
        }
    }
}