package v1_1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class OperationTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testMain() {	//测试加法算式子类
		BinaryOperation add ;
		add = new AdditionOperation();
		System.out.println(add.toString());
		System.out.println(add.allString());
	}
	@Test
	public void testMain2() {   //测试减法算式子类
		BinaryOperation sub;
		sub = new SubstractOperation();
		System.out.println(sub.toString());
		System.out.println(sub.allString());
	}

}
