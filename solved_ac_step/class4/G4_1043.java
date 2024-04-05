package solved_ac_step.class4;
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
진실을 아는 사람이 있는 파티장에서는 지민이는 진실을 말할 수 밖에 없다.
진실을 모르는 사람이라도, 진실을 아는 사람과 같이 파티를 즐겼던 사람들은 모두 진실을 알게 된다.
그러면 그렇게 진실을 알게 된 사람이 다른 파티에 갔을 때도 지민은 진실을 말해야 한다.
약간 바이러스 같은 느낌이다.
결국, 진실을 아는 어떤 사람과 같은 파티에 참여하는(그래프 상으로 연결된) 사람들은 모두 진실을 알게 되고, 지민은 그러한 파티에서 진실을 말할 수 밖에 없기 때문에,
그래프 탐색을 거쳐서 일단 방문 처리 한 후, 방문 처리 되지 않은 곳을 찾아 그 파티 수를 체크한다.
사실 조금만 더 쉽게 생각하면, 이차원 배열을 이용하여 각 열마다 파티에 참가하는 사람 리스트를 받은 후,
진실을 아는 사람을 기준으로 같이 파티에 참여하는 사람들을 소거해 나가면
파티의 개수를 쉽게 특정할 수 있을 것이다.
 */

public class G4_1043 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        //첫째 줄 입력, 사람의 수 N과 파티의 수 M
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 사람의 수
        int M = Integer.parseInt(st.nextToken()); // 파티의 수

        /*
        & & & & & ... & (N개)
        .
        .
        .
        &(M개)
         */
        int[][] party = new int[M][N+1]; // N+1로 잡은 건 사람 index랑 맞춰서 편하게 보려고.
        // 상태 0 - 참여 x  상태 1 - 참여함 상태 2 - 참여하면서 진실을 아는 사람. 이렇게 할거다.


        //둘째 줄 입력, 진실을 아는 사람의 수와 번호
        st = new StringTokenizer(br.readLine());
        int tod = Integer.parseInt(st.nextToken());
        ArrayList<Integer> isTruth = new ArrayList<>();
        if (tod != 0) { //0이 아니면 진실을 아는 사람이 존재
            while(st.hasMoreTokens())
                isTruth.add(Integer.parseInt(st.nextToken()));
        }

        //셋째 줄부터 M번째 줄까지. 입력
        int tempM = M;
        int indexM = 0; // 파티의 인덱스
        while(tempM --> 0) {
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()) {
                int num = Integer.parseInt(st.nextToken()); // 파티에 참여하는 사람 수
                while(num --> 0)
                    party[indexM][Integer.parseInt(st.nextToken())] = 1; // 상태 1 - 참여함으로 기록.
            }
            indexM++;
        }

        //1차 순회. 진실을 아는 사람이 있는 경우 상태 2로 변경
        if(!isTruth.isEmpty()) {
            for (int i = 0; i < M; i++) {
                for (int a : isTruth) {
                    if (party[i][a] == 1)
                        party[i][a] = 2;
                }
            }
        }

        //파티 순회. 진실을 아는 사람이 존재하는지를 상태로 파악후 해당 파티에 참여하는 모든 사람을 진실을 알도록 변경.
        //순회가 끝나는 시점은 모든 파티를 돌아도 더이상 진실을 알아야 하는 사람이 추가되지 않을 때.
        while(true) {

            if(!isTruth.isEmpty()) {
                for (int i = 0; i < M; i++) {
                    for (int a : isTruth) {
                        if (party[i][a] == 1)
                            party[i][a] = 2;
                    }
                }
            }
            boolean status = false;
            for (int i = 0; i < M; i++) {
                boolean status2 = false; // 내부에서 진실이 있는 사람을 찾아서 이후 상태 1인 값들을 2로 바꿀 때 확인하는 상태값
                for (int j = 1; j <= N; j++) {
                    if (party[i][j] == 2) {
                        status2 = true;
                        break;
                    }
                }
                if (status2) {
                    for (int k = 1; k <= N; k++) {
                        if (party[i][k] == 1) {
                            boolean status3 = false; // list에 이미 진실된 사람으로 등록되어 있는지?
                            for (int a : isTruth) {
                                if (a == k)
                                    status3 = true;
                            }
                            if (!status3)
                                isTruth.add(k);
                            status = true; // 다시 순회를 돌아야 하는 경우 체크.
                            party[i][k] = 2;
                        }
                    }
                }
            }
            if(!status)
                break;
            else
                status = false;
        }

        //참고용. 배열 출력
//        for(int i = 0; i < M; i++) {
//            for(int j = 1; j <= N; j++) {
//                bw.write(party[i][j]+" ");
//            }
//            bw.write("\n");
//        }


        //과장된 얘기를 할 수 있는 파티의 개수 세기
        int count = 0;
        for(int i = 0; i < M; i++) {
            boolean status4 = true; // 과장된 얘기를 할 수 있음?
            for(int j = 1; j <= N; j++) {
                if(party[i][j] == 2)
                    status4 = false;
            }
            if(status4)
                count++;
        }
        System.out.println(count);
    }
}
