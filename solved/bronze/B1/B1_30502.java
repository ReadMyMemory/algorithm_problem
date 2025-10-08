package solved.bronze.B1;
import java.io.*;
import java.util.*;

public class B1_30502 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 각 생물의 특징 저장
        // 0: 광합성 여부 (null: 모름, true: 있음, false: 없음)
        // 1: 운동성 여부 (null: 모름, true: 있음, false: 없음)
        Boolean[][] features = new Boolean[N + 1][2];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            char b = st.nextToken().charAt(0);
            int c = Integer.parseInt(st.nextToken());

            int idx = (b == 'P') ? 0 : 1;
            features[a][idx] = (c == 1);
        }

        int minPlants = 0;
        int maxPlants = 0;

        for (int i = 1; i <= N; i++) {
            Boolean hasPhotosynthesis = features[i][0];
            Boolean hasMotility = features[i][1];

            // 최솟값: 확실하게 식물인 경우만 카운트
            // 광합성 O, 운동성 X인 경우만
            if (hasPhotosynthesis != null && hasPhotosynthesis &&
                    hasMotility != null && !hasMotility) {
                minPlants++;
            }

            // 최댓값: 식물일 가능성이 있는 경우 모두 카운트
            // 광합성이 X가 아니고, 운동성이 O가 아닌 경우
            boolean canBePlant = true;

            // 광합성이 명확히 없으면 식물이 될 수 없음
            if (hasPhotosynthesis != null && !hasPhotosynthesis) {
                canBePlant = false;
            }

            // 운동성이 명확히 있으면 식물이 될 수 없음
            if (hasMotility != null && hasMotility) {
                canBePlant = false;
            }

            if (canBePlant) {
                maxPlants++;
            }
        }
        System.out.println(minPlants + " " + maxPlants);
    }
}