package solved_ac_step.class2;
import java.io.*;
import java.util.Stack;

public class S4_10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //선입 후출의 방식을 사용하면 매우 쉬워보인다.
        //stack을 사용하면 될듯
        Stack<Integer> stack = new Stack<>();
        int K = Integer.parseInt(br.readLine());
        for(int i = 0; i < K; i++) {
            int value = Integer.parseInt(br.readLine());
            if(value == 0) // 설마 아무것도 입력 안한 상태에서
                stack.pop();
            else
                stack.add(value);
        }

        int sum = 0;
        while(!stack.isEmpty()) {
            sum += stack.pop();
        }
        System.out.println(sum);
    }
}
