import java.util.*;

class Solution {
    public int solution(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int i : nums) {
            if (map.get(i) == null) {  // 새 값이면 map에 key 추가
                map.put(i, 0);
            }
            map.put(i, map.get(i) + 1);  // 해당 key의 value 카운팅
        }
        return Math.min(map.size(),nums.length/2); // key값의 종류 수와 2/n 비교 
    }
}
