package Arena.season22;

import java.io.*;
import java.util.StringTokenizer;

public class A1 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        // N 입력
        int N = Integer.parseInt(br.readLine());

        // 사용할 수 있는 숫자 배열 입력
        int[] numbers = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        // 소수가 아닌 수 생성 및 출력
        int result = findNonPrimeNumber(numbers);

        // 결과 출력
        if (result != 0) {
            System.out.println("YES");
            System.out.println(result);
        } else {
            System.out.println("NO");
        }
    }

    // 소수가 아닌 수를 찾는 함수
    private static int findNonPrimeNumber(int[] numbers) {
        for (int i = 2; i <= 1_000_000_000_000L; i++) {
            if (!isPrime(i) && isPossible(i, numbers)) {
                return i;
            }
        }
        return 0;
    }

    // 소수 판별 함수
    private static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    // 숫자 배열로 주어진 숫자들로 구성될 수 있는지 확인하는 함수
    private static boolean isPossible(int num, int[] numbers) {
        String numStr = String.valueOf(num);
        for (char digit : numStr.toCharArray()) {
            int d = Character.getNumericValue(digit);
            if (contains(numbers, d)) {
                numbers = remove(numbers, d);
            } else {
                return false;
            }
        }
        return true;
    }

    // 배열에서 특정 값 제거
    private static int[] remove(int[] arr, int value) {
        int[] result = new int[arr.length - 1];
        int index = 0;
        for (int i : arr) {
            if (i != value) {
                result[index++] = i;
            }
        }
        return result;
    }

    // 배열에 값 존재 여부 확인
    private static boolean contains(int[] arr, int value) {
        for (int i : arr) {
            if (i == value) {
                return true;
            }
        }
        return false;
    }
}