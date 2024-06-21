package solved.bronze.B4;
import java.io.*;

public class B4_10808 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        int[] arr = new int[26]; // a~z를 0~25로

        for(int i = 0; i < str.length(); i++) {
            arr[str.charAt(i) - 'a']++; // a의 아스키 코드 값을 빼서 index 찾음.
        }

        for(int a : arr)
            bw.write(a+" ");

        bw.flush();
        br.close();
        bw.close();
    }
}
