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

        //1. n과 m 입력받기.
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> map = new HashMap<>();


        //2. 집합 S에 포함되는 N개의 문자열 입력
        int index = 1;
        while(n --> 0) {
            String str = br.readLine();
            map.put(str, 1); // 중복은 없다 했으니 그냥 1로 뒀다., 0으로 하지 않은건 getOrDefault의 defaultValue를 0으로 해서 구분함으로써 key 존재 여부 찾기 위해서다.
            index++;
        }

        //3. M개의 문자열을 기반으로 탐색하여 집합 S 존재 여부 파악
        int count = 0;
        while(m --> 0) {
            String str = br.readLine();
            if(map.getOrDefault(str, 0) == 1) // 모든 key에 대한 value를 1로 했으니 지정된 키에 매핑된 값이 있으면 1, 없으면 0을 반환할 것이다. 그걸 이용
                count++;
        }

        //4. count 출력
        System.out.println(count);
    }
}
