import java.util.*;

class Solution {    
    public int solution(int[] prior, int location) {
        int[][] que = new int[10000][2];
        int st = -1;
        int ed = -1;
        int answer = 0;
        for (int i = 0; i < prior.length; i++) {  // 큐에 우선순위, location 쌍 입력
            que[++st][0] = prior[i];
            que[st][1] = i;
        }
        while (st != ed) {
            int now = que[++ed][0];
            int i;
            for (i = ed; i <= st; i++) {
                if (now < que[i][0]) {  // 현재 작업보다 우선순위가 높은 작업이 큐에 있으면 현재작업을 큐의 맨뒤로 보내고 break;
                    que[++st][0] = now;
                    que[st][1] = que[ed][1];
                    break;
                }
            }
            if (i == st + 1) {  // 만약 break가 동작하지 않으면 수행
                if (que[ed][1] == location) return answer + 1;  // 현재 작업의 location이 찾아야하는 작업의 location이면 answer+1를 반환
                else answer += 1;  // 아니면 answer 값에 1 추가
            }
        }
        return 0;
    }
}
