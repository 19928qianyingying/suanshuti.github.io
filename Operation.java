package v4_1;

import java.util.Random;

public class Operation { //��ʽ��
	static final int UPPER = 100;  
	protected int left_operator = 0;  //��ʽ������
	protected int right_operator = 0;
	protected char operator = '+';
	protected int result = 0;  //��ʽ��� 
	
	public String toString()  //������Ŀ
	{
		return "" + left_operator + operator + right_operator + "=";
	}
	
	public int allString()  //������Ŀ�ͽ��
	{
		return result;
	}
}

