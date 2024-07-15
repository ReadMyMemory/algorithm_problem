package programmers.LEVEL1;
import java.util.*;
public class valid_parentheses_12909 {
    public boolean solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(c);
            else {
                if (stack.isEmpty() || stack.pop() != '(')
                    return false;
            }
        }
        return stack.isEmpty();
    }
    }
