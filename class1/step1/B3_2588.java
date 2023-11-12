package class1.step1;

import java.util.Scanner;

public class B3_2588 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        int [] arr = new int[3];
        for(int i = 0; i<3; i++) {
            arr[i] = Character.getNumericValue(b.charAt(i));
        }
        for(int j = 0; j<3; j++) {
            System.out.println(Integer.parseInt(a) * arr[2-j]);
        }
        System.out.println(Integer.parseInt(a) * Integer.parseInt(b));
    }
}
