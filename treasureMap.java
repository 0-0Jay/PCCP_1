import java.util.*;
class Solution {
    public int solution(int n, int m, int[][] hole) {
        int[] dx = {1, 0, -1, 0};  // 상하좌우 방향 지정
        int[] dy = {0, 1, 0, -1};
        int[][][] chk = new int[n + 1][m + 1][2];
        Queue<int[]> que = new LinkedList<>();
        int[][] map = new int[n + 1][m + 1];  // hole의 정보에 따라 map을 2차원 배열로 구현
        for (int i = 0; i < hole.length; i++) {
            map[hole[i][0]][hole[i][1]] = -1;
        }
        que.offer(new int[]{1, 1, 0, 0});  // {x좌표, y좌표, 점프(0 : 미사용 / 1 : 사용), 이동 수}
        chk[1][1][0] = 1;  // 점프 미사용 경우 방문 체크
        chk[1][1][1] = 1;  // 점프 사용 경우 방문 체크
        int min = Integer.MAX_VALUE;
        while(!que.isEmpty()) {  // BFS로 탐색
            int[] now = que.poll();
            if (now[0] == n && now[1] == m) {
                if (now[3] < min) min = now[3];
            }
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];  // 1칸 이동
                int ny = now[1] + dy[i];
                if (nx >= 1 && nx <= n && ny >= 1 && ny <= m && map[nx][ny] == 0) {
                    // now[2]를 그대로 넣어서 점프 사용여부 그대로 큐에 삽입
                    if (now[2] == 0 && chk[nx][ny][0] == 0) {  // 점프를 사용하지 않았을 경우 방문 체크
                        que.offer(new int[]{nx, ny, now[2], now[3] + 1});
                        chk[nx][ny][0] = 1;
                    }
                    if (now[2] == 1 && chk[nx][ny][1] == 0) {  // 점프를 사용했을 경우 방문 체크
                        que.offer(new int[]{nx, ny, now[2], now[3] + 1});
                        chk[nx][ny][1] = 1;
                    }
                }
                int dnx = nx + dx[i];  // 점프로 2칸 이동
                int dny = ny + dy[i];
                if (now[2] == 0 && dnx >= 1 && dnx <= n && dny >= 1 && dny <= m && map[dnx][dny] == 0 && chk[dnx][dny][1] == 0) {
                    // 점프를 사용하지 않았고(now[2] == 0), 점프를 사용했을 경우의 방문 기록이 없으면(chk[dnx][dny][1] == 0) 수행
                    que.offer(new int[]{dnx, dny, 1, now[3] + 1});  // now[2]를 1로 체크(점프 사용)
                    chk[dnx][dny][1] = 1;
                }
            }
        }
        return (min < Integer.MAX_VALUE)? min : -1;  // min이 한번도 감소하지 않았으면 보물에 도달할 수 없는 지형
    }
}
