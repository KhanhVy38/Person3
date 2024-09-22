
package Person3;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;


public class PersonList {
   private ArrayList<Person3> personList;
   
   public PersonList(){
       this.personList = new ArrayList<>();
   }
   
   public void addStudent(Student student){
       personList.add(student);
   }
   
   public void addTeacher(Teacher teacher){
       personList.add(teacher);
   }
   
   public void updatePerson(String updateperson) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter student id to update: ");
        String id = sc.nextLine();
        for (int i = 0; i < personList.size(); i++) {
            if (personList.get(i).getId().equals(id)) {
                System.out.println("update information:");
                Person3 updatedStudent = personList.get(i);

                System.out.print("Enter full name: ");
                updatedStudent.setFullName(sc.nextLine());

                System.out.print("Enter date of birth: ");
                String dobStr = sc.nextLine();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    updatedStudent.setDateOfBirth(sdf.parse(dobStr));
                } catch (Exception e) {
                    System.out.println("Wrong Format!");
                }

                personList.set(i, updatedStudent);
            }
        }
    }
   
   // Delete person by ID
    public void deletePersonById(String id) {
        personList.removeIf(person -> person.getId().equals(id));
    }

    // Find person by ID
    public Person3 findPersonById(String id) {
        for (Person3 person : personList) {
            if (person.getId().equals(id)) {
                return person;
            }
        }
        return null;
    }

    public void displayAll() {
    System.out.println("all student anh teacher:");

        for (Person3 person : personList) {
            if (person instanceof Student) {
                System.out.println("Student");
            } else if (person instanceof Teacher) {
                System.out.println("Teacher:");
            }
            person.displayInfo();  // Gọi phương thức hiển thị thông tin
            System.out.println("----------------------------");
        }
    }

    // Find the student with the highest GPA
    public Student findTopStudent() {
        Student topStudent = null;
        for (Person3 person : personList) {
            if (person instanceof Student) {
                Student student = (Student) person;
                if (topStudent == null || student.getGpa() > topStudent.getGpa()) {
                    topStudent = student;
                }
            }
        }
        return topStudent;
    }

    // Find a teacher by department
    public Teacher findTeacherByDepartment(String department) {
        for (Person3 person : personList) {
            if (person instanceof Teacher) {
                Teacher teacher = (Teacher) person;
                if (teacher.getDepartment().equals(department)) {
                    return teacher;
                }
            }
        }
        return null;
    }
}
