class Solution {
    static int cnt;  // 재귀함수를 활용해 카운팅하기 위한 전역변수
    
    public static void DFS(int d, int tar, int[] num) {
        d++;
        if (d == num.length) {  // d가 주어진 배열의 크기와 같으면 tar가 0이면 카운팅
            if (tar == 0) cnt++;
            return;
        }
        DFS(d, tar + num[d], num);  // target에 numbers 배열의 0번 인덱스부터 마지막 인덱스까지의 수를 더하거나 뺸 경우를 재귀로 탐색
        DFS(d, tar - num[d], num);
    }
    
    public int solution(int[] numbers, int target) {
        DFS(-1, target, numbers);
        return Solution.cnt;
    }
}
