package solved_ac_step.class2;
import java.io.*;
import java.util.Stack;

public class S4_9012 {
    static boolean status;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        /* 아이디어
        괄호 닫기와 같은 문제는 스택으로 풀면 편하다. 선입후출의 방식이라 처음에 넣은 괄호가 닫는 괄호가 나올 때마다 제거.
        string을 다 읽었는데 스택에 (가 남아있거나,
        스택이 비어있는데 )를 string에서 읽었다면 NO다.
         */
        int number = Integer.parseInt(br.readLine());

        while(number > 0) {
            status = true;
            Stack<String> stack = new Stack<>();
            String str = br.readLine();
            for(int i = 0; i < str.length(); i++) {
                String temp = String.valueOf(str.charAt(i));
                if(temp.equals("("))
                    stack.add("("); // stack에 ( 하나 add
                if(temp.equals(")")) {
                    if(stack.isEmpty()) {// 스택이 비어있다 = 괄호가 제대로 닫히지 않았다.
                        status = false;
                        break;
                    }
                    else
                        stack.pop(); // 맨 위의 ( 하나 pop
                }
            }
            if(!stack.isEmpty()) // 스택이 비어있지 않다. ( 가 남아있어 닫히지 않은 괄호가 존재.
                status = false;
            if(status)
                bw.write("YES\n");
            else
                bw.write("NO\n");
            number--;
        }
        bw.flush();
        br.close();
        bw.close();

    }
}
