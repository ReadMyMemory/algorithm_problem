package solved.silver;
import java.io.*;
import java.util.Collections;
import java.util.LinkedList;

public class S5_1251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 검색의 이점은 Arraylist. 데이터의 삽입이나 삭제의 이점이 있는 건 LinkedList. 따라서 후자를 사용하는게 좋아보였다.
//        ArrayList<String> list = new ArrayList<>();
        LinkedList<String> list = new LinkedList<>();

        //단어 입력
        String temp = br.readLine();

        //세 단어로 나누기. 그리고 뒤집기. 그리고 합치기
        int length = temp.length();
        for(int i = 2; i < length; i++) {
            for(int j = 1; j < i; j++) {
                StringBuilder sb1 = new StringBuilder(temp.substring(0, j));
                StringBuilder sb2 = new StringBuilder(temp.substring(j, i));
                StringBuilder sb3 = new StringBuilder(temp.substring(i));
                String s1 = sb1.reverse().toString();
                String s2 = sb2.reverse().toString();
                String s3 = sb3.reverse().toString();
                list.add(s1 + s2 + s3);
            }
        }
        Collections.sort(list); // 사전 순 정렬
        System.out.println(list.pop());


    }
}
