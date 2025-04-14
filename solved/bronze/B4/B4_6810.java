package solved.bronze.B4;
import java.io.*;

public class B4_6810 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 고정된 10자리 ISBN 숫자
        int[] isbn = {9, 7, 8, 0, 9, 2, 1, 4, 1, 8};

        // 사용자로부터 3자리 입력 받아 배열에 추가
        for (int i = 0; i < 3; i++) {
            isbn = append(isbn, Integer.parseInt(br.readLine()));
        }

        // 1-3-sum 계산
        int sum = 0;
        for (int i = 0; i < isbn.length; i++) {
            if (i % 2 == 0) {
                sum += isbn[i] * 1;
            } else {
                sum += isbn[i] * 3;
            }
        }

        System.out.println("The 1-3-sum is " + sum);
    }

    // 배열에 요소를 추가하는 헬퍼 메소드
    static int[] append(int[] arr, int value) {
        int[] newArr = new int[arr.length + 1];
        System.arraycopy(arr, 0, newArr, 0, arr.length);
        newArr[arr.length] = value;
        return newArr;
    }
}
