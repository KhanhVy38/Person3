
package Person3;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Teacher extends Person3{
    private String department;
    private String teachingSubject;

    public Teacher() {
        super();
    }

    public Teacher(String department, String teachingSubject, String id, String fullName, Date dateOfBirth) {
        super(id, fullName, dateOfBirth);
        this.department = department;
        this.teachingSubject = teachingSubject;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getTeachingSubject() {
        return teachingSubject;
    }

    public void setTeachingSubject(String teachingSubject) {
        this.teachingSubject = teachingSubject;
    }
    
    public void addTeacher(){};
    
    public void updateTeacher(){};
    
    public void inputInfo(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter id: ");
        id = sc.nextLine();
        System.out.println("Enter full name: ");
        fullName = sc.nextLine();
        System.out.println("Enter department: ");
        department = sc.nextLine();
        System.out.println("Enter teachingSubject");
        teachingSubject = sc.nextLine();
        System.out.println("date of birth: ");
        String dateOfBirthString = sc.nextLine();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            dateOfBirth = sdf.parse(dateOfBirthString);
        } catch (Exception e) {
            System.out.println("Wrong fomat!");
        }
    }
    
    public void displayInfo(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("id: "+id);
        System.out.println("full name: "+fullName);
        System.out.println("date of birth: "+sdf.format(dateOfBirth));
        System.out.println("department: "+department);
        System.out.println("teachingSubject: "+teachingSubject);
    }
}
