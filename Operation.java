package v1_1;

import java.util.Random;

abstract class BinaryOperation { //��ʽ������
	static final int UPPER = 100;
	private int left_operator = 0;
	private int right_operator = 0;
	char operator = '+';
	private int result = 0;  //��ʽ���
	Random random = new Random(); 
	public void randomOperator(char anoperator) //��������
	{
		int left,right;
		int value;
		left = (int)random.nextInt(UPPER + 1); //��������������ŵ�������ֵ	
		do
		{
			right = (int)random.nextInt(UPPER + 1);
			value = caculate(left, right);
		}while(!checkOperation(left, right)); //�����������ʽ��Χ����������right�����¼���value

		left_operator = left;  
		right_operator = right;
		operator = anoperator;
		result = value;

	}
	public abstract boolean checkOperation(int leftCheck,int rightCheck); //�����ʽ��Χ
	public abstract int caculate(int left,int right); //������ʽ���
	
	public String toString()  //������Ŀ
	{
		return "" + left_operator + operator + right_operator + "=";
	}
	
	public String allString()  //������Ŀ�ͽ��
	{
		return "" +left_operator + operator + right_operator + "=" + result;
	}
}

class AdditionOperation extends BinaryOperation{
	public AdditionOperation() 
	{
		 randomOperator('+');
	}
	@Override
	public boolean checkOperation(int leftCheck,int rightCheck)
	{
		return leftCheck+ rightCheck <= UPPER;
	}

	@Override
	public int caculate(int left,int right) 
	{		
		return left + right;
	}
}

class SubstractOperation extends BinaryOperation{
	public SubstractOperation() 
	{
		 randomOperator('-');
	}
	@Override
	public boolean checkOperation(int leftCheck,int rightCheck)
	{
		return leftCheck > rightCheck; 
	}

	@Override
	public int caculate(int left,int right) 
	{
		return left - right;
	}
}

public class Operation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryOperation add = new AdditionOperation();
		System.out.println(add.toString());
		System.out.println(add.allString());
		
		BinaryOperation sub;
		sub = new SubstractOperation();
		System.out.println(sub.toString());
		System.out.println(sub.allString());

	}

}
