package services;

import java.util.HashMap;
import java.util.Map;

public class Expense {
    Map<String, Map<String, Double>> expenseRecord;

    public Expense() {
        expenseRecord = new HashMap<>();
    }

    public Map<String, Map<String, Double>> getexpenseRecord() {
        return expenseRecord;
    }
}
