package solved.bronze.B4;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class B4_2752 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n1 = Integer.parseInt(st.nextToken());
        int n2 = Integer.parseInt(st.nextToken());
        int n3 = Integer.parseInt(st.nextToken());
        ArrayList<Integer> list = new ArrayList<>();
        list.add(n1);
        list.add(n2);
        list.add(n3);
        Collections.sort(list);
        System.out.println(list.get(0)+" "+list.get(1)+" "+list.get(2));
    }
}
