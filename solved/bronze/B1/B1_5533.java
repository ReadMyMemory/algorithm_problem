package solved.bronze.B1;
import java.io.*;
import java.util.*;

/*
처음에 모든 라운드 대상으로 중복을 체크하는 줄 알고 hashmap과 hashset을 이용해 중복을 제거하려고 했었는데
각 라운드 별로 적용이었다. 그래서 브론즈 1인가 보다.
 */
public class B1_5533 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] scores = new int[N+1][3]; // 참가자 점수 기록
        int[] finalScore = new int[N+1]; // 최종 점수

        //참가자 점수 입력부
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++)
                scores[i][j] = Integer.parseInt(st.nextToken());
        }

        //최종 점수 계산
        for(int i = 0; i < 3; i++) { // 게임 라운드는 총 3번
            for(int j = 1; j <= N; j++) {
                int playerNum = j;
                boolean isUnique = true;
                for(int p = 1; p <= N; p++) {
                    if(p == j)
                        continue;
                    if(scores[p][i] == scores[playerNum][i]) {
                        isUnique = false;
                        break;
                    }
                }
                if(isUnique) // 중복 없는 경우에만 최종 점수에 추가
                    finalScore[playerNum] += scores[playerNum][i];
            }
        }

        //출력부
        for(int i = 1; i <= N; i++)
            bw.write(finalScore[i]+"\n");

        bw.flush();
        br.close();
        bw.close();
    }
}


/*
아래는 전체 라운드 대상으로 다른 사람과 점수가 겹쳐 중복 제거했을 때를 조건으로 보고 푼 문제다. 코드가 아까워서 남겨놓음.

public class B1_5533 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Map<Integer, ArrayList<Integer>> map = new HashMap<>(); // 참가자들의 역대 점수 기록 <플레이어순서, 점수 리스트>
        int[][] scores = new int[N+1][3]; // 참가자 점수 기록

        //참가자 점수 입력부
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            Set<Integer> unique = new HashSet<>(); // 중복이 허용되지 않는 Set 이용하여 고유한 점수만 추가
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                int score = Integer.parseInt(st.nextToken());
                scores[i][j] = score;
                if (unique.add(score))
                    list.add(score);
            }
            map.put(i, list);
        }

        for(int i = 0; i < N; i++) {
            int playerNum = i; // 현재 점수 출력 대상의 참가자. 이 순번에서 나왔던 숫자는 무시할거다.
            Set<Integer> scoreSet = new HashSet<>(); // 자기꺼 제외하고 점수만 Set으로 받음.
            for(int j = 0; j < N; j++) {
                if(j == playerNum)
                    continue;
                scoreSet.addAll(map.get(j));
            }
            int finalScore = 0;
            for(int p = 0; p < 3; p++) {
                if(!scoreSet.contains(scores[playerNum][p])) // 기존 Set에 없는 점수였다면
                    finalScore += scores[playerNum][p];
            }
            bw.write(finalScore+"\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
 */
