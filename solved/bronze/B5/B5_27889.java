package solved.bronze.B5;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class B5_27889 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> schoolMap = new HashMap<>();
        schoolMap.put("NLCS", "North London Collegiate School");
        schoolMap.put("BHA", "Branksome Hall Asia");
        schoolMap.put("KIS", "Korea International School");
        schoolMap.put("SJA", "St. Johnsbury Academy");
        System.out.println(schoolMap.get(br.readLine().trim()));
    }

}
