package org.tpg.models;

import static org.junit.Assert.*;

import org.junit.Test;

public class StudentTest {
	private static final int DELTA = 0;

	@Test
	public void testCreate_UsingConstructor() throws Exception {
		int id = 1;
		String name = "Alec";
		double gpa = 3.5;
		Student student = new Student(id, name, gpa);
		
		assertEquals(id, student.getId());
		assertEquals(name, student.getName());
		assertEquals(gpa, student.getGpa(), DELTA);
	}
	
	@Test
	public void testToString() throws Exception {
		Student student = new Student(1, "Alec", 4);
		
		assertEquals("1 Alec", student.toString());
	}
}
