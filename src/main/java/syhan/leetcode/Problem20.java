package syhan.leetcode;

public class Problem20 {
    public boolean isValid(String s) {
        int[] acc = validHelper(s, 0, 0, 0);
        return acc[0] == 0 && acc[1] == 0 && acc[2] == 0;
    }

    private int[] validHelper(String s, int acc1, int acc2, int acc3) {
        if (s.isEmpty()) {
            return new int[]{acc1, acc2, acc3};
        }

        char c = s.charAt(0);

        if (c == '{') acc1 ++;
        else if (c == '[') acc2 ++;
        else if (c == '(') acc3 ++;
        // close must in a correct order
        else if (c == '}' && acc2 == 0 && acc3 == 0) acc1 --;
        else if (c == ']' && acc1 == 0 && acc3 == 0) acc2 --;
        else if (c == ')' && acc1 == 0 && acc2 == 0) acc3 --;

        return validHelper(s.substring(1), acc1, acc2, acc3);

    }

    public static void main(String[] args) {
        Problem20 problem20 = new Problem20();

        System.out.println(problem20.isValid("(]"));
        System.out.println(problem20.isValid("([)]"));
        System.out.println(problem20.isValid("()"));
        System.out.println(problem20.isValid("()[]{}"));
    }
}
