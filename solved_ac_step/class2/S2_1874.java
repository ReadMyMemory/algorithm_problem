package solved_ac_step.class2;
import java.io.*;
import java.util.ArrayList;
import java.util.Stack;

public class S2_1874 {
    static boolean status = true; // NO를 출력할 것인가(false) 아니면 스택 로그를 출력할 것인가(true) 상태 여부 확인.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayList<String> list = new ArrayList<>(); // 스택 로그 기록용.
        int index = 0; //순차적으로 숫자 넣는 index 1부터 N까지 넣으면 끝.
        Stack<Integer> stack = new Stack<>();
        int N = Integer.parseInt(br.readLine());

        /*
        문제를 이해해보자. 테스트 케이스(8 / 4 3 6 8 7 5 2 1)
        1부터 8까지 순차적으로 넣을건데. 넣을 땐 index를 잡아서 순차적으로 넣음
        다음 숫자를 본다. 4다. index = 4 될때까지 index 1씩 늘려.
        그다음 4를 뺀다. 그다음 숫자를 본다
        3이다. index보다 작다. 그러면 push 하지 말고 pop 하는데, 이때 peek를 먼저 확인한다.
        peek가 3보다 작다면 이건 스택으로 풀 수 없다. NO 출력하면 된다.
        암튼 이를 반복한다. index가 8이 된 순간부턴 이제 빼기만 한다.
        peek를 본다. peek가 숫자보다 작다. 그러면 NO다.
        이제 풀어보자!
         */
        int repeat = N;
        while(repeat > 0) {
            int num = Integer.parseInt(br.readLine());
            if(index != N && index < num) { // index가 N까지 가지 않았고, index가 num보다 작다면
                while(index != num) { // index가 num까지 갈때까지 반복.
                    index++;
                    stack.push(index);
                    list.add("+");
                }
                stack.pop();
                list.add("-");
            }
            else if(index > num) {
                if(!stack.isEmpty()) {
                    while (stack.peek() != num) { // peek가 num이랑 같을 때까지 반복
                        if (stack.peek() < num) { // 만약 peek가 num보다 작으면
                            status = false; // 스택 구현 불가.
                            break; // while 반복문 탈출
                        } else { //
                            stack.pop(); // 스택 맨 위 제거
                            list.add("-"); // 리스트에 기록
                        }
                    }
                    if (!status) // while 반복문 탈출
                        break;
                    //status에 문제가 없으면서 반복문이 끝나면 stack.peek() == num 상태임. 그러니 이제 제거하면 된다.
                    stack.pop(); // 스택 맨 위 제거
                    list.add("-"); // 리스트에 기록
                } else { // 피크랑 들어온 숫자랑 비교해서 빼줘야 하는데 stack이 비어있다면, 이건 stack으로 구현할 수 없는 거라 NO 출력. 예제 입력 2와 같은 경우다. 마지막 4를 비교하려고 해도 스택이 아무것도 없음.
                    status = false;
                }
            }
            repeat--;
        }
        if(status) {
            for(String a : list)
                bw.write(a+"\n");
        } else {
            bw.write("NO");
        }
        bw.flush();
        br.close();
        bw.close();
        }
    }
