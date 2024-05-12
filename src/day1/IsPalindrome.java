package day1;

public class IsPalindrome {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        } else {
            int reversed = 0;

            int original;
            int digit;
            for(original = x; x != 0; reversed = reversed * 10 + digit) {
                digit = x % 10;
                x /= 10;
            }

            return original == reversed;
        }
    }

    public boolean isPalindromeV2(String s) {
        if (Integer.parseInt(s) < 0 || s.isEmpty()) {
            return false;
        } else {
            int i = 0;
            int j = s.length() - 1;
            if (s.charAt(i) != s.charAt(j)) {
                return true;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        IsPalindrome isPalindrome = new IsPalindrome();
        System.out.println(isPalindrome.isPalindrome(121));
        System.out.println(isPalindrome.isPalindrome(-121));
        System.out.println(isPalindrome.isPalindrome(10));

        System.out.println(isPalindrome.isPalindromeV2("-121"));
    }

}
