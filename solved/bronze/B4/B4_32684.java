package solved.bronze.B4;
import java.io.*;
import java.util.StringTokenizer;

public class B4_32684 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int[] score = {13, 7, 5, 3, 3, 2};
        double cho = 0;
        double han = 1.5;
        for(int i = 0; i < 6; i++) {
            cho += Integer.parseInt(st1.nextToken()) * score[i];
            han += Integer.parseInt(st2.nextToken()) * score[i];
        }
        if(cho > han)
            System.out.println("cocjr0208");
        else
            System.out.println("ekwoo");
    }
}
