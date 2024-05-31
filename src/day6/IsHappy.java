package day6;

public class IsHappy {

    public boolean isHappy(int n) {
        int slow = n;
        int fast = digitSquareSum(n);
        while (fast != 1 && slow != fast) {
            slow = digitSquareSum(slow);
            fast = digitSquareSum(digitSquareSum(fast));
        }
        return fast == 1;
    }

    public boolean isHappyV2(int n) {

        int slow = n;
        int fast = n;

        do {
            slow = digitSquareSum(slow);
            fast = digitSquareSum(digitSquareSum(fast));
        } while (slow != fast);


        return slow == 1;
    }

    private int digitSquareSum(int n) {
        int sum = 0;
        while (n != 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        IsHappy isHappy = new IsHappy();
        System.out.println(isHappy.isHappy(19));
        System.out.println(isHappy.isHappy(2));
    }
}
