package solved_ac_step.class2;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class S5_11650 {

    static class Pair implements Comparable<Pair> {
        int x, y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Pair pair) {
            if(this.x == pair.x)
                return Integer.compare(this.y, pair.y);
            return Integer.compare(this.x, pair.x);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testcase = Integer.parseInt(br.readLine());
        StringTokenizer st;
        ArrayList<Pair> list = new ArrayList<>();
        for(int i = 0; i < testcase; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new Pair(x, y));
        }
        Collections.sort(list);
        for(int i = 0; i < testcase; i++) {
            bw.write(list.get(i).x+" "+list.get(i).y+"\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
