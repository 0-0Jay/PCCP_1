import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < progresses.length; i++) {  // arr 리스트에 각 작업별 남은 작업시간 저장
            int r = (int)Math.ceil((double)(100 - progresses[i]) / speeds[i]);
            arr.add(r);
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) == 101) continue;  // 중복 탐색 방지
            int cnt = 1;
            for (int j = i + 1; j < arr.size(); j++) {  // arr[i]보다 작거나 같은 작업시간 모두 카운팅
                if (arr.get(i) >= arr.get(j)) {
                    cnt++;
                    arr.set(j, 101);  // 카운팅한 작업은 101로 변경해 추가 탐색 방지
                } else {
                    break;
                }
            }
            ans.add(cnt);  // ans에 카운트 저장
        }
        int[] answer = new int[ans.size()];
        for (int i = 0; i < answer.length; i++) {  // 정답 배열로 변환
            answer[i] = ans.get(i);
        }
	    return answer;
    }
}
