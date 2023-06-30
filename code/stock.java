class Solution {
    public int[] solution(int[] prices) {
        for (int i = 0; i < prices.length; i++) {
            int cnt = 0;
            for (int j = i + 1; j < prices.length; j++) {
                cnt++;
                if (prices[i] > prices[j]) break;  // prices[i]가 떨어지는 순간 break;
            }
            prices[i] = cnt;  // prices의 i인덱스를 cnt로 교체
        }
        return prices;
    }
}
