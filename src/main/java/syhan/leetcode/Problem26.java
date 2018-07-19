package syhan.leetcode;

public class Problem26 {
    public int removeDuplicates(int[] nums) {
        int i = nums[0];
        int j = 0;
        int k = 1;

        for (; k < nums.length; k++) {
            j = nums[k];

            if (i == j) { // duplicate found
                for (int m = k; k < nums.length; m++) {
                    int n = nums[m];
                    if (n != j) { // found a different value
                        // exchange these two values
                        nums[k] = n;
                        nums[m] = j;
                    }
                }
            } else {
                j = i;
            }


        }

        return -1;

    }
}
