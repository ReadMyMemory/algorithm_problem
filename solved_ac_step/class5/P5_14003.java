package solved_ac_step.class5;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
처음에 이거 왜 플래티넘일까 생각해봤다.
보니까 가장 긴 증가하는 부분 수열의 길이 뿐만 아니라 그 수열도 출력해야 했었다.
또한 dp로 풀기에 메모리제한에 비해 크기 N이 너무 커보였다.
한편으론 가장 긴 바이토닉 부분 수열을 출력하라는 문제가 아니여서 다행이다.

dp만을 사용해서 풀면 최악의 상황에서 O(N^2)의 시간복잡도가 발생한다.
따라서 이분탐색법을 사용해야한다.

부분 수열 출력을 위해선 동적계획법 역추적을 사용하면 좋다. 아래 링크를 참고했다.
https://velog.io/@flowersayo/%EB%8F%99%EC%A0%81%EA%B3%84%ED%9A%8D%EB%B2%95-%EC%97%AD%EC%B6%94%EC%A0%81
 */

public class P5_14003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] seq = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int idx = 0;
        while(st.hasMoreTokens())
            seq[idx++] = Integer.parseInt(st.nextToken());

        solution(N, seq);
        br.close();

    }
    private static void solution(int N, long[] seq) {
        ArrayList<Integer> list = new ArrayList<>(); // lis는 실제 값이 아니라 seq의 인덱스를 저장
        int[] path = new int[N]; // 경로를 기록하는 배열
        Arrays.fill(path, -1); // 초기값 -1로 설정

        list.add(0); // 첫 번째 요소의 인덱스를 추가

        for (int i = 1; i < N; i++) {
            if (seq[i] > seq[list.get(list.size() - 1)]) {
                path[i] = list.get(list.size() - 1);
                list.add(i);
            } else {
                int pos = binarySearch(seq, list, seq[i]);
                list.set(pos, i);
                if (pos > 0) {
                    path[i] = list.get(pos - 1);
                }
            }
        }
        // LIS 길이 출력
        System.out.println(list.size());

        // 역추적하여 LIS 배열을 구성
        int currentIdx = list.get(list.size() - 1);
        ArrayList<Long> answer = new ArrayList<>();

        while (currentIdx != -1) {
            answer.add(seq[currentIdx]);
            currentIdx = path[currentIdx];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = answer.size() - 1; i >= 0; i--) {
            sb.append(answer.get(i)).append(" ");
        }
        System.out.println(sb.toString());
    }

    private static int binarySearch(long[] seq, ArrayList<Integer> list, long key) {
        int low = 0;
        int high = list.size() - 1;

        while (low < high) {
            int mid = (low + high) / 2;
            if (seq[list.get(mid)] >= key) high = mid;
            else low = mid + 1;
        }
        return low;
    }
}
