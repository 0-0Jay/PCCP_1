import java.util.*;
class Solution {
    class node {  // 각 플레이어(노드) 인스턴스를 생성할 node 클래스 작성
        int num;
        int win = 0;
        int lose = 0;
        int flag = 0;
        List<node> vs = new LinkedList<>();  // 대결을 해서 이긴 선수를 삽입할 리스트 (이길 때만 삽입하여 방향성 있게 활용)
        node(int n) {
            num = n;
        }
    }
    public int solution(int n, int[][] results) {
        int answer = 0;
        List<node> arr = new ArrayList<>();  // 각 선수 인스턴스를 저장할 arr 리스트 생성
        for (int i = 1; i <= n; i++) {
            arr.add(new node(i));
        }
        for (int[] r : results) {  // winner와 loser 인스턴스를 생성하여 winner의 vs에 loser 저장
            node winner = arr.get(r[0] - 1);
            node loser = arr.get(r[1] - 1);
            winner.vs.add(loser);
        }
        for (node p : arr) {  // 모든 선수 탐색
            Queue<node> que = new LinkedList<>();  // 매 탐색마다 que와 모든 node의 방문여부(flag)를 초기화
            for (node a : arr) {
                a.flag = 0;
            }
            que.offer(p);
            p.flag = 1;
            while (!que.isEmpty()) {  // BFS 활용
                node now = que.poll();
                for (node l : now.vs) {
                    if (l.flag == 1) continue;  // 이번 탐색에서 한번 방문한 노드(선수)의 중복 탐색 방지 
                    que.offer(l);
                    l.flag = 1;
                    p.win += 1;  // 각 승, 패 카운팅
                    l.lose += 1;
                }
            }
        }
        for (node p : arr) {  // 승패 합이 자신을 제외한 모든 선수 수와 같으면 answer에 +1
            if(p.win + p.lose == n - 1) answer++;
        }
        return answer;
    }
}
