import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static boolean check(Character open, Character close){
        
        if(open == '(' && close == ')')
            return true;
        else if(open == '[' && close == ']')
               return true;
        else if(open == '{' && close == '}')
                return true;
        else
                return false;
        
    }
    
    // function to check if the given string is a balanced paranthesis.
    public static String checkBraces(String value) {
        
        // Stack to hold the opening braces
        Stack<Character> specialCharacter = new Stack<Character>();
        char tempChar;
      
            
        String response = "NO";
        
        // List that holds opening and closing braces.
        Character[] openBraces = {'{', '[', '('};
        Character[] closeBraces ={'}', ']', ')'};
        List<Character> open = Arrays.asList(openBraces);
        List<Character> close = Arrays.asList(closeBraces);
        
        // boundary checks
        if(value == null)
                return response;
        else if(value.length() == 0)
                return "YES";
        else {

               
            for(int i = 0; i < value.length(); i++){
                
                tempChar = value.charAt(i);
               
                // if opening brace push it in the stack/
                if(open.contains(tempChar))
                        specialCharacter.push(tempChar);
                else if(close.contains(tempChar)) {
                    
                    if(! specialCharacter.isEmpty()) {
                        
                       if(! check(specialCharacter.pop(), tempChar))
                           return response;
                    }
                    else
                        return response;
                }
                else
                    return response;               
            }
                
            if(specialCharacter.isEmpty())
                    return "YES";
            else
                return response;
            
        }
     
    } 
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            String s = in.next();
            String res = checkBraces(s);
            System.out.println(res);
        }
    }
}
