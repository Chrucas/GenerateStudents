
package generatestudents;

import java.util.ArrayList;

/**
 *
 * @author breud
 */
public class GenerateStudents {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int studentCount = 10000;
        StudentList students = new StudentList(studentCount);
//        System.out.println(students);
        ArrayList a = new ArrayList();
        String s = "zzzz9";
        for (int i = 0; i < studentCount; i++) {
             int x;
            x = HashFunction.hashed(students.getStudent(i).getLdap());
            System.out.println(x);
          }
    }
    
}
