import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void add() {
        System.out.println("Add method");
    }

    @Test
    void testCase1(){
        System.out.println("Test Case 1");
        int actual = Calculator.add(2,3);
        assertEquals(5, actual, "Test Failed");
    }

    @Test
    void testCase2(){
//        System.out.println("Test Case 2");
        fail("Not implemented yet.");
    }

    @Test
    void testCase3(){
        System.out.println("Test Case 3");
        assertEquals("add", Calculator.Operator);
        assertTrue(Calculator.Operator.equals("add"));
    }

    @Test
    void testCase4(){
        System.out.println("Test Case 4");
        assertArrayEquals(new int[]{1,2,3}, new int[]{1,2,3}, "Arrays are not the same" );
    }

    @Test
    void testCase5(){
        System.out.println("Test Case 5");
        String nullString = null;
        String notNullString = "Cydeo";

        assertNull(nullString);
        assertNotNull(notNullString);

    }

}