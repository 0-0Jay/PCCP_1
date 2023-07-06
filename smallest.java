import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        if (arr.length == 1) return new int[] {-1};  // 배열의 길이가 1이면 {-1} 반환
        int[] tmp = arr.clone();  // 정렬을 위해 깊은 복사
        Arrays.sort(tmp);
        int[] answer = new int[arr.length - 1];  // 최소값 하나만 제거하면 되므로 배열과 k(키값) 활용
        int k = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == tmp[0]) continue;  // tmp[0]은 무조건 최소값이니 arr[i]가 이 값이면 스킵
            answer[k++] = arr[i];
        }
        return answer;
    }
}
