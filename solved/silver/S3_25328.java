package solved.silver;
import java.io.*;
import java.util.*;

public class S3_25328 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String X = br.readLine();
        String Y = br.readLine();
        String Z = br.readLine();
        int K = Integer.parseInt(br.readLine());

        Set<String> x_Combinations = getCombinations(X, K);
        Set<String> y_Combinations = getCombinations(Y, K);
        Set<String> z_Combinations = getCombinations(Z, K);

        Map<String, Integer> map = new HashMap<>();

        for(String s : x_Combinations)
            map.put(s, map.getOrDefault(s, 0) + 1);
        for(String s : y_Combinations)
            map.put(s, map.getOrDefault(s, 0) + 1);
        for(String s : z_Combinations)
            map.put(s, map.getOrDefault(s, 0) + 1);

        List<String> result = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            if(entry.getValue() > 1)
                result.add(entry.getKey());
        }

        Collections.sort(result);

        if(result.isEmpty())
            System.out.println("-1");
        else {
            for(String s : result)
                System.out.println(s);
        }
    }

    private static Set<String> getCombinations(String S, int k) {
        Set<String> combinations = new HashSet<>();
        generateCombinations(S, k, 0, "", combinations);
        return combinations;
    }

    private static void generateCombinations(String S, int k, int start, String current, Set<String> combinations) {
        if(current.length() == k) {
            combinations.add(current);
            return;
        }
        for(int i = start; i < S.length(); i++)
            generateCombinations(S, k, i + 1, current + S.charAt(i), combinations);
    }
}
