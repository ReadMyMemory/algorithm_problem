package solved_ac_step.class2;

import java.io.*;
import java.util.StringTokenizer;

public class S2_1654 {
    static long min = 1;
    static long max;
    static long mid, count;
    static int[] arr;
    static int K, N;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[K];
        for(int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if(max < arr[i])
                max = arr[i];
        }
        // while문에 min max 조건을 달아두었기 때문에 max는 min보다 무조건 1커야함.
        max++;
        ParametricSearch();
        bw.write(min-1+"");
        br.close();
        bw.close();
    }

    public static void ParametricSearch() {
        while(min < max) {
            mid = (min + max) >> 1;
            count = 0;
            for(int i = 0; i < arr.length; i++) {
                count += (arr[i] / mid);
            }

            if(count < N) // count가 필요 요구랑 랜선보다 낮다면
                max = mid; // max를 줄인다.
            else // 크거나 같다면
                min = mid + 1; // 최소 길이를 늘린다.
        }
    }

    // 틀린 원인 분석
    /*
    2개의 랜선이 주어지고, 2개의 랜선를 뽑고, 랜선의 길이가 1 1 이었다면
    min을 0으로 두고 max는 랜선 길이 중 가장 큰 값을 두니 1이 될건데
    mid = (min + max) >> 1 과정에서 mid가 0이 된다.
    이때 mid가 0이면 반복문을 걍 탈출해버리게 짰었는데
    차라리 그렇게 탈출해버릴거면 출력에서 min-1을 해버리니까 0이 출력된다.
    길이가 0일 수는 없는 법이다.
    그래서 min을 1로 줬다. 그러면 0으로 나눌 일이 없어진다.

    두번째 min과 max가 같아지는 경우에
    조건문을 돌지 않아 발생하는 문제다.
    while 조건에 min < max을 달았는데 min을 아까 1로 줬는데
    아까랑 같이 랜선의 길이가 1 1이라면
    max랑 같아지면서 조건문을 안돈다.
    그건 이제 max를 갱신하면서 마지막에 1을 더해주면 해결된다.
    min은 0으로 두어도 되고 1로 두어도 되지만
    1로 두는 것이 좀 더 직관적이다.
     */
}
