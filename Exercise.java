package v4_1;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import v4_1.AdditionOperation;
import v4_1.Operation;
import v4_1.SubstractOperation;
public class Exercise{

	public static final int NUMBER = 20; //要生成的算式数量	
	protected String[] exercise = new String[NUMBER]; //存放生成算式的字符串数组
	protected int[] result = new int[NUMBER]; //存放生成算式结果的字符串数组
	protected int[] value = new int[NUMBER];
	
	String fileExercise = "f:\\exercise.csv"; //习题文件
	String fileValue = "f:\\value.csv";  //练习文件
	String fileResult = "f:\\result.csv"; //结果文件
	ArrayList<String[]> lstFile = new ArrayList<String[]>();
	
	public void displayExercise(int colums)  //输出算式题集，colms为每行显示的算式数目
	{
		    System.out.println("共计" + NUMBER + "道算术题，请作答：");
		    System.out.println("—————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————");
		    for(int i = 0;i < NUMBER;i++)
	    	{
	    		System.out.print((i + 1) + ":\t" + exercise[i] + "\t\t");
	    		Scanner aValue = new Scanner(System.in);
	    		int number = aValue.nextInt();
	    		value[i] = number;
	    	}
	}
	
	public void displayResult(int colums)  //输出题集的结果
	{
		double number = 0; //做对题的个数
		double rate; //正确率
		System.out.println();
		System.out.println("—————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————");
		System.out.println("正确答案：");
		for(int i = 0;i < NUMBER;i++)  //输出正确答案
		{
			System.out.print((i + 1) + ":"+ exercise[i] + result[i] + "\t\t");
			if((i + 1) % colums == 0)
			{
				System.out.println();
			}
		}
		System.out.println("—————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————");
		for(int j = 0;j < result.length;j++) //对比value数组和正确答案result数组
		{
			if(value[j] == result[j])
			{
				number++;
			}
			else
			{
				System.out.println("第" + (j+1) + "题答案错误！正确答案为：" + result[j]);
			}
		} 
		rate = number / value.length * 100;  //计算正确率
		System.out.println("总共题目数为：" + result.length + "；答对题数为：" + number);
		System.out.println("正确率为：" + rate + "%");
	}

}


