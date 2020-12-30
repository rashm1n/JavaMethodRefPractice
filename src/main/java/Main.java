import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // creating an array
        List<Integer> numList = Arrays.asList(1,2,3,4,5);

        // if we are not using method references
        numList.stream().map(item -> Multiply.doCalc(item)).forEach(item -> System.out.println(item));

        // if we are using method references
        numList.stream().map(Multiply::doCalc).forEach(System.out::println);

        // can be used to implement functional interfaces as well
        // trying without method references
        DumbCalculator dumbCalculatorLegacy = new DumbCalculator() {
            @Override
            public int add(int parameter1, int parameter2) {
                return parameter1+parameter2;
            }
        };

        // trying with lambda expressions
        DumbCalculator dumbCalculatorLambda = (param1, param2) -> param1+param2;

        // trying with method references
        /** since the CalculatorProvide Class's addTwo method already accepts two ints and return one int, we can give
            that method as the method reference to implement the DumbCalculator Interface.
         **/
        DumbCalculator dumbCalculatorMethRef = CalculatorProvider::addTwo;


        System.out.println(dumbCalculatorMethRef.add(1,1000));
    }
}
