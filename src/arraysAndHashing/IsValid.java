package arraysAndHashing;

import java.util.Stack;

public class IsValid {

    // Not valid all test case
    public boolean isValid(String s) {
        StringBuilder sb = new StringBuilder();
        if (s.length() % 2 != 0) {
            return false;
        }
        String result;
        for (int i = 0; i < s.length() - 1; i++) {
            sb.append(s.charAt(i));
            sb.append(s.charAt(i + 1));
            result = sb.toString();
            if (!checkValid(result)) {
                return false;
            }
            sb.delete(0, 2);
            i = i + 1;
        }
        return true;
    }

    private boolean checkValid(String result) {
        switch (result) {
            case "[]":
                return true;
            case "{}":
                return true;
            case "()":
                return true;
            default:
                return false;
        }
    }

    //Copy best solution
    public boolean isValidV2(String s) {
        Stack<Character> stack = new Stack<Character>(); // create an empty stack
        for (char c : s.toCharArray()) { // loop through each character in the string
            if (c == '(') // if the character is an opening parenthesis
                stack.push(')'); // push the corresponding closing parenthesis onto the stack
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c) // if the character is a closing bracket
                // if the stack is empty (i.e., there is no matching opening bracket) or the top of the stack
                // does not match the closing bracket, the string is not valid, so return false
                return false;
        }
        // if the stack is empty, all opening brackets have been matched with their corresponding closing brackets,
        // so the string is valid, otherwise, there are unmatched opening brackets, so return false
        return stack.isEmpty();
    }

    public boolean isValidV3(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (stack.isEmpty() || c == ')' && stack.pop() != '(' || c == '}' && stack.pop() != '{' || c == ']' && stack.pop() != '[') {
                return false;
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        IsValid isValid = new IsValid();
        System.out.println(isValid.isValid("()"));
        System.out.println(isValid.isValid("()[]{}"));
        System.out.println(isValid.isValid("()(]{}"));
        System.out.println(isValid.isValid("(]"));
        System.out.println(isValid.isValid("([)]"));
        System.out.println(isValid.isValid("{[]}"));
        System.out.println(isValid.isValidV2("()"));
        System.out.println(isValid.isValidV2("()[]{}"));
        System.out.println(isValid.isValidV2("()(]{}"));
        System.out.println(isValid.isValidV2("(]"));
        System.out.println(isValid.isValidV2("([)]"));
        System.out.println(isValid.isValidV2("{[]}"));
    }
}
