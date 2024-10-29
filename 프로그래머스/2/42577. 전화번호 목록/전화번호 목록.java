import java.util.*;
import java.lang.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Arrays.sort(phone_book);
        
        HashSet<String> phoneBook = new HashSet<>();
        
        // 전화번호 배열 1000000
        for (int i=0; i<phone_book.length; i++) {
            String curr = phone_book[i];
            
            StringBuilder sb = new StringBuilder();  // 한글자씩 붙여가면서 -> 해시에 있는지확인.
            for (int s=0;s<curr.length();s++) { // 전화번호는 한글자씩 돌아야함.(20)    
                sb.append(curr.charAt(s) + "");
                 // 전화번호가 긴 애들은 Hash에 현재 자신의 문자열에 해당하는 키가 있는지 확인하면 될듯.
                if (phoneBook.contains(sb.toString())) {
                    answer = false;
                    break;
                }
            } 
           
            if (!answer) {
                break;
            }
            
            // 전화번호가 짧은 애들은 그냥 Hash로 들어가게 될 것.
            phoneBook.add(curr);   
        }
  
        return answer;
    }
}