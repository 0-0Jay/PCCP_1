class Solution {
    public String solution(String input_string) {
        int[] frq = new int[26];  // 알파벳 빈도 체크
        int[] tmp = new int[26];  // 알파벳 그룹 수 체크
        for (int i = 0; i < input_string.length(); i++) {
            char now = input_string.charAt(i);
            frq[now - 'a']++;
            if (i < input_string.length() - 1&& now != input_string.charAt(i+1)) {  // 다음 철자와 다르면 그룹으로 카운팅
                tmp[now - 'a']++;
            }
        }
        tmp[input_string.charAt(input_string.length() - 1) - 'a']++;  // 마지막 철자의 경우 체크
        String answer = "";
        for (int i = 0; i < 26; i++) {
            if (frq[i] >= 2 && tmp[i] >= 2) {  // 2회이상 쓰였고, 그룹이 2개 이상이면 answer에 추가
                answer += (char)('a' + i);
            }
        }
        if (answer.equals("")) return "N";  // answer가 공백이면 N 반환
        return answer;
    }
}
