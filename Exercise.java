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

	public static final int NUMBER = 10; //ÒªÉú³ÉµÄËãÊ½ÊýÁ¿	
	protected String[] exercise = new String[NUMBER]; //´æ·ÅÉú³ÉËãÊ½µÄ×Ö·û´®Êý×é
	protected int[] result = new int[NUMBER]; //´æ·ÅÉú³ÉËãÊ½½á¹ûµÄ×Ö·û´®Êý×é
	protected int[] value = new int[NUMBER];
	
	String pathCSV = "f:\\exercise.csv";
	ArrayList<String[]> lstFile = new ArrayList<String[]>();
	
	public void displayExercise(int colums)  //Êä³öËãÊ½Ìâ¼¯£¬colmsÎªÃ¿ÐÐÏÔÊ¾µÄËãÊ½ÊýÄ¿
	{
		//csvÎÄ¼þÐ´Èë²Ù×÷£¨Éú³ÉÌâ¼¯Ê±¾ÍÐ´ÈëcsvÎÄ¼þ£©
		try{  
			CsvWriter csvWriter = new CsvWriter(pathCSV,',',Charset.forName("gb2312"));
			String[] csvHeader = {"ÌâÄ¿","¼ÆËã½á¹û"};
			csvWriter.writeRecord(csvHeader);
		    System.out.println("¹²¼Æ" + NUMBER + "µÀËãÊõÌâ£¬Çë×÷´ð£º");
		    System.out.println("¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª");
		    for(int i = 0;i < NUMBER;i++)
	    	{
	    		System.out.print((i + 1) + ":\t" + exercise[i] + "\t\t");
	    		Scanner aValue = new Scanner(System.in);
	    		int number = aValue.nextInt();
	    		if(number == -1)
	    		{
	    	    	System.out.println("--------------------ÒÑÍê³ÉÐ´Èë²Ù×÷--------------");
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
	
	public void displayResult(int colums)  //Êä³öÌâ¼¯µÄ½á¹û
	{
		double number = 0; //×ö¶ÔÌâµÄ¸öÊý
		double rate; //ÕýÈ·ÂÊ
		System.out.println();
		System.out.println("¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª");
		System.out.println("ÕýÈ·´ð°¸£º");
		for(int i = 0;i < NUMBER;i++)
		{
			System.out.print((i + 1) + ":"+ exercise[i] + result[i] + "\t\t");
			if((i + 1) % colums == 0)
			{
				System.out.println();
			}
		}
		System.out.println("¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª");
		for(int j = 0;j < result.length;j++) //¶Ô±ÈvalueÊý×éºÍÕýÈ·´ð°¸resultÊý×é
		{
			if(value[j] == result[j])
			{
				number++;
			}
			else
			{
				System.out.println("µÚ" + (j+1) + "Ìâ´ð°¸´íÎó£¡ÕýÈ·´ð°¸Îª£º" + result[j]);
			}
		} 
		rate = number / value.length * 100;  //¼ÆËãÕýÈ·ÂÊ
		System.out.println("×Ü¹²ÌâÄ¿ÊýÎª£º" + result.length + "£»´ð¶ÔÌâÊýÎª£º" + number);
		System.out.println("ÕýÈ·ÂÊÎª£º" + rate + "%");
	}

	public void readExerciseCSV()  //csvÎÄ¼þ¶ÁÈë²Ù×÷
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
			System.out.println("¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª");
			System.out.println("¹²×öÁË" + lstFile.size() + "µÀËãÊõÌâ£º");
			for(int row = 0 ; row < lstFile.size(); row ++ ){
				for(col=0;col<lstFile.get(row).length;col++){
				String cell = lstFile.get(row)[col];
				System.out.print(cell);
				}
				System.out.println();
			}			
			//¼ÌÐø×öÌâ
			System.out.println("¼ÌÐø×öÌâ£º");
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



