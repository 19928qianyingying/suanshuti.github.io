package v1_1;

import java.util.Random;

abstract class BinaryOperation { //算式抽象类
	static final int UPPER = 100;
	private int left_operator = 0;
	private int right_operator = 0;
	char operator = '+';
	private int result = 0;  //算式结果
	Random random = new Random(); 
	public void randomOperator(char anoperator) //生成算数
	{
		int left,right;
		int value;
		left = (int)random.nextInt(UPPER + 1); //随机生成算数符号的左右数值	
		do
		{
			right = (int)random.nextInt(UPPER + 1);
			value = caculate(left, right);
		}while(!checkOperation(left, right)); //如果不符合算式范围则重新生成right并重新计算value

		left_operator = left;  
		right_operator = right;
		operator = anoperator;
		result = value;

	}
	public abstract boolean checkOperation(int leftCheck,int rightCheck); //检查算式范围
	public abstract int caculate(int left,int right); //计算算式结果
	
	public String toString()  //返回题目
	{
		return "" + left_operator + operator + right_operator + "=";
	}
	
	public String allString()  //返回题目和结果
	{
		return "" +left_operator + operator + right_operator + "=" + result;
	}
}

class AdditionOperation extends BinaryOperation{
	public AdditionOperation() 
	{
		 randomOperator('+');
	}
	@Override
	public boolean checkOperation(int leftCheck,int rightCheck)
	{
		return leftCheck+ rightCheck <= UPPER;
	}

	@Override
	public int caculate(int left,int right) 
	{		
		return left + right;
	}
}

class SubstractOperation extends BinaryOperation{
	public SubstractOperation() 
	{
		 randomOperator('-');
	}
	@Override
	public boolean checkOperation(int leftCheck,int rightCheck)
	{
		return leftCheck > rightCheck; 
	}

	@Override
	public int caculate(int left,int right) 
	{
		return left - right;
	}
}

public class Operation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryOperation add = new AdditionOperation();
		System.out.println(add.toString());
		System.out.println(add.allString());
		
		BinaryOperation sub;
		sub = new SubstractOperation();
		System.out.println(sub.toString());
		System.out.println(sub.allString());

	}

}
