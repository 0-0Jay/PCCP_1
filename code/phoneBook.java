import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);  // for문 하나로 해결하기 위해 오름차순 정렬
        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i+1].startsWith(phone_book[i])) return false; // 오름차순 조건에 따라 다음 번호가 현재 번호로 시작하면 false 반환
        }
        return true;
    }
}
