package solved;

public class S1_2583 {

    //아이디어
    //기존에는 탐색을 하라고 맵에 대한 정보를 칸마다 줬다면, 이번엔 영역
    //끝점과 끝점을 줬으니 그 안에 있는 영역을 돌면서 다 방문처리
    //탐색하지 않는 주어지는 직사각형의 영역은 겹칠 수 있다. 그러니 가중치는 1까지만 주기
    //좌표의 기준이 좌측 하단이 0,0이지만 상관은 없다. 어쩌피 우리는 좌표의 값에 따라
    //탐색을 순차적으로 해야 하는게 아니니까. 그렇게 되면 위쪽으로 한번 뒤집은 모양이 될거다

    public static void main(String[] args) {

        //상하좌우 탐색을 위한
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        //원래 int 배열로 받았는데
        //boolean으로 하는게 메모리적으로 효율적이라고 해서
        boolean[][] visited = new boolean[104][104];
        boolean[][] adj = new boolean[104][104];

        /*
        이차원 배열에서 [x][y]는
        x   x   x   x
        x   x   x   x
        x   x   x   x
        [3][4]인거다. 세로가 x 가로가 y인거임
        */

    }
}
