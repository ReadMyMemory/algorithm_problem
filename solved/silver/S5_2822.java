package solved.silver;
import java.io.*;
import java.util.*;

public class S5_2822 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //모든 문제에 대한 점수는 서로 다르다고 했으니 인덱스를 저장하기 위해 배열 사용 가능.
        int[] index = new int[151]; // 이걸 맨 처음에 150으로 해버려서 점수가 150이면 ArrayIndexOutOfBounds 에러 뜬다. 수정
        ArrayList<Integer> list = new ArrayList<>();
        int num = 8;
        int j = 1;
        while(num --> 0) {
            int temp = Integer.parseInt(br.readLine());
            list.add(temp);
            index[temp] = j;
            j++;
        }
        list.sort(Comparator.reverseOrder());
        List<Integer> list2 = new LinkedList<>();
        int sum = 0;
        for(int i = 0; i < 5; i++) {
            int temp = list.get(i);
            sum += temp;
            list2.add(index[temp]);
        }
        Collections.sort(list2);
        bw.write(sum+"\n");
        for(int a : list2)
            bw.write(a+" ");
        bw.flush();
        br.close();
        bw.close();


    }
}
