package solved.silver;
import java.util.Scanner;

public class S3_17499 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 수열의 길이 N과 연산의 개수 Q 입력
        int N = sc.nextInt();
        int Q = sc.nextInt();

        // 정수 수열 입력
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        // 연산 수행
        for (int q = 0; q < Q; q++) {
            int op = sc.nextInt();
            if (op == 1) {
                // 1 i x 연산: ai에 정수 x만큼 더하기
                int i = sc.nextInt() - 1;
                int x = sc.nextInt();
                arr[i] += x;
            } else if (op == 2) {
                // 2 s 연산: 수열을 오른쪽으로 s칸 시프트
                int s = sc.nextInt();
                shiftRight(arr, s);
            } else if (op == 3) {
                // 3 s 연산: 수열을 왼쪽으로 s칸 시프트
                int s = sc.nextInt();
                shiftLeft(arr, s);
            }
        }

        // 결과 출력
        for (int i = 0; i < N; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    // 수열을 오른쪽으로 s칸 시프트하는 함수
    private static void shiftRight(int[] arr, int s) {
        int N = arr.length;
        s = s % N; // s가 N보다 큰 경우 최적화

        reverseArray(arr, 0, N - 1); // 전체 배열을 뒤집음
        reverseArray(arr, 0, s - 1); // 처음부터 s-1까지 뒤집음
        reverseArray(arr, s, N - 1); // s부터 끝까지 뒤집음
    }

    // 수열을 왼쪽으로 s칸 시프트하는 함수
    private static void shiftLeft(int[] arr, int s) {
        int N = arr.length;
        s = s % N; // s가 N보다 큰 경우 최적화

        reverseArray(arr, 0, s - 1); // 처음부터 s-1까지 뒤집음
        reverseArray(arr, s, N - 1); // s부터 끝까지 뒤집음
        reverseArray(arr, 0, N - 1); // 전체 배열을 뒤집음
    }

    private static void reverseArray(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
