package v4_1;

import java.util.Random;

abstract class OperationFactory {  //算式工厂
	Operation op = new Operation();
	Random random = new Random(); 
	public void randomOperator(char anoperator) //生成算数
	{
		int left,right;
		int value;
		left = (int)random.nextInt(op.UPPER + 1); //随机生成算数符号的左右数值	
		do
		{
			right = (int)random.nextInt(op.UPPER + 1);
			value = caculate(left, right);
		}while(!checkOperation(left, right)); //如果不符合算式范围则重新生成right并重新计算value

		op.left_operator = left;  
		op.right_operator = right;
		op.operator = anoperator;
		op.result = value;
	}
	public abstract boolean checkOperation(int leftCheck,int rightCheck); //检查算式范围
	public abstract int caculate(int left,int right); //计算算式结果
	
	public Operation display()
	{
		return op;
	}
}

class AdditionOperation extends OperationFactory{  //生成加法算式的子类
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

class SubstractOperation extends  OperationFactory{  //生成减法算式的子类
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




