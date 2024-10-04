package solved.bronze.B3;
import java.io.*;
import java.util.StringTokenizer;

/*
근의 공식을 사용하면 될 것 같고, 중근 판단은 b^2 - 4ac가 0인지를 판단하면 된다. 참고로 a = 1고정이므로,
4A * A - 4 * B 를 4로 묶으면
A * A - B가 0인지를 판단하면 된다.
물론, 그냥 근을 두개 구하고 같으면 하나만 출력, 다르면 둘 다 출력해도 된다.

 */
public class B3_17945 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //입력부
        int A = 2 * Integer.parseInt(st.nextToken()); // 편의상 2A로 받았다.
        int B = Integer.parseInt(st.nextToken());

        //연산부
        int x_1 = (int) (-A + Math.sqrt(A * A - 4 * B)) / 2; // 근이 정수임을 문제에서 보장받았기 때문에 int로 강제 형변환 해도 문제없다.
        int x_2 = (int) (-A - Math.sqrt(A * A - 4 * B)) / 2; // 같은 이유.

        //출력부
        if(x_1 == x_2)
            System.out.println(x_1);
        else
            System.out.println(Math.min(x_1, x_2) + " " + Math.max(x_1, x_2));

        br.close();
    }
}
