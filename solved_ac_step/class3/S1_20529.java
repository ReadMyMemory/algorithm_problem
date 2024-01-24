package solved_ac_step.class3;
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class S1_20529 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        /*
        아이디어
        이산수학에서 배우는 비둘기집 원리라는게 있다.
        n+1마리의 비둘기가 n개의 비둘기 집에 넣는다면,
        적어도 한 집에는 비둘기가 2마리가 들어가있다는 원리다.
        이 문제에서 생각해보면
        예를 들어 mbti는 16종류가 있고 주어진 학생의 수는 33명이라면,
        같은 mbti를 가진 사람이 3명 이상인 경우가 무조건 존재한다는 것이다.
        그러면 당연하게도 거리는 0이 된다.
        아 그러면 32이하인 경우에만 내가 직접 찾아보고, 그게 아니면 0을 출력하면 되겠다!

        32C3해서 심리적 거리를 구하면 시간 복잡도가 어떻게 될까?
        32C3 = 4960이고,
        32! / 3! * (32-3)! 일 것이다.
        당연하지만 간소화해서 계산하지 않으면 분명 int로는 물론 long으로도 overflow 날 것이다.
        다만 3이 고정이기 때문에,
        nC3이라고 한다면, n * (n-1) * (n-2) / 6 이 결과값이 될 것이다.
        물론 조합을 코드로 짜야하는 건 아니라서 중요한 얘기는 아니였다.

         */

        int testcase = Integer.parseInt(br.readLine());
        for(int i = 0; i < testcase; i++) {
            int number = Integer.parseInt(br.readLine());
            int minValue = 32;
            if(number > 32) {
                br.readLine(); //32보다 크면 mbti가 같은 사람이 3명 이상인 경우가 무조건 존재.
                bw.write(String.valueOf(0)+"\n"); // !! 줄넘김 처리 안해줘서 틀림 ㅎㅎ
            } else {
                st = new StringTokenizer(br.readLine());
                String[] po = new String[number];
                int index = 0;
                while (st.hasMoreTokens()) {
                    po[index] = st.nextToken();
                    index++;
                }

                for(int j = 0; j < number; j++) {
                    for(int p = j + 1; p < number; p++) {
                        for(int k = p + 1; k < number; k++) {
                            minValue = Math.min(minValue, function(po[j], po[p], po[k]));
                        }
                    }
                }
                bw.write(minValue+"\n");
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }
    static int function(String person1, String person2, String person3) {
        int distance = 0;
        for(int i = 0; i < 4; i++) {
            if(person1.charAt(i) != person2.charAt(i)) // 예를 들어 I, E였다면 거리가 있는 것이다. 1추가
                distance +=1;
            if(person2.charAt(i) != person3.charAt(i))
                distance +=1;
            if(person3.charAt(i) != person1.charAt(i))
                distance +=1;
        }
        return distance;
    }

}
