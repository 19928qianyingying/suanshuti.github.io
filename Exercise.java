package v3_1;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

import v3_1.AdditionOperation;
import v3_1.Operation;
import v3_1.SubstractOperation;
public class Exercise{

	public static final int NUMBER = 10; //Ҫ���ɵ���ʽ����	
	protected String[] exercise = new String[NUMBER]; //���������ʽ���ַ�������
	protected int[] result = new int[NUMBER]; //���������ʽ������ַ�������
	protected int[] value = new int[NUMBER];
	
	String pathCSV = "f:\\exercise.csv";
	ArrayList<String[]> lstFile = new ArrayList<String[]>();
	
	public void displayExercise(int colums)  //�����ʽ�⼯��colmsΪÿ����ʾ����ʽ��Ŀ
	{
		//csv�ļ�д������������⼯ʱ��д��csv�ļ���
		try{  
			CsvWriter csvWriter = new CsvWriter(pathCSV,',',Charset.forName("gb2312"));
			String[] csvHeader = {"��Ŀ","������"};
			csvWriter.writeRecord(csvHeader);
		    System.out.println("����" + NUMBER + "�������⣬������");
		    System.out.println("����������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������");
		    for(int i = 0;i < NUMBER;i++)
	    	{
	    		System.out.print((i + 1) + ":\t" + exercise[i] + "\t\t");
	    		Scanner aValue = new Scanner(System.in);
	    		int number = aValue.nextInt();
	    		if(number == -1)
	    		{
	    	    	System.out.println("--------------------�����д�����--------------");
	    			break;
	    		}
	    		value[i] = number;
		    	String[] csvContent = {exercise[i],""+value[i]};
		    	csvWriter.writeRecord(csvContent);
	    	}
	    	csvWriter.close();
	   	}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void displayResult(int colums)  //����⼯�Ľ��
	{
		double number = 0; //������ĸ���
		double rate; //��ȷ��
		System.out.println();
		System.out.println("����������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������");
		System.out.println("��ȷ�𰸣�");
		for(int i = 0;i < NUMBER;i++)
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

	public void readExerciseCSV()  //csv�ļ��������
	{
		int col = 0 ;
		try {
			CsvReader reader = new CsvReader(pathCSV,',',Charset.forName("gb2312"));
			reader.readHeaders();
			while(reader.readRecord()){
				//System.out.println(reader.getRawRecord());
				lstFile.add(reader.getValues());				
			}			
			reader.close();
			System.out.println("����������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������");
			System.out.println("������" + lstFile.size() + "�������⣺");
			for(int row = 0 ; row < lstFile.size(); row ++ ){
				for(col=0;col<lstFile.get(row).length;col++){
				String cell = lstFile.get(row)[col];
				System.out.print(cell);
				}
				System.out.println();
			}			
			//��������
			System.out.println("�������⣺");
			for(int i = lstFile.size();i < NUMBER;i++)
			{
				System.out.print((i + 1) + ":\t" + exercise[i] + "\t\t");
	    		Scanner aValue = new Scanner(System.in);
	    		int number = aValue.nextInt();
	    		value[i] = number;
			}
		} catch (IOException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
}



