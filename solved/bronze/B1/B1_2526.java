package solved.bronze.B1;
import java.io.*;
import java.util.HashMap;

public class B1_2526 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int P = Integer.parseInt(input[1]);

        HashMap<Integer, Integer> map = new HashMap<>();

        int current = N;
        int index = 0;

        while (!map.containsKey(current)) {
            map.put(current, index++);
            current = (current * N) % P;
        }

        int startIndex = map.get(current);
        int cycleLength = map.size() - startIndex;

        System.out.println(cycleLength);
    }
}
