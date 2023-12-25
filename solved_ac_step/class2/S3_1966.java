package solved_ac_step.class2;
import java.io.*;
import java.util.*;

public class S3_1966 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        Queue<Integer> que;
        ArrayList<Integer> list;


        int testcase = Integer.parseInt(br.readLine());

        while(testcase > 0) {
            st = new StringTokenizer(br.readLine()); // 문서의 개수와 궁금한 인덱스 읽기

            int amount = Integer.parseInt(st.nextToken());
            int index = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine()); // N개 문서의 중요도 읽기
            que = new LinkedList<>(); // 중요도 저장을 위한 큐
            list = new ArrayList<>(); // 중요도 최댓값을 찾기 위한 리스트
            int number = 0; // 내가 찾는 인덱스의 문서가 언제 출력될지를 지속적으로 저장하는 변수
            int pollNumber = 0; // 몇번째인쇄인지 기록.

            while(st.hasMoreTokens()) {
                int value = Integer.parseInt(st.nextToken());
                list.add(value);
                que.add(value);
            }
            list.sort(Collections.reverseOrder()); // 내림차순 정렬, 중요도가 높은 걸로

            int max = list.get(0); // 중요도가 가장 높은 문서의 중요도 값
            while(!que.isEmpty()) {
                int value; // 맨 위 값의 중요도가 max보다 작다면 빼서 다시 뒤에 넣음.
                if(que.peek() < max) {
                    value = que.poll();
                    que.add(value);
                    if(number == index) {
                        index += que.size(); // 아직 빼지 못하는 내 문서. 다음에 큐 사이즈 만큼 돌았을 때 다시 시도.
                    }
                    number++;
                } else { // max와 큐 맨 앞의 중요도가 같거나 더 큼
                    que.poll();
                    pollNumber++;
                    if(number == index) {
                        bw.write(pollNumber+"\n"); // 내가 원하는 문서가 몇번째에 인쇄되는지 출력
                        break;
                    }
                    list.remove(0);
                    if(!list.isEmpty())
                        max = list.get(0);
                    number++;
                }
                }
            testcase--;
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
