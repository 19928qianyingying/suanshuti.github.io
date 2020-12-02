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
		exe.setBothExercise(); //测试加减法混合算式生成方法
		exe.displayExercise(4);
	}

}
