public class Solution {
    private final int MIN = -100000;
    
    private boolean isOperator(String token){
        if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/"))
           return true;
        return false;
    }
    
    private int plus(int a, int b){
        return a+b;
    }
    
    private int minus(int a, int b){
        return a-b;
    }
    
    private int times(int a, int b){
        return a*b;
    }
    
    private int devide(int a, int b){
        return a/b;
    }
    
    private int oper(int a, int b, String token){
        if (token.equals("+")){
            return plus(a,b);
        }else if (token.equals("-")){
            return minus(a,b);
        }else if (token.equals("*")){
            return times(a,b);
        }else if (token.equals("/")){
            return devide(a,b);
        }else{
            return 0;
        }
    }
    
    public int evalRPN(String[] tokens) {
        int value;
        int[] stack = new int[tokens.length];
        int tail = -1;
        for (int i = 0; i < tokens.length; i ++){
            if (isOperator(tokens[i])){
                value = stack[tail--];
                value = oper(stack[tail--], value, tokens[i]);
                stack[++tail] = value;
            }else{
                int num = Integer.parseInt(tokens[i]);
                stack[++tail] = num;
            }
        }
        return stack[tail];
    }
}
