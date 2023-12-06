package solved_ac_step.class1;

import java.util.Scanner;

public class a2439 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for(int i = 0; i < num; i++) {
            for(int j = 1; j < num - i; j++) {
                System.out.print(" ");
            }
            for(int p = 0; p <= i; p++) {
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }
}
