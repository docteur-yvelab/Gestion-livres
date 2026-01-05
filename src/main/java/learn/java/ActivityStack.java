package learn.java;

import java.util.ArrayList;
import java.util.List;

public class ActivityStack {
    private List<String> stack = new ArrayList<>();

    public void push(String activity) {
        stack.add(activity);
    }

    public String pop() {
        if (!stack.isEmpty()) {
            return stack.remove(stack.size() - 1);
        }
        return "Aucune activité.";
    }

    public List<String> getAll() {
        return new ArrayList<>(stack);
    }
}
