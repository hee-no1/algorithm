package ch4_array1D;

import java.util.Scanner;

/** No_5597 과제 안 내신 분..?
 * X대학 M교수님은 프로그래밍 수업을 맡고 있다. 교실엔 학생이 30명이 있는데, 학생 명부엔 각 학생별로 1번부터 30번까지 출석번호가 붙어 있다.
 * 교수님이 내준 특별과제를 28명이 제출했는데, 그 중에서 제출 안 한 학생 2명의 출석번호를 구하는 프로그램을 작성하시오.

 * 입력
 * 입력은 총 28줄로 각 제출자(학생)의 출석번호 n(1 ≤ n ≤ 30)가 한 줄에 하나씩 주어진다. 출석번호에 중복은 없다.

 * 출력
 * 출력은 2줄이다. 1번째 줄엔 제출하지 않은 학생의 출석번호 중 가장 작은 것을 출력하고, 2번째 줄에선 그 다음 출석번호를 출력한다.
 */

public class No_5597 {
    public static void main(String[] args){

        //1. 크기가 30 + 1 = 31인 배열을 만든다.
        int[] arr = new int[31];

        //2. for문을 돌리면서 해당 값과 같은 값을 같는 index에 값을 넣어준다.
        Scanner sc = new Scanner(System.in);

        for(int i=1;i<=28;i++){
            int j = sc.nextInt();
            arr[j] = j;
        }

        for(int i=1;i<arr.length;i++){
            if(arr[i] == 0){
                System.out.println(i);
            }
        }

    }
}
