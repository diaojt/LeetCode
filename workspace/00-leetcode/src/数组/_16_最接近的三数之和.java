package 数组;
import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/3sum-closest/
 * @author diaojt
 *
 */
public class _16_最接近的三数之和 {

	public int threeSumClosest(int[] nums, int target) {
		
		Arrays.sort(nums);
		int result = nums[0] + nums[1] + nums[2];
		int len = nums.length;
		for (int i = 0; i < nums.length - 2; i++) {
			int L = i + 1;
			int R = len -1;
			while (L < R) {
				int sum = nums[i] + nums[L] +  nums[R];
				if (Math.abs(sum-target) < Math.abs(result - target)) 
					result = sum;
				if (sum > target) {
					R--;
				}
				else{
					L++;
				}	
			}
		}
		
		return result;
    }
}
