package v4_1;

import java.util.Random;

public class Operation { //算式类
	static final int UPPER = 100;  
	protected int left_operator = 0;  //算式的属性
	protected int right_operator = 0;
	protected char operator = '+';
	protected int result = 0;  //算式结果 
	
	public String toString()  //返回题目
	{
		return "" + left_operator + operator + right_operator + "=";
	}
	
	public int allString()  //返回题目和结果
	{
		return result;
	}
}

