class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        for (int i = 0; i < n; i++) {
            int st = -1, ed = -1;
            int[] que = new int[500];
            if (computers[i][i] == 0) continue; // computers[i][i]가 0이라는 것은 해당 컴퓨터가 없다는 뜻  
            que[++st] = i;  // bfs를 활용해 탐색. 중복탐색 방지를 위함
            while(st != ed) {
                int now = que[++ed];
                for (int j = 0; j < n; j++) {
                    if (computers[now][j] == 1) {
                        que[++st] = j;  // 연결된 컴퓨터는 que에 추가
                        computers[now][j] = 0;  // que에 담았음으로 두 컴퓨터를 0으로 낮추어 중복탐색 방지
                        computers[j][now] = 0;
                    }
                }
            }
            answer++;  // 중복탐색 방지 작업이 끝났으면 answer에 1 누적
        }  
        return answer;
    }
}
