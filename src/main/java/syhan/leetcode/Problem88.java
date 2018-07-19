package syhan.leetcode;


public class Problem88 {

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = {1, 3, 5, 0, 0, 0};
        int[] nums2 = {2, 4, 6};

        solution.merge(nums1, 3, nums2, 3);

        System.out.println(nums1);
    }

}

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int t = m + n - 1;
        m--;
        n--;

        while (m >= 0 && n >= 0) {
            if (nums1[m] > nums2[n]) {
                nums1[t] = nums1[m];
                m--;
            } else {
                nums1[t] = nums2[n];
                n--;
            }

            t--;
        }

        while (n >= 0) {
            nums1[t] = nums2[n];
            t--;
            n--;
        }

    }
}
