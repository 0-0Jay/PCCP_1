import java.util.*;
class Solution {
    public long[] solution(int[][] program) {
        long[] answer = new long[11];
        PriorityQueue<int[]> que = new PriorityQueue<>((a, b) -> {  // 대기열 역할을 할 우선순위 큐
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];  // 점수 순으로 정렬, 점수가 같으면 호출 시간 순으로 정렬
        });
        PriorityQueue<int[]> list = new PriorityQueue<>((a, b) -> {  // 프로그램 리스트역할을 할 우선순위 큐
            return a[1] - b[1];  // 호출 시간 순으로 정렬
        });
        for (int i = 0; i < program.length; i++) {  // 프로그램을 list로 변환
            list.add(program[i]);
        }
        long time = -1;
        int end = 0;
        while(!que.isEmpty() || !list.isEmpty() || end > 0) {  // que와 list가 모두 비어 있고, end가 남아있으면 계속 반복
            time++;
            while(!list.isEmpty() && list.peek()[1] == time) {  // list에 남은 프로그램이 존재하고 다음 프로그램의 호출시간이 time과 같으면 que로 이동
                que.add(list.poll());
            }
            if (end > 0) end--;  // 현재 실행중인 프로그램의 남은 시간 카운팅
            if (end == 0 && !que.isEmpty()) {  // 만약 실행중이던 프로그램이 작업을 마치고, que에 대기중인 프로그램이 있으면 작업 시작
                int[] now = que.poll();
                end += now[2];  // 남은 시간에 시작한 프로그램의 실행시간 추가
                answer[now[0]] += time - now[1];  // answer의 해당 프로그램의 인덱스에 대기시간(현재시간 - 호출된 시간) 추가
            }
        }
        answer[0] = time;  // answer[0]에 반복문이 종료되을 때의 시간(모든 프로그램 작업 완료) 저장
        return answer;
    }
}

/*
이 문제를 풀면서 한가지 의문점이 발생했다.
        long time = -1;
        long end = 0;
        while(!que.isEmpty() || !list.isEmpty() || end > time) {  // que와 list가 모두 비어 있고, end가 남아있으면 계속 반복
            time++;
            while(!list.isEmpty() && list.peek()[1] == time) {  // list에 남은 프로그램이 존재하고 다음 프로그램의 호출시간이 time과 같으면 que로 이동
                que.add(list.poll());
            }
            if (time == end && !que.isEmpty()) {  // 만약 실행중이던 프로그램이 작업을 마치고, que에 대기중인 프로그램이 있으면 작업 시작
                int[] now = que.poll();
                end += now[2];  // 남은 시간에 시작한 프로그램의 실행시간 추가
                answer[now[0]] += time - now[1];  // answer의 해당 프로그램의 인덱스에 대기시간(현재시간 - 호출된 시간) 추가
            }
        }
바로 위의 코드는 맨 처음 작성했던 코드다.
end에 계속해서 프로그램 실행시간을 누적시키고 time이 end를 따라가는 형태로 작성했다.
두가지 방법 다 예시 테스트 케이스는 수행되는데, 이 코드는 시간 초과가 발생한다.
눈으로 보기에는 아래 방법이 end를 매 반복마다 -1해주는 카운팅 단계가 없어서 더 빠를 것 같은데 왜 더 느려지는 지 궁금하다.
예상되는 문제 발생 지점은 long과 int의 형변환에서 오버플로우가 발생하는 것인데, 머릿속으로 굴려봐도 이유가 잘 찾아지지 않았다.
*/
