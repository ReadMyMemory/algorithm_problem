package solved.bronze.B1;
import java.io.*;

public class B1_2816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int kbs1_idx = 0;
        int kbs2_idx = 0;
        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            if(s.equals("KBS1"))
                kbs1_idx = i;
            if(s.equals("KBS2"))
                kbs2_idx = i;
        }
        StringBuilder sb = new StringBuilder();

        if(kbs1_idx > kbs2_idx)
            kbs2_idx++;
        for(int i = 0; i < kbs1_idx; i++)
            sb.append("1");
        for(int i = 0; i < kbs1_idx; i++)
            sb.append("4");
        if(kbs2_idx != 1) {
            for(int i = 0; i < kbs2_idx; i++)
                sb.append("1");
            for(int i = 1; i < kbs2_idx; i++)
                sb.append("4");
        }
        System.out.println(sb.toString());

    }
}
