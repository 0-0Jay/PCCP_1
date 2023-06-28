import java.util.ArrayList;
class Solution {
    public int[] solution(int[] arr) {
        ArrayList<Integer> a = new ArrayList();
        int max = 0;
        for (int i : arr) {  // 최대값 찾기
            if (i > max) max = i;
        }
        for (int i = 0; i < arr.length; i++) {  // 최대값 인덱스 찾기
            if (arr[i] == max) {
                a.add(i);
            }
        }
        int[] answer = new int[a.size()];
        for (int i = 0; i < a.size(); i++) {  // 배열로 변환
            answer[i] = a.get(i);
        }

        return answer;
    }
}
