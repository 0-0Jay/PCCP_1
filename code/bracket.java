import java.util.*;

class Solution {
    boolean solution(String s) {
        int left = 0;  // '(' 카운팅
        int right = 0;  // ')' 카운팅
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') left++;
            else right++;
            if (right > left) return false;  // 만약 한번이라도 right가 left보다 커지면 false 반환
        }
        if (left > right) return false;  // 반복 종료후 left가 right보다 크면 false 반환
        return true;  // 그 외에는 true 반환
    }
}
