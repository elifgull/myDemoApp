package com.mycompany.app;
import java.util.Arrays;
public class App 
{
   public static boolean func(int[] array,int[] array2,int a,int b,int c){
		System.out.println("inside the method");
		boolean one=false;
		boolean two=false;
		for(int i=0;i<array.length;i++){
			if(array[i] == a || array[i] == b || array[i] == c ){
				one = true;
				break;
			}
		
			
		}
		
		for(int i=0;i<array2.length;i++){
			if(array2[i] == a || array2[i] == b || array2[i] == c ){
				two = true;
				break;
			}
		
			
		}
		
		
		
		
		return one && two;
	}
}
