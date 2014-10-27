
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
        Student[]array = new Student[studentCount];
//        for (int i = 0; i < studentCount; i++) {
//             int x;
//             x = HashFunction.hashed(students.getStudent(i).getLdap())%97;
//             arr[i] = x;
//          }
//        for (int i = 0; i < studentCount; i++) {
//             System.out.println(arr[i]);
//        }
        HashFunction hashFunction = new HashFunction(students, array);
        
    }
    
}
