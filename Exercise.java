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

	public static final int NUMBER = 10; //勣伏撹議麻塀方楚	
	protected String[] exercise = new String[NUMBER]; //贋慧伏撹麻塀議忖憲堪方怏
	protected int[] result = new int[NUMBER]; //贋慧伏撹麻塀潤惚議忖憲堪方怏
	protected int[] value = new int[NUMBER];
	
	String pathCSV = "f:\\exercise.csv";
	ArrayList<String[]> lstFile = new ArrayList<String[]>();
	
	public void displayExercise(int colums)  //補竃麻塀籾鹿��colms葎耽佩�塋承痛稱淑�朕
	{
		//csv猟周亟秘荷恬��伏撹籾鹿扮祥亟秘csv猟周��
		try{  
			CsvWriter csvWriter = new CsvWriter(pathCSV,',',Charset.forName("gb2312"));
			String[] csvHeader = {"籾朕","柴麻潤惚"};
			csvWriter.writeRecord(csvHeader);
		    System.out.println("慌柴" + NUMBER + "祇麻宝籾��萩恬基��");
		    System.out.println("！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！");
		    for(int i = 0;i < NUMBER;i++)
	    	{
	    		System.out.print((i + 1) + ":\t" + exercise[i] + "\t\t");
	    		Scanner aValue = new Scanner(System.in);
	    		int number = aValue.nextInt();
	    		if(number == -1)
	    		{
	    	    	System.out.println("--------------------厮頼撹亟秘荷恬--------------");
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
	
	public void displayResult(int colums)  //補竃籾鹿議潤惚
	{
		double number = 0; //恂斤籾議倖方
		double rate; //屎鳩楕
		System.out.println();
		System.out.println("！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！");
		System.out.println("屎鳩基宛��");
		for(int i = 0;i < NUMBER;i++)
		{
			System.out.print((i + 1) + ":"+ exercise[i] + result[i] + "\t\t");
			if((i + 1) % colums == 0)
			{
				System.out.println();
			}
		}
		System.out.println("！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！");
		for(int j = 0;j < result.length;j++) //斤曳value方怏才屎鳩基宛result方怏
		{
			if(value[j] == result[j])
			{
				number++;
			}
			else
			{
				System.out.println("及" + (j+1) + "籾基宛危列�》�鳩基宛葎��" + result[j]);
			}
		} 
		rate = number / value.length * 100;  //柴麻屎鳩楕
		System.out.println("悳慌籾朕方葎��" + result.length + "�惨雍毀睚�葎��" + number);
		System.out.println("屎鳩楕葎��" + rate + "%");
	}

	public void readExerciseCSV()  //csv猟周響秘荷恬
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
			System.out.println("！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！");
			System.out.println("慌恂阻" + lstFile.size() + "祇麻宝籾��");
			for(int row = 0 ; row < lstFile.size(); row ++ ){
				for(col=0;col<lstFile.get(row).length;col++){
				String cell = lstFile.get(row)[col];
				System.out.print(cell);
				}
				System.out.println();
			}			
			//写偬恂籾
			System.out.println("写偬恂籾��");
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



