
package Person3;

import java.util.Scanner;

public class Processor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PersonList personList = new PersonList();
        
        while (true) {
            System.out.println("1. Add a new student");
            System.out.println("2. Add a new teacher");
            System.out.println("3. Update person");
            System.out.println("4. Delete person by ID");
            System.out.println("5. Find person by ID");
            System.out.println("6. Display all students and teachers");
            System.out.println("7. Find the student with the highest GPA");
            System.out.println("8. Find a teacher by department");
            System.out.println("0. Exit");
            System.out.println("choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine();
            
            switch (choice) {
                case 1:
                    Student st = new Student();
                    st.inputInfo();
                    personList.addStudent(st);
                    break;
                    
                case 2:
                    Teacher teacher = new Teacher();
                    teacher.inputInfo();
                    personList.addTeacher(teacher);
                    break;
                    
                case 3:
                    System.out.print("Enter ID of the person to update: ");
                    String updateperson = sc.nextLine();
                    personList.updatePerson(updateperson);
                    break;
                    
                case 4:
                    System.out.print("Enter person ID to delete: ");
                    String deleteId = sc.nextLine();
                    personList.deletePersonById(deleteId);
                    break;   
                                
                case 5:
                    System.out.println("Enter find Person By Id");
                    String findid = sc.nextLine();
                    personList.findPersonById(findid);
                    break;
                    
                case 6:
                    personList.displayAll();
                    break;

                case 7:
                    Student topStudent = personList.findTopStudent();
                    if (topStudent != null) {
                        System.out.println("Student with the highest GPA: ");
                        topStudent.displayInfo();
                    } else {
                        System.out.println("No students found.");
                    }
                    break;

                case 8:
                    System.out.print("Enter department to find teacher: ");
                    String findTeach = sc.nextLine();
                    Teacher foundTeacher = personList.findTeacherByDepartment(findTeach);
                    if (foundTeacher != null) {
                        foundTeacher.displayInfo();
                    } else {
                        System.out.println("No teacher found in department " + findTeach);
                    }
                    break;
                    
                case 0:
                    System.out.println("Exiting program...");
                    sc.close();
                    return;
                    
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}
