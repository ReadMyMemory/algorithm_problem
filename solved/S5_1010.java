    package solved;

    import java.io.*;
    import java.util.StringTokenizer;

    public class S5_1010 {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            /*
            다리는 겹치면 안됨. 그러면서 최대한 다리 많이
            겹친다는 건, 매번 다리를 지을 때 바로 이전 서쪽 인덱스를 확인해서 새로 연결되는 다리의 동쪽 인덱스가 더 작아야함.
            겹치면 안되니까 작으면 안되고, 커야함.
             */
            int repeat = Integer.parseInt(br.readLine());

            while(repeat>0) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                long answer = buildBridge(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
                bw.write(answer+"\n");
                repeat--;
            }
            bw.flush();
            br.close();
            bw.close();
        }

        public static long buildBridge(long west, long east) {
            //사실상 조합이다. 다리를 선택하는거다. 임의로 west 개만.
            //어쩌피 겹치지 않는 건 내가 순번 지정해줘야 하고, 그건 west의 인덱스에 따라
            //순서대로 정해지니까 조합인거다.
            if(east == west)
                return 1;
            //29 12
            if(east-west <= west) // 계산을 가능한 간소화 하기. 이걸 해야 오버플로우 안남. 29 c 23 = 29 c 6 이용하는거.

                return fact(east, west) / fact(east-west, 1);
            else
                return fact(east, east-west) / fact(west, 1);
        }

        public static long fact(long n, long m) {
            if(n-m <= 0)
                return 1;
            else {
                return fact(n-1, m) * n;
            }
            }

    }

