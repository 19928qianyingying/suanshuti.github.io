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

	public static final int NUMBER = 20; //Ҫ���ɵ���ʽ����	
	protected String[] exercise = new String[NUMBER]; //���������ʽ���ַ�������
	protected int[] result = new int[NUMBER]; //���������ʽ������ַ�������
	protected int[] value = new int[NUMBER];
	
	String fileExercise = "f:\\exercise.csv"; //ϰ���ļ�
	String fileValue = "f:\\value.csv";  //��ϰ�ļ�
	String fileResult = "f:\\result.csv"; //����ļ�
	ArrayList<String[]> lstFile = new ArrayList<String[]>();
	
	public void displayExercise(int colums)  //�����ʽ�⼯��colmsΪÿ����ʾ����ʽ��Ŀ
	{
		    System.out.println("����" + NUMBER + "�������⣬������");
		    System.out.println("����������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������");
		    for(int i = 0;i < NUMBER;i++)
	    	{
	    		System.out.print((i + 1) + ":\t" + exercise[i] + "\t\t");
	    		Scanner aValue = new Scanner(System.in);
	    		int number = aValue.nextInt();
	    		value[i] = number;
	    	}
	}
	
	public void displayResult(int colums)  //����⼯�Ľ��
	{
		double number = 0; //������ĸ���
		double rate; //��ȷ��
		System.out.println();
		System.out.println("����������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������");
		System.out.println("��ȷ�𰸣�");
		for(int i = 0;i < NUMBER;i++)  //�����ȷ��
		{
			System.out.print((i + 1) + ":"+ exercise[i] + result[i] + "\t\t");
			if((i + 1) % colums == 0)
			{
				System.out.println();
			}
		}
		System.out.println("����������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������");
		for(int j = 0;j < result.length;j++) //�Ա�value�������ȷ��result����
		{
			if(value[j] == result[j])
			{
				number++;
			}
			else
			{
				System.out.println("��" + (j+1) + "��𰸴�����ȷ��Ϊ��" + result[j]);
			}
		} 
		rate = number / value.length * 100;  //������ȷ��
		System.out.println("�ܹ���Ŀ��Ϊ��" + result.length + "���������Ϊ��" + number);
		System.out.println("��ȷ��Ϊ��" + rate + "%");
	}

}


