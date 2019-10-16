package 数组;
/**
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 * @author diaojt
 *
 */
public class _04_寻找两个有序数组的中位数 {
	
	// 解法一：寻找第k小数的思想
	public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
    
		int len1 = nums1.length;
		int len2 = nums2.length;
		// 要求第k小的数，先求出k，这里求中位数，所以k满足:
		// nums1和nums2总个数为奇数时，k = (len1+len2+1)/2，即为第中间那个数
		// nums1和nums2总个数为偶数时，求中卫数需要知道合并排序后中间的两个数，位置分别为left，right
		// 那么left = (len1+len2+1)/2, right = (len1 + len2 + 2)/2
		int left = (len1 + len2 +1)/2;
		int right = (len1 + len2 + 2)/2;
		
		// 将偶数和奇数的情况合并，如果是奇数，会求两次同样的k
		return (getKth(nums1, 0, len1-1, nums2, 0, len2 - 1, left) + getKth(nums1, 0, len1-1, nums2, 0, len2-1, right)) * 0.5;
    }
	
	
	// 获取两个有序数组中第k小数
	private int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
		int len1 = end1 - start1 + 1;
		int len2 = end2 - start2 + 1;
		//让len1的长度小于len2，这样就能保证有数组空了，一定是len1
		if (len1 > len2) return getKth(nums2, start2, end2, nums1, start1, end1, k);
		if (len1 == 0) return nums2[start2 + k- 1];
		
		if (k == 1) return Math.min(nums1[start1], nums2[start2]);
		int i = start1 + Math.min(len1, k/2) -1;
		int j = start2 + Math.min(len2, k/2) -1;
		
		if (nums1[i] > nums2[j]) {
			return getKth(nums1, start1, end1, nums2, j + 1 , end2, k- (j-start2+1));
		}else {
			return getKth(nums1, i + 1, end1, nums2, start2, end2, k- (i-start1+1));
		}
	}
	
	// 解法二：
		public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
			
			
			
			return 0;
		}
	
}
