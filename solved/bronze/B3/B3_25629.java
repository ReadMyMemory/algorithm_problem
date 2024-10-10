package solved.bronze.B3;
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
순차적으로 같거나 증가하도록 수열을 나열할 수 있는지는 중요하지 않다. 무조건 가능하기 때문
따라서 N의 짝수면 홀수의 개수와 짝수의 개수가 일치하는지, N이 홀수면 홀수의 개수가 짝수의 개수보다 1 많은지만 체크해주면 된다.
N이 짝수인데 홀수와 짝수의 개수가 차이가 난다면 짝수개만큼 차이가 날 것이기 때문에 결국 N의 여부와 관계없이 홀수 개수 = 짝수 개수 또는 홀수 개수 = 짝수개수 + 1을 하나의 조건으로 체크 가능하다.
 */

public class B3_25629 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        System.out.println(solution(N, arr));
    }

    private static int solution(int N, int[] sequence) {
        int answer = 1;
        ArrayList<Integer> odd = new ArrayList<>();
        ArrayList<Integer> even = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            if(sequence[i] % 2 == 0)
                even.add(sequence[i]);
            else
                odd.add(sequence[i]);
        }
        //조건 : even과 odd는 같거나 odd가 1 많아야한다.
        if(even.size() != odd.size() && odd.size() != even.size() + 1)
            answer = 0;
        return answer;
    }
}
