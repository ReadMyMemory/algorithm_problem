package solved_ac_step.class2;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class S4_1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine());
        int[] arr = new int[size];
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        ArrayList<Integer> list1 = new ArrayList<>();


        for(int i = 0; i < size; i++) { // 리스트 입력
            list1.add(Integer.parseInt(st1.nextToken()));
        }
        Collections.sort(list1); // 이분 탐색의 기본 조건

//        for(int a : list1)
//            System.out.println(a);

        int testcase = Integer.parseInt(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i = 0; i < testcase; i++) {
            int num = Integer.parseInt(st2.nextToken());
            if(Collections.binarySearch(list1, num) >= 0) // 양의 값을 가진다는 건 실제로 존재해서 인덱스를 뱉어냈다는 소리.
                //인덱스는 0번째일수도 있어서 등호 조건 추가해야 함.
                bw.write(1+"\n");
            else
                bw.write(0+"\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

}
