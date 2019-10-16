package 数组;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * @author diaojt
 *
 */

/**
 * 双指针法
 * 算法
 * 
 * 数组完成排序后，我们可以放置两个指针i和j，其中i是慢指针，而j是快指针
 * 只要nums[i] == nums[j]，我们就增加j，跳过重复项
 * 当我们遇到nums[i] != nums[j]，跳过重复项的运行已结束，因此我们必须把它nums[j]的值复制到nums[i+1]
 * 然后递增i，接着我们将再次重复相同的过程，直至j到达数组的末尾为止
 * 
 * */
public class _26_删除排序数组中的重复项 {
	 
	public int removeDuplicates(int[] nums) {
	        
		if (nums.length == 0) return 0;
		int i = 0;
		for (int j = 1; j < nums.length; j++) {
			if (nums[i] != nums[j]) {
				i++;
				nums[i] = nums[j];
			}
		}
		return i + 1;
	}
}
