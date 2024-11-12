package solved.silver.S5;
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class S5_1316 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        while(N-->0) {
            String word = br.readLine();
            if(checking(word, word.length()))
                count++;
        }

        System.out.println(count);

    }

    static boolean checking(String word, int word_length) {
        ArrayList<String> list = new ArrayList<>(); // 특정 알파벳의 연속이 끝남. 이제 이 알파벳은 다시 등장해선 안됨.
        for(int i = 0; i < word_length; i++) {
            String s = String.valueOf(word.charAt(i));
            if(i == word_length-1) { // 단어의 마지막 단어인 경우 이미 나온 단어가 아닌지만 체크.
                if (!list.isEmpty()) {
                    for (int j = 0; j < list.size(); j++) {
                        if (s.equals(list.get(j)))
                            return false;
                    }
                }
            } else {
                if (!s.equals(String.valueOf(word.charAt(i + 1)))) {
                    if (!list.isEmpty()) {
                        for (int j = 0; j < list.size(); j++) {
                            if (s.equals(list.get(j)))
                                return false;
                        }
                    }
                    list.add(s);
                }
            }
        }
        return true;
    }
}
