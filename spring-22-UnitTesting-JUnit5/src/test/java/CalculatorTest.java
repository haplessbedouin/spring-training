import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    @BeforeAll
    static void setUpAll(){
        System.out.println("Before All is executed");
    }
    @AfterAll
    static void tearDownAll(){
        System.out.println("After All is executed");
    }

    @BeforeEach
    void setUpEach(){
        System.out.println("BeforeEach is executed.");
    }
    @AfterEach
    void tearDownEach(){
        System.out.println("AfterEach is executed.");
    }

    @Test
    void add() {
        System.out.println("Add method");
    }

    @Test
    void add2() {
        System.out.println("Add2 method");
        assertThrows(IllegalArgumentException.class, () -> Calculator.add2(3,2));
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

    @Test
    void testCase6(){
        System.out.println("Test Case 6");

        Calculator c1 = new Calculator();
        Calculator c2 = c1;
        Calculator c3 = new Calculator();

        assertSame(c1, c2);
        assertNotSame(c1,c3);

    }

}