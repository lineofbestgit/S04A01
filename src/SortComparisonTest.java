import static org.junit.Assert.assertEquals;

import java.io.*;
import java.util.Scanner;

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
    	
    	
    }
    
    // ----------------------------------------------------------
    /**
     * Check that the methods work for empty arrays
     */
    @Test
    public void testEmpty()
    {
    }


    // TODO: add more tests here. Each line of code and ech decision in Collinear.java should
    // be executed at least once from at least one test.

    // ----------------------------------------------------------
    /**
     *  Main Method.
     *  Use this main method to create the experiments needed to answer the experimental performance questions of this assignment.
     *
     */
    public static void main(String[] args)
    {
        //TODO: implement this method
    	
    	Scanner inputScanner;
    	
    	File file = new File("/sortingAlgs/src/sortingAlgs/S04A01/assignment input data files/numbers10.txt");
    	try {
            inputScanner = new Scanner(file);

            while(inputScanner.hasNextDouble())
            {
                System.out.println( inputScanner.nextDouble() );
            }

        } catch (FileNotFoundException e1) {
                e1.printStackTrace();
        }
    }

}

