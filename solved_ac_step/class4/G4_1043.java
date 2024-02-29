package solved_ac_step.class4;
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class G4_1043 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        //첫째 줄 입력, 사람의 수 N과 파티의 수 M
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        //둘째 줄 입력, 진실을 아는 사람의 수와 번호
        st = new StringTokenizer(br.readLine());
        int tod = Integer.parseInt(st.nextToken());
        ArrayList<Integer> isTruth = new ArrayList<>();
//        while(tod -> 0) {
            isTruth.add(Integer.parseInt(st.nextToken()));
        }
    }
