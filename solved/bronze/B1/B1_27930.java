package solved.bronze.B1;
import java.io.*;
import java.util.ArrayList;

/*
풀고 나니 arrayList 안쓰고
큐 써도 됐을 것 같다.
 */

public class B1_27930 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        ArrayList<Character> yonsei = new ArrayList<>();
        ArrayList<Character> korea = new ArrayList<>();
        yonsei.add('Y');
        yonsei.add('O');
        yonsei.add('N');
        yonsei.add('S');
        yonsei.add('E');
        yonsei.add('I');
        korea.add('K');
        korea.add('O');
        korea.add('R');
        korea.add('E');
        korea.add('A');

//        char[] yonsei = {'Y', 'O', 'N', 'S', 'E', 'I'};
//        char[] korea = {'K', 'O', 'R', 'E', 'A'};

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == yonsei.get(0)) {
                yonsei.remove(0);
                if(yonsei.size() == 0) {
                    System.out.println("YONSEI");
                    break;
                }
            }
            if(s.charAt(i) == korea.get(0)) {
                korea.remove(0);
                if(korea.size() == 0) {
                    System.out.println("KOREA");
                    break;
                }
            }
        }
    }
}
