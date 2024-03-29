package baekjoon.ch12_bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/** No_1018 체스판 다시 칠하기
 * 지민이는 자신의 저택에서 MN개의 단위 정사각형으로 나누어져 있는 M×N 크기의 보드를 찾았다. 어떤 정사각형은 검은색으로 칠해져 있고, 나머지는 흰색으로 칠해져 있다. 지민이는 이 보드를 잘라서 8×8 크기의 체스판으로 만들려고 한다.
 * 체스판은 검은색과 흰색이 번갈아서 칠해져 있어야 한다. 구체적으로, 각 칸이 검은색과 흰색 중 하나로 색칠되어 있고, 변을 공유하는 두 개의 사각형은 다른 색으로 칠해져 있어야 한다. 따라서 이 정의를 따르면 체스판을 색칠하는 경우는 두 가지뿐이다. 하나는 맨 왼쪽 위 칸이 흰색인 경우, 하나는 검은색인 경우이다.
 * 보드가 체스판처럼 칠해져 있다는 보장이 없어서, 지민이는 8×8 크기의 체스판으로 잘라낸 후에 몇 개의 정사각형을 다시 칠해야겠다고 생각했다. 당연히 8*8 크기는 아무데서나 골라도 된다. 지민이가 다시 칠해야 하는 정사각형의 최소 개수를 구하는 프로그램을 작성하시오.

 * 입력
 * 첫째 줄에 N과 M이 주어진다. N과 M은 8보다 크거나 같고, 50보다 작거나 같은 자연수이다. 둘째 줄부터 N개의 줄에는 보드의 각 행의 상태가 주어진다. B는 검은색이며, W는 흰색이다.

 * 출력
 * 첫째 줄에 지민이가 다시 칠해야 하는 정사각형 개수의 최솟값을 출력한다.
 */
public class No_1018_ver2 {

    static int min = Integer.MAX_VALUE; //최종적인 최소값

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[][] arr = new boolean[N][M];

        for(int i=0;i<arr.length;i++){
            String str = br.readLine();
            for(int j=0;j<arr[i].length;j++){
                if(str.charAt(j) == 'W'){ arr[i][j] = true;} //W일때는 true, B일때는 false가 저장
            }
        }

        for(int a=0;a<=N-8;a++){
            for(int b=0;b<=M-8;b++){
                check(arr,a,b);
            }
        }

        System.out.println(min);
    }

    static void check(boolean[][] arr, int a, int b){
        int count = 0;
        //첫 시작이 White이면, W가 아닐때 count++를 해준다.
        boolean color = true;
        for(int i=a;i<a+8;i++){
            for(int j=b;j<b+8;j++){
                if(arr[i][j] != color){ //첫 color = W
                    count++; //White가 아니면 count++
                }
                color = !color; //교차로 흰색인지 검은색인지를 check하기 위해
            }
            //줄이 바꼈을 때도 check하는 color를 바꿔줘야한다.
            color = !color;
        }

        count = Math.min(count,64-count);
        /*
            WWB
            WBW
            BWB
            위의 행렬을 기준으로 W시작 개수와 B시작 개수를 비교해보면 왜 64-count를 하는지 감이 온다.
         */
        min = Math.min(min, count); //min이 static변수로 선언되어있다.
    }
}
