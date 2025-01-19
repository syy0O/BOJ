class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String number = Integer.toString(n,k);
        
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<number.length();i++) {
            if (number.charAt(i) != '0') {
                sb.append(number.charAt(i));
            }
            
            if (number.charAt(i) == '0' || i == number.length()-1){
                if (sb.length() != 0) {
                    long prime = Long.parseLong(sb.toString(), 10);
                    if (prime != 1 && isPrime(prime)) {
                        answer++;
                    }
                    sb.setLength(0);
                }
            }
        }
        
        return answer;
    }
    
    public boolean isPrime(long n) {
        int max = (int) Math.sqrt(n);
        for (int i=2;i<=max;i++) {
            if (n % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}