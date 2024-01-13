import java.util.HashMap;

class Solution {
    public boolean solution(String[] phone_book) {      
        boolean answer = true;

        HashMap<String, Integer> phoneBook = new HashMap<>();
        for (int i = 0; i < phone_book.length; i++) {
            phoneBook.put(phone_book[i], i);
        }

        for (int i = 0; i < phone_book.length; i++) {
            StringBuilder sb = new StringBuilder();
            String curr = phone_book[i];
            for (int j = 0; j < curr.length(); j++) {
                sb.append(curr.charAt(j));
                if (phoneBook.containsKey(sb.toString())) {
                    if (phoneBook.get(sb.toString()) != i) {
                        answer = false;
                        return answer;
                    }
                }
            }
        }

        return answer;
    }
}