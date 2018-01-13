package syhan.leetcode;

public class Problem7 {

    public static void main(String[] args) {

        Problem7 problem7 = new Problem7();

        System.out.println(problem7.reverse(123));
        System.out.println(problem7.reverse(-123));
        System.out.println(problem7.reverse(120));
        System.out.println(problem7.reverse(Integer.MAX_VALUE));
        System.out.println(problem7.reverse(Integer.MIN_VALUE));
    }

    public int reverse(int x) {
        String s = new StringBuilder(String.valueOf(x)).reverse().toString();

        if (s.endsWith("-")) {
            s = s.substring(0, s.length() - 1);
            s = "-" + s;
        }

        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
