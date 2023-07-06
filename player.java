import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String i : participant) {  // 참가자를 map에 입력
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (String i : completion) {  // 완주하면 value -1. 0 되면 key 제거
            map.put(i, map.get(i) - 1);
            if (map.get(i) == 0) map.remove(i);
        }
        return map.keySet().iterator().next();  // map에 남아있는 key 반환
    }
}
