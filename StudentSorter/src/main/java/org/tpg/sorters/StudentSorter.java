package org.tpg.sorters;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.tpg.models.Student;

public class StudentSorter {

	private Comparator<Student> studentComparator = new Comparator<Student>() {
		@Override
		public int compare(Student student1, Student student2) {
			int c = compareByGpa(student1, student2);
			if (c == 0) {
				c = compareByName(student1, student2);
			}
			if (c == 0) {
				c = compareById(student1, student2);
			}
			return c;
		}
	};
	
	public List<Student> sort(List<Student> students) {
		if (students == null) {
			return null;
		} else {
			List<Student> myStudents = students;
			Collections.sort(myStudents, studentComparator);
			return myStudents;
		}
	}

	private int compareByGpa(Student student1, Student student2) {
		double delta = student1.getGpa() - student2.getGpa();
		if(delta > 0.01) return -1;
		if(delta < -0.01) return 1;
		return 0;
	}
	
	private int compareByName(Student student1, Student student2) {
		return student1.getName().compareTo(student2.getName());
	}
	
	private int compareById(Student student1, Student student2) {
		return Long.compare(student1.getId(), student2.getId());
	}

}
