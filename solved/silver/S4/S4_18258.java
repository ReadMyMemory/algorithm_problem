package solved.silver.S4;
import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class S4_18258 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        Deque<Integer> queue = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            //1. push
            if(str.equals("push"))
                queue.add(Integer.parseInt(st.nextToken()));
            //2. pop
            if(str.equals("pop")) {
                if (queue.isEmpty())
                    bw.write("-1\n");
                else
                    bw.write(queue.poll()+"\n");
            }
            //3. size
            if(str.equals("size"))
                bw.write(queue.size()+"\n");
            //4. empty
            if(str.equals("empty")) {
                if(queue.isEmpty())
                    bw.write("1\n");
                else
                    bw.write("0\n");
            }
            //5. front
            if(str.equals("front")) {
                if(queue.isEmpty())
                    bw.write("-1\n");
                else
                    bw.write(queue.peekFirst()+"\n");
            }
            //6. back
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
