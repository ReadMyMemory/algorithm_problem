package solved_ac_step.class2;
import java.io.*;
import java.util.Stack;

public class S4_4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //괄호 판별의 경우 스택을 쓰면 편리하다.
        while (true) {
            String str = br.readLine();
            boolean status = true;
            Stack<String> stack = new Stack<>();
            if(str.equals(".")) // 반복문 탈출조건, 문장의 끝
                break;

            for(int i = 0; i < str.length(); i++) {
                String s = String.valueOf(str.charAt(i));
                if(s.equals("(") || s.equals("["))
                    stack.add(s);
                if(s.equals(")")) {
                    if(stack.isEmpty()) { // 닫힌 괄호가 들어왔는데 큐가 비어있다. = 균형 X
                        status = false;
                        break;
                    }
                    if(!(stack.peek()).equals("(")) { // 마지막으로 열린 괄호가 들어온 괄호와 종류가 다르다. = 균형 X
                        status = false;
                        break;
                    } else {
                        stack.pop(); // 같다면, pop
                    }
                }
                if(s.equals("]")) {
                    if(stack.isEmpty()) { // 닫힌 괄호가 들어왔는데 큐가 비어있다. = 균형 X
                        status = false;
                        break;
                    }
                    if(!(stack.peek()).equals("[")) { // 마지막으로 열린 괄호가 들어온 괄호와 종류가 다르다. = 균형 X
                        status = false;
                        break;
                    } else {
                        stack.pop(); // 같다면, pop
                    }
                }
            }
            //반복문이 끝났는데 스택이 비어있지 않다면, 열린 괄호가 남아있다는 뜻. 빼먹지 않도록 주의.
            if(!stack.isEmpty()) status = false;

            if(status)
                System.out.println("yes");
            else
                System.out.println("no");
        }
    }
}
