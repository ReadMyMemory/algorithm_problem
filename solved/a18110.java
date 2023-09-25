package solved;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class a18110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        double amount = 0;

        long cut = Math.round(count * 0.15);
        int[] arr = new int [300000];
        for(int i =0; i<count; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            amount = amount + arr[i];
        }

        Arrays.sort(arr);

        for(int j=0; j<cut; j++) {
            amount -= arr[299999-j];
            amount -= arr[299999-count+j+1];
        }
//        System.out.println();
//        for(int w=299999-count+1;w<300000;w++)
//            System.out.print(arr[w]+" ");
//        System.out.println("");
        int level = 0;
        if(count != 0) {
            double d = (amount / (count - 2 * cut));
            level=(int)d;
            int a = (int)(d*10-Math.floor(d)*10);
            if(a>=5)level++;
        }
        System.out.println(level);
    }
}
