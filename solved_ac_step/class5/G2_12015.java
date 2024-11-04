package solved_ac_step.class5;
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
1000000 * (1 + 2 + ... 999999) 이라서 시간복잡도상 1초를 넘어 시간초과가 날 수 있어
동적계획법보단 이분탐색이 적절하다.
 */

public class G2_12015 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] seq = new int[N];
        int idx = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens())
            seq[idx++] = Integer.parseInt(st.nextToken());
        System.out.println(solution(N, seq));
    }
    private static int solution(int N, int[] seq) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(seq[0]);
        int answer = 0;

        for(int i = 0; i < N; i++) {
            if(seq[i] > list.get(list.size() - 1)) {
                list.add((seq[i]));
                answer = list.size() - 1;
            } else {
                int pos = binarySearch(list, seq[i]);
                list.set(pos, seq[i]);
            }
        }
        return answer + 1;
    }

    
    private static int binarySearch(ArrayList<Integer> list, int key) {
        int low = 0;
        int high = list.size() - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (list.get(mid) >= key) high = mid;
            else low = mid + 1;
        }

        return low;
    }
}
