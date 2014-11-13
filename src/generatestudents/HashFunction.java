/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generatestudents;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author gebak_000
 */
public class HashFunction {
    StudentList list;
    Student[]array;
    static int collisions;
    
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
         k = 7 * k + si[i];
    }
    k = k%10000;    
    return k;
    }
    
    public static void doubleHashing(Student[] list, Student[]array){
        System.out.println(list.length);
        for (int i = 0; i < list.length-1; i++) {

            Student newElement = list[i];
             int arrayIndex = hashed(newElement.getLdap());
             int stepDistance = 5-hashed(newElement.getLdap())%5;
             
             while(array[arrayIndex]!=null){
                collisions++;
                arrayIndex+=stepDistance;
                arrayIndex%=array.length;
            }
             System.out.println("Modulus index = "+arrayIndex+" for "+newElement.getLdap()+" from "+ i);
             array[arrayIndex]=newElement;
        }
        System.out.println(collisions);
    } 
   
    public static void linearProbing(Student[] list, Student[]array){
        System.out.println(list.length);
        for (int i = 0; i < list.length-1; i++) {

            Student newElement = list[i];
             int arrayIndex = hashed(newElement.getLdap());
             
             
             while(array[arrayIndex]!=null){
                ++arrayIndex;
                arrayIndex%=array.length;
            }
             System.out.println("Modulus index = "+arrayIndex+" for "+newElement.getLdap()+" from "+ i);
             array[arrayIndex]=newElement;
        }    
    }
    
    public static void seperateChaining(Student[] Slist, ArrayList<ArrayList<Student>> chainingList){
 
        for (int i = 0; i < Slist.length-1; i++) {
            Student newElement = Slist[i];
             int arrayIndex = hashed(newElement.getLdap());
             
             if(chainingList.get(arrayIndex)!=null){
                 ArrayList newList = chainingList.get(arrayIndex);
                 newList.add(newElement);
                 chainingList.set(arrayIndex, newList);
                collisions++;
             }
             else{
             
             ArrayList newList = new ArrayList();
             newList.add(newElement);
             chainingList.set(arrayIndex, newList);
             }
             System.out.println("Modulus index = "+arrayIndex+" for "+newElement.getLdap()+" from "+ i);
             
        }
        System.out.println(collisions);
    }
    
}
