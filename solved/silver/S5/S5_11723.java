package solved.silver.S5;
import java.io.*;
import java.util.*;

public class S5_11723 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(br.readLine());
        int set = 0;

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if (command.equals("all")) {
                set = (1 << 21) - 2; // 1~20번 비트만 1
            } else if (command.equals("empty")) {
                set = 0;
            } else {
                int x = Integer.parseInt(st.nextToken());
                int bit = 1 << x;

                switch (command) {
                    case "add":
                        set |= bit;
                        break;
                    case "remove":
                        set &= ~bit;
                        break;
                    case "check":
                        sb.append((set & bit) != 0 ? 1 : 0).append('\n');
                        break;
                    case "toggle":
                        set ^= bit;
                        break;
                }
            }
        }
        System.out.print(sb);
    }
}