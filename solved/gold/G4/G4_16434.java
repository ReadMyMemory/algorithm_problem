package solved.gold.G4;
import java.io.*;
import java.util.*;

public class G4_16434 {
    static class Room {
        int type;
        long a, h;

        Room(int type, long a, long h) {
            this.type = type;
            this.a = a;
            this.h = h;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long hatk = Long.parseLong(st.nextToken());

        Room[] rooms = new Room[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            long a = Long.parseLong(st.nextToken());
            long h = Long.parseLong(st.nextToken());
            rooms[i] = new Room(t, a, h);
        }

        long left = 1;
        long right = Long.MAX_VALUE / 2;
        long answer = right;

        while (left <= right) {
            long mid = (left + right) / 2;

            if (canSurvive(rooms, hatk, mid)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }

    static boolean canSurvive(Room[] rooms, long initialAtk, long maxHp) {
        long curHp = maxHp;
        long atk = initialAtk;

        for (Room room : rooms) {
            if (room.type == 1) {
                // 몬스터와 전투
                long monsterAtk = room.a;
                long monsterHp = room.h;

                // 용사가 몬스터를 죽이는데 필요한 공격 횟수
                long attacksNeeded = (monsterHp + atk - 1) / atk;

                // 몬스터가 용사를 공격하는 횟수 (용사의 마지막 공격으로 몬스터가 죽으면 그 때는 공격 안함)
                long monsterAttacks = attacksNeeded - 1;

                // 용사가 받는 총 데미지
                long totalDamage = monsterAttacks * monsterAtk;

                curHp -= totalDamage;

                if (curHp <= 0) {
                    return false;
                }
            } else {
                // 포션
                atk += room.a;
                curHp = Math.min(maxHp, curHp + room.h);
            }
        }
        return true;
    }
}