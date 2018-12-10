package leetcode;

/**
 * https://leetcode.com/problems/remove-element/
 */
public class RemoveElement27 {
    public static int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int nlength = (nums[0] == val) ? 0 : 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[nlength] = nums[i];
                nlength++;
            }
        }
        return nlength;
    }

    public static void main(String[] args) {
        System.out.println(removeElement(new int[]{0, 0, 12, 3, 2, 2, 4}, 2));
    }
}
