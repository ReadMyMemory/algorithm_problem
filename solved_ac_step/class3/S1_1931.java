package solved_ac_step.class3;
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S1_1931 {
    static class Pair implements Comparable<Pair> {
        int start, end;
        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Pair pair) {
            if(this.end == pair.end) //종료 시간이 같으면 시작시간 빠른 것부터 정렬
                return this.start - pair.start;
            return this.end - pair.end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        //이 문제는 종료 시간이 가장 빠른 강의부터 선택하면 된다.
        int N = Integer.parseInt(br.readLine()); // 회의의 수
        Pair[] lecture = new Pair[N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            lecture[i] = new Pair(start, end);
        }

        //그리디 알고리즘. compareTo에서 정한 정렬 기준에 따라
        Arrays.sort(lecture);

        int lastEnd = lecture[0].end;
        int count = 1;


        for(int i = 1; i < N; i++) {
            if (lastEnd <= lecture[i].start) { // 종료시간이 가장 빠른 거 < 새로 넣는 시작 시간
                count++;
                lastEnd = lecture[i].end;
            }
        }
        bw.write(count+"");
        bw.flush();
        br.close();
        bw.close();
    }
}
