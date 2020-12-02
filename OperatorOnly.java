package v1_0;

import java.util.Random;

public class OperatorOnly {
	public static final int UPPER = 100;
	private int left_operator;  //�����ֵ
	private int right_operator;  //�ұ���ֵ
	private char operator;  //��������
	private int result;  //��ʽ���
	Random random = new Random(); 
	public void randomOperator() //��������
	{
		
		left_operator = (int)random.nextInt(UPPER + 1); //��������������ŵ�������ֵ
		right_operator = (int)random.nextInt(UPPER + 1);

	}
	public void setOperators()  //�����������ż���ʽ
	{

		int get_operator;  //�����������
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
		construct(left_operator, operator, right_operator);  
	}
	public int construct(int left,char op,int right) //������ʽ���
	{
		left_operator = left;
		right_operator = right;
		operator = op;
		if(operator == '+')  //������Ϊ+ʱ
		{
			checkOperator(); //�����ʽ����Ƿ���100����
			result = left_operator + right_operator;
		}
		else if(operator == '-')  //������Ϊ-ʱ
		{
			checkOperator(); //�����ʽ����Ƿ����0
			result = left_operator - right_operator;
		}
		return result;
	}
	public void checkOperator() //��������ɵ���ʽ�Ƿ��ڹ涨��Χ��
	{
		//������ɵ���ʽ�Ƿ����Ҫ��100���ڼӼ�����
		if(operator == '+')  //������Ϊ+ʱ������֮�Ͳ��ܴ���100
		{
			if(left_operator + right_operator > UPPER) //�������֮�ʹ���100������������������ֱ������֮��С�ڵ���100
			{
				do {
					randomOperator();
				}while(left_operator+ right_operator > UPPER);
			}
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
	public String toString()
	{
		return "��Ŀ�ǣ�" +left_operator + operator + right_operator + "=" + result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OperatorOnly anoperator = new OperatorOnly();
		anoperator.setOperators();
		System.out.println(anoperator.toString());
	}

}
