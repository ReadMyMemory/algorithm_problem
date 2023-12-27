package solved_ac_step.class3;
import java.io.*;

public class S3_1003 {
    static int X0;
    static int X1;
    public static void fibonacci(int n) {
        int count = 2;
        int a = 1;
        int b = 1;
        int temp;
        if(n == 0) {
            X0 = 1;
            X1 = 0;
        }
        else if(n == 1) {
            X0 = 0;
            X1 = 1;
        }
        else if(n == 2) {
            X0 = 1;
            X1 = 1;
        }
        else {
            while (count < n) {
                temp = b;
                b = a+b;
                a = temp;
                count++;
            }
            X0 = a;
            X1 = b;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testcase = Integer.parseInt(br.readLine());
        while (testcase > 0) {
            /*
            아이디어를 생각해보기 위해 일단 호출을 직접 해본다.
            2 -> 1 0  (1/1)
            3 -> 2 1 -> (1 0) 1   (2/1)
            4 -> 3 2 -> (1 0 1) 1 0  (3/2)
            5 -> 4 3 -> (1 0 1 1 0) (1 0 1) (5/3)
            6 -> 5 4 -> (1 0 1 1 0 1 0 1) (1 0 1 1 0) (8/5)
            7 -> (13 / 8)
            8 -> (21 / 13)

            1의 개수 0의 개수 또한 피보나치 수열이다.
            1의 경우 1 2 3 5 8 13 21 34 55...
            0의 경우 1 1 2 3 5 8 13 21 34 55...
            0은 1보다 하나씩 순서가 늦는다.
             */
            X0 = 0;
            X1 = 0;
            fibonacci(Integer.parseInt(br.readLine()));
            bw.write(X0+" ");
            bw.write(X1+"\n");
            testcase--;
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
