package 数组;
/**
 * https://leetcode-cn.com/problems/container-with-most-water/
 * @author diaojt
 *
 */

/**
 * 最初我们考虑由最外围两条线段构成的区域。现在，为了使面积最大化，我们需要考虑更长的两条线段之间的区域。
 * 如果我们试图将指向较长线段的指针向内侧移动，矩形区域的面积将受限于较短的线段而不会获得任何增加。
 * 但是，在同样的条件下，移动指向较短线段的指针尽管造成了矩形宽度的减小，但却可能会有助于面积的增大。
 * 因为移动较短线段的指针会得到一条相对较长的线段，这可以克服由宽度减小而引起的面积减小。 
 * 
 * */
public class _11_盛最多水的容器 {
	public int maxArea(int[] height) {
        int maxarea = 0;
        int l = 0, r = height.length -1;
        while(l < r) {
        	maxarea = Math.max(maxarea, (r-l)*(Math.min(height[l], height[r])));
        	if (height[l] > height[r]) {
				r--;
			}else {
				l ++;
			}
        }
		
		return maxarea;
    }
}
