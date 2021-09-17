public class Calculator {

    public Calculator() {

    }

    public int splitInput(String input) {
        int num1;
        int num2;
        String operator;

        int plusEnd = input.indexOf('+');
        int subtractEnd = input.indexOf('-');
        int multiplyEnd = input.indexOf('*');
        int divideEnd = input.indexOf('/');
        int square = input.indexOf('^');
        int root = input.indexOf('#');

        if (plusEnd != -1) {
            num1 = Integer.parseInt(input.substring(0, plusEnd));
            operator = "+";
            num2 = Integer.parseInt(input.substring(plusEnd+1));
        }
        else if (subtractEnd != -1) {
            num1 = Integer.parseInt(input.substring(0, subtractEnd));
            operator = "-";
            num2 = Integer.parseInt(input.substring(subtractEnd+1));
        }
        else if (multiplyEnd != -1) {
            num1 = Integer.parseInt(input.substring(0, multiplyEnd));
            operator = "*";
            num2 = Integer.parseInt(input.substring(multiplyEnd+1));
        }
        else if (divideEnd != -1) {
            num1 = Integer.parseInt(input.substring(0, divideEnd));
            operator = "/";
            num2 = Integer.parseInt(input.substring(divideEnd+1));
        }
        else if (square != -1) {
            num1 = Integer.parseInt(input.substring(0, square));
            operator = "^";
            num2 = 0;
        }
        else if (root != -1) {
            num1 = Integer.parseInt(input.substring(0, root));
            operator = "#";
            num2 = 0;
        }
        else {
            num1 = 0;
            operator = null;
            num2 = 0;
        }

        return operate(num1, operator, num2);
    }

    public int operate(int num1, String operator, int num2) {
        int result = 0 ;
        int num1Deci = quatToDeci(String.valueOf(num1));
        int num2Deci = quatToDeci(String.valueOf(num2));

        switch(operator){
            case "+" :
                result = num1Deci + num2Deci;
                break;
            case "-":
                result = num1Deci - num2Deci;
                break;
            case "*":
                result = num1Deci * num2Deci;
                break;
            case "/":
                result = num1Deci / num2Deci;
                break;
            case "^":
                result = square(String.valueOf(num1));
                break;
            case "#":
                result = squareRoot(String.valueOf(num1));
                break;
            default:
                System.out.println("Invalid operation");
        }
        String resultString = deciToQuat(result);
        int returnResult;
        if (resultString.equals(""))
            returnResult = 0;
        else
            returnResult = Integer.parseInt(resultString);
        System.out.println(returnResult);
        return returnResult;

    }

    public int quatToDeci(String num){
        int result = 0;
        for (int i = 0; i < num.length(); i++){
            result += Character.getNumericValue(num.charAt(i)) * Math.pow(4,num.length()-i-1);
        }

        return result;
    }

    public String deciToQuat(int num) {
        String result = "";
        while(num != 0) {
            int remainder;
            remainder = num % 4;
            num = num / 4;

            result = remainder + result;
        }

        return result;
    }
    
    public int square(String num){
        int nums = quatToDeci(num);
        int result = nums * nums ;
        result = Integer.parseInt(deciToQuat(result));
        return result ;
    }

    public int squareRoot(String num){
        int nums = quatToDeci(num);
        int result = (int) Math.sqrt(nums);
        result = Integer.parseInt(deciToQuat(result));
        return result ;
    }
}
