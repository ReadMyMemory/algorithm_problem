package solved.silver.S2;
import java.io.*;
import java.util.*;

public class S2_1058 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] map = new char[n][];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> friends = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (i == j) continue; // 자기 자신 제외
                if (map[i][j] == 'Y') {
                    friends.add(j);
                } else {
                    // 친구의 친구 확인
                    for (int k = 0; k < n; k++) {
                        if (map[i][k] == 'Y' && map[k][j] == 'Y') {
                            friends.add(j);
                            break;
                        }
                    }
                }
            }
            max = Math.max(max, friends.size());
        }
        System.out.println(max);
    }
}
