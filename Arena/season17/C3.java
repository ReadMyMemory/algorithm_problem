package Arena.season17;
import java.io.*;
import java.util.ArrayList;

public class C3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int index = 3;
        ArrayList<Integer> list = new ArrayList<>();

        while(true) {
            if(list.size() == 0)  {
                list.add(1);
                list.add(2);
            }
            if(N == 2) break;
            list.add(index);

            for(int i = 0; i < list.size()-1; i++) {
                    if((list.get(i) *  list.get(list.size()-1)) % (list.get(i) + list.get(list.size()-1)) == 0)
                      list.remove(list.size()-1);
            }
            if(list.size() == N) break;
            index++;
        }
        for(int a : list)
            bw.write(a+" ");
        bw.flush();
        br.close();
        bw.close();
    }

}
