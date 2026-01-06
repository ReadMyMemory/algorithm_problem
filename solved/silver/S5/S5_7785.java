package solved.silver.S5;
import java.io.*;
import java.util.*;

public class S5_7785 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        Set<String> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String action = st.nextToken();

            if (action.equals("enter")) set.add(name);
            else set.remove(name);
        }

        List<String> list = new ArrayList<>(set);
        list.sort(Collections.reverseOrder()); // 사전 역순

        StringBuilder sb = new StringBuilder();
        for (String name : list) sb.append(name).append('\n');
        System.out.print(sb.toString());
    }
}
