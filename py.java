class Solution {
    boolean solution(String s) {
        int p = 0;
        int y = 0;
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);  // 앞에서부터 한글자씩 p인지 y인지 판단 후 카운팅
            if (a == 'p' || a == 'P') p++;
            else if (a == 'y' || a == 'Y') y++;
        }
        return p == y;
    }
}
