/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

//my number means 猜的人说的那个数
public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int low = 0, high = n;
        
        while(low + 1 < high) {
            int mid = low + (high - low) / 2;
            if(guess(mid) == 0) return mid;
            if(guess(mid) < 0) high = mid;
            else low = mid;
        }
        
        return guess(low) == 0 ? low : high;
    }
}