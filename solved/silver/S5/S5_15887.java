package solved.silver.S5;
import java.io.*;
import java.util.*;

public class S5_15887 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 카드 개수 입력
        int N = Integer.parseInt(br.readLine());

        // 카드 배열 입력
        int[] cards = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        // 연산 기록을 위한 리스트
        List<int[]> operations = new ArrayList<>();

        // 목표 배열은 [1, 2, 3, ..., N]
        for (int i = 0; i < N; i++) {
            // 목표 배열에서의 값이 cards[i]와 다르면, 해당 구간을 뒤집는다.
            if (cards[i] != i + 1) {
                // 뒤집을 구간 [i+1, 위치(cards[i])]
                int targetIndex = findIndex(cards, i + 1);
                if (targetIndex > i) {
                    // 연산을 기록
                    operations.add(new int[]{i + 1, targetIndex + 1});
                    // 해당 구간을 뒤집는다.
                    reverse(cards, i, targetIndex);
                }
            }
        }

        // 결과 출력
        System.out.println(operations.size());
        for (int[] op : operations) {
            System.out.println(op[0] + " " + op[1]);
        }
    }

    // 특정 값이 배열에서 어디에 있는지 찾는 함수
    private static int findIndex(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1; // 찾을 수 없으면 -1 반환
    }

    // 배열의 특정 구간을 뒤집는 함수
    private static void reverse(int[] arr, int left, int right) {
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}
