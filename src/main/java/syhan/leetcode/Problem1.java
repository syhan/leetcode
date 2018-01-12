package syhan.leetcode;

public class Problem1 {
    public static void main(String[] args) {
        int[] answer = new Problem1().twoSum(new int[]{2, 7, 11, 15}, 9);

        System.out.println(answer[0]);
        System.out.println(answer[1]);
    }

    public int[] twoSum(int[] nums, int target) {
        int length = nums.length;

        for (int i = 0; i < length; i++) {
            for (int j = 1; j < length; j++) {
                if (i != j && nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        throw new IllegalArgumentException("assume input has exactly one answer");
    }
}