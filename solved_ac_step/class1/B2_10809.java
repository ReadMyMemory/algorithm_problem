package solved_ac_step.class1;

import java.io.*;


public class B2_10809 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[26]; // 알파벳은 26자니까,
        for(int i = 0; i < 26; i++) // 처음엔 그냥 배열 값이 0이면 -1을 출력하자 라고 했는데 그러고 보니 문자의 맨 처음 index가 0이라 이거랑 구분이 안된다.
            arr[i] = -1;



        String str = br.readLine();
        for(int i = 0; i < str.length(); i++) {
            int index = str.charAt(i) - '0' - 49;
             if(arr[index] == -1)  // 가장 처음 등장하는 위치만 기록해야한다. 따라서 -1 일때만 변환.
                 arr[index] = i; // string을 한글자씩 끊어 int로 변환. 그 값을 가지는 배열의 인덱스에 처음 등장하는 위치를 저장한다.
        }
        for(int i = 0; i < 26; i++) {
            if(arr[i] == -1)
                bw.write(-1+" ");
            else
                bw.write(arr[i]+" ");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
