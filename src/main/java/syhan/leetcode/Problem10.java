package syhan.leetcode;

public class Problem10 {
    public static void main(String[] args) {
        Problem10 problem10 = new Problem10();

        System.out.println(problem10.isMatch("aa", "a"));
        System.out.println(problem10.isMatch("aa", "aa"));
        System.out.println(problem10.isMatch("aaa", "aa"));
        System.out.println(problem10.isMatch("aa", "a*"));
        System.out.println(problem10.isMatch("aa", ".*"));
        System.out.println(problem10.isMatch("ab", ".*"));
        System.out.println(problem10.isMatch("aab", "c*a*b"));
        System.out.println(problem10.isMatch("ab", ".*c"));
        System.out.println(problem10.isMatch("abcd", "d*"));
    }

    public boolean isMatch(String s, String p) {
        char[] pattern = p.toCharArray();
        char[] inputs = s.toCharArray();

        int index = 0;
        int i = 0;
        char last = 0;

        while (i < pattern.length && index < inputs.length) {
            char c = pattern[i];
            char input = inputs[index];

            if (c == '*') { // match zero or more of the preceding character
                if (last == '.') { // any character
                    index ++;
                } else {
                    if (input == last) {
                        index ++; // continue use last pattern
                    } else {
                        i ++; // move to next pattern
                    }
                }
            } else if (c == '.')  { // any character
                last = c;
                i ++; // move to next input
            } else { // normal character
                last = c;
                if (input == c) {
                    index ++; // next input
                }
                i ++; // next pattern
            }
        }

        return index == inputs.length ;
    }
}
