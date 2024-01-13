package solved_ac_step.class2;
import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class S4_10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        Stack<Integer> stack = new Stack<>();

        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            //1. push
            if(str.equals("push"))
                stack.add(Integer.parseInt(st.nextToken()));
            //2. pop
            if(str.equals("pop")) {
                if (stack.isEmpty())
                    bw.write("-1\n");
                else
                    bw.write(stack.pop()+"\n");
            }
            //3. size
            if(str.equals("size"))
                bw.write(stack.size()+"\n");
            //4. empty
            if(str.equals("empty")) {
                if(stack.isEmpty())
                    bw.write("1\n");
                else
                    bw.write("0\n");
            }
            //5. top
            if(str.equals("top")) {
                if(stack.isEmpty())
                    bw.write("-1\n");
                else
                    bw.write(stack.peek()+"\n");
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
