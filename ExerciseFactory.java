package v4_1;

import java.util.Random;

import v4_1.Exercise;

abstract class ExerciseFactory{ //ϰ�⹤������������ϰ�⼯
	
	public Exercise exe = new Exercise() ; //����һ��ϰ�⼯
	public abstract Exercise makeExercise(); //���󷽷�������ϰ�⼯

}

class AdditionFactory extends ExerciseFactory{  //ȫΪ�ӷ�ϰ�⼯������
	@Override
	public Exercise makeExercise()  
	{	
		for(int i = 0;i < exe.NUMBER;i++)
		{
			OperationFactory factory = new AdditionOperation();		
			Operation add ;
			add = factory.display();
			exe.exercise[i] ="" + add.toString(); //����ʽд��ϰ�⼯
			exe.result[i] = add.allString(); //����ʽ���д��ϰ�⼯
		}
		return exe;
	}	
}

class SubstractFactory extends ExerciseFactory{  //ȫΪ����ϰ�⼯������
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


class BothFactory extends ExerciseFactory{  //��������⼯������

	@Override
	public Exercise makeExercise()
	{
		for(int i = 0;i < exe.NUMBER;i++)  //����NUMBER����ʽ
		{
			OperationFactory factory;		
			Operation both ;
			both = setExercise();    //������ʽ���ɷ���������ɼӼ�����ʽ
			exe.exercise[i] ="" + both.toString(); //����ʽ������ϰ��������
			exe.result[i] = both.allString(); //����������ڽ�������У���ͬ
		}
		return exe;
	}
	public Operation setExercise() 
	{
		int get_operator;
		Random random = new Random();
		get_operator = (int)random.nextInt(2); //���������������
		if(get_operator == 1)	//��������ɵ�����Ϊ1ʱ������Ϊ�ӷ�����
		{ 
			OperationFactory factory = new AdditionOperation();
			Operation op = factory.display();
			return op;  //�������ɵļӷ���ʽ
		}
		else   //������Ϊ��������
		{
			OperationFactory factory = new SubstractOperation();
			Operation op = factory.display();
			return op;   //�������ɵļ�����ʽ
		}
	}
}