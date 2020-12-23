package v3_1;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ExerciseFactory factory;  //创建一个工厂
		factory = new BothFactory();  //加法算式生成工厂
		Exercise exercise = factory.makeExercise();  //将工厂生成的题集赋值给exercise对象
		exercise.displayExercise(5); //输出题集
		exercise.readExerciseCSV();  //读文件操作
		exercise.displayResult(5); //输出正确答案
	}

}
