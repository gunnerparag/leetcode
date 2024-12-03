import java.util.Stack;

public class ReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (isOperator(token)) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(applyOperator(a, b, token));
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    private int applyOperator(int a, int b, String operator) {
        switch (operator) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return a / b; // Integer division
            default: throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        ReversePolishNotation solution = new ReversePolishNotation();

        // Test case
        String[] tokens = {"2", "1", "+", "3", "*"};
        System.out.println("Result: " + solution.evalRPN(tokens)); // Output: 9

        tokens = new String[]{"4", "13", "5", "/", "+"};
        System.out.println("Result: " + solution.evalRPN(tokens)); // Output: 6

        tokens = new String[]{"10", "6", "9", "3", "/", "-", "*", "17", "+", "5", "+"};
        System.out.println("Result: " + solution.evalRPN(tokens)); // Output: 22
    }
}
