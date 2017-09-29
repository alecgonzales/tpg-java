package org.tpg.sorters;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.tpg.models.Student;

public class StudentSorterTest {
	StudentSorter studentSorter;
	
	@Before
	public void setup() throws Exception {
		studentSorter = new StudentSorter();
	}
	
	@Test
	public void testSort_WhenNull() throws Exception {
		List<Student> result = studentSorter.sort(null);
		
		assertNull(result);
	}
	
	@Test
	public void testSort_byGpa() throws Exception {
		List<Student> students = generateStudents();
		
		List<Student> result = studentSorter.sort(students);
		
		String[] expected = new String[] {"1 Louis", "85 Louis", "22 Lorry", "19 Samar", "56 Samil", "33 Tina"};
		for (int i = 0; i < result.size(); i++) {
			assertEquals(expected[i], result.get(i).toString());
		}
	}

	private List<Student> generateStudents() {
		List<Student> students = new ArrayList<Student>();
		
		students.add(new Student(33, "Tina", 3.68));
		students.add(new Student(85, "Louis", 3.85));
		students.add(new Student(56, "Samil", 3.75));
		students.add(new Student(19, "Samar", 3.75));
		students.add(new Student(22, "Lorry", 3.76));
		students.add(new Student(1, "Louis", 3.85));
		
		return students;
	}
}
