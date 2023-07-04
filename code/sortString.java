import java.util.*;
class Solution {
    public String[] solution(String[] strings, int n) {
        for (int i = 0; i < strings.length; i++) {
            strings[i] = strings[i].charAt(n) + strings[i];  // 각 문자열의 n번인덱스를 맨앞에 추가
        }
        Arrays.sort(strings);  // 정렬하면 맨앞의 인덱스부터 사전 순 정렬
        for (int i = 0; i < strings.length; i++) {
            strings[i] = strings[i].substring(1);  // 처음에 추가한 0번 인덱스를 제외한 나머지 문자열로 다시 변환
        }
        return strings;
    }
}
