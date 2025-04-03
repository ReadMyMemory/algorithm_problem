package solved.bronze.B5;
import java.io.*;
import java.util.*;

public class B5_30087 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 세미나별 강의실 매핑
        Map<String, String> seminarRooms = new HashMap<>();
        seminarRooms.put("Algorithm", "204");
        seminarRooms.put("DataAnalysis", "207");
        seminarRooms.put("ArtificialIntelligence", "302");
        seminarRooms.put("CyberSecurity", "B101");
        seminarRooms.put("Network", "303");
        seminarRooms.put("Startup", "501");
        seminarRooms.put("TestStrategy", "105");

        // 신청한 세미나에 대한 강의실 출력
        for (int i = 0; i < N; i++) {
            String seminar = br.readLine();
            System.out.println(seminarRooms.get(seminar));
        }
    }
}
