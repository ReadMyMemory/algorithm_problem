package solved.silver.S4;
import java.io.*;
import java.util.ArrayList;

public class S4_12873 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        /*
        1, 1+8, 1+8+27, 1+8+27+64, .. 이 순으로 제거 되지만.
        Arraylist의 특성을 사용하면 좀 더 편할지도 모르겠다.
        list 특성 상 값을 제거하면 인덱스가 하나씩 앞댕겨지기 때문에 1번째 사람 제거한 후 8번째 사람 제거해도 문제가 없다.
         */
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 1; i<= N; i++)
            list.add(i);
        // 5000*5000*5000는 무조건 overflow난다. long에서도.
        // 그래서 생각해본게 어쩌피 5000^3 & list.size() 니까
        // ((5000 * 5000) % list.size()) * (5000 % list.size()) 을 다시 list.size()로 % 연산 하면 된다. 분배법칙.
        int index = 0;
        for(int i = 1; i < N; i++) {
            int temp = (index + (((i * i) % list.size()) * i - 1)) % list.size(); //index는 제거한 사람의 다음 차례로 넘어간다 하였으니 그걸 기억하는 것이다.
            if(temp < 0) // index가 0. (i * i) % list.size()가 0이면 temp가 -1이 된다. 따라서 이때 사용한다.
                temp += list.size();
            list.remove(index=temp);
        }
        System.out.println(list.get(0));

    }
}
