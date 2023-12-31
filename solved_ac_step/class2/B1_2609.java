package solved_ac_step.class2;
import java.io.*;
import java.util.StringTokenizer;

public class B1_2609 {
    //유클리드 호제법. 최대 공약수 구하기
    //A B가 있을 때 A % B = C -> B % C = D -> C % D = E.. 이런식으로 반복하여 나머지가 0이 될 때 우측에 있는 값이 최대 공약수다.
    //A B의 대소는 상관 없는 이유가 작은 걸로 큰 걸 나눠 나머지가 구하는 경우 작은 값이 결과 값으로 그대로 나오기 때문에 그 다음부턴
    // 큰수 % 작은수 로 정상 배치된다. 다만 연산을 1번 더 해야 한다는 단점이 있다.
    static int GCN (int a, int b) {
        int c = a % b;
        if(c == 0)
            return b;
        else
            return GCN(b, c);
    }

    //유클리드 호제법. 최소 공배수 구하기
    //최소 공배수는 더 간단하다. 주어진 두 수 A B를 곱한 뒤 최대 공약수로 나누면 된다.
    //굳이 함수로 구현할 필요도 없지만, 그래도 구해본다.
    static int LCM (int a, int b, int g) {
        return (a * b) / g;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int gcn = GCN(A, B); // 최소공배수를 구할 때 사용하기 위해 변수에 잠시 초기화해놨다.
        System.out.println(gcn); // 최대공약수
        System.out.println(LCM(A, B, gcn));
    }
}
