package solved.silver;
import java.io.*;
import java.util.ArrayList;

/*
처음에 스택을 사용할까 하다가 복잡해서 아래와 같은 방법을 생각했다.
N과 S가 번갈아 나오는 개수를 체크하여 리스트에 저장
배열에 이웃하는 값들 중 작은 값이 곧 막대자석 문자열의 길이다.
여기서 최대치를 구하면 된다.
 */

/*
범위 조건을 계속 틀리는 바람에 살짝 헤맸다.
while문의 le != s.length(), if문의 le < s.length(), le >= s.length()에 대해서 좀 더 생각해보고 고쳐서 해결했다.
 */

public class S5_26122 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        String s = br.readLine();
        int le = 0;
        while(le != s.length()) {
            int temp = 0;
            char standard = s.charAt(le);
            le++;
            temp++;
            if(le < s.length()) { // stringindexoutofbound 예방
                while (s.charAt(le) == standard) {
                    le++;
                    temp++;
                    if (le >= s.length())
                        break;
                }
            }
            list.add(temp);
        }

        int max = 0;
        for(int i = 0; i < list.size() - 1; i++) {
            int temp = Math.min(list.get(i), list.get(i+1));
            if(max < temp)
                max = temp;
        }
        System.out.println(max * 2);
        }
    }
