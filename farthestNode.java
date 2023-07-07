import java.util.*;
class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        List<Integer>[] node = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            node[i] = new ArrayList<>();  // 가변길이 행(list)을 가진 node 배열 생성
        }
        int[][] que = new int[50000][2];  // 최대 노드 수가 50000이므로 BFS에 활용할 해당 크기의 배열 선언
        int[] chk = new int[n + 1];  // 노드 중복 탐색 방지용 체크 배열 선언
        int st = -1, ed = -1;
        for (int i = 0; i < edge.length; i++) {  // node에 edge의 간선 정보 입력
            node[edge[i][0]].add(edge[i][1]);
            node[edge[i][1]].add(edge[i][0]);
        }
        que[++st][0] = 1;
        que[st][1] = 0;
        chk[1] = -1;
        while (st != ed) {  // BFS를 활용
            int now = que[++ed][0];
            for (int i = 0; i < node[now].size(); i++) {
                if (chk[node[now].get(i)] != -1) {
                    que[++st][0] = node[now].get(i);
                    que[st][1] = que[ed][1] + 1;
                    chk[node[now].get(i)] = -1;  // 한번 탐색한 노드는 체크배열에 -1로 체크
                }
            }
        }
        int max = que[ed][1];  // que의 마지막에 삽입된 노드는 무조건 최대값
        for (int i = que.length - 1; i > 0; i--) {  // que를 끝에서부터 탐색하여 max와 같은 값 카운팅
            if (que[i][1] == max) answer++;
        }
        return answer;
    }
}
