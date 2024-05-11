package day1;

public class RomanToInt {
    public int romanToInt(String s) {
        int result = 0;
        int prev = 0;

        for(int i = s.length() - 1; i >= 0; --i) {
            int current = this.romanToInt(s.charAt(i));
            if (current < prev) {
                result -= current;
            } else {
                result += current;
            }

            prev = current;
        }

        return result;
    }

    private int romanToInt(char c) {
        switch (c) {
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'I':
                return 1;
            case 'L':
                return 50;
            case 'M':
                return 1000;
            case 'V':
                return 5;
            case 'X':
                return 10;
            default:
                throw new IllegalArgumentException("Invalid roman numeral");
        }
    }

    public static void main(String[] args) {
        RomanToInt romanToInt = new RomanToInt();
        System.out.println(romanToInt.romanToInt("III"));
        System.out.println(romanToInt.romanToInt("IV"));
        System.out.println(romanToInt.romanToInt("IX"));
        System.out.println(romanToInt.romanToInt("LVIII"));
        System.out.println(romanToInt.romanToInt("MCMXCIV"));
    }
}
