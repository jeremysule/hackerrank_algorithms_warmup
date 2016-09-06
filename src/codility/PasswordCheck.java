package codility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by jeremy on 19/08/16.
 */
public class PasswordCheck {
    String rejectCharacters = ".*[^a-zA-Z0-9].*";

    public boolean satisfyEvenLetters(String word){
        int howMany = 0;
        char[] characters = word.toLowerCase().toCharArray();
        for (char c : characters){
            int ascii = (int) c;
            if ( ascii >= 97 && ascii <= 122)
                howMany ++;
        }
        return howMany%2 == 0;
    }

    public boolean satisfyOddDigits(String word) {
        int howMany = 0;
        char[] characters = word.toLowerCase().toCharArray();
        for (char c : characters){
            int ascii = (int) c;
            if ( ascii >= 48 && ascii <= 57)
                howMany ++;
        }
        return howMany%2 == 1;
    }

    public int solution(String S) {
        int res = -1;
        String[] words = S.split(" ");
        for (String word : words) {
            if ( word.matches(rejectCharacters) )
                continue;
            if ( ! satisfyEvenLetters(word))
                continue;
            if (! satisfyOddDigits(word))
                continue;
            res = Math.max(res,word.length());
        }
        return res;
    }

    public static void main(String[] args) {
        PasswordCheck task = new PasswordCheck();
        System.out.println(task.solution("test 5 a0A pass007 ?xy1"));

    }
}
