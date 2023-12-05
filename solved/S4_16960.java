package solved;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S4_16960 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 스위치의 개수
        int M = Integer.parseInt(st.nextToken()); // 램프의 개수

        boolean[][] arr = new boolean[N+1][M+1]; // 전등과 스위치 관계 기록용
        for (boolean[] row1 : arr) { // 2차원 배열 각각 값 false로 초기화
            Arrays.fill(row1, false);
        }
        int[] light = new int[M+1]; // 램프 다 켤 수 있는지 여부 확인용



        //전등과 스위치 관계 입력
        for(int i =1; i <= N; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int trash = Integer.parseInt(st2.nextToken()); // 스위치에 연결된 전등 개수라는데 필요없음.
            while(st2.hasMoreTokens()) {
                int num = Integer.parseInt(st2.nextToken());
                //이해하기 쉽게 1번부터 배열 입력 받기.
                arr[i][num] = true;
                light[num]++; //스위치와 전등 누적 합연산
            }
        }





        int index = 0;
        boolean exit = false;
        while(index < N) {
            index++;// ex. 1번 스위치를 켜지 않는다.
            for(int p =1; p<=M; p++) { // ex. 1번 스위치를 안켰으니, 관련된 전등 끄기
                if (arr[index][p]) {
                    light[p]--;
                }
            }
                //조건 확인. 그래도 모든 전등을 켤 수 있는가?
                for(int j = 1; j <= M; j++) {
                    if(light[j] == 0)
                        break;
                    if(j==M) // break 되지 않고 모든 조건 통과. 0인 곳이 없음.
                        exit = true;
                }
                if(exit)  // 스위치를 n-1만 해도 모든 전등이 켜지는 것을 확인. 반복문 탈출
                    break;
                else {
                    for(int q =1; q<=M; q++) { // 뺀거 다시 복구. index 올려서 다시 체크해야지.
                        if(arr[index][q]) {
                            light[q]++;
                        }
                }
            }
            //모든 전등 켤 수 있는가 확인

        }
        if(exit) // exit = true 라는건 n-1 개의 스위치 켰음에도 전등 다 켜짐.
            bw.write(1+" ");
        else
            bw.write(0+" ");

        bw.flush();
        br.close();
        bw.close();
    }
}
