package org.example.test;

import java.io.File;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public AppTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(AppTest.class);
	}

	/**
	 * Rigourous Test :-)
	 */
	public void testApp() {
		String classPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
		String filePath = Thread.currentThread().getContextClassLoader().getResource("").getFile();

		System.out.println(classPath);
		System.out.println(filePath);

		filePath = "/d:/webapp%20-%2002";

		if (filePath.indexOf("%20") >= 0) {
			filePath = filePath.replace("%20", " ");
		}

		File file = new File(filePath);
		System.out.println(file.exists());
		System.out.println(file);
	}
}
