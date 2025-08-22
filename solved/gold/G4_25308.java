package solved.gold;
import java.io.*;
import java.util.*;

public class G4_25308 {
    static int count = 0;
    static double[] angles;
    static double[][] unitVectors;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] abilities = new int[8];
        for (int i = 0; i < 8; i++) {
            abilities[i] = Integer.parseInt(st.nextToken());
        }

        // 각 위치의 각도 (라디안)와 단위 벡터 미리 계산
        angles = new double[8];
        unitVectors = new double[8][2];
        for (int i = 0; i < 8; i++) {
            angles[i] = Math.toRadians(45 * i);
            unitVectors[i][0] = Math.cos(angles[i]);
            unitVectors[i][1] = Math.sin(angles[i]);
        }

        // 순열 생성 및 볼록성 검사
        permute(abilities, 0);
        System.out.println(count);
    }

    // 순열 생성
    static void permute(int[] arr, int start) {
        if (start == arr.length) {
            if (isConvex(arr)) {
                count++;
            }
            return;
        }

        for (int i = start; i < arr.length; i++) {
            swap(arr, start, i);
            permute(arr, start + 1);
            swap(arr, start, i);
        }
    }

    // 배열 원소 교환
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 볼록 다각형 판별
    static boolean isConvex(int[] abilities) {
        // 각 꼭짓점의 실제 좌표 계산
        double[][] points = new double[8][2];
        for (int i = 0; i < 8; i++) {
            points[i][0] = abilities[i] * unitVectors[i][0];
            points[i][1] = abilities[i] * unitVectors[i][1];
        }

        // 모든 연속된 세 점에 대해 외적 검사
        // 볼록 다각형이려면 모든 외적의 부호가 같아야 함
        boolean firstSign = true;
        boolean sign = false;

        for (int i = 0; i < 8; i++) {
            int j = (i + 1) % 8;
            int k = (i + 2) % 8;

            // 벡터 (j-i)와 (k-j)의 외적
            double v1x = points[j][0] - points[i][0];
            double v1y = points[j][1] - points[i][1];
            double v2x = points[k][0] - points[j][0];
            double v2y = points[k][1] - points[j][1];

            double cross = v1x * v2y - v1y * v2x;

            // 외적이 0에 매우 가까우면 일직선상에 있음 (허용)
            if (Math.abs(cross) < 1e-9) {
                continue;
            }

            if (firstSign) {
                sign = cross > 0;
                firstSign = false;
            } else {
                // 부호가 다르면 오목 다각형
                if ((cross > 0) != sign) {
                    return false;
                }
            }
        }
        return true;
    }
}