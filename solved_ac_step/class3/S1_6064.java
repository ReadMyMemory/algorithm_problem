package solved_ac_step.class3;
import java.io.*;
import java.util.StringTokenizer;

public class S1_6064 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        /*
        카잉 달력이 뭔가?
        M과 N이 주어지고 x y는 1씩 증가하다가
        마지막 증가한 값이 M또는 N과 같다면, 그다음 값은 1부터 다시 시작
        다만 이제 x = M x = N이 되는 경우 세상의 종말이 다가오는 것이다.

        그냥 세는 방법은?
        N은 40000보다 작고, M은 1보다 크면 제한이 없다.
        직접 하나씩 센다고 하면 시간 복잡도는 어떻게 될까?
        1억은 충분히 넘을 수 있을 거 같다. 불가능.

        M = 5 N = 7을 가정해보자.
        1 1  2 2 ... 5 5  (M초기화) 1 6   2 7  (N초기화) 3 1   4 2   5 3
        1 4   2 5   3 6   4 7   5 1   1 2   2  3

        첫 초기화 시엔 초기화 된 값만큼 차이가 나다가
        그다음 초기화되면 더 큰값에서 작은 값 뺀 만큼 차이가 난다.
        그래서 차이가 5 .. 2(=7-5) .. 3(5-2)... 이렇게 난다.
        당연히 빼는 순서는 작은 값(예시에선 M), 큰 값(예시에선 N)
        이게 반복될 것이다.
        5개 (M 초기화) 2개 (N 초기화) 3개 (M초기화) 4개 (N초기화)
        이제 규칙이 보이는 것 같다.
        M과 N이 한번씩 초기화된 시점은 당연하게 더 큰값을 가지는 횟수만큼일것.
        차이의 변화는
        작은 값 , A(=큰값 - 작은값), B=(작은값 - A), C(=큰값 - B),...
        5, 2(=7-5), 3(=5-2), 4(=7-3), 1(5-4), 6(7-1)
        차이가 6이 나왔고, 이건 존재할 수가 없다. 이건 왜냐하면
        5가 두번 초기화되는 일이 발생했기 때문이다.
        차이가 1이고 5가 초기화되면 1 2 2 3 3 4 4 5 5 6 .. 이런것이다.
        7에 다다르기도 전에 5가 한 번 더 초기화된거다. 따라서 이 아이디어는 잘못됨.
        그래서 차이가 작은 값(여기선 M)보다 커지면 작은값에서 한번 빼도록 하는 건 어떨까?
        그렇게 되면 차이가 2번 바뀌면 횟수가 7번 돌았다는 걸 쓸 수 없다.

        !!여기부터 아이디어!!

        차라리 관점을 내가 구해야하는 x y를 찾아보자.
        x를 고정해두고, x가 루프 한번 돌 때 y 값을 계산하는 거다.
        내가 구해야 하는 x = 3 y = 5라면,
        x = 3 y = 3 까지 간 후에 5만큼 계속 돌려보는 거다.
        x는 항상 3일 것이니, y만 확인하면 된다.
        이때 y값이 7을 초과하면 7만큼을 빼주면 된다.
        3  8(1이다) 6 11(4이다) 9(2다) 7 12(5이다) 10(3이다)
        하지만 우리가 고려해야 할 게 있다. 바로 카잉달력이 끝나는 조건이다.
        x = 5일 때 y= 7이 될 때를 생각해야 하는 것이다.
        5 10(3이다) 8(1이다) 6 11(4이다) 9(2이다) 7
        아 그러니까 5번 루프니까 위에서 3을 구할때도 5번 루프 돌기 전에 주어진 x y값이 존재하는지 찾아주면 되겠다.

        <추가 사항>
        일단 아이디어는 맞는 거 같았는데 틀렸다.
        int로 해서 overflow가 나는가 해서 long으로 바꿨지만 그래도 틀렸다.
        그래서 생각하던 중 아래 글을 보고 다시 생각해봤다.
        https://www.acmicpc.net/board/view/21503

        일단 내가 안쪽 while문은 잘 처리해줬는데 바깥쪽 while문(초기 세팅 하는 부분)은 그냥 if 조건으로만 달아놔서 틀렸던 것 같다.
        M과 N이 차이가 크게 나는 경우 tempN = M 으로 맞추고 tempN > N이라면 카잉 달력 조건 위배니 N 아래로 값 만들어주기 위해
        빼주는 코드를 넣었는데 이걸 if문으로 한번만 빼도록 하여 예외가 발생하였다.
        따라서 tempN > N 과 tempY > N 조건이 달린 4부분을 while로 교체하였다.
        그랬더니 맞았다.

        */
        int number = Integer.parseInt(br.readLine());
        for(int i = 0; i < number; i++) {
            st = new StringTokenizer(br.readLine());
            long M = Long.parseLong(st.nextToken());
            long N = Long.parseLong(st.nextToken());
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());

            //일단 카잉 달력이 끝나는 횟수를 구하자.
            long tempN = M; // 일단은 x=M으로 맞추고 y=M으로 맞추자.
            while(tempN > N) // 만약 M이 N보다 컸다면 N을 빼줘서 카잉 달력 조건 위배 방지한다.
                tempN -= N;
            int count = 0; // 루프 횟수를 셀거다.
            while(tempN != N) {
                tempN += M; // M만큼 계속 더해서 M은 일정한데, N값을 계속 관찰하는 것임.
                while(tempN > N) // tempN이 N보다 크다면, 카잉 달력 조건 위배라서 N만큼 빼줌.
                    tempN -= N;
                count++;
            }

            boolean status = true;
            //이제 x를 고정시켜놓고 y를 관찰하자.
            long tempY = x;
            while(tempY > N)
                tempY -= N;
            int count2 = 0; //루프 횟수를 셀거다.
            while(tempY != y) { //일단은 x <=M이니 루프 횟수가 같은 것까진 괜찮다. 그 이상을 넘어가면 -1 출력해야한다.
                tempY += M;
                while(tempY > N)
                    tempY -= N;
                count2++;
                if(count2 > count) {
                    status = false;
                    break;
                }
            }

            if(status)
                bw.write(String.valueOf(x + count2 * M)+"\n");
            else
                bw.write(String.valueOf(-1)+"\n");

        }
        bw.flush();
        br.close();
        bw.close();

    }
}
