package solved.bronze.B1;
import java.io.*;

/*
Integer.parseInt(String s, int radix)
Integer.toBinaryString(int i)
Integer.toOctalString(int i)
같은게 있지만 결국 못쓰는 이유는 값 제한이 100만자리여서다.
Long.parseLong()도 64비트까지라서 불가능하니까.
직접 3자리씩 끊어서 변환할 것.
*/

public class B1_1373 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String binary = br.readLine();

        // 2진수를 3자리씩 끊어서 8진수로 변환하기 위해 앞쪽에 0을 추가
        int len = binary.length();
        int pad = (3 - len % 3) % 3; // 앞에 붙일 0의 개수
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < pad; i++) {
            sb.append("0");
        }
        sb.append(binary);
        binary = sb.toString();

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < binary.length(); i += 3) {
            String chunk = binary.substring(i, i + 3);
            int octalDigit = Integer.parseInt(chunk, 2);
            result.append(octalDigit);
        }

        System.out.println(result.toString());
    }
}
