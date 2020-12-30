package v4_1;

import java.util.Random;

import v4_1.Exercise;

abstract class ExerciseFactory{ //习题工厂，用来产生习题集
	
	public Exercise exe = new Exercise() ; //定义一个习题集
	public abstract Exercise makeExercise(); //抽象方法，生成习题集

}

class AdditionFactory extends ExerciseFactory{  //全为加法习题集的子类
	@Override
	public Exercise makeExercise()  
	{	
		for(int i = 0;i < exe.NUMBER;i++)
		{
			OperationFactory factory = new AdditionOperation();		
			Operation add ;
			add = factory.display();
			exe.exercise[i] ="" + add.toString(); //将算式写入习题集
			exe.result[i] = add.allString(); //将算式结果写入习题集
		}
		return exe;
	}	
}

class SubstractFactory extends ExerciseFactory{  //全为减法习题集的子类
	@Override
	public Exercise makeExercise() 
	{
		for(int i = 0;i < exe.NUMBER;i++)
		{
			OperationFactory factory = new SubstractOperation();		
			Operation sub ;
			sub = factory.display();
			exe.exercise[i] ="" + sub.toString();
			exe.result[i] = sub.allString();
		}
		return exe;
	}
}


class BothFactory extends ExerciseFactory{  //生成随机题集的子类

	@Override
	public Exercise makeExercise()
	{
		for(int i = 0;i < exe.NUMBER;i++)  //生成NUMBER个算式
		{
			OperationFactory factory;		
			Operation both ;
			both = setExercise();    //调用算式生成方法随机生成加减法算式
			exe.exercise[i] ="" + both.toString(); //将算式储存在习题数组中
			exe.result[i] = both.allString(); //将结果储存在结果数组中，下同
		}
		return exe;
	}
	public Operation setExercise() 
	{
		int get_operator;
		Random random = new Random();
		get_operator = (int)random.nextInt(2); //随机生成算数符号
		if(get_operator == 1)	//当随机生成的数字为1时，定义为加法运算
		{ 
			OperationFactory factory = new AdditionOperation();
			Operation op = factory.display();
			return op;  //返回生成的加法算式
		}
		else   //否则定义为减法运算
		{
			OperationFactory factory = new SubstractOperation();
			Operation op = factory.display();
			return op;   //返回生成的减法算式
		}
	}
}