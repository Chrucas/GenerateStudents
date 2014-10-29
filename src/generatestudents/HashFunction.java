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
    
    public static void quadraticProbing(Student[] list, Student[]array){
        System.out.println(list.length);
        for (int i = 0; i < list.length-1; i++) {

            Student newElement = list[i];
             int arrayIndex = hashed(newElement.getLdap())%97;
             
             
             while(array[arrayIndex]!=null){
                arrayIndex=arrayIndex*4;
                arrayIndex%=array.length;
            }
             System.out.println("Modulus index = "+arrayIndex+" for "+newElement.getLdap());
             array[arrayIndex]=newElement;
        }
    } 
   
    public static void linearProbing(Student[] list, Student[]array){
        System.out.println(list.length);
        for (int i = 0; i < list.length-1; i++) {

            Student newElement = list[i];
             int arrayIndex = hashed(newElement.getLdap())%97;
             
             
             while(array[arrayIndex]!=null){
                ++arrayIndex;
                arrayIndex%=array.length;
            }
             System.out.println("Modulus index = "+arrayIndex+" for "+newElement.getLdap()+" from "+ i);
             array[arrayIndex]=newElement;
        }    
    }  
}
