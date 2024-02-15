package solved.silver;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class S4_1302 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> map = new HashMap<>();
        int number = Integer.parseInt(br.readLine());
        int max = 0;
        for(int i = 0; i < number; i++) {
            String str = br.readLine();
            map.put(str, map.getOrDefault(str, 0) + 1); // getOrDefault에 대해서도 처음 알았다. 키에 대한 값을 반환하는 메서드고, 키가 맵에 존재하지 않으면 기본값(defaultValue)을 반환한다. 그 기본값을 0으로 한거다. 그다음 1을 더함.
            max = Math.max(max, map.get(str));
        }
        ArrayList<String> list = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : map.entrySet())// Entry와 entrySet이라는 걸 처음 알았다.
            // map.entrySet()을 통해 맵에 있는 각 엔트리(key-value) 쌍에 대한 set를 반환하고 for문으로 하나씩 순회하며 각 엔트리를 entry에 할당하는 거다. 그렇게 해서 max가 동일한 여러 단어를 찾는다.
            if(entry.getValue() == max) list.add(entry.getKey());
        Collections.sort(list);
        System.out.println(list.get(0));
    }
}
