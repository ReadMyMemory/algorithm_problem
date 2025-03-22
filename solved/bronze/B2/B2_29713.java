package solved.bronze.B2;
import java.io.*;
import java.util.*;

public class B2_29713 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String stickers = br.readLine();

        String target = "BRONZESILVER";
        Map<Character, Integer> targetCount = new HashMap<>();
        Map<Character, Integer> stickerCount = new HashMap<>();

        for (char c : target.toCharArray()) {
            targetCount.put(c, targetCount.getOrDefault(c, 0) + 1);
        }

        for (char c : stickers.toCharArray()) {
            stickerCount.put(c, stickerCount.getOrDefault(c, 0) + 1);
        }

        int minSets = Integer.MAX_VALUE;

        for (char c : targetCount.keySet()) {
            if (!stickerCount.containsKey(c)) {
                minSets = 0;
                break;
            }
            minSets = Math.min(minSets, stickerCount.get(c) / targetCount.get(c));
        }

        System.out.println(minSets);
    }
}
