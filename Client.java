package v3_1;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ExerciseFactory factory;  //����һ������
		factory = new BothFactory();  //�ӷ���ʽ���ɹ���
		Exercise exercise = factory.makeExercise();  //���������ɵ��⼯��ֵ��exercise����
		exercise.displayExercise(5); //����⼯
		exercise.readExerciseCSV();  //���ļ�����
		exercise.displayResult(5); //�����ȷ��
	}

}
