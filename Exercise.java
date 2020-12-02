package v1_1;

import java.util.Random;
import java.util.function.BinaryOperator;


public class Exercise {

	public static final int NUMBER = 50; //Ҫ���ɵ���ʽ����
	
	private String[] exercise = new String[NUMBER]; //���������ʽ���ַ�������
	private String[] result = new String[NUMBER]; //���������ʽ������ַ�������
	
	public BinaryOperation setExercise() //��������⼯
	{
		int get_operator;
		Random random = new Random();
		get_operator = (int)random.nextInt(2); //���������������
		if(get_operator == 1)	//��������ɵ�����Ϊ1ʱ������Ϊ�ӷ�����
		{ 
			return new AdditionOperation(); //�������ɵļӷ���ʽ
		}
		else   //������Ϊ��������
		{
			return new SubstractOperation();  //�������ɵļ�����ʽ
		}

	}

	public void setBothExercise()  //�Ӽ����������
	{
		BinaryOperation exe;  //����һ��������ʽ����
		for(int i = 0;i < NUMBER;i++)  //����NUMBER����ʽ
		{
			exe = setExercise();    //������ʽ���ɷ���������ɼӼ�����ʽ
			exercise[i] ="" + exe.toString(); //����ʽ������ϰ��������
			result[i] = "" + exe.allString(); //����������ڽ�������У���ͬ
		}
	}
	
	public void getAdditionExercise()   //���ɼӷ���ʽ�⼯
	{
		AdditionOperation add = new AdditionOperation();
		for(int i = 0;i < NUMBER;i++)
		{
			add.randomOperator('+');
			exercise[i] ="" + add.toString();
			result[i] = "" + add.allString();
		}
	}
	public void getSubstractExercise()  //���ɼ�����ʽ�⼯
	{
		SubstractOperation sub = new SubstractOperation();
		for(int i = 0;i < NUMBER;i++)
		{
			sub.randomOperator('-');
			exercise[i] ="" + sub.toString();
			result[i] = "" + sub.allString();
		}
	}

	public void displayExercise(int colums)  //�����ʽ�⼯��colmsΪÿ����ʾ����ʽ��Ŀ
	{
		System.out.println("����" + NUMBER + "�������⣺");
		System.out.println("����������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������");
		for(int i = 0;i < NUMBER;i++)
		{
			System.out.print((i + 1) + ":\t" + exercise[i] + "\t\t");
			if((i + 1) % colums == 0)
			{
				System.out.println();
			}
		}
	}
	public void displayResult(int colums)  //����⼯�Ľ��
	{
		System.out.println();
		System.out.println("����������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������");
		System.out.println("��ȷ�𰸣�");
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
