package sakkesoft.com;

public class Main {

    public static void main(String[] args) {
        SimpleCalculator calculator = new SimpleCalculator();
        calculator.setFirstNumber(5.0);
        calculator.setSecondNumber(4);
        System.out.println("add = "+calculator.getAdditionResult());
        System.out.println("subtract = "+calculator.getSubtractionResult());
        calculator.setFirstNumber(5.25);
        calculator.setSecondNumber(0);
        System.out.println("multiply = "+calculator.getMultiplicationResult());
        System.out.println("divide = "+calculator.getDivisionResult());

    }
    public static class SimpleCalculator {
        private double firstNumber;
        private double secondNumber;

        public void setFirstNumber(double FirstNumber){
            this.firstNumber=FirstNumber;
            //   System.out.println(FirstNumber);

        }
        public void setSecondNumber(double SecondNumber){
            this.secondNumber=SecondNumber;
            //    System.out.println(SecondNumber);
        }
        public double getFirstNumber(){
            return this.firstNumber;
        }
        public double getSecondNumber(){
            return this.secondNumber;
        }
        public double getAdditionResult(){
            return (firstNumber+secondNumber);

        }
        public double getSubtractionResult(){
            return  (firstNumber-secondNumber);

        }
        public double getMultiplicationResult(){
            return  (firstNumber*secondNumber);

        }
        public double getDivisionResult(){
            if (secondNumber!=0){
                return  (firstNumber/secondNumber);
            }else return 0;



        }
    }
}


