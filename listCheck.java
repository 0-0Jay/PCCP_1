import java.util.Arrays;

class Solution {
    public boolean solution(int[] arr) {
        Arrays.sort(arr);  // 배열 정렬
        int[] tmp = new int[100001];  // 빈도 배열로 중복 체크
        for (int i = 0; i < arr.length; i++) {  // 중복이거나 연결된 값 아니면 false 반환
            tmp[arr[i]]++;
            if (i > 0 && arr[i] - 1 != arr[i - 1] || tmp[i] > 1) {
                return false;
            } 
        }
        return true;
    }
}
