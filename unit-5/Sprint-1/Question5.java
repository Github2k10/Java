package day1;

@FunctionalInterface
interface StudentService{
		public void printStudentDetails(Student student);
}


public class Question5 {
	
	static void show(Student student) {
		System.out.println(student.toString());
	}
	
	void fun(Student student) {
		System.out.println(student.toString());
	}
	
	public Question5() {}
	
	public Question5(Student student) {
		System.out.println(student.toString());
	}
	
	public static void main(String args[]) {
		StudentService service = Question5::show;
		Question5 question4 = new Question5();
		
		StudentService service2 = question4::fun;
		
		StudentService service3 = Question5::new;
		
		service.printStudentDetails(new Student(1, "abc", 500));
		
		service2.printStudentDetails(new Student(1, "abc", 500));
		
		service3.printStudentDetails(new Student(1, "abc", 500));
		
	}
}
