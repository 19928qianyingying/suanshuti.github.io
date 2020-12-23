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

	public static final int NUMBER = 5; //要生成的算式数量	
	protected String[] exercise = new String[NUMBER]; //存放生成算式的字符串数组
	protected int[] result = new int[NUMBER]; //存放生成算式结果的字符串数组
	protected int[] value = new int[NUMBER];
	
	String fileExercise = "f:\\exercise.csv"; //习题文件
	String fileValue = "f:\\value.csv";  //练习文件
	String fileResult = "f:\\result.csv"; //结果文件
	ArrayList<String[]> lstFile = new ArrayList<String[]>();
	
	public void displayExercise(int colums)  //输出算式题集，colms为每行显示的算式数目
	{
		//csv文件写入操作
		try{ //习题文件的写入
			CsvWriter csvWriter = new CsvWriter(fileExercise,',',Charset.forName("gb2312"));
			String[] csvHeader = {"题目"};
			csvWriter.writeRecord(csvHeader);
			for(int i = 0;i < NUMBER;i++)
		    {
    	    	String[] csvContent = {exercise[i]};
	        	csvWriter.writeRecord(csvContent);
		    }
        	csvWriter.close();
       	}
		catch(IOException e){
	    	e.printStackTrace();
    	}
		try{  //练习文件的写入
			CsvWriter csvWriter = new CsvWriter(fileValue,',',Charset.forName("gb2312"));
			String[] csvHeader = {"题目","计算结果"};
			csvWriter.writeRecord(csvHeader);
		    System.out.println("共计" + NUMBER + "道算术题，请作答：");
		    System.out.println("—————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————");
		    for(int i = 0;i < NUMBER;i++)
	    	{
	    		System.out.print((i + 1) + ":\t" + exercise[i] + "\t\t");
	    		Scanner aValue = new Scanner(System.in);
	    		int number = aValue.nextInt();
	    		if(number == -1)
	    		{
	    	    	System.out.println("--------------------已完成写入操作--------------");
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
	
	public void displayResult(int colums)  //输出题集的结果
	{
		double number = 0; //做对题的个数
		double rate; //正确率
		System.out.println();
		System.out.println("—————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————");
		System.out.println("正确答案：");
		try{  //批改文件的写入
			CsvWriter csvWriter = new CsvWriter(fileResult,',',Charset.forName("gb2312"));
			String[] csvHeader = {"题目","计算结果","正确答案","得分"};
			csvWriter.writeRecord(csvHeader);
			for(int i = 0;i < NUMBER;i++)
		    {
				String[] judge = new String[NUMBER];
				if(value[i] == result[i])
				{
					judge[i] = "right";
				}
				else
				{
					judge[i] = "fault";
				}
    	    	String[] csvContent = {exercise[i],""+value[i],""+result[i],""+judge[i]};
	        	csvWriter.writeRecord(csvContent);
		    }
        	csvWriter.close();
       	}
		catch(IOException e){
	    	e.printStackTrace();
    	}
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

	public void readExerciseCSV()  //csv文件读入操作
	{
		int col = 0 ;
		try { //读入练习文件继续作答
			CsvReader reader = new CsvReader(fileValue,',',Charset.forName("gb2312"));
			reader.readHeaders();
			while(reader.readRecord()){
				//System.out.println(reader.getRawRecord());
				lstFile.add(reader.getValues());				
			}			
			reader.close();
			System.out.println("—————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————");
			System.out.println("共做了" + lstFile.size() + "道算术题：");
			for(int row = 0 ; row < lstFile.size(); row ++ ){
				for(col=0;col<lstFile.get(row).length;col++){
				String cell = lstFile.get(row)[col];
				System.out.print(cell);
				}
				System.out.println();
			}			
			//继续做题
			System.out.println("继续做题：");
			try{  //重写练习文件
				CsvWriter csvWriter = new CsvWriter(fileValue,',',Charset.forName("gb2312"));
				String[] csvHeader = {"题目","计算结果"};
				csvWriter.writeRecord(csvHeader);
			    for(int i = 0;i < lstFile.size();i++)
		    	{
			    	String[] csvContent = {exercise[i],""+value[i]};
			    	csvWriter.writeRecord(csvContent);
		    	}
				for(int i = lstFile.size();i < NUMBER;i++)
			    {

					System.out.print((i + 1) + ":\t" + exercise[i] + "\t\t");
		    		Scanner aValue = new Scanner(System.in);
		    		int number = aValue.nextInt();
		    		value[i] = number;
	    	    	String[] csvContent = {exercise[i],""+value[i]};
		        	csvWriter.writeRecord(csvContent);
			    }
	        	csvWriter.close();
	       	}
			catch(IOException e){
		    	e.printStackTrace();
	    	}
		} catch (IOException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
}



