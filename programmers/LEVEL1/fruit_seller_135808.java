package programmers.LEVEL1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class fruit_seller_135808 {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        int size = score.length;

        Arrays.sort(score); // 오름차순 정렬

        int i = 0;
        while(size - m >= i) {
            int[] temp = new int[m];

            for(int p = 0; p < m; p++) // 상자에서 최솟값을 찾기 위한 배열 입력.
                temp[p] = score[size-i-p-1];

            Arrays.sort(temp); // 오름차순 정렬로 최솟값은 가장 앞에 위치할 것.

            answer += temp[0] * m;
            i+=m;
        }
        return answer;
    }
    /* 테스트용, 필요시 solution을 static으로 변경하시오
    public static void main(String[] args) {
        int k = 3;
        int m = 4;
        int[] arr = new int[7];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;
        arr[3] = 1;
        arr[4] = 2;
        arr[5] = 3;
        arr[6] = 1;
        System.out.println(solution(k, m, arr));

    }
    */
}
