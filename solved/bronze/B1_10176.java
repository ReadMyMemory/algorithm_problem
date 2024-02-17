package solved.bronze;
import java.io.*;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class B1_10176 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            if(isOpposite(br.readLine()))
                bw.write("Yes\n");
            else
                bw.write("No\n");
        }
        bw.flush();
    }
    static boolean isOpposite(String s) {
        s = s.toUpperCase().replaceAll("[^A-Z]", ""); // 모두 대문자로 변경, 알파벳 이외의 요소 제거
        int size = s.length();
        if(size == 0)
            return true;
        ArrayList<String> list = new ArrayList<>();
        for(int i = 0; i < size; i++)
            list.add(String.valueOf(s.charAt(i)));
        boolean status = false;
        while(list.size() != 0) {
            String st = list.get(0);
            list.remove(0);
            String tmp = Opposite(st);
            for(int i = 0; i < list.size(); i++) {
                String ss = String.valueOf(list.get(i));
                if(tmp.equals(ss)) {
                    list.remove(i);
                    status = true;
                    break;
                }
            }
            if(!status)
                break;
        }
        return status;
    }

    static String Opposite(String s) {
        //알파벳을 넣으면 아스키코드 값을 이용하여 반대 알파벳을 반환해주는 함수
        char temp = s.charAt(0);
        int diff = 90 + (65 - (int)temp);
        return Character.toString((char) diff);
    }
}


/*
함수 검증. A ~ Z
        System.out.println(Opposite("A"));
        System.out.println(Opposite("B"));
        System.out.println(Opposite("C"));
        System.out.println(Opposite("D"));
        System.out.println(Opposite("E"));
        System.out.println(Opposite("F"));
        System.out.println(Opposite("G"));
        System.out.println(Opposite("H"));
        System.out.println(Opposite("I"));
        System.out.println(Opposite("J"));
        System.out.println(Opposite("K"));
        System.out.println(Opposite("L"));
        System.out.println(Opposite("M"));
        System.out.println(Opposite("N"));
        System.out.println(Opposite("O"));
        System.out.println(Opposite("P"));
        System.out.println(Opposite("Q"));
        System.out.println(Opposite("R"));
        System.out.println(Opposite("S"));
        System.out.println(Opposite("T"));
        System.out.println(Opposite("U"));
        System.out.println(Opposite("V"));
        System.out.println(Opposite("W"));
        System.out.println(Opposite("X"));
        System.out.println(Opposite("Y"));
        System.out.println(Opposite("Z"));
 */