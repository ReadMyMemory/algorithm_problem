package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class S4_11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();
        int n = Integer.parseInt(num);
        int sum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());

        //ArrayList를 사용
//        ArrayList<Integer> arr = new ArrayList<Integer>();
//        for(int i = 0; i<n; i++) {
//            arr.add(Integer.parseInt(st.nextToken()));
//        }
//        Collections.sort(arr);
//        for(int j = 0; j < n; j++) {
//            sum = sum + arr.get(j) * (n-j);
//        }

        //그냥 배열 사용
        int[] arr = new int[n];
        for(int i = 0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        for(int j = 0; j < n; j++) {
            sum = sum + arr[j] * (n-j);
        }
        System.out.println(sum);
    }
}
