public class Calculator {
    public static float calculate(float firstOperand, char operator, float secondOperand) throws ArithmeticException{
        float result = 0;
        switch (operator){
            case '+' :
                result = firstOperand + secondOperand;
                break;
            case '-' :
                result = firstOperand - secondOperand;
                break;
            case '*' :
                result = firstOperand * secondOperand;
                break;
            case '/' :
                if (secondOperand == 0){
                    throw new ArithmeticException();
                }
                result = firstOperand / secondOperand;
                break;
        }
        return result;
    }
}
