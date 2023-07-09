import java.util.*;
class Solution {
    public int solution(int[] menu, int[] order, int k) {
        int answer = 0;
        Queue<Integer> wait = new LinkedList<>();  // 대기열로 사용하기 위한 큐
        int time = 0;  // 경과 시간
        int tmp = 0;  // order배열의 인덱스 포인터
        int now = 0;  // 현재 음료의 남은 시작
        while (tmp < order.length) {
            if (now > 0) now--;  // 음료 제작 시간이 남아있으면 1씩 감소
            if (now == 0) wait.poll();  // 음료가 완성되면 대기열에서 주문 삭제
            if (time % k == 0) wait.add(order[tmp++]);  // 경과시간이 k가 지날때마다 대기열에 주문 추가
            if (now == 0 && !wait.isEmpty()) now = menu[wait.peek()];  // 제작중인 음료가 없고 대기중인 주문이 있으면 음료 제작 시작
            if (wait.size() > answer) answer = wait.size();  // 대기열의 길이 최대값 비교
            time++;  // 시간 1씩 경과
        }
        return answer;
    }
}
