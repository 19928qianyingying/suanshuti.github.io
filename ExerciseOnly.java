package v1_0;

public class ExerciseOnly{
	public static final int NUMBER = 50; //要生成的算式数量
	private int[][] operators = new int[NUMBER][2]; //存放左右数值
	private char[] exercise = new char[NUMBER];  //存放算术符号 
	private int[] result = new int[NUMBER];  //存放习题集的算式结果
	Operator anoperator = new Operator(); //一个算式
	public void setExercise() //生成题集
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
	public void checkDuplicate()  //检查生成算式是否重复
	{
		for(int i = 0,j = 0;i < operators.length; i++)
		{
			for(int k = i + 1;k <operators.length; k++)
			{
				//当运算符号相等时，检查符号两边值是否重复，重复则重新生成
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
	public void printExercise() //输出题集
	{
		System.out.println("共计" + NUMBER + "道算术题：");
		System.out.println("—————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————");
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
	public void printResult()  //输出答案
	{
		System.out.println("—————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————————");
		System.out.println("正确答案：");
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
