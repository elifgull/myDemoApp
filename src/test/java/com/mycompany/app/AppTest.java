package com.mycompany.app;
import java.util.Arrays;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
   
    
     public void testUnit1() {
      int[] array = {1,2,3,4};
       int[] array2 = {1,2,3,4};
      assertTrue(new App().func(array,array2,1,2,3));
    }

    public void testUnit2() {
      int[] array = {1,2,3,4};
       int[] array2 = {1,2,3,4};
      assertFalse(new App().func(array,array2,8,9,10));
}
    public void testUnit3() {
     int[] array = new int[5];
      int[] array2 =new int[5];
      assertFalse(new App().func(array,array2,1,2,3));
    }

    public void testUnit4() {
    int[] array = {1,2,3,4};
      int[] array2 = {9,8,0,-1};
    
      assertFalse(new App().func(array,array2,1,2,3));
    }
    
     public void testUnit5() {
      int[] array = {6,7,8,9};
      int[] array2 = {5,6,7,8};
      assertTrue(new App().func(array,array2,6,7,8));
    }
    
    

}
