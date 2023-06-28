import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String[] i : clothes) {  // 의상 종류별 카운팅
            map.put(i[1], map.getOrDefault(i[1],0) + 1);
        }
        int answer = 1;
        var n = map.values().iterator();  // map의 요소 반환
        while(n.hasNext()){ // n의 다음에 가져올 값이 있으면 해당 값 + 1 곱해줌
            answer *= n.next() + 1;
        }
        return answer - 1; // 아무것도 안입는 경우 1 빼서 반환
    }
}

// var : 타입추론 변수. 변수를 명시적으로 적지 않아도 컴파일러가 알아서 타입 추론
