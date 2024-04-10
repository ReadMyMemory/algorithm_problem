package solved.bronze;
import java.io.*;
public class B4_11948 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int min = 101;
        int sum = 0;

        //일단 물 화 생 지 점수를 받아서 4개 중 제일 낮은 과목 점수 저장하구 다 더한다.
        for(int i = 0; i < 4; i++) {
            int temp = Integer.parseInt(br.readLine());
            if(min > temp)
                min = temp;
            sum += temp;
        }

        //제일 낮은 과목 점수 하나 뺀다.
        sum -= min;

        //역사 지리 중 높은 점수 더한다.
        sum += Math.max(Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine()));

        //점수 출력
        System.out.println(sum);
    }
}
