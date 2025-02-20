package daily.february;

public class day_10_02_2025 {
    public static void main(String[] args) {
        day_10_02_2025 solution = new day_10_02_2025();
        System.out.println(solution.clearDigits("bc34")); // ""
        System.out.println(solution.clearDigits("abc")); // "abc"
    }

    public String clearDigits(String s) {
        // loại bỏ hết số trong chuỗi và chữ cái gần nhaất  bên trái của nó
        // abc34 -> a
        // bc34 -> ""
        // abc -> abc
        // 1. tìm số đầu tiên trong chuỗi
        // 2. tìm chữ cái gần nhất bên trái của số đó
        // 3. xóa số và chữ cái đó
        // 4. lặp lại bước 1 cho đến khi không còn số nào

        while (true) {
            int index = -1;
            for (int i = 0; i < s.length(); i++) {
                if (Character.isDigit(s.charAt(i))) {
                    index = i;
                    break;
                }
            }
            if (index == -1) {
                break;
            }
            int left = index - 1;
            while (left >= 0 && !Character.isLetter(s.charAt(left))) {
                left--;
            }
            s = s.substring(0, left) + s.substring(index + 1);
        }

        return s;
    }
}
