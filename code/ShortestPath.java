class Solution {
    public int solution(int[][] maps) {
        int[] dx = new int[]{1, 0, 0, -1};  // dx와 dy로 상하좌우 4방향 탐색
        int[] dy = new int[]{0, 1, -1, 0};
        int[][] que = new int[10000][2];
        int st = -1, ed = -1, n = maps.length, m = maps[0].length;
        que[++st][0] = 0;
        que[st][1] = 0;
        maps[0][0] = -1;  // 시작점을 -1로 두고 다음 경로로 이동할 때마다 해당 장소에 -1 씩 누적
        while (st != ed) {  // BFS를 통해 최단 경로 탐색
            int nx = que[++ed][0];
            int ny = que[ed][1];
            for (int i = 0; i < 4; i++) {
                int a = nx + dx[i];
                int b = ny + dy[i];
                if (a > -1 && a < n && b > -1 && b < m && maps[a][b] == 1) {
                    que[++st][0] = a;
                    que[st][1] = b;
                    maps[a][b] = maps[nx][ny] - 1;  // return의 편의성을 위해 음수로 누적
                }
            }
        }
        return -maps[n - 1][m - 1];  // 만약 상대기지에 도착하지 못한다면 1이 그대로 -1로 반환. 그 외에는 음수로 누적된 값이 양수로 전환되어 반환.
    }
}
