import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> que = new PriorityQueue<>();  // 최소값 활용의 효율성을 위해 우선순위 큐 이용
        for (int i : scoville) que.add(i);
        while (que.peek() < K && que.size() > 1) {
            que.add(que.poll() + que.poll() * 2);
            answer++;
        }
        if (que.peek() < K) return -1;  // que의 size가 1이되었음에도 K보다 작으면 -1 반환
        return answer;
    }
}
