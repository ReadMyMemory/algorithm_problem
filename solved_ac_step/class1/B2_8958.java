package solved_ac_step.class1;

import java.io.*;

public class B2_8958 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testNum = Integer.parseInt(br.readLine());
        while(testNum>0) {
            String str = br.readLine();
            int count = 0;
            int weight = 0;
            for(int i =0; i < str.length(); i++) {
                String eq = String.valueOf(str.charAt(i));
                if (eq.equals("O")) { // O가 나옴.
                    if(weight != 0) { // 연속 정답 중이라면
                        count += weight + 1; // 정답 1점 + 연속 정답 가중치 더하기
                        weight++; // 연속 정답 가중치 1 증가
                    } else { // 연속 정답이 아님.
                        count++; // 정답 1점 추가
                        weight++; // 연속 정답 가중치 1 증가
                    }
                } else { // X가 나옴.
                    weight = 0; // 연속 정답 보너스 초기화.
                }
            }
            bw.write(count+"\n");
            testNum--;
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
