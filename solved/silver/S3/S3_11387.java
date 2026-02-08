package solved.silver.S3;
import java.io.*;
import java.util.*;
import java.math.*;

public class S3_11387 {

    static class Stat {
        int a, h, c, d, s; // 공격력, 힘, 치명확률, 치명피해, 공속증가
        Stat(int a, int h, int c, int d, int s) {
            this.a = a; this.h = h; this.c = c; this.d = d; this.s = s;
        }
        Stat sub(Stat o) { return new Stat(a - o.a, h - o.h, c - o.c, d - o.d, s - o.s); }
        Stat add(Stat o) { return new Stat(a + o.a, h + o.h, c + o.c, d + o.d, s + o.s); }
    }

    static Stat readStat(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        return new Stat(a, h, c, d, s);
    }

    // 전투력의 공통 분모를 제거한 분자만 계산해서 비교
    static BigInteger powerNumerator(Stat x) {
        int crit = Math.min(x.c, 100); // min(치확, 1) 처리: %단위라 100으로 캡
        long critTerm = 10000L - 100L * crit + 1L * crit * x.d; // (10000 - 100c + cD)

        BigInteger A = BigInteger.valueOf(x.a);
        BigInteger H = BigInteger.valueOf(100L + x.h);
        BigInteger CTERM = BigInteger.valueOf(critTerm);
        BigInteger S = BigInteger.valueOf(100L + x.s);

        return A.multiply(H).multiply(CTERM).multiply(S);
    }

    static char compare(Stat cur, Stat swapped) {
        BigInteger pCur = powerNumerator(cur);
        BigInteger pNew = powerNumerator(swapped);
        int cmp = pNew.compareTo(pCur);
        if (cmp > 0) return '+';
        if (cmp < 0) return '-';
        return '0';
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stat kri = readStat(br);   // 크리 현재
        Stat pabu = readStat(br);  // 파부 현재
        Stat wK = readStat(br);    // 크리의 현재 무기 스탯
        Stat wP = readStat(br);    // 파부의 현재 무기 스탯

        // 기본 스탯(무기 제외)
        Stat baseK = kri.sub(wK);
        Stat baseP = pabu.sub(wP);

        // 무기 교체 후 스탯
        Stat kriWithP = baseK.add(wP);
        Stat pabuWithK = baseP.add(wK);

        StringBuilder sb = new StringBuilder();
        sb.append(compare(kri, kriWithP)).append('\n');
        sb.append(compare(pabu, pabuWithK)).append('\n');

        System.out.print(sb.toString());
    }
}
