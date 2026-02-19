package solved.bronze.B2;
import java.io.*;
import java.util.*;

public class B2_1076 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String c1 = br.readLine().trim();
        String c2 = br.readLine().trim();
        String c3 = br.readLine().trim();

        Map<String, Integer> value = new HashMap<>();
        value.put("black", 0);
        value.put("brown", 1);
        value.put("red", 2);
        value.put("orange", 3);
        value.put("yellow", 4);
        value.put("green", 5);
        value.put("blue", 6);
        value.put("violet", 7);
        value.put("grey", 8);
        value.put("white", 9);

        int first = value.get(c1);
        int second = value.get(c2);
        int mulExp = value.get(c3);

        long base = first * 10L + second;
        long result = base;
        for (int i = 0; i < mulExp; i++) result *= 10L;

        System.out.print(result);
    }
}
