package solved.bronze.B3;
import java.io.*;
public class B3_23812 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int width = 5 * N;
        int height = 5 * N;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if ((i < N && (j < N || j >= 4 * N)) || // 상단 두 개의 세로 줄
                        (i >= N && i < 2 * N) ||             // 첫 번째 가로 줄
                        (i >= 2 * N && i < 3 * N && (j < N || j >= 4 * N)) || // 중간 두 개의 세로 줄
                        (i >= 3 * N && i < 4 * N) ||         // 두 번째 가로 줄
                        (i >= 4 * N && (j < N || j >= 4 * N))) { // 하단 두 개의 세로 줄
                    System.out.print("@");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
