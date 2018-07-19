package syhan.leetcode;

public class Problem20 {
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        int acc = 0;
        char[] stack = new char[s.length()];

        for (char c : chars) {
            switch (c) {
                case '{':
                case '[':
                case '(':
                    stack[acc++] = c;
                    break;
                case '}':
                    if (acc == 0 || stack[--acc] != '{') return false;
                    break;
                case ']':
                    if (acc == 0 || stack[--acc] != '[') return false;
                    break;
                case ')':
                    if (acc == 0 || stack[--acc] != '(') return false;
                    break;
            }
        }

        return acc == 0;
    }

    public static void main(String[] args) {
        Problem20 problem20 = new Problem20();

        System.out.println(problem20.isValid("(]"));
        System.out.println(problem20.isValid("([)]"));
        System.out.println(problem20.isValid("()"));
        System.out.println(problem20.isValid("()[]{}"));
        System.out.println(problem20.isValid("([]"));
        System.out.println(problem20.isValid("([])"));
    }
}
