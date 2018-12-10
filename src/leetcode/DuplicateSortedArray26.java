package leetcode;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 */
public class DuplicateSortedArray26 {

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int nlength = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] != nums[i]) {
                nums[nlength] = nums[i];
                nlength++;
            }
        }
        return nlength;

    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{0, 0, 1, 1, 2, 2}));
    }
}
