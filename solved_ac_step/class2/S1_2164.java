package solved_ac_step.class2;
import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class S1_2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //양방향으로 넣고 빼기가 가능한 deque를 사용하면 쉽게 풀 수 있는 걸로 보인다.
        Deque<Integer> deque = new LinkedList<>();
        int size = Integer.parseInt(br.readLine());

        for(int i = 1; i <= size; i++) {
            deque.offerLast(i); //i를 반대로 size부터 1씩 빼면서 add 또는 offerFirst 해도 된다.
        }

        while(true) {
            deque.pollFirst(); // 맨 위의 카드를 버린다.
            if(deque.size() == 1) break; //카드가 1장이 될 수 있는 상황은 버릴때만이다.
            int value = deque.pollFirst(); // 그다음 맨 위에 카드를 빼서
            deque.offerLast(value); // 뒤에 넣는다.
        }

        System.out.println(deque.peek());
    }
}
