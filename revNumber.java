import java.util.ArrayList;

class Solution {
    public int[] solution(long n) {
        ArrayList<Integer> arr = new ArrayList();
        while(n != 0) {  // 1의자리부터 n의 자리까지 리스트에 삽입
            arr.add((int)(n % 10));
            n /= 10;
        }
        int[] answer = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {  // 배열로 변환
            answer[i] = arr.get(i);
        }
        return answer;
    }
}
