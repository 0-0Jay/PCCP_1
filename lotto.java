import java.util.*;

class Solution {
    public boolean solution(int[] lotto) {
        List<Integer> list = new ArrayList<>();
        for (int i : lotto) list.add(i);  // lotto배열을 리스트로 변환
        Set<Integer> set = new HashSet<>(list);  // 리스트는 set로 변환하여 중복 제거
        return set.size() == lotto.length;  // set의 길이와 lotto의 길이가 같으면 true, 다르면 false 반환
    }
}
