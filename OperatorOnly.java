package v1_0;

import java.util.Random;

public class OperatorOnly {
	public static final int UPPER = 100;
	private int left_operator;  //左边数值
	private int right_operator;  //右边数值
	private char operator;  //算术符号
	private int result;  //算式结果
	Random random = new Random(); 
	public void randomOperator() //生成算数
	{
		
		left_operator = (int)random.nextInt(UPPER + 1); //随机生成算数符号的左右数值
		right_operator = (int)random.nextInt(UPPER + 1);

	}
	public void setOperators()  //生成算术符号及算式
	{

		int get_operator;  //获得算术符号
		randomOperator(); 
		get_operator = (int)random.nextInt(2); //随机生成算数符号
		if(get_operator == 1)	
		{
			operator = '+';
		}
		else
		{
			operator = '-';
		}
		construct(left_operator, operator, right_operator);  
	}
	public int construct(int left,char op,int right) //计算算式结果
	{
		left_operator = left;
		right_operator = right;
		operator = op;
		if(operator == '+')  //当符号为+时
		{
			checkOperator(); //检查算式结果是否在100以内
			result = left_operator + right_operator;
		}
		else if(operator == '-')  //当符号为-时
		{
			checkOperator(); //检查算式结果是否大于0
			result = left_operator - right_operator;
		}
		return result;
	}
	public void checkOperator() //检查所生成的算式是否在规定范围内
	{
		//检查生成的算式是否符合要求（100以内加减法）
		if(operator == '+')  //当符号为+时，两数之和不能大于100
		{
			if(left_operator + right_operator > UPPER) //如果两数之和大于100，重新生成两个算数直到两数之和小于等于100
			{
				do {
					randomOperator();
				}while(left_operator+ right_operator > UPPER);
			}
		}
		else if(operator == '-')  //当符号为-时，两数之差不能小于零
		{
			if(left_operator < right_operator ) //如果两数之差小于零，重新生成两个算数直到两数之差大于等于零
			{
				do
				{
					randomOperator();
				}while(left_operator < right_operator);
			}
		}
	}
	public char getOperator()  //获得算术符号
	{
		return operator;
	}
	public int getLeftOperator()   //获得左边数值
	{
		return left_operator;
	}
	public int getRightOperator()  //获得右边数值
	{
		return right_operator;
	}
	public int getResult()  //获得算式结果
	{
		return result;
	}
	public String toString()
	{
		return "题目是：" +left_operator + operator + right_operator + "=" + result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OperatorOnly anoperator = new OperatorOnly();
		anoperator.setOperators();
		System.out.println(anoperator.toString());
	}

}
