    package baekjun_step.step4;

    import java.io.*;
    import java.util.StringTokenizer;

    public class B3_10810 {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 바구니 개수
            int M = Integer.parseInt(st.nextToken()); // 공 index 개수

            int[] arr = new int[N];
            for(int i = 0; i < M; i++) {
                StringTokenizer st2 = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st2.nextToken());
                int end = Integer.parseInt(st2.nextToken());
                int index = Integer.parseInt(st2.nextToken());
                 for (int j = start; j <= end; j++)
                     arr[j-1] = index;
            }
            for(int printarr : arr)
                bw.write(printarr+" ");
            bw.flush();
            br.close();
            bw.close();
        }
    }

