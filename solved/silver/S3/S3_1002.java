package solved.silver.S3;
import java.io.*;

public class S3_1002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            String[] input = br.readLine().split(" ");
            int x1 = Integer.parseInt(input[0]);
            int y1 = Integer.parseInt(input[1]);
            int r1 = Integer.parseInt(input[2]);
            int x2 = Integer.parseInt(input[3]);
            int y2 = Integer.parseInt(input[4]);
            int r2 = Integer.parseInt(input[5]);

            int result = getNumberOfPoints(x1, y1, r1, x2, y2, r2);
            sb.append(result).append("\n");
        }
        System.out.print(sb.toString());
    }

    private static int getNumberOfPoints(int x1, int y1, int r1, int x2, int y2, int r2) {
        double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

        // 무한대인 경우: 두 원이 완전히 일치
        if (distance == 0 && r1 == r2) {
            return -1;
        }

        // 두 원이 만나지 않는 경우 1: 너무 멀리 떨어져 있음
        if (distance > r1 + r2) {
            return 0;
        }

        // 두 원이 만나지 않는 경우 2: 한 원이 다른 원 안에 있으나 접하지 않음
        if (distance < Math.abs(r1 - r2)) {
            return 0;
        }

        // 두 원이 외접하거나 내접하는 경우: 한 점에서 만남
        if (distance == r1 + r2 || distance == Math.abs(r1 - r2)) {
            return 1;
        }

        // 그 외의 경우: 두 점에서 만남
        return 2;
    }
}
