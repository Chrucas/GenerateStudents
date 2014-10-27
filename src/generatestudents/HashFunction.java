/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generatestudents;

/**
 *
 * @author gebak_000
 */
public class HashFunction {
    StudentList list;
    Student[]array;
    
    public HashFunction(StudentList list,Student[]array) {
    this.list = list;
    this.array=array;
    }

    
    public static int hashed(String s){
    char ch;
    char[]ca = s.toCharArray();
    int[]si = new int[ca.length];
//    for (int i =0;i<ca.length;i++){
//         System.out.print(ca[i]);
//    }
    int x = 0;
    for (int i = 0; i < ca.length; i++) {
         ch = ca[i];
         x = Character.getNumericValue(ch);
         si[i]=x;
    }

    int k = 0;
    for (int i = 0; i < si.length; i++){
         k = 8 * k + si[i];
    }
    k = k%10000;    
    return k;
    }
    
    public void hashFunction1(StudentList list, Student[]array){
        for (int i = 0; i < list.size(); i++) {
             Student newElement = list.getStudent(i);
             int arrayIndex = hashed(list.getStudent(i).getLdap())%97;
             
             System.out.println("Modulus index = "+arrayIndex+" for value "+newElement);
             
             while(array[arrayIndex]!=null){
                ++arrayIndex;
                System.out.println("Collision, try"+arrayIndex+" instead");
                arrayIndex%=array.length;
            }
             array[arrayIndex]=newElement;
        }
        
        
    }
}
