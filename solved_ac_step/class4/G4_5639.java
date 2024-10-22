package solved_ac_step.class4;
import java.io.*;

public class G4_5639 {
    static BufferedWriter bw;
    static int[] trees;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        trees = new int[10001];
        String line;
        int idx = 0;
        while(true) {
            line = br.readLine();
            if(line == null || line.equals(""))
                break;
            trees[idx++] = Integer.parseInt(line);
        }
        postOrder(0, idx - 1);
        bw.flush();
        br.close();
        bw.close();
    }

    private static void postOrder(int n, int end) throws IOException {
        if(n > end)
            return;

        int mid = n + 1;
        while(mid <= end && trees[mid] < trees[n]) // 조건 1. trees[n]이 먼저 입력받은 값인데, 그 뒤의 값이 먼저 입력받은 값보다 컸다면, 거기부터는 루트 노드에서의 오른쪽이다. 따라서 오른쪽이 나올때까지 while문을 반복해서 돌린다.
            mid++;

        postOrder(n + 1, mid - 1); //계속해서 발생하는 이진검색트리에서 루트 노드를 제외, 루트 노드에서의 오른쪽을 탐색하기 직전의 index(전위 순회에서는 왼쪽에서 가장 하단, 오른쪽에 있는 노드)를 end로 지정.
        postOrder(mid, end); //계속해서 발생하는 이진검색트리에서 우측 부분을 탐색.
        bw.write(trees[n]+"\n");
    }
}
