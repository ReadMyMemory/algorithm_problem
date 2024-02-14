package solved.silver;
import java.io.*;
import java.util.Arrays;

public class S4_2217 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        int[] rope = new int[count];
        for(int i = 0; i < count; i++)
            rope[i] = Integer.parseInt(br.readLine());
        Arrays.sort(rope); // 오름차순 정렬
        int max = 0;
        for(int i = 0; i < count; i++) {
            if(max < rope[i] * (count - i)) // 병렬 처리에서 최대 중량 찾기. 본인보다 큰 로프 개수끼리만 병렬연결
                max = rope[i] * (count - i);
        }
        System.out.println(max);
    }
}
