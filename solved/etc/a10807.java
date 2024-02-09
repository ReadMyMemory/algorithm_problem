package solved.etc;

import java.util.*;
import java.io.*;

// use Scanner
/*public class solved.etc.a10807 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int Count = 0; // 일치하는 숫자 개수 기록용 변수
        int N = sc.nextInt(); // 입력되는 숫자의 개수를 저장하는 변수
        int[] arr = new int[N];// 입력되는 숫자를 저장하기 위한 배열

        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        };

        int matchNum = sc.nextInt(); // ? 와 일치하는 숫자를 찾아주세요의 ? 입력받기

        for (int j = 0; j < N; j++) {
            if(arr[j] == matchNum) Count++;
        };

        System.out.println(Count);
    }
}*/

// use bufferReader
public class a10807 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;
        int mount = Integer.parseInt(br.readLine());
        String s1 = br.readLine();
        StringTokenizer st = new StringTokenizer(s1);
        int[] arr = new int[mount];
        for(int i = 0; i < mount; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int num1 = Integer.parseInt(br.readLine());
        for(int j = 0; j < mount; j++) {
            if(arr[j] == num1) count++;
        };
        System.out.println(count);
    }
    }