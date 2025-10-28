package solved.bronze.B3;
import java.io.*;
import java.util.*;

public class B3_12756 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 플레이어 A의 카드 정보 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int attackA = Integer.parseInt(st.nextToken());
        int healthA = Integer.parseInt(st.nextToken());

        // 플레이어 B의 카드 정보 입력
        st = new StringTokenizer(br.readLine());
        int attackB = Integer.parseInt(st.nextToken());
        int healthB = Integer.parseInt(st.nextToken());

        // 각각 몇 번의 공격을 버틸 수 있는지 계산
        int turnsA = (healthA + attackB - 1) / attackB; // A가 버티는 턴 수
        int turnsB = (healthB + attackA - 1) / attackA; // B가 버티는 턴 수

        if (turnsA > turnsB) {
            System.out.println("PLAYER A");
        } else if (turnsB > turnsA) {
            System.out.println("PLAYER B");
        } else {
            System.out.println("DRAW");
        }
    }
}