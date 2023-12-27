package solved_ac_step.class2;
import java.io.*;
import java.util.StringTokenizer;

public class B1_2869 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        int days = 0;

        // while 반복문으로 구현하니까 오류난다. 직접 계산하자.

        if(A == V)
            days += 1;
        else if((V - A) <= (A - B)) // 나누는 값이 1보다 작을 때, 0이 나오는 경우를 생각한거다.
            days += 2; // V랑 A랑 같지 않기 때문에 하루만에 올라갈 순 없지만, 조건상 다음 날엔 낮에 무조건 올라간다.
        else {
            days += (V - A) / (A - B) + 1;
            if((V - A) % (A - B) != 0) // 나머지가 0이 아니다. << 이 부분을 잠깐 잘못 생각했었다. 나머지가 1이거나 2이면 되는 줄 잘 못 알았음.
                days += 1; // 추가로 하루가 더 추가된다.
        }

        bw.write(days+"");
        bw.flush();
        br.close();
        bw.close();
    }
}
