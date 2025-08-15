package solved.silver.S3;
import java.io.*;
import java.util.*;

public class S3_12867 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N차원 입력 (실제로는 사용하지 않지만 문제 조건)
        int N = Integer.parseInt(br.readLine());

        // 여행 계획의 길이
        int M = Integer.parseInt(br.readLine());

        // 좌표 인덱스 배열 (1-indexed)
        String[] indexInput = br.readLine().split(" ");
        int[] indices = new int[M];
        for (int i = 0; i < M; i++) {
            indices[i] = Integer.parseInt(indexInput[i]) - 1; // 0-indexed로 변환
        }

        // 방향 문자열 (+/-)
        String directions = br.readLine();

        // 방문한 점들을 저장할 Set
        Set<String> visited = new HashSet<>();

        // 현재 위치를 저장할 Map (좌표 인덱스 -> 값)
        // 대부분의 좌표는 0이므로 Map을 사용하여 0이 아닌 값만 저장
        Map<Integer, Integer> currentPos = new HashMap<>();

        // 시작점 (원점) 방문 처리
        visited.add(positionToString(currentPos));

        // 여행 계획대로 이동
        for (int i = 0; i < M; i++) {
            int coordIndex = indices[i];
            char direction = directions.charAt(i);

            // 현재 좌표값 가져오기 (없으면 0)
            int currentValue = currentPos.getOrDefault(coordIndex, 0);

            // 방향에 따라 이동
            if (direction == '+') {
                currentPos.put(coordIndex, currentValue + 1);
            } else {
                currentPos.put(coordIndex, currentValue - 1);
            }

            // 0이 된 좌표는 Map에서 제거 (메모리 효율)
            if (currentPos.get(coordIndex) == 0) {
                currentPos.remove(coordIndex);
            }

            // 현재 위치를 문자열로 변환
            String posStr = positionToString(currentPos);

            // 이미 방문한 점인지 확인
            if (visited.contains(posStr)) {
                System.out.println(0);
                return;
            }

            // 방문 처리
            visited.add(posStr);
        }

        // 모든 점을 중복 없이 방문함
        System.out.println(1);
    }

    // Map을 문자열로 변환하는 함수
    private static String positionToString(Map<Integer, Integer> pos) {
        if (pos.isEmpty()) {
            return "origin";
        }

        // 좌표 인덱스를 정렬하여 일관된 문자열 생성
        List<Integer> keys = new ArrayList<>(pos.keySet());
        Collections.sort(keys);

        StringBuilder sb = new StringBuilder();
        for (int key : keys) {
            sb.append(key).append(":").append(pos.get(key)).append(",");
        }
        return sb.toString();
    }
}