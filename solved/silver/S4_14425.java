package solved.silver;
import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

/*
값을 찾고 대조하는 과정에선 해시맵이 효과적이다.
근데 시간 제한이 2초인데, 그냥 배열에 담아서 해도 되지 않을까?
하지만 문제의 의도는 해싱 기법을 이용하여 데이터를 빠르게 찾아서 풀으라는 것 같았다. 그렇게 풀어봄.
 */
public class S4_14425 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<Integer, String> map = new HashMap<>();
        int map_size = n-1;

        int index = 1;

        while(n --> 0) {
            map.put(index, br.readLine());
            index++;
        }
        while(m --> 0) {
            String str = br.readLine();
            for(int i = 0; i < map_size; i++) {

                map.get(i)
            }
        }


        
    }
}
