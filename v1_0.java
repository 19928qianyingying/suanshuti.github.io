package v1_0;

import java.util.Random;

class Operator{
	private int left_operator;  //左边数值
	private int right_operator;  //右边数值
	private int get_operator;  //获得算术符号
	private char operator;  //算术符号
	private int result;  //算式结果
	Random random = new Random(); 
	public void randomOperator() //生成算数
	{
		left_operator = (int)random.nextInt(101); //随机生成算数符号的左右数值
		right_operator = (int)random.nextInt(101);
	}
	public void setOperators()  //生成算术符号及算式
	{
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
		checkOperator();  //检查算式
	}
	public void checkOperator() //检查所生成的算式是否在规定范围内
	{
		//检查生成的算式是否符合要求（100以内加减法）
		if(operator == '+')  //当符号为+时，两数之和不能大于100
		{
			if(left_operator + right_operator > 100) //如果两数之和大于100，重新生成两个算数直到两数之和小于等于100
			{
				do {
					randomOperator();
				}while(left_operator+ right_operator > 100);
			}
			result = left_operator + right_operator;
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
			result = left_operator - right_operator;
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
}

class Exercise{
	private int number = 50; //要生成的算式数量
	private int[][] operators = new int[number][2]; //存放左右数值
	private char[] exercise = new char[number];  //存放算术符号 
	private int[] result = new int[number];  //存放习题集的算式结果
	Operator ex = new Operator();
	public void setExercise() //生成题集
	{
		for(int i = 0,j = 0;i < number;i++) 
		{
			ex.setOperators();
			operators[i][j] = ex.getLeftOperator();
			operators[i][j+1] = ex.getRightOperator();
			exercise[i] = ex.getOperator();
			result[i] = ex.getResult();
		}
	}
	public void checkDuplicate()  //检查生成算式是否重复
	{
		for(int i = 0,j = 0;i < number; i++)
		{
			for(int k = i + 1;k <number; k++)
			{
				//当运算符号相等时，检查符号两边值是否重复，重复则重新生成
				if(exercise[i] == exercise[k])
				{
					if(operators[i][j] == operators[k][j] && operators[i][j+1] == operators[k][j+1] || operators[i][j] == operators[k][j+1] && operators[i][j+1] == operators[k][j])
					{
						do 
						{
							ex.randomOperator();
							operators[k][j] = ex.getLeftOperator();
							operators[k][j+1] = ex.getRightOperator();
							result[k] = ex.getResult();
						}while(operators[i][j] == operators[k][j] && operators[i][j+1] == operators[k][j+1] || operators[i][j] == operators[k][j+1] && operators[i][j+1] == operators[k][j]);					
					}
				}
			}
		}
	}
	public int[][] getOperators() 
	{
		return operators;
	}
	public char[] getExercise() 
	{
		return exercise;
	}
	public void printExercise() //输出
	{
		System.out.println("共计" + number + "道算术题：");
		System.out.println("—————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————");
		for(int i = 0;i < number;i++)
		{
			for(int j = 0;j < 1;j++)
			{
				System.out.print((i + 1) + ":\t" + operators[i][j] + exercise[i] + operators[i][j+1] + "=" + "\t\t");
				if((i + 1) % 5 == 0)
				{
					System.out.println();
				}
			}
		}
	}
	public void printResult()  //输出答案
	{
		System.out.println("—————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————");
		System.out.println("正确答案：");
		for(int i = 0;i < number;i++)
		{
			System.out.print((i + 1) + ":\t" + result[i] + "\t\t");
			if((i + 1) % 5 == 0)
			{
				System.out.println();
			}
		}
	}
}
public class v1_0 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub			
		Exercise exee = new Exercise();
		exee.setExercise();
		exee.printExercise();
		exee.printResult();
	}

}
