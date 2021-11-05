
public class Student {
	
	private String name;
	private String id;
	// ������� ����� Course
	// � �������� myCourse ������ �� '������' �� ����������� Course
	private Course myCourse;

	// ���� set �� ������ ��� ���� ����� �� ������, ���� �� ������ ��� ��� ������ ����� �������� �����
	public void setCourse(Course aCourse){

		myCourse = aCourse;
		// ������� ��� ���� �� ����������� ��� ���������
		aCourse.enrollStudent(this);
	}
	
	public Student(String aName, String someId){
		name = aName;
		id = someId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}
	
	public void printInfo(){
		
		System.out.println("Name: " + name);
		System.out.println("Id: " + id);
		System.out.println("--------------------");
		System.out.println("Is enrolled in ");
		if(myCourse!= null){
			System.out.println("Course: " + myCourse.getName());
		    System.out.println("ECTS: " + myCourse.getECTS());
		}
		else
			System.out.println("No course selected");
		}
	
}
