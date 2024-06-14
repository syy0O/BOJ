import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        
        int[] pattern1 = {1,2,3,4,5};
        int[] pattern2 = {2,1,2,3,2,4,2,5};
        int[] pattern3 = {3,3,1,1,2,2,4,4,5,5};
        
        Person person1 = new Person(pattern1);
        Person person2 = new Person(pattern2);
        Person person3 = new Person(pattern3);
        
        List<Person> people = new ArrayList<>();
        people.add(person1);
        people.add(person2);
        people.add(person3);
        
        for (int i=0;i<answers.length;i++) {
            int collectAnswer = answers[i];
            for (int j=0;j<people.size();j++) {
                if (people.get(j).getCurrAnswer() == collectAnswer) {
                    people.get(j).updateAnswerCnt();
                }
            }
        }
        
        int max = Integer.MIN_VALUE;
        for (int i=0; i<people.size();i++) {
            int curr = people.get(i).getAnswerCnt();
            if (max < curr) {
                max = curr;
            }
        }
        
        List<Integer> answerList = new ArrayList<>();
         for (int i=0; i<people.size();i++) {
            int curr = people.get(i).getAnswerCnt();
            if (max == curr) {
                answerList.add(i+1);
            }
        }
        
        
        int[] answer = new int[answerList.size()];
        for (int i=0;i<answer.length;i++) {
            answer[i] = answerList.get(i);
        }
        
        
        return answer;
    }
    
    
    private class Person {
        private int[] pattern;
        private int currIdx;
        private int answerCnt;
        
        public Person(int[] pattern) {
            this.pattern = pattern;
            this.currIdx = 0;
            this.answerCnt = 0;
        }
        
        public void updateCurrIdx(){
            int size = pattern.length;
            currIdx = (currIdx+1) % size;
        }
        
        public void updateAnswerCnt(){
            answerCnt++;
        }
        
       public int getCurrAnswer(){
           int answer = pattern[currIdx];
           updateCurrIdx();
           return answer;
       }
        
        public int getAnswerCnt(){
            return answerCnt;
        }
    }
    
}