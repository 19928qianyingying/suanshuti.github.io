package v1_1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ExerciseSheetTest {
	Exercise exe;

	@Before
	public void setUp() throws Exception {	  
		exe = new Exercise();
	}

	@Test
	public void testMain() {
		exe.setBothExercise(); //���ԼӼ��������ʽ���ɷ���
		exe.displayExercise(4);
	}

}
