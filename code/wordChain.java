import java.util.*;

class Solution {
    public boolean solution(String[] words) {
        List<String> list = new ArrayList<>();
        for (String i : words) list.add(i);  // words를 리스트로 변환
        Set<String> set = new HashSet<>(list);  // list를 set로 변환
        if (words.length != set.size()) return false;  // set의 길와 word의 길이가 다르면 false 반환
        for (int i = 1; i < words.length; i++) {  // 끝말잇기가 안되면 false 반환
            if (words[i].charAt(0) != words[i - 1].charAt(words[i - 1].length() - 1)) return false;
            
        }
        return true;  // 그 외에는 true 반환
    }
}
