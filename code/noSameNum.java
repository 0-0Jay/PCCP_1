import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> lst = new ArrayList<>();
        int n = -1;
        for (int i : arr) {
            if (i == n) continue;  // n과 i가 같으면 스킵
            n = i;  // 다르면 n을 i로 업데이트. lst에 추가
            lst.add(n);
        }
        int[] answer = new int[lst.size()];
        for (int i = 0; i < lst.size(); i++) {  // answer 배열로 변환
            answer[i] = lst.get(i);
        }
        return answer;
    }
}
