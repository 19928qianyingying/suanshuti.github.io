package v1_0;

import java.util.Random;

class Operator{
	private int left_operator;  //�����ֵ
	private int right_operator;  //�ұ���ֵ
	private int get_operator;  //�����������
	private char operator;  //��������
	private int result;  //��ʽ���
	Random random = new Random(); 
	public void randomOperator() //��������
	{
		left_operator = (int)random.nextInt(101); //��������������ŵ�������ֵ
		right_operator = (int)random.nextInt(101);
	}
	public void setOperators()  //�����������ż���ʽ
	{
		randomOperator(); 
		get_operator = (int)random.nextInt(2); //���������������
		if(get_operator == 1)	
		{
			operator = '+';
		}
		else
		{
			operator = '-';
		}
		checkOperator();  //�����ʽ
	}
	public void checkOperator() //��������ɵ���ʽ�Ƿ��ڹ涨��Χ��
	{
		//������ɵ���ʽ�Ƿ����Ҫ��100���ڼӼ�����
		if(operator == '+')  //������Ϊ+ʱ������֮�Ͳ��ܴ���100
		{
			if(left_operator + right_operator > 100) //�������֮�ʹ���100������������������ֱ������֮��С�ڵ���100
			{
				do {
					randomOperator();
				}while(left_operator+ right_operator > 100);
			}
			result = left_operator + right_operator;
		}
		else if(operator == '-')  //������Ϊ-ʱ������֮���С����
		{
			if(left_operator < right_operator ) //�������֮��С���㣬����������������ֱ������֮����ڵ�����
			{
				do
				{
					randomOperator();
				}while(left_operator < right_operator);
			}
			result = left_operator - right_operator;
		}
	}
	public char getOperator()  //�����������
	{
		return operator;
	}
	public int getLeftOperator()   //��������ֵ
	{
		return left_operator;
	}
	public int getRightOperator()  //����ұ���ֵ
	{
		return right_operator;
	}
	public int getResult()  //�����ʽ���
	{
		return result;
	}
}

class Exercise{
	private int number = 50; //Ҫ���ɵ���ʽ����
	private int[][] operators = new int[number][2]; //���������ֵ
	private char[] exercise = new char[number];  //����������� 
	private int[] result = new int[number];  //���ϰ�⼯����ʽ���
	Operator ex = new Operator();
	public void setExercise() //�����⼯
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
	public void checkDuplicate()  //���������ʽ�Ƿ��ظ�
	{
		for(int i = 0,j = 0;i < number; i++)
		{
			for(int k = i + 1;k <number; k++)
			{
				//������������ʱ������������ֵ�Ƿ��ظ����ظ�����������
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
	public void printExercise() //���
	{
		System.out.println("����" + number + "�������⣺");
		System.out.println("����������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������");
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
	public void printResult()  //�����
	{
		System.out.println("����������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������");
		System.out.println("��ȷ�𰸣�");
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
