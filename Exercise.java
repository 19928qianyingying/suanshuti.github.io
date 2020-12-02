package v1_1;

import java.util.Random;
import java.util.function.BinaryOperator;


public class Exercise {

	public static final int NUMBER = 50; //要生成的算式数量
	
	private String[] exercise = new String[NUMBER]; //存放生成算式的字符串数组
	private String[] result = new String[NUMBER]; //存放生成算式结果的字符串数组
	
	public BinaryOperation setExercise() //生成随机题集
	{
		int get_operator;
		Random random = new Random();
		get_operator = (int)random.nextInt(2); //随机生成算数符号
		if(get_operator == 1)	//当随机生成的数字为1时，定义为加法运算
		{ 
			return new AdditionOperation(); //返回生成的加法算式
		}
		else   //否则定义为减法运算
		{
			return new SubstractOperation();  //返回生成的减法算式
		}

	}

	public void setBothExercise()  //加减法混合运算
	{
		BinaryOperation exe;  //定义一个抽象算式对象
		for(int i = 0;i < NUMBER;i++)  //生成NUMBER个算式
		{
			exe = setExercise();    //调用算式生成方法随机生成加减法算式
			exercise[i] ="" + exe.toString(); //将算式储存在习题数组中
			result[i] = "" + exe.allString(); //将结果储存在结果数组中，下同
		}
	}
	
	public void getAdditionExercise()   //生成加法算式题集
	{
		AdditionOperation add = new AdditionOperation();
		for(int i = 0;i < NUMBER;i++)
		{
			add.randomOperator('+');
			exercise[i] ="" + add.toString();
			result[i] = "" + add.allString();
		}
	}
	public void getSubstractExercise()  //生成减法算式题集
	{
		SubstractOperation sub = new SubstractOperation();
		for(int i = 0;i < NUMBER;i++)
		{
			sub.randomOperator('-');
			exercise[i] ="" + sub.toString();
			result[i] = "" + sub.allString();
		}
	}

	public void displayExercise(int colums)  //输出算式题集，colms为每行显示的算式数目
	{
		System.out.println("共计" + NUMBER + "道算术题：");
		System.out.println("—————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————");
		for(int i = 0;i < NUMBER;i++)
		{
			System.out.print((i + 1) + ":\t" + exercise[i] + "\t\t");
			if((i + 1) % colums == 0)
			{
				System.out.println();
			}
		}
	}
	public void displayResult(int colums)  //输出题集的结果
	{
		System.out.println();
		System.out.println("—————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————");
		System.out.println("正确答案：");
		for(int i = 0;i < NUMBER;i++)
		{
			System.out.print((i + 1) + ":" + result[i] + "\t\t");
			if((i + 1) % colums == 0)
			{
				System.out.println();
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Exercise exe = 	new Exercise();
		exe.setBothExercise();
		exe.displayExercise(6);
		exe.displayResult(6);

	}
}
