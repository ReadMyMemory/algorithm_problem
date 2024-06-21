package solved.bronze.B3;
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B3_1267 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int youngSikSum = 0;
        int minSikSum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()) {
            int temp = Integer.parseInt(st.nextToken());
            //영식 요금제
            youngSikSum += (temp / 30 * 10) + 10;
            //민식 요금제
            minSikSum += (temp / 60 * 15) + 15;
        }

        if(youngSikSum == minSikSum)
            sb.append("Y ").append("M ").append(youngSikSum);
        else if(youngSikSum > minSikSum)
            sb.append("M ").append(minSikSum);
        else
            sb.append("Y ").append(youngSikSum);

        System.out.println(sb.toString());
    }
}
