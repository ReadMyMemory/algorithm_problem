package solved_ac_step.class3;
import java.io.*;
import java.util.StringTokenizer;

public class G5_1107 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //여기부터 아이디어
        /*
        시작은 100번 채널이다.
        누를 수 있는 버튼에서 가능한 가까운 숫자를 골라서 + - 이동
        시작 채널(100)에서 + - 이동
        그래도 예외가 발생하지 않을까..?
        그러면 일단은 모든 버튼을 탐색하고
        거기서 이동해야 하는 채널까지 이동하는 횟수를 구해서
        비교하면?
         */

        //여기부터 입력
        String num = br.readLine(); //이동해야 하는 채널 번호
        boolean[] buttons = new boolean[10]; // 버튼 0~9 10개임
        int brokenNum = Integer.parseInt(br.readLine()); // 망가진 버튼 개수
        if(brokenNum != 0) { // 망가진 버튼 0개면 입력 안받음
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens())
                buttons[Integer.parseInt(st.nextToken())] = true; // 망가진 버튼 true로 체크
        }

        //여기부터 코드
        int min = Math.abs(Integer.parseInt(num) - 100);
        for(int i = 0; i <= 999999; i++) {
            String str = String.valueOf(i);
            boolean status = true; // 현재 i가 망가진 버튼 눌러야 하는 채널 번호인가?
            for(int j = 0; j < str.length(); j++) {
                if (buttons[str.charAt(j) - '0']) { // 망가진 버튼 포함된 숫자라면
                    status = false;
                    break;
                }
            }
                if(status) { // 망가진 버튼 누른 게 아니라면, 현재 i에서 num까지 몇번 이동해야하는지? 그리고 그 값이 최솟값인지?
                    min = Math.min(Math.abs(Integer.parseInt(num) - i) + str.length(), min); // str.length()인데 num.length()로 실수를 했다.
                }
        }
        System.out.println(min);
        }
    }
