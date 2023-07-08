class Solution {
    public int[] solution(String command) {
        int[] answer = new int[] { 0, 0 };  // answer를 0,0 좌표로 초기화
        int[] dx = new int[] { 0, 1, 0, -1 };  // dx와 dy 배열을 통해 상, 우, 하, 좌로 한칸 이동하는 경우를 만들어 두고, k(인덱스)를 활용해 핸들링
        int[] dy = new int[] { 1, 0, -1, 0 };
        int k = 0;
        for (int i = 0; i < command.length(); i++) {
            char c = command.charAt(i);
            if (c == 'G') {  // 'G' 와 'B'는 각각 dx[k]와 dy[k]의 값을 더하거나 빼는 경우
                answer[0] += dx[k];
                answer[1] += dy[k];
            } else if (c == 'B') {
                answer[0] -= dx[k];
                answer[1] -= dy[k];
            } else if (c == 'R') {  // 'R' 과 'L'은 각각 k를 +1 하거나 -1 하는경우
                k = (k + 1) % 4;
            } else if (c == 'L') {
                k = (k + 3) % 4;  // % 4를 하기 때문에 -1은 4 - 1을 더하는 것과 동일
            }
        }
        return answer;
    }
}
