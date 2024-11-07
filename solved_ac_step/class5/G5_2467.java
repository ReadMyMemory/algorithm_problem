package solved_ac_step.class5;
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
배열이 정렬되어있다는 점.
이분 탐색 또는 그리디로 풀 수 있을듯
 */

public class G5_2467 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];
        int idx = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens())
            arr[idx++] = Long.parseLong(st.nextToken());

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
