package class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class a1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] arr = new int[26]; // 알파벳 카운트 배열
        for(int i = 0; i < s.length(); i++) {
            if(123 > (int) s.charAt(i) && (int) s.charAt(i) > 96) { // 소문자를 아스키 코드 변환
                arr[(int) s.charAt(i) - 97] += 1;
            } else if(64 < (int) s.charAt(i) && (int) s.charAt(i) < 91) { // 대문자를 아스키 코드 변환
                arr[(int) s.charAt(i) - 65] += 1;
            } else
                continue;
        }

        // 최댓값 찾기
        int max = arr[0];
        int maxindex = 0;
        for(int i = 1; i < 26; i++) {
            if(arr[i] > max)
                max = arr[i];
        }
        int count = 0;
        // 최댓값이 여러 개인지 확인
        for(int i = 0; i < 26; i++) {
            if(max == arr[i]) {
                maxindex = i;
                count++;
            }
        }
        if(count >= 2)
            System.out.println("?");
        else
            System.out.println((char) (maxindex + 65));
    }
}
