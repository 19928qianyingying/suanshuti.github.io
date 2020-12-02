package v1_1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ExerciseTest {
	Exercise exe = 	new Exercise();

	@Before
	public void setUp() throws Exception {

	}

	@Test
	public void testSetExercise() {
		exe.setExercise();
	}

	@Test
	public void testSetBothExercise() {
		exe.setBothExercise();
	}

	@Test
	public void testGetAdditionExercise() {
		exe.getAdditionExercise();
	}

	@Test
	public void testGetSubstractExercise() {
		exe.getSubstractExercise();
	}
	
	@Test
	public void testMain() {
		exe.getAdditionExercise();
		exe.displayExercise(5);
//		exe.displayResult(2);
	}

}
