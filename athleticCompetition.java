class Solution {
    static int max;
    public static void DFS(int d, int sum, int[][] ab, int[] chk) {
        if (d == ab[0].length - 1) {  // 모든 종목 순회 시, 최대값 비교
            if (max < sum) max = sum;
            return;
        }
        for (int i = 0; i < ab.length; i++) {
            if (chk[i] == 0) {  // 종목 중복 방지
                chk[i] = 1;
                DFS(d + 1, sum + ab[i][d + 1], ab, chk);  // 종목별로 각 선수들을 재귀 탐색
                chk[i] = 0;
            }
        }
    }
    public int solution(int[][] ability) {
        int[] chk = new int[ability.length];
        DFS(-1, 0, ability, chk);
        return max;
    }
}
