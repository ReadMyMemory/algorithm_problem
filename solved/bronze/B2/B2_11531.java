package solved.bronze.B2;
import java.util.*;

public class B2_11531 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 문제별 제출 상태를 기록하는 맵
        Map<String, ProblemStatus> problemMap = new HashMap<>();

        while (true) {
            String line = scanner.nextLine();

            if (line.equals("-1")) {
                break;
            }

            String[] parts = line.split(" ");
            int time = Integer.parseInt(parts[0]);
            String problem = parts[1];
            String result = parts[2];

            // 이미 해결된 문제는 무시함
            problemMap.putIfAbsent(problem, new ProblemStatus());
            ProblemStatus status = problemMap.get(problem);

            if (status.solved)
                continue;


            if (result.equals("right")) {
                status.solved = true;
                status.solveTime = time;
            } else if (result.equals("wrong"))
                status.wrongAttempts++;

        }

        int solvedCount = 0;
        int totalPenalty = 0;

        // 문제별 페널티 계산
        for (ProblemStatus status : problemMap.values()) {
            if (status.solved) {
                solvedCount++;
                totalPenalty += status.solveTime + status.wrongAttempts * 20;
            }
        }

        // 결과 출력
        System.out.println(solvedCount + " " + totalPenalty);
    }

    static class ProblemStatus {
        boolean solved = false;
        int solveTime = 0;
        int wrongAttempts = 0;
    }
}
