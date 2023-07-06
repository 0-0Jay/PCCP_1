class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for (int i = 0; i < skill_trees.length; i++) {
            String tr = skill_trees[i];  // 스킬트리 하나 선택
            int j;  // 플래그로 활용하기 위해 for문 밖으로 빼서 선언
            for (j = 1; j < skill.length(); j++) {
                int a = tr.indexOf(skill.charAt(j - 1));  // tr에서 a(선) 스킬의 위치
                int b = tr.indexOf(skill.charAt(j));  // tr에서 b(후) 스킬의 위치
                if (a != -1 && b != -1 && a > b || a == -1 && b != -1) break;  // a, b가 존재하면서 a > b 이거나, a가 존재하지 않는데 b가 있으면 스킬트리 오류. break로 반복문 중단
            }
            if (j == skill.length()) answer++;  // 반복문이 끝까지 돌았으면 가능한 경우로 카운트
        }
        return answer;
    }
}
