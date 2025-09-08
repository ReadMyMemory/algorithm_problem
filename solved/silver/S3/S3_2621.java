package solved.silver.S3;
import java.io.*;
import java.util.*;

public class S3_2621 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 카드 5장 입력받기
        char[] colors = new char[5];
        int[] numbers = new int[5];

        for (int i = 0; i < 5; i++) {
            String[] input = br.readLine().split(" ");
            colors[i] = input[0].charAt(0);
            numbers[i] = Integer.parseInt(input[1]);
        }

        int maxScore = 0;

        // 규칙 1: 같은 색 + 연속 숫자
        if (isSameColor(colors) && isConsecutive(numbers)) {
            int max = getMax(numbers);
            maxScore = Math.max(maxScore, max + 900);
        }

        // 규칙 2: 4장 같은 숫자
        int fourOfKind = getFourOfKind(numbers);
        if (fourOfKind != -1) {
            maxScore = Math.max(maxScore, fourOfKind + 800);
        }

        // 규칙 3: 3장 같은 숫자 + 2장 같은 숫자 (풀하우스)
        int[] fullHouse = getFullHouse(numbers);
        if (fullHouse[0] != -1) {
            maxScore = Math.max(maxScore, fullHouse[0] * 10 + fullHouse[1] + 700);
        }

        // 규칙 4: 같은 색
        if (isSameColor(colors)) {
            int max = getMax(numbers);
            maxScore = Math.max(maxScore, max + 600);
        }

        // 규칙 5: 연속 숫자
        if (isConsecutive(numbers)) {
            int max = getMax(numbers);
            maxScore = Math.max(maxScore, max + 500);
        }

        // 규칙 6: 3장 같은 숫자
        int threeOfKind = getThreeOfKind(numbers);
        if (threeOfKind != -1) {
            maxScore = Math.max(maxScore, threeOfKind + 400);
        }

        // 규칙 7: 2장 같은 숫자 + 2장 같은 숫자 (투페어)
        int[] twoPair = getTwoPair(numbers);
        if (twoPair[0] != -1) {
            int bigger = Math.max(twoPair[0], twoPair[1]);
            int smaller = Math.min(twoPair[0], twoPair[1]);
            maxScore = Math.max(maxScore, bigger * 10 + smaller + 300);
        }

        // 규칙 8: 2장 같은 숫자
        int pair = getPair(numbers);
        if (pair != -1) {
            maxScore = Math.max(maxScore, pair + 200);
        }

        // 규칙 9: 아무것도 해당 안됨
        if (maxScore == 0) {
            int max = getMax(numbers);
            maxScore = max + 100;
        }

        System.out.println(maxScore);
    }

    // 같은 색인지 확인
    static boolean isSameColor(char[] colors) {
        for (int i = 1; i < 5; i++) {
            if (colors[i] != colors[0]) return false;
        }
        return true;
    }

    // 연속된 숫자인지 확인
    static boolean isConsecutive(int[] numbers) {
        int[] sorted = numbers.clone();
        Arrays.sort(sorted);
        for (int i = 1; i < 5; i++) {
            if (sorted[i] != sorted[i-1] + 1) return false;
        }
        return true;
    }

    // 최대값 구하기
    static int getMax(int[] numbers) {
        int max = numbers[0];
        for (int i = 1; i < 5; i++) {
            max = Math.max(max, numbers[i]);
        }
        return max;
    }

    // 4장이 같은 숫자인지 확인
    static int getFourOfKind(int[] numbers) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : numbers) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if (entry.getValue() == 4) {
                return entry.getKey();
            }
        }
        return -1;
    }

    // 풀하우스 확인 (3장 + 2장)
    static int[] getFullHouse(int[] numbers) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : numbers) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        int three = -1, two = -1;
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if (entry.getValue() == 3) {
                three = entry.getKey();
            } else if (entry.getValue() == 2) {
                two = entry.getKey();
            }
        }
        if (three != -1 && two != -1) {
            return new int[]{three, two};
        }
        return new int[]{-1, -1};
    }

    // 3장이 같은 숫자인지 확인
    static int getThreeOfKind(int[] numbers) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : numbers) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if (entry.getValue() == 3) {
                return entry.getKey();
            }
        }
        return -1;
    }

    // 투페어 확인
    static int[] getTwoPair(int[] numbers) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : numbers) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        List<Integer> pairs = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if (entry.getValue() == 2) {
                pairs.add(entry.getKey());
            }
        }
        if (pairs.size() == 2) {
            return new int[]{pairs.get(0), pairs.get(1)};
        }
        return new int[]{-1, -1};
    }

    // 원페어 확인
    static int getPair(int[] numbers) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : numbers) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if (entry.getValue() == 2) {
                return entry.getKey();
            }
        }
        return -1;
    }
}