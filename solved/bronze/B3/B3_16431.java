package solved.bronze.B3;
import java.io.*;
import java.util.StringTokenizer;

public class B3_16431 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        StringTokenizer st3 = new StringTokenizer(br.readLine());
        int zone_x = Integer.parseInt(st3.nextToken());
        int zone_y = Integer.parseInt(st3.nextToken());

        int bessie_x = Integer.parseInt(st1.nextToken());
        int bessie_y = Integer.parseInt(st1.nextToken());
        int count_bessie = Math.max(Math.abs(zone_x - bessie_x), Math.abs(zone_y - bessie_y));
        int count_daisy = Math.abs(zone_x - Integer.parseInt(st2.nextToken()) + Math.abs(zone_y - Integer.parseInt(st2.nextToken())));

        if(count_bessie == count_daisy)
            System.out.println("tie");
        else if(count_bessie < count_daisy)
            System.out.println("bessie");
        else
            System.out.println("daisy");
    }
}
