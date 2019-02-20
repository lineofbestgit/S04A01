import static org.junit.Assert.*;

import java.io.*;
import java.util.*;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 *  Test class for SortComparison.java
 *
 *  @author
 *  @version HT 2019
 */
@RunWith(JUnit4.class)
public class SortComparisonTest
{
	
	public void SortComparisonTest() {
		
	}
    //~ Constructor ........................................................
    @Test
    public void testConstructor()
    {
        new SortComparison();
    	
    }

    //~ Public Methods ........................................................

    /*
     * Testing for normal array10 
     * 
     *
     */
    
    @Test
    public void test10() {
    	SortComparison sorter = new SortComparison();
      
        a = SortComparison.insertionSort(a);

        assertTrue(Arrays.equals(aSorted, a));
    }
    
    // ----------------------------------------------------------
    /**
     * Check that the methods work for empty arrays
     */
    @Test
    public void testEmpty()
    {
    	
    }

    // ----------------------------------------------------------
    /**
     *  Main Method.
     *  Use this main method to create the experiments needed to answer the experimental performance questions of this assignment.
     *
     */
    public static void main(String[] args)
   
    {
    	
    	SortComparisonTest tester = new SortComparisonTest();
    	
    	double[] a = new double[10];
    	double[] aSorted = new double[10];
    	int i = 0;
    	
    	Scanner inputScanner = null;

    	File file = new File("assignment input data files/numbers10.txt");
    	File fileSorted = new File("src/assignment input data files/numbers10sorted.txt");
    	
        try {
			inputScanner = new Scanner(file);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        while(inputScanner.hasNextDouble())
        {
         a[i] = inputScanner.nextDouble();
         i++;
        }
        
        try {
			inputScanner = new Scanner(fileSorted);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        i=0;
        while(inputScanner.hasNextDouble())
        {
         aSorted[i] = inputScanner.nextDouble();
         i++;
        }
        
        tester.test10(a, aSorted);    	
    }

}

