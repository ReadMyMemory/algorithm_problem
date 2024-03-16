package Arena.season24;
import java.io.*;
import java.util.StringTokenizer;

public class A1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[][] map = new String[10][10];
        StringTokenizer st;
        for(int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 10; j++)
                map[j][i] = st.nextToken();
        }
        int temp = 0;

        boolean status = false;

        for(int i = 0; i < 10; i++) {
            String standard = map[i][0];
            boolean isCheck = true;
            for(int j = 1; j < 10; j++) {
                if(!standard.equals(map[i][j]))
                    isCheck = false;
            }
            if(isCheck)
                status = true;
        }

        for(int i = 0; i < 10; i++) {
            String standard = map[0][i];
            boolean isCheck = true;
            for(int j = 1; j < 10; j++) {
                if(!standard.equals(map[j][i]))
                    isCheck = false;
            }
            if(isCheck)
                status = true;
        }

        if(status)
            System.out.println(1);
        else
            System.out.println(0);

    }
}
