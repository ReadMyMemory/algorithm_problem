package solved_ac_step.class3;
import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class S5_10814 {
    // comparable을 사용하면 매우 쉬운 문제. 아이디어가 딱히 필요 없었다.
    static class Pair implements Comparable<Pair> {
        int age, index;
        String name;
        public Pair(int age, String name, int index) {
            this.age = age;
            this.name = name;
            this.index = index;
        }

        @Override
        public int compareTo(Pair pair) {
            if(this.age == pair.age) // 나이가 같으면 가입한 순서로.
                return Integer.compare(this.index, pair.index);
            return Integer.compare(this.age, pair.age);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int number = Integer.parseInt(br.readLine());
        Pair[] member = new Pair[number];
        for(int i = 0; i < number; i++) {
            st = new StringTokenizer(br.readLine());
            member[i] = new Pair(Integer.parseInt(st.nextToken()), st.nextToken(), i); // 처음은 age, 뒤는 이름이 담긴다.
        }
        Arrays.sort(member); // 위에서 적은 Pair 정렬 기준에 따라 정렬
        for(int i = 0; i < number; i++) {
            bw.write(member[i].age+" "+member[i].name+"\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
