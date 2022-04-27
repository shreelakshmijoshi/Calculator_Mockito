package core;

public class Calculator
{
    CalculatorService calculatorService;
//    Every time you test Calculator class, it will be using this calculatorService
//    But we assume that CalculatorService is a cloud service and it is well tested
//    Also, while testing Calculator it will test CalculatorService too along with it which is redundant
//    To test only what is needed, we create a stub (yet-to-be-implemented) in pur application

//  create a dependency by saying you cannot create an object of Calculator
//  without creating CalculatorService interface
    public Calculator(CalculatorService calculatorService)
    {
        this.calculatorService = calculatorService;
    }

    public int performAdd(int i , int j)
    {
        return calculatorService.add(i,j) * i;
    }

    public int performSubtract(int i, int j)
    {
        return calculatorService.subtract(i, j);
    }

    public int performDivide(int i, int j)
    {
        return calculatorService.divide(i, j);
    }

    public int performMultiply(int i, int j)
    {
//        Not using the Calculator service
//        So it should fail verify method of Mockito
        return i*j;
    }
}
