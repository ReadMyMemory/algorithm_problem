package solved.silver.S2;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;


public class S2_1927 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
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
