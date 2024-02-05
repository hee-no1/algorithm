package baekjoon.ch16_stack_queue_deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/** No_9012 괄호 (java.util.Stack 클래스 사용, 로직 단순화, 128ms)
 * 괄호 문자열(Parenthesis String, PS)은 두 개의 괄호 기호인 ‘(’ 와 ‘)’ 만으로 구성되어 있는 문자열이다. 그 중에서 괄호의 모양이 바르게 구성된 문자열을 올바른 괄호 문자열(Valid PS, VPS)이라고 부른다. 한 쌍의 괄호 기호로 된 “( )” 문자열은 기본 VPS 이라고 부른다. 만일 x 가 VPS 라면 이것을 하나의 괄호에 넣은 새로운 문자열 “(x)”도 VPS 가 된다. 그리고 두 VPS x 와 y를 접합(concatenation)시킨 새로운 문자열 xy도 VPS 가 된다. 예를 들어 “(())()”와 “((()))” 는 VPS 이지만 “(()(”, “(())()))” , 그리고 “(()” 는 모두 VPS 가 아닌 문자열이다.
 * 여러분은 입력으로 주어진 괄호 문자열이 VPS 인지 아닌지를 판단해서 그 결과를 YES 와 NO 로 나타내어야 한다.

 * 입력
 * 입력 데이터는 표준 입력을 사용한다. 입력은 T개의 테스트 데이터로 주어진다. 입력의 첫 번째 줄에는 입력 데이터의 수를 나타내는 정수 T가 주어진다. 각 테스트 데이터의 첫째 줄에는 괄호 문자열이 한 줄에 주어진다. 하나의 괄호 문자열의 길이는 2 이상 50 이하이다.

 * 출력
 * 출력은 표준 출력을 사용한다. 만일 입력 괄호 문자열이 올바른 괄호 문자열(VPS)이면 “YES”, 아니면 “NO”를 한 줄에 하나씩 차례대로 출력해야 한다.
 */
public class No_9012_v2 {
    public static void main(String[] args) throws IOException {
        //처음에는 중간 삭제/삽입을 하려고 LinkedList를 사용하려고 했는데 -> Stack을 사용해서 문자하나하나 입력될때마다 따져서 조건에 맞으면 제거하는 씩으로 진행
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        //문자열을 받고 문 자 하나씩 Stack에 담으면서 조건을 확인한다. 조건이 맞으면 제거하고 틀리면 가장 위에 담는다.
        for(int i=0;i<T;i++){
            String str = br.readLine();
            sb.append(check(str)).append("\n");
        }

        System.out.println(sb);
    }

    static String check(String str){
        Stack<Character> stack = new Stack<>();
        for(int j=0;j<str.length();j++){
            char c = str.charAt(j);
            if (c == '(') { //'('일땐 무조건 add, stack이 empty인지는 상관X
                stack.add(c);
            } else if(stack.empty()){ //stack이 empty일 경우 ')'는 들어올수 없다.
                return "NO";
            } else{ //무조건 앞에 '('가 있고, ')'기 들어가는 상황
                stack.pop();
            }
        }
        //출력
        if(stack.empty()){
            return "YES";
        }else {
            return "NO";
        }
    }
}
