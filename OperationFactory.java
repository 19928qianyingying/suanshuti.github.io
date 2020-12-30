package v4_1;

import java.util.Random;

abstract class OperationFactory {  //��ʽ����
	Operation op = new Operation();
	Random random = new Random(); 
	public void randomOperator(char anoperator) //��������
	{
		int left,right;
		int value;
		left = (int)random.nextInt(op.UPPER + 1); //��������������ŵ�������ֵ	
		do
		{
			right = (int)random.nextInt(op.UPPER + 1);
			value = caculate(left, right);
		}while(!checkOperation(left, right)); //�����������ʽ��Χ����������right�����¼���value

		op.left_operator = left;  
		op.right_operator = right;
		op.operator = anoperator;
		op.result = value;
	}
	public abstract boolean checkOperation(int leftCheck,int rightCheck); //�����ʽ��Χ
	public abstract int caculate(int left,int right); //������ʽ���
	
	public Operation display()
	{
		return op;
	}
}

class AdditionOperation extends OperationFactory{  //���ɼӷ���ʽ������
	public AdditionOperation() 
	{
		 randomOperator('+');
	}
	@Override
	public boolean checkOperation(int leftCheck,int rightCheck)
	{
		return leftCheck+ rightCheck <= op.UPPER;
	}

	@Override
	public int caculate(int left,int right) 
	{		
		return left + right;
	}
}

class SubstractOperation extends  OperationFactory{  //���ɼ�����ʽ������
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




