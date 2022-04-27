package core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

//class CalculatorTest {
//
//    Calculator testCalculator;
//    Calculator mockCalculator;
//
//    @org.junit.jupiter.api.BeforeEach
//    void setUp() {
//        testCalculator = new Calculator();
//        mockCalculator = Mockito.mock(Calculator.class);
//    }
//
//    @org.junit.jupiter.api.Test
//   public void testAddWhenInputsAreValid() {
//      //assertEquals(30, testCalculator.perform(10,20));
//    }
//
//    @Test
//    public void testPerformWhenInputsAreInvalidThenExpectIllegalStateException() {
//        Mockito.when(mockCalculator.perform(anyInt(),anyInt())).thenReturn(25);
//        assertEquals(25, mockCalculator.perform(10,20));
//        assertEquals(25, mockCalculator.perform(100,20));
//    }
//
//    @Test
//    public void testPerformWhenInputsAreInvalidThenExpectIllegalStateException1() {
//        Mockito.when(mockCalculator.perform(anyInt(),anyInt())).thenThrow(new IllegalStateException("Invalid input types"));
//        try{
//            mockCalculator.perform(20,30);
//        } catch (Exception e) {
//            assertEquals(IllegalStateException.class, e.getClass());
//            assertEquals("Invalid input types", e.getMessage());
//        }
//    }
//}
class CalculatorTest {
Calculator calculator;
//   CalculatorService calculatorService = new CalculatorService() {
//       @Override
//       public int add(int i, int j) {
//           return 0;
//       }
//   };

    CalculatorService calculatorService = mock(CalculatorService.class);
//    @Mock
//    CalculatorService calculatorService ;
//    public MockitoRule rule = MockitoJUnit.rule();

   @BeforeEach
   public void setUp()
   {
       calculator = new Calculator(calculatorService);
//       calculatorService = mock(CalculatorService.class); -> Will give a Null pointer exception here
   }
   @Test
    public void testPerformAdd()
   {
//       hard coding the service "add" which is provided by Cloud(Assumption)
//       The only thing that we have to check (Test) is perform method from Calculator class
       when(calculatorService.add(4,4)).thenReturn(8);
       assertEquals(32 , calculator.performAdd(4,4));
//      check if the .add method from CalculatorService is actually being called from
//       Calculator or is the perform method from Calculator simply returning
//       a hard-coded result
       verify(calculatorService).add(4,4);
   }

   @Test
    public void testPerformSubtract()
   {
        when(calculatorService.subtract(10,5)).thenReturn(5);
        assertEquals(5, calculator.performSubtract(10,5));
        verify(calculatorService).subtract(10, 5);
   }

   @Test
    public void testPerformDivide()
   {
        when(calculatorService.divide(10, 5)).thenReturn(2);
       assertEquals(2, calculator.performDivide(10, 5));
       verify(calculatorService).divide(10,5);
   }

   /*
    * calculator is not calling service so this test should fail
    */
   @Test
    public void testPerformMultiply()
   {
        when(calculatorService.multiply(10,5)).thenReturn(50);
       assertEquals(50, calculator.performMultiply(10, 5));
       verify(calculatorService).multiply(10,5);
   }
}