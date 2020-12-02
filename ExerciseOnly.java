package v1_0;

public class ExerciseOnly{
	public static final int NUMBER = 50; //Ҫ���ɵ���ʽ����
	private int[][] operators = new int[NUMBER][2]; //���������ֵ
	private char[] exercise = new char[NUMBER];  //����������� 
	private int[] result = new int[NUMBER];  //���ϰ�⼯����ʽ���
	Operator anoperator = new Operator(); //һ����ʽ
	public void setExercise() //�����⼯
	{
		for(int i = 0,j = 0;i < operators.length;i++) 
		{
			anoperator.setOperators();
			operators[i][j] = anoperator.getLeftOperator();
			operators[i][j+1] = anoperator.getRightOperator();
			exercise[i] = anoperator.getOperator();
			result[i] = anoperator.getResult();
		}
	}
	public void checkDuplicate()  //���������ʽ�Ƿ��ظ�
	{
		for(int i = 0,j = 0;i < operators.length; i++)
		{
			for(int k = i + 1;k <operators.length; k++)
			{
				//������������ʱ������������ֵ�Ƿ��ظ����ظ�����������
				if(exercise[i] == exercise[k])
				{
					if(operators[i][j] == operators[k][j] && operators[i][j+1] == operators[k][j+1] || operators[i][j] == operators[k][j+1] && operators[i][j+1] == operators[k][j])
					{
						do 
						{
							anoperator.randomOperator();
							operators[k][j] = anoperator.getLeftOperator();
							operators[k][j+1] = anoperator.getRightOperator();
							result[k] = anoperator.getResult();
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
	public void printExercise() //����⼯
	{
		System.out.println("����" + NUMBER + "�������⣺");
		System.out.println("����������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������");
		for(int i = 0;i < operators.length;i++)
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
		for(int i = 0;i < operators.length;i++)
		{
			System.out.print((i + 1) + ":\t" + result[i] + "\t\t");
			if((i + 1) % 5 == 0)
			{
				System.out.println();
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExerciseOnly anexercise = new ExerciseOnly();
		anexercise.setExercise();
		anexercise.printExercise();
		anexercise.printResult();
	}

}
