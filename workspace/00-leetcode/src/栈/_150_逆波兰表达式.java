package 栈;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/
 * @author diaojt
 */
public class _150_逆波兰表达式 {

	private boolean isOperator(String token) {
		return "+-*/".contains(token);
	}
	
	private int calculate(Integer left, Integer right, String operator) {
		switch (operator) {
		case "+": return left + right;
		case "-": return left - right;
		case "*": return left * right;
		default: return left / right;
		}
	}
	
	// ["2","1","+","3","*"]
	public int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<Integer>();
		for (String token : tokens) {
			if (isOperator(token)) { // 符号
				Integer right = stack.pop(); // 右操作数
				Integer left  = stack.pop(); // 左操作数
				stack.push(calculate(left, right, token));
			}else { // 数字
				stack.push(Integer.parseInt(token));
			}
		}
		
		return stack.pop();
	}
	
}
