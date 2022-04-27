# Calculator_Mockito
Calculator application tested with the help of Mockito and JUnit 5

- CalculatorService is an interface which declares add(), subtract(), multiply() and divide() methods
- Calculator class calls the service (methods) by defining performAdd(), performSubract(), performMultiply(), performDivide() methods
- CalculatorService interface is not implemented, rather it's methods are Mocked in TestCalculator class
- Calculator class methods are tested using assertEquals to compare the results
- the test class methods also verify if the performAdd(), performSubtract(), performDivide(), performMultiply() actually call CalculatorService methods or return a hardcoded result
