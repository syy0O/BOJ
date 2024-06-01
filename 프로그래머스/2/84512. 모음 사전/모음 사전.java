class Solution {
    private final Character[] vowel = {'A', 'E', 'I', 'O','U'};
    private int seq = 0, answer = 0;
    private StringBuilder sb;
    public int solution(String word) {
        sb = new StringBuilder();
        findWordSeq(word);

        return answer;
    }

    
    public void findWordSeq(String word){
        if (word.equals(sb.toString())) {
            answer = seq;
            return;   
        }
        
        for (int i=0;i<5;i++) {
            if (sb.toString().length() < 5) {
                 sb.append(vowel[i]);
                 seq++;
                 findWordSeq(word);
                 sb.deleteCharAt(sb.length() - 1);
            }
        }    
    }

}