package solved.silver;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

public class S2_11279 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder()); // Collections.reverseOrder() 조건 넣어 내림차순 정렬.
        while(num > 0) {
            int value = Integer.parseInt(br.readLine());
            if(value == 0) {
                if(priorityQueue.isEmpty()) {
                    bw.write(0+"\n");
                } else {
                    bw.write(priorityQueue.poll()+"\n");
                }
            } else {
                priorityQueue.add(value);
            }
            num--;
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
