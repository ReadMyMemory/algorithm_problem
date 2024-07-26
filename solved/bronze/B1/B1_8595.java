package solved.bronze.B1;
import java.io.*;

public class B1_8595 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int length = Integer.parseInt(br.readLine());
        String word = br.readLine();
        long sum = 0; // 답이 int 범위를 넘을 수 있기에, int -> long으로 변경
        for(int i = 0; i < length; i++) {
            int c = word.charAt(i) - '0';
            if(c <= 9) // c의 값에서 아스키코드 값이 80인 0을 빼는 것과 같아서, 0~9 값이 나오면 된다.
                sb.append(c);
            else {
                if(sb.length() != 0) { // stringbuilder가 비어있는 경우, 즉 히든 넘버가 나오는 순간이 아닌 그냥 알파벳이 나오는 경우를 체크
                    sum += Integer.parseInt(sb.toString());
                    sb.setLength(0); // stringbuilder 초기화
                }
            }
        }
        /* 마지막이 숫자로 끝날 때 처리를 추가 */
        if(sb.length() != 0)
            sum += Integer.parseInt(sb.toString());

        System.out.println(sum);
    }
}
