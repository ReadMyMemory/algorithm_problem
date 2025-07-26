package solved.silver.S1;
import java.io.*;
import java.util.*;

public class S1_2785 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayList<Integer> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            a.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(a);
        int cnt = 0;
        while (a.size() > 1) {
            a.set(0, a.get(0) - 1);
            a.remove(a.size() - 1);
            if (a.get(0) == 0)
                a.remove(0);
            cnt++;
        }
        System.out.println(cnt);
    }
}




