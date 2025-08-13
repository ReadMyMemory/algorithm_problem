package solved.silver.S3;
import java.io.*;
import java.util.*;

public class S3_15886 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String map = br.readLine();

        // 각 시작 위치에서 방문하는 칸들을 저장
        List<Set<Integer>> visitedSets = new ArrayList<>();

        for (int start = 0; start < n; start++) {
            Set<Integer> visited = new HashSet<>();
            Set<Integer> currentPath = new HashSet<>();
            int pos = start;

            // 사이클을 찾을 때까지 이동
            while (!currentPath.contains(pos)) {
                currentPath.add(pos);
                visited.add(pos);

                // 다음 위치로 이동
                if (map.charAt(pos) == 'E') {
                    pos++;
                } else { // W
                    pos--;
                }

                // 범위 체크 (문제 조건상 벗어나지 않음)
                if (pos < 0 || pos >= n) {
                    break;
                }
            }

            // 사이클에 포함된 칸들도 visited에 추가
            if (pos >= 0 && pos < n) {
                Set<Integer> cycle = new HashSet<>();
                int cycleStart = pos;
                do {
                    cycle.add(pos);
                    if (map.charAt(pos) == 'E') {
                        pos++;
                    } else {
                        pos--;
                    }
                } while (pos != cycleStart);
                visited.addAll(cycle);
            }

            visitedSets.add(visited);
        }

        // 모든 시작 위치에서 공통으로 방문하는 칸 찾기
        Set<Integer> common = new HashSet<>(visitedSets.get(0));
        for (int i = 1; i < visitedSets.size(); i++) {
            common.retainAll(visitedSets.get(i));
        }

        // 공통 칸이 있으면 1개만 놓으면 됨
        if (!common.isEmpty()) {
            System.out.println(1);
        } else {
            // 공통 칸이 없으면, 최소 개수의 칸으로 모든 경로를 커버
            // 그리디 접근: 가장 많은 경로를 커버하는 칸을 선택
            Set<Integer> covered = new HashSet<>();
            int count = 0;

            while (covered.size() < n) {
                int bestPos = -1;
                int maxCover = 0;

                // 각 위치에 대해 커버할 수 있는 시작점 개수 계산
                for (int pos = 0; pos < n; pos++) {
                    int coverCount = 0;
                    for (int start = 0; start < n; start++) {
                        if (!covered.contains(start) && visitedSets.get(start).contains(pos)) {
                            coverCount++;
                        }
                    }
                    if (coverCount > maxCover) {
                        maxCover = coverCount;
                        bestPos = pos;
                    }
                }

                // 선택한 위치가 커버하는 시작점들을 표시
                for (int start = 0; start < n; start++) {
                    if (visitedSets.get(start).contains(bestPos)) {
                        covered.add(start);
                    }
                }
                count++;
            }
            System.out.println(count);
        }
    }
}