package solved.bronze.B2;
import java.io.*;
import java.util.StringTokenizer;

public class B2_29332 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine()) - 1;
        st = new StringTokenizer(br.readLine());
        boolean[] direction = new boolean[4];
        Long f_X = Long.parseLong(st.nextToken());
        Long f_Y = Long.parseLong(st.nextToken());
        Long maxX = f_X, minX = f_X;
        Long maxY = f_Y, minY = f_Y;
        // L = 0, R = 1, U = 2, D = 3 으로 계산
        direction[calculateDirection(st.nextToken())] = true;
        while(T --> 0) {
            st = new StringTokenizer(br.readLine());
            Long tempX = Long.parseLong(st.nextToken());
            Long tempY = Long.parseLong(st.nextToken());

            if(tempX > maxX)
                maxX = tempX;
            else if(tempX < minX)
                minX = tempX;

            if(tempY > maxY)
                maxY = tempY;
            else if(tempY < minY)
                minY = tempY;

            direction[calculateDirection(st.nextToken())] = true;
        }

        boolean status = false;
        for(int i = 0; i < 4; i++) {
            if(!direction[i]) {
               status = true;
                break;
            }
        }
        if(status)
            bw.write("Infinity");
        else
            bw.write(String.valueOf((maxX - minX - 1) * (maxY - minY - 1)));

        bw.flush();
        br.close();
        bw.close();
    }
    static int calculateDirection(String s) {
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
        return 4;
    }
}
