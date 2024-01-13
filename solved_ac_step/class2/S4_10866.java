package solved_ac_step.class2;
import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class S4_10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        Deque<Integer> queue = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            //1. push_front
            if(str.equals("push_front"))
                queue.addFirst(Integer.parseInt(st.nextToken()));
            //2. push_back
            if(str.equals("push_back"))
                queue.addLast(Integer.parseInt(st.nextToken()));
            //3. pop_front
            if(str.equals("pop_front")) {
                if (queue.isEmpty())
                    bw.write("-1\n");
                else
                    bw.write(queue.pollFirst()+"\n");
            }
            //4. pop_back
            if(str.equals("pop_back")) {
                if (queue.isEmpty())
                    bw.write("-1\n");
                else
                    bw.write(queue.pollLast()+"\n");
            }
            //5. size
            if(str.equals("size"))
                bw.write(queue.size()+"\n");
            //6. empty
            if(str.equals("empty")) {
                if(queue.isEmpty())
                    bw.write("1\n");
                else
                    bw.write("0\n");
            }
            //7. front
            if(str.equals("front")) {
                if(queue.isEmpty())
                    bw.write("-1\n");
                else
                    bw.write(queue.peekFirst()+"\n");
            }
            //8. back
            if(str.equals("back")) {
                if(queue.isEmpty())
                    bw.write("-1\n");
                else
                    bw.write(queue.peekLast()+"\n");
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
