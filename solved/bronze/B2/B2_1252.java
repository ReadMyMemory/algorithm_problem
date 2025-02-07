package solved.bronze.B2;

import java.io.*;
import java.math.BigInteger;

public class B2_1252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        // 입력받은 이진수를 BigInteger로 변환하여 덧셈 수행
        BigInteger binary1 = new BigInteger(input[0], 2);
        BigInteger binary2 = new BigInteger(input[1], 2);
        BigInteger sum = binary1.add(binary2);

        // 결과를 이진수로 변환하여 출력
        System.out.println(sum.toString(2));
    }
}

