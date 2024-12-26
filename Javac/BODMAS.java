import java.util.*;

public class EnhancedExpressionEvaluator {
    /**
     * Evaluates a mathematical expression following BEDMAS rules
     * (Brackets, Exponents, Division, Multiplication, Addition, Subtraction)
     * 
     * @param expression The mathematical expression as a string
     * @return The result of the evaluation
     */
    public static double evaluate(String expression) {
        // Remove all spaces from the expression
        expression = expression.replaceAll("\\s+", "");
        
        // Process brackets first
        while (expression.contains("(")) {
            int openBracket = expression.lastIndexOf("(");
            int closeBracket = expression.indexOf(")", openBracket);
            
            if (closeBracket == -1) {
                throw new IllegalArgumentException("Mismatched brackets");
            }
            
            String subExpression = expression.substring(openBracket + 1, closeBracket);
            double result = evaluateWithoutBrackets(subExpression);
            
            expression = expression.substring(0, openBracket) + 
                        result + 
                        expression.substring(closeBracket + 1);
        }
        
        return evaluateWithoutBrackets(expression);
    }
    
    /**
     * Evaluates an expression without brackets following EDMAS rules.
     */
    private static double evaluateWithoutBrackets(String expression) {
        // Handle negative numbers at the start
        if (expression.startsWith("-")) {
            expression = "0" + expression;
        }
        
        // Split into numbers and operators while preserving negative signs
        List<String> tokens = tokenize(expression);
        
        // Process exponents first (right to left)
        for (int i = tokens.size() - 2; i >= 1; i -= 2) {
            String operator = tokens.get(i);
            if (operator.equals("^")) {
                double base = Double.parseDouble(tokens.get(i - 1));
                double exponent = Double.parseDouble(tokens.get(i + 1));
                double result = Math.pow(base, exponent);
                
                tokens.set(i - 1, String.valueOf(result));
                tokens.remove(i + 1);
                tokens.remove(i);
            }
        }
        
        // Process multiplication and division (left to right)
        for (int i = 1; i < tokens.size() - 1; i += 2) {
            String operator = tokens.get(i);
            if (operator.equals("*") || operator.equals("/")) {
                double num1 = Double.parseDouble(tokens.get(i - 1));
                double num2 = Double.parseDouble(tokens.get(i + 1));
                double result;
                
                if (operator.equals("*")) {
                    result = num1 * num2;
                } else {
                    if (num2 == 0) {
                        throw new ArithmeticException("Division by zero");
                    }
                    result = num1 / num2;
                }
                
                tokens.set(i - 1, String.valueOf(result));
                tokens.remove(i + 1);
                tokens.remove(i);
                i -= 2;
            }
        }
        
        // Process addition and subtraction
        double result = Double.parseDouble(tokens.get(0));
        for (int i = 1; i < tokens.size() - 1; i += 2) {
            String operator = tokens.get(i);
            double num = Double.parseDouble(tokens.get(i + 1));
            
            if (operator.equals("+")) {
                result += num;
            } else if (operator.equals("-")) {
                result -= num;
            }
        }
        
        return result;
    }
    
    /**
     * Splits the expression into tokens (numbers and operators)
     * while preserving negative signs.
     */
    private static List<String> tokenize(String expression) {
        List<String> tokens = new ArrayList<>();
        StringBuilder currentNumber = new StringBuilder();
        
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            
            if (Character.isDigit(c) || c == '.') {
                currentNumber.append(c);
            } else if (c == '-' && (i == 0 || 
                     "+-*/^(".contains(String.valueOf(expression.charAt(i-1))))) {
                // Handle negative numbers
                currentNumber.append(c);
            } else if ("+-*/^".contains(String.valueOf(c))) {
                if (currentNumber.length() > 0) {
                    tokens.add(currentNumber.toString());
                    currentNumber.setLength(0);
                }
                tokens.add(String.valueOf(c));
            }
        }
        
        if (currentNumber.length() > 0) {
            tokens.add(currentNumber.toString());
        }
        
        return tokens;
    }

    /**
     * Validates the expression for basic syntax errors
     */
    private static void validateExpression(String expression) {
        // Check for invalid characters
        if (!expression.matches("[0-9+\\-*/^()\\s.]+")) {
            throw new IllegalArgumentException("Expression contains invalid characters");
        }
        
        // Check for consecutive operators
        if (expression.matches(".*[+\\-*/^][+*/^].*")) {
            throw new IllegalArgumentException("Invalid operator sequence");
        }
        
        // Check bracket matching
        int bracketCount = 0;
        for (char c : expression.toCharArray()) {
            if (c == '(') bracketCount++;
            if (c == ')') bracketCount--;
            if (bracketCount < 0) {
                throw new IllegalArgumentException("Mismatched brackets");
            }
        }
        if (bracketCount != 0) {
            throw new IllegalArgumentException("Mismatched brackets");
        }
    }

    /**
     * Main method to demonstrate the enhanced expression evaluator
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.println("Enhanced Expression Evaluator (with exponents)");
            System.out.println("Operators: +, -, *, /, ^ (exponent)");
            System.out.println("Enter 'exit' to quit");
            System.out.println("\nExample expressions:");
            System.out.println("2^3 = 8");
            System.out.println("2 + 3^2 = 11");
            System.out.println("(2 + 3)^2 = 25");
            
            while (true) {
                System.out.print("\nExpression: ");
                String input = scanner.nextLine().trim();
                
                if (input.equalsIgnoreCase("exit")) {
                    break;
                }
                
                if (input.isEmpty()) {
                    continue;
                }
                
                try {
                    validateExpression(input);
                    double result = evaluate(input);
                    System.out.printf("Result: %.4f%n", result);
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
            
        } finally {
            scanner.close();
        }
    }
}