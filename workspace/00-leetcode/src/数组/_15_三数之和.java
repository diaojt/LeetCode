package 数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * https://leetcode-cn.com/problems/3sum/
 * @author diaojt
 *
 */

/**
 * 解决方案
 * 思路
 * 标签：数组遍历
 * 首先对数组进行排序，排序后固定一个数nums[i]，再使用左右指针指向nums[i]后面的两端，数字分别为nums[L]和nums[R]
 * 计算三个数的和sum判断是否满足为0，满足则添加进结果集
 * 如果nums[i]>0，则三数之和必然无法等于0，结束循环
 * 如果nums[i] == nums[i-1]，则说明该数字重复，会导致结果重复，所以应该跳过
 * 当sum == 0时，nums[L] == nums[L+1]则会导致结果重复，应该跳过，L++
 * 当sum == 0时，nums[R] == nums[R-1]则会导致结果重复，应该跳过，R--
 * 时间复杂度：O(n2),n为数组长度
 * 
 * */

public class _15_三数之和 {

	public List<List<Integer>> threeSum(int[] nums) {
        
		List<List<Integer>> ans = new ArrayList<>();
		int len = nums.length;
		if (nums == null || len < 3) return ans;
		
		// 排序
		Arrays.sort(nums);
		for (int i = 0; i < len; i++) {
			// 如果当前数字大于0，则三数之和一定大于0，退出循环
			if (nums[i] > 0) break; 
			if (i > 0 && nums[i] == nums[i-1]) continue;
			
			int L = i+1;
			int R = len -1;
			while(L < R) {
				int sum = nums[i] + nums[L] + nums[R];
				if (sum == 0) {
					ans.add(Arrays.asList(nums[i], nums[L], nums[R]));
					while(L<R && nums[L] == nums[L+1]) L++; //去重
					while(L<R && nums[R] == nums[R-1]) R--; //去重
					L++;
					R--;
				}
				else if (sum < 0) L++;
				else if (sum > 0) R--;
			}
		}
		return ans;
	}
}
