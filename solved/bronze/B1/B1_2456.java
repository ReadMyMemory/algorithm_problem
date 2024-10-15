package solved.bronze.B1;
import java.io.*;
import java.util.StringTokenizer;

/*
쉽게 푼 사람은 보니까 포인트를 받을때마다 제곱수를 구해서 넣었더라.
비교하기 더 쉬워보였다.
 */

public class B1_2456 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] points = new int[3][3];
        int[] point = new int[3];
        while(N --> 0) {
            st = new StringTokenizer(br.readLine());
            int p1 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());
            int p3 = Integer.parseInt(st.nextToken());
            points[0][p1-1]++;
            points[1][p2-1]++;
            points[2][p3-1]++;
            point[0] += p1;
            point[1] += p2;
            point[2] += p3;
        }

        int max_point = Math.max(point[0], Math.max(point[1], point[2]));
        int index = 0;
        int count = 0;
        for(int i = 0; i < 3; i++) {
            if(max_point == point[i]) {
                index+= i+1;
                count++;
            }
        }
        System.out.println(calc_function(points, index, count) + " " + max_point);
    }
    private static int calc_function(int[][] arr, int index, int count) {
        if(index <= 3 && count == 1) // 1또는 2또는 3
            return index;
        else {
            if(index == 3) { // 1과 2의 점수가 같아서 3점 받은 횟수를 비교
                if(arr[0][2] > arr[1][2]) // 1이 2보다 3점을 더 많이 받음
                    return 1;
                else if(arr[0][2] < arr[1][2]) // 2이 1보다 3점을 더 많이 받음
                    return 2;
                else { // 1과 2가 3점 받은 횟수가 같으면 2점 받은 횟수를 비교
                    if(arr[0][1] > arr[1][1]) // 1이 2보다 2점을 더 많이 받음
                        return 1;
                    else if(arr[0][1] < arr[1][1]) // 2가 1보다 2점을 더 많이 받음
                        return 2;
                    else // 3점, 2점 받은 횟수가 모두 같아 비교할 수 없음.
                        return 0;
                }
            }
            else if(index == 4) { // 1과 3의 점수가 같아서 3점 받은 횟수를 비교
                if(arr[0][2] > arr[2][2]) // 1이 3보다 3점을 더 많이 받음
                    return 1;
                else if(arr[0][2] < arr[2][2]) // 3이 1보다 3점을 더 많이 받음
                    return 3;
                else { // 1과 3이 3점 받은 횟수가 같으면 2점 받은 횟수를 비교
                    if(arr[0][1] > arr[2][1]) // 1이 3보다 2점을 더 많이 받음
                        return 1;
                    else if(arr[0][1] < arr[2][1]) // 3이 1보다 2점을 더 많이 받음
                        return 3;
                    else // 3점, 2점 받은 횟수가 모두 같아 비교할 수 없음.
                        return 0;
                }
            } else if(index == 5) {// 2과 3의 점수가 같아서 3점 받은 횟수를 비교
                if(arr[1][2] > arr[2][2]) // 2가 3보다 3점을 더 많이 받음
                    return 2;
                else if(arr[1][2] < arr[2][2]) //3이 2보다 3점을 더 많이 받음
                    return 3;
                else { //2와 3이 3점 받은 횟수가 같으면 2점 받은 횟수 비교
                    if(arr[1][1] > arr[2][1]) //2가 3보다 2점을 더 많이 받음
                        return 2;
                    else if(arr[1][1] < arr[2][1]) //3이 2보다 2점을 더 많이 받음
                        return 3;
                    else // 3점, 2점 받은 횟수가 모두 같아 비교할 수 없음
                        return 0;
                }
            } else if(index == 6){ // 1, 2, 3 모두가 점수가 같음
                int index_2 = 0;
                int count_2 = 0;
                int max = Math.max(arr[0][2], Math.max(arr[1][2], arr[2][2]));
                for (int i = 0; i < 3; i++) {
                    if (max == arr[i][2]) {
                        index_2 += i+1;
                        count_2++;
                    }
                }
                if(index_2 <= 3 && count_2 == 1) // 3점을 받은 횟수가 가장 큰 놈이 한명임.
                    return index_2;
                else {
                    if(index_2 == 3) {// 1와 2가 3점을 받은 횟수가 같음
                        if(arr[0][1] > arr[1][1]) // 1이 2보다 2점을 더 많이 받음
                            return 1;
                        else if(arr[0][1] < arr[1][1]) // 2가 1보다 2점을 더 많이 받음
                            return 2;
                        else
                            return 0;
                    }
                    if(index_2 == 4) { // 1와 3이 3점을 받은 횟수가 같음
                        if(arr[0][1] > arr[2][1]) // 1이 3보다 2점을 더 많이 받음.
                            return 1;
                        else if(arr[0][1] < arr[2][1]) //3이 1보다 2점을 더 많이 받음.
                            return 3;
                        else //3점, 2점 받은 횟수가 모두 같아 비교할 수 없음.
                            return 0;
                    } else if(index_2 == 5) { //2와 3이 3점을 받은 횟수가 같음.
                        if (arr[1][1] > arr[2][1]) //2가 3보다 2점을 더 많이 받음.
                            return 2;
                        else if((arr[1][1] < arr[2][1])) //3이 2보다 2점을 더 많이 받음.
                            return 3;
                        else //3점, 2점 받은 횟수가 모두 같아 비교할 수 없음.
                            return 0;
                    } else { //1와 2와 3이 3점을 받은 횟수가 모두 같음. 2점 받은 횟수 비교
                        int max_2 = Math.max(arr[0][1], Math.max(arr[1][1], arr[2][1]));
                        int index_3 = 0;
                        for(int i = 0; i < 3; i++) {
                            if(max_2 == arr[i][1])
                                index_3 += i+1;
                        }
                        if(index_3 <= 3) // 2점을 받은 횟수가 가장 많은 놈이 1명임.
                            return index_3;
                        else //2점을 받은 횟수가 같은 놈이 2명 이상 있음. 판별 불가능
                            return 0;
                    }
                }
            }
        }
        return -1;
    }
}
