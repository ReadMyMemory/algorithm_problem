package solved.silver;
import java.io.*;
public class S5_1475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        int[] numbers = new int[10]; //0 ~ 9 10개 숫자 사용한 횟수 입력받기.
        for(int i = 0; i < N.length(); i++) {
            int temp = N.charAt(i) - '0';
            numbers[temp]++;
        }
        int addValue = numbers[6] + numbers[9]; // 6이나 9는 돌려서 서로 대신 사용 가능하다. 그걸 처리하기 위함.
        if(addValue != 0) { // 0을 나눌 수는 없다. 예외 처리
            if(addValue % 2 == 0)
                numbers[6] = addValue / 2;
            else
                numbers[6] = addValue / 2 + 1; // 2로 나누어지지 않는다면, 예를 들어 addValue = 3이었다면, 2세트를 사용한거니까 2로 나눈 값이 1을 더한다.
        }
        int max = 0;
        for(int i = 0; i <= 8; i++) {
            if(max < numbers[i])
                max = numbers[i];

        }
        System.out.println(max);
    }
}
