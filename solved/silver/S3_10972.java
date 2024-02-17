package solved.silver;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class S3_10972 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        int[] arr = new int[number];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < number; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        boolean isLast = true;
        //사전 순 마지막인지 체크
        for(int i = 0; i < number; i++) {
            if(arr[i] == number-i)
                continue;
            else {
                isLast = false;
                break;
            }
        }
        if(isLast)
            System.out.println(-1);
        else {
            for(int i = number-1; i > 0; i--) {
                if(arr[i] > arr[i-1]) {
                    ArrayList<Integer> list = new ArrayList<>();
                    for(int j = i-1; j < number; j++)
                        list.add(arr[j]);
                    Collections.sort(list);
                    for(int k = 0; k < list.size(); k++) {
                        if(list.get(k) == arr[i-1]) {
                            arr[i-1] = list.get(k+1);
                            list.remove(k+1);
                        }
                    }
                    for(int j = i; j < number; j++) {
                        arr[j] = list.get(0);
                        list.remove(0);
                    }
                    break;
                }
            }
            for(int a : arr)
                System.out.print(a+" ");
        }
    }
}

/*
좋은 반례
4
2 1 4 3
2 3 1 4

나는 2개씩 값을 비교하여 더 뒷자리에 있는 값이 큰 경우,
그러니까, 1 4에서 1 < 4니까
1을 먼저 이보다 큰 값으로 교체하고자 +1을 했었는데 이는 큰 오산이었다.
그게 아니라 먼저 1 4 3을 list에 다 넣은다음 오름차순 sort하여
list에서 1의 위치를 찾고, 그보다 인덱스 1 높은 숫자를 1의 위치에 놓으면 해결된다.
그리고 나머지 뒷자리는 오름차순 sort한 것에 따라 순서대로 놓으면 된다.
즉, 1의 위치 뒤에서 숫자들이 가질 수 있는 가장 작은 값을 만들어내면 된다.

내 아이디어는 다음과 같았다.
일단 마지막 순열인지 먼저 체크하고 아니면
숫자를 2개씩 비교하여 뒷자리가 더 큰지 체크한다. 뒷자리가 더 크다면, 거기서부터가 그 다음 순열을 찾는 key가 된다.
나는 일단은 i-1, i의 인덱스를 비교하였다.
만약 arr[i-1] < arr[i] 였다면 일단 먼저 arr[i-1]을 보다 큰 값으로 교체하고 나머지 뒷자리는 가장 작은 값을 가지도록 만들어야 한다.
즉 1 7 6 5 4 3 2 였다면, 1 < 7 지점에서 1은 2가 되고, 나머지 뒷자리는 34567 로 가진 숫자들 중에서 가장 작은 값을 가지도록 한 것이다.
다만 arr[i-1]의 값을 교체할 땐 i-1에서 number-1까지의 인덱스 중에서 arr[i-1] 다음으로 큰 숫자를 선택해서 arr[i-1]을 교체해야 한다.
따라서 내가 생각한 건 arr[i-1] ~ arr[number-1] 까지의 값을 일단 모두 arraylist에 넣는다. 그다음 오름차순 sort를 한다.
그다음 list에서 arr[i-1]의 인덱스를 찾은다음 그 다음 인덱스의 값을 arr[i-1]에 넣고 list에서 그 값을 제거한다.
이게 되는 이유는 오름차순 정렬을 해서이고 그다음부턴 list안의 sort된 값을 arr[i]부터 arr[number-1]까지 순차적으로 넣어주면 된다.
그러면 다음 순열을 구할 수 있다.
 */
