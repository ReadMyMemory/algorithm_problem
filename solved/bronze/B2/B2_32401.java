package solved.bronze.B2;
import java.io.*;
import java.util.ArrayList;

public class B2_32401 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        String s = br.readLine();
        ArrayList<Integer> list = new ArrayList<>();
        int count = 0;

        for(int i = 0; i < length; i++) {
            if(s.charAt(i) == 'A')
                list.add(i);
        }

        for(int i = 0; i < list.size()-1; i++) {
            int startAt = list.get(i);
            int endAt = list.get(i+1);
            if(endAt - startAt == 1)
                continue;

            int is_N = 0;
            for(int j = startAt+1; j < endAt; j++) {
                if(s.charAt(j) == 'N')
                    is_N++;
            }
            if(is_N == 1)
                count++;
        }

        System.out.println(count);

    }
}
