package solved_ac_step.class2;
import java.io.*;
import java.util.StringTokenizer;

public class B3_4153 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int checksum = Integer.parseInt(st.nextToken());
            if(checksum == 0) {
                st.nextToken();
                st.nextToken();
                break;
            }
            else {
                int other1 = 0;
                int other2 = 0;
                int max = 0;
                int maxValue = 0;
                int[] arr = new int[3];
                arr[0] = checksum;
                if(maxValue <= arr[0]) {
                    maxValue = arr[0];
                    max = 0;
                    other1 = 1;
                    other2 = 2;
                } ;
                arr[1] = Integer.parseInt(st.nextToken());
                if(maxValue <= arr[1]) {
                    maxValue = arr[1];
                    max = 1;
                    other1 = 0;
                    other2 = 2;
                }
                arr[2] = Integer.parseInt(st.nextToken());
                if(maxValue <= arr[2]) {
                    maxValue = arr[2];
                    max = 2;
                    other1 = 0;
                    other2 = 1;
                }
                int C = arr[max] * arr[max];
                int ot = arr[other1] * arr[other1] + arr[other2] * arr[other2];
                if(C == ot) bw.write("right\n");
                else bw.write("wrong\n");
                }

            }
        bw.flush();
        br.close();
        bw.close();

        }
    }