package solved_ac_step.class2;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class S5_1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // key는 길이가 될 것이고, 길이가 같으면 계속 추가되야 하니까 ArrayList가 적합해보인다.
        HashMap<Integer, ArrayList<String>> map = new HashMap<>();

        int Num = Integer.parseInt(br.readLine());
        //단어 입력 받기.
        while(Num > 0) {
            ArrayList<String> list;
            String str = br.readLine();
            int key = str.length(); // 문장의 길이. 이건 hashmap의 key가 된다.
            if(map.get(key) == null) { // 해당 키를 가지는 데이터가 없다.
                list = new ArrayList<String>();
                map.put(key, list); // 그러면 새로운 리스트 만들어서 넣어줌.
            }
            ArrayList<String> existList = map.get(key); // 기존 리스트 받아오기.
            boolean status = true; // 이건 이제 동일한 단어 나오는지 상태 확인용
            // 동일 값 있는지 파악. for문을 써서 list 순회하면 시간복잡도 상으로 안좋다곤 하나
            // 돌아봐야 10번도 돌 일이 없을 듯. 그냥 씀
            for (String s : existList) {
                if (str.equals(s)) {
                    status = false;
                    break;
                }
            }

            if(status) {
                existList.add(str); // 새로운 값 넣고
                map.put(key, existList); // 다시 hashmap에 put
            }
            Num--;
        }
        //출력하기.
        for(int i = 0; i < 51; i++) { // i < 50 아니고 i < 51이다. 50자리도 생각..!
            if (map.get(i) != null) {// 키가 hashmap 안에 존재하면
                ArrayList<String> printList = map.get(i);
                Collections.sort(printList); // 사전순 정렬
                for (String value : printList)
                    bw.write(value + "\n");
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }

}
