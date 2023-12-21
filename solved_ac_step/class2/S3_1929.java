package solved_ac_step.class2;
import java.io.*;
import java.util.StringTokenizer;

public class S3_1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 소수 구하기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        //소수를 찾는 아이디어. 에라토스테네스의 체 사용
        boolean[] map = new boolean[end+1]; // 보기 좋게 인덱스 구성
        for(int i = start; i <= end; i++) {
            map[i] = true; // 값이 있으면 true, 없으면 false임.
        }
        // 2의 배수 4 6 8 10 12 .. 제거
        // 3의 배수 6 9 12 15 18 .. 제거.
        int index = 2; // 체크는 2부터 시작.
        while(index<=end) { //반복문은 체크가 마지막 번호까지 끝났을때
            int check = index; // 현재 체크 중인 숫자 저장용.
            if (!map[check] && index > start) { //체크는 2부터 하지만, 넣는 값이 2보다 큰 값이면 해당 조건을 통과하여 조건 검사 못함.
                //따라서 시작 값보다 index가 큰지를 검사해줘야 문제 없어짐.
                index++;
                continue; // 이번 체크 값이 이미 false(제거당했음)면 패스
            }
            int add = check; // 더하는 값은 일정해야함.
            check += add; // 맨처음 체크 값은 제거하지 않는 조건 명시.
            while(check <= end) {
                if (map[check]) // 해당 인덱스가 true 였다면 비워줌.
                    map[check] = false;
                check += add; // check의 배수. check가 2였다면 2+2 2+2+2 ...
            }
            index++;
        }

        //1은 당연히 소수가 아니다. 1이 값에 포함되어 체크되더라도 1은 따로 빼주도록 하자.
        map[1] = false;
        //배열의 값이 true이면 소수임. 그걸 출력
        for(int i = start; i <= end; i++) {
            if(map[i])
                bw.write(i+"\n");
        }
        bw.flush();
        br.close();
        bw.close();

    }
}
