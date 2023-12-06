package baekjun_step.step1;

import java.util.Scanner;

public class B5_25314 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while(n>0) {
            System.out.print("long"+" ");
            n = n-4;
        }
        System.out.println("int");
    }
}
