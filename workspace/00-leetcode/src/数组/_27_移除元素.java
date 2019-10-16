package 数组;

import java.util.Arrays;
import java.util.concurrent.Delayed;

/**
 * https://leetcode-cn.com/problems/remove-element/
 * @author diaojt
 *
 */
public class _27_移除元素 {

	public int removeElement(int[] nums, int val) {
		if (nums.length == 0) return 0;
		int result = nums.length;
		int left = 0;
		int right = nums.length - 1;
		while (left <= right) {
			if (nums[left] != val) {
				left++;
			}else {
				if (nums[right] != val) {
					nums[left] = nums[right];
					left ++;
				}
				result --;
				right --;
			}
		}
		
		return result;
    }
}
