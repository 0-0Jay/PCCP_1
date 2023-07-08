import java.util.*;
class Solution {
    public String[] solution(int[][] queries) {
        String[] tmp = new String[]{"RR", "Rr", "Rr", "rr"};  // Rr을 자가수분 했을 때 나올 수 있는 모든 경우
        String[] answer = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int n = queries[i][0];
            int p = queries[i][1] - 1;  // %4를 한 값을 인덱스로 사용하기 위해 -1
            Stack<Integer> stk = new Stack<>();
            if (n == 1) answer[i] = "Rr";  // n이 1이면 1세대 이므로 Rr 바로 추가
            else {
                while(n > 1) {  // p를 4로 나누어 그 나머지를 스택에 쌓고, 세대 1 감소 
                    stk.push(p % 4);
                    n--;
                    p /= 4;
                }
                while(!stk.isEmpty()) {
                    int now = stk.pop();  // tmp에서 스택의 top에 있는 숫자 인덱스를 answer에 저장
                    answer[i] = tmp[now];
                    if (now == 0 || now == 3) break; // 윗세대를 탐색중에 한번이라도 now가 0 또는 3이 나오면 그 아랫세대는 전부 무조건 RR 아니면 rr만 나오니 break;
                }                                    // 이 문장이 없으면 RR이 나왔음에도 윗세대의 Rr을 또 탐색하게 되기 때문에 불필요한 탐색을 수행하여 오답 탐색
            }
        }
        return answer;
    }
}
