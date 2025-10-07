package solved.gold.G5;
import java.io.*;
import java.util.*;

public class G5_15686 {
    static int N, M;
    static ArrayList<int[]> houses = new ArrayList<>();
    static ArrayList<int[]> chickens = new ArrayList<>();
    static int minCityDistance = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int value = Integer.parseInt(st.nextToken());
                if (value == 1) {
                    houses.add(new int[]{i, j});
                } else if (value == 2) {
                    chickens.add(new int[]{i, j});
                }
            }
        }

        // M개의 치킨집을 선택하는 모든 조합을 시도
        combination(0, 0, new ArrayList<>());
        System.out.println(minCityDistance);
    }

    // 치킨집 중에서 M개를 선택하는 조합
    static void combination(int start, int count, ArrayList<int[]> selected) {
        if (count == M) {
            // 선택된 치킨집들로 도시의 치킨 거리 계산
            int cityDistance = calculateCityDistance(selected);
            minCityDistance = Math.min(minCityDistance, cityDistance);
            return;
        }

        for (int i = start; i < chickens.size(); i++) {
            selected.add(chickens.get(i));
            combination(i + 1, count + 1, selected);
            selected.remove(selected.size() - 1);
        }
    }

    // 선택된 치킨집들로 도시의 치킨 거리 계산
    static int calculateCityDistance(ArrayList<int[]> selectedChickens) {
        int totalDistance = 0;

        // 각 집마다 가장 가까운 치킨집까지의 거리를 구함
        for (int[] house : houses) {
            int minDistance = Integer.MAX_VALUE;
            for (int[] chicken : selectedChickens) {
                int distance = Math.abs(house[0] - chicken[0]) + Math.abs(house[1] - chicken[1]);
                minDistance = Math.min(minDistance, distance);
            }
            totalDistance += minDistance;
        }
        return totalDistance;
    }
}