package 数组;

import java.util.HashMap;


/**
 * https://leetcode-cn.com/problems/two-sum/
 * @author diaojt
 *
 */
public class _01_两数之和 {

	// 思路:
	// 标签：哈希映射
	// 本题如果采用暴力遍历的话是容易解决的，但是时间复杂度为O(n2)
	// 由于哈希查找的时间复杂度为O(1)，所以可以利用哈希容器map降低时间复杂度
	// 遍历数组nums，i为当前下标，每个值都判断map中是否存在target - num[i]的key值
	// 如果存在则找到了两个值，如果不存在则将当前的(nums[i], i)存入map中，继续遍历直到找到为止
	// 如果最终都没有结果则抛出异常
	// 时间复杂度为O(n)
	public int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(target-nums[i])) {
				return new int[] {map.get(target - nums[i]),i};
			}
			map.put(nums[i], i);
		}
		throw new IllegalArgumentException("No two sum solution");
        
    }
}
