package solved.bronze.B1;
import java.io.*;

/*
문제가 똥같다
질문 게시판을 보고 나서야 제대로 이해할 수 있었다.
조건 명시를 제대로 안해주니 헷갈린듯..

추가로 틀린 부분은 내가 실수한 부분이었다.
무기 퇴사를 당한 경우 반복문을 break 해버리고 바로 출력해버렸는데, 이후 추가 벌점을 받아 영구 퇴사를 당할 수도 있었다.
따라서 영구 퇴사를 당하는지까지 sum을 지켜봐야한다.

언어에 따른 시간 제한 차등이 주어지지 않아 기존의 방법으로 풀긴 어렵다
다른 언어로 풀어야할듯?
 */

public class B1_16130 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int number = Integer.parseInt(br.readLine());
        while (number --> 0) {
            String s = br.readLine();
            int sum = 0;
            int week = 0;
            int index_week = 0;
            for (int i = 0; i < s.length(); i++) {
                int c = s.charAt(i) - '0';
                if (c >= 17)
                    c -= 7;
                sum += c;
                if(sum < 40) {
                    if (sum / 10 > index_week) {
                        week += sum / 10;
                        index_week = sum / 10;
                    }
                }
                if(sum >= 50)
                    break;
            }
            if(sum >= 50)
                bw.write(week + "(09)\n");
            else if(sum >= 40)
                bw.write(week + "(weapon)\n");
            else
                bw.write(week+"\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
