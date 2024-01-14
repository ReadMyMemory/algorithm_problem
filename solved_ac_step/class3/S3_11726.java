package solved_ac_step.class3;
import java.io.*;

public class S3_11726 {
    static int value;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 2 x n 직사각형
        // 2 x 2의 경우엔 일자 2개를 놓아도 되고, 눞혀서 놔도 되고
        // 가로 2인 블록, 가로 1인 블럭 이렇게 생각해야 할 거 같음.
        // 직접 세보면서 경우를 보자.
        // 1은 1 2는 2
        // 3 = 2 + 1 // 2가지
        // 3 = 1 + 1 + 1 // 1가지
        // 3
        // 4 = 2 + 2 // 1가지
        // 4 = 2 + 1 + 1 // 3C1
        // 4 = 1 + 1 + 1 + 1 // 1가지
        // 5
        // 5 = 2 + 2 + 1 // 3C2
        // 5 = 2 + 1 + 1 + 1 // 4C1
        // 5 = 1 + 1 + 1 + 1 + 1 // 1가지
        //8
        // 6 = 2 + 2 + 2 // 1가지
        // 6 = 2 + 2 + 1 + 1 // 4C2
        // 6 = 2 + 1 + 1 + 1 + 1 // 5C1
        // 6 = 1 + 1 + 1 + 1 + 1 + 1 // 1가지
        //1 + 6 + 5 + 1 = 13
        // 7 = 2 + 2 + 2 + 1 // 4C1
        // 7 = 2 + 2 + 1 + 1 + 1 // 5C2
        // 7 = 2 + 1 + 1 + 1 + 1 + 1 // 6C1
        // 7 = 1 + ... + 1 // 1
        //21
        //피보나치 수열의 규칙이 보인다.
        int n = Integer.parseInt(br.readLine());
        //16384, 32768, 65536, 131072, 262144 정도...
        //6377, 2747, 5494, 981
        //이전 나머지 x2를 한다음, 10007이 넘는 경우 10007로 나눠주면 되는 것이다.
        value = fibonacci(n);
        System.out.println(value);

    }
    // 재귀는 시간초과난다.
//    static int fibonacci(int a) {
//        if(a == 1)
//            return 1;
//        else if(a == 2)
//            return 2;
//        else
//            return fibonacci(a-1) + fibonacci(a-2);
//    }
    // 따라서 dp를 사용해야 할듯
    static int fibonacci(int a) {
        int[] result = new int[a + 3];
        result[1] = 1;
        result[2] = 2;
        for(int i = 3; i <= a; i++) {
            result[i] = result[i-2] + result[i-1];
            if(result[i] >= 10007)
                result[i] = result[i] % 10007;
        }
        return result[a];
    }
}
