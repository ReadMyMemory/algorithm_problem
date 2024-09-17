package solved.bronze.B2;
import java.io.*;
import java.util.StringTokenizer;

/*
브론즈 2치고 문제를 이해하는데 시간이 좀 걸렸다.
이해한 내용은 아래와 같다.
한 방향에서의 값은 한쪽의 리밋만 정한다.
또한 같은 방향에서 갱신이 일어난다면, 더 작은 값이 정답이다. 왜냐하면 보물을 가르키는 정보는 서로 모순되지 않아야 하기 때문이다.
여기서 두번째 개념을 잘못 이해해서 여러 번 틀렸다.

아쉽다.

*/


public class B2_29332 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        long maxLeft = Long.MIN_VALUE, maxRight = Long.MAX_VALUE;
        long maxUp = Long.MAX_VALUE, maxDown = Long.MIN_VALUE;
        while(T --> 0) {
            st = new StringTokenizer(br.readLine());
            long tempX = Long.parseLong(st.nextToken());
            long tempY = Long.parseLong(st.nextToken());
            int direction_value = calculateDirection(st.nextToken());

            switch (direction_value) {
                case 0: // Left에 보물이 있음, right의 리밋
                    maxRight = Math.min(tempX, maxRight);
                    break;
                case 1: // Right에 보물이 있음, left의 리밋
                    maxLeft = Math.max(tempX, maxLeft);
                    break;
                case 2: // Up에 보물이 있음, down의 리밋
                    maxDown = Math.max(tempY, maxDown);
                    break;
                case 3: // down에 보물이 있음, up의 리밋
                    maxUp = Math.min(tempY, maxUp);
                    break;
            }
        }
        if(maxLeft == Long.MIN_VALUE || maxRight == Long.MAX_VALUE || maxDown == Long.MIN_VALUE || maxUp == Long.MAX_VALUE) // 방향 정보 갱신이 되지 않은 경우
            bw.write("Infinity");
        else
            bw.write(String.valueOf((maxRight - maxLeft - 1) * (maxUp - maxDown - 1)));

        bw.flush();
        br.close();
        bw.close();
    }

    static int calculateDirection(String s) {  // L = 0, R = 1, U = 2, D = 3 으로 계산
        switch (s) {
            case "L":
                return 0;
            case "R":
                return 1;
            case "U":
                return 2;
            case "D":
                return 3;
        }
        return -1;
    }
}
