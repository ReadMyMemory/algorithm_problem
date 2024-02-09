package solved.etc;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;


//로직
//몇 번째 숫자인지 string으로 입력받기
//1부터 숫자 하나씩 늘려가면서 666 포함된 숫자 찾기. 근데 string 형태여야 해서 int > string 전환해야.
//666포함된 숫자 찾을 때마다 count, 그리고 이 count가 입력받은 string과 동일할 시 반복문 break 후 출력

public class a1436 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int count = 0;
        int i = 0;
        while(!Objects.equals(s, Integer.toString(count))) {
            i++;
            if(Integer.toString(i).contains("666") == true) {
                count++;
            }
        }
        System.out.println(i);
    }
}
