package solved.silver;
import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

public class S5_1417 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        int daSom = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());

        while(number --> 1) // 다솜이는 미리 입력받았으니, 하나 덜 입력받기.
            q.add(Integer.parseInt(br.readLine()));
        int vote = 0;
        while(!q.isEmpty() && q.peek() >= daSom) {
            vote++;
            daSom++;
            q.add(q.poll()-1); // 최대값 찾아서 하나 빼고 다시 넣기.
        }
        System.out.println(vote);
    }
}
