/**
**You are playing the following Bulls and Cows game with your friend: You write down a number and ask your friend to guess what the number is. 
**Each time your friend makes a guess, you provide a hint that indicates how many digits in said guess match your secret number 
**exactly in both digit and position (called "bulls") and how many digits match the secret number but locate in the wrong position (called "cows"). 
**Your friend will use successive guesses and hints to eventually derive the secret number.
**For example:
**Secret number:  "1807"
**Friend's guess: "7810"
**Hint: 1 bull and 3 cows. (The bull is 8, the cows are 0, 1 and 7.)
**Write a function to return a hint according to the secret number and friend's guess, use A to indicate the bulls and B to indicate the cows. 
**In the above example, your function should return "1A3B".
**/

class Solution {
    public String getHint(String secret, String guess) {
        int a = 0;
        int b = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < secret.length(); i++){
            if (guess.charAt(i) == secret.charAt(i)){
                a++;
            }
            else if(map.containsKey(Character.valueOf(secret.charAt(i)))){
                map.put(secret.charAt(i), map.get(Character.valueOf(secret.charAt(i))) + 1);
            }
            else
                map.put(secret.charAt(i), 1);
        }
        
        for (int i = 0; i < guess.length(); i++){
            if (map.containsKey(Character.valueOf(guess.charAt(i))) && map.get(Character.valueOf(guess.charAt(i))) > 0 && (guess.charAt(i) != secret.charAt(i))){
                b++;
                map.put(guess.charAt(i), map.get(Character.valueOf(guess.charAt(i))) - 1);
            }
        }
        String sb = a+"A"+b+"B";
        return sb;
    }
}