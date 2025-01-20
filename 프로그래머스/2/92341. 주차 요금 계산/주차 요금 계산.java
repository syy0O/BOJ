import java.util.*;

class Solution {
    private static final String LAST_OUT_TIME = "23:59";

    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> in = new HashMap<>();
        Map<String, Integer> cost = new TreeMap<>();

        for (String record : records) {
            StringTokenizer st = new StringTokenizer(record);
            int time = hourToMin(st.nextToken());
            String carNum = st.nextToken();
            String status = st.nextToken();

            if (status.equals("IN")) {
                in.put(carNum, time); // 입차 기록
            } else {
                int inTime = in.remove(carNum); // 입차 시간 가져오기
                int timeSpent = time - inTime; // 머문 시간 계산
                cost.put(carNum, cost.getOrDefault(carNum, 0) + timeSpent); // 누적 주차 시간
            }
        }

        // 출차하지 않은 차량 처리
        int lastOutTime = hourToMin(LAST_OUT_TIME);
        for (String carNum : in.keySet()) {
            int inTime = in.get(carNum);
            int timeSpent = lastOutTime - inTime; // 마지막 출차 시간 기준 머문 시간
            cost.put(carNum, cost.getOrDefault(carNum, 0) + timeSpent);
        }

        // 최종 요금 계산
        int[] answer = new int[cost.size()];
        int idx = 0;
        for (String carNum : cost.keySet()) {
            int totalTime = cost.get(carNum);
            answer[idx++] = calculateFee(totalTime, fees);
        }

        return answer;
    }

    private int hourToMin(String time) {
        StringTokenizer st = new StringTokenizer(time, ":");
        int hour = Integer.parseInt(st.nextToken()) * 60;
        int min = Integer.parseInt(st.nextToken());
        return hour + min;
    }

    private int calculateFee(int totalTime, int[] fees) {
        if (totalTime <= fees[0]) {
            return fees[1]; // 기본 시간 이하일 경우 기본 요금
        }
        double extraTime = totalTime - fees[0];
        return fees[1] + (int) Math.ceil(extraTime / fees[2]) * fees[3]; // 초과 요금 계산
    }
}
