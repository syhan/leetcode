package syhan.leetcode;

public class Problem27 {
    public static void main(String[] args) {
        Problem27 problem27 = new Problem27();

//        int[] ints = {3, 2, 2, 3};
        int[] ints = {2};
        int i = problem27.removeElement(ints, 3);

        System.out.println(i);
    }

    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = nums.length - 1; i <= j;) {
            if (nums[i] == val) {
                if (nums[j] != val) { // swap
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                } else {
                    j--;
                }
            } else {
                i++;
            }
        }

        return i;
    }
}
