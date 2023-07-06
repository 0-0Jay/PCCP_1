class Solution {
    public int solution(String begin, String target, String[] words) {
        String que[] = new String[3000];  // 단어를 저장할 큐와, 카운팅할 보조 큐 선언
        int cnt[] = new int[3000];
        int st = -1, ed = -1;
        que[++st] = begin;
        cnt[st] = 0;
        while (st != ed) {  // BFS를 통해 words 배열 탐색
            String now = que[++ed];
            if (now.equals(target)) {  // 만약 now가 target과 같은 단어면 cnt에서 now와 동일한 인덱스의 숫자 반환
                return cnt[ed];
            }
            for (int i = 0; i < words.length; i++) {
                int tmp = 0;
                if (words[i].equals("*")) continue;  // 중복 체크 방지
                for (int j = 0; j < words[i].length(); j++) {  // 다른 철자가 있으면 tmp + 1
                    if (words[i].charAt(j) != now.charAt(j)) {
                        tmp++;
                    }
                }
                if (tmp == 1) {  // 철자를 한 번에 하나씩 바꿔야 하므로 tmp가 1인 경우에만 큐에 삽입, 삽입한 단어는 "*"로 변경해 중복 탐색 방지
                    que[++st] = words[i];
                    cnt[st] = cnt[ed] + 1;
                    words[i] = "*";
                }
            }
        }
        return 0;  // BFS를 전부 돌았음에도 return이 일어나지 않았다면 가능한 경로가 없으므로 0 반환
    }
}
