package Task_01;

public class B_05_02 {
	 public static void main(String[] args) {
	        String input = "5abcde";  // приклад введеного рядка

	        System.out.println("Умова A: " + checkConditionA(input));
	        System.out.println("Умова B: " + checkConditionB(input));
	        System.out.println("Умова C: " + checkConditionC(input));
	    }

	    // Умова A: рядок починається з ненульової цифри, за якою йде відповідна кількість літер
	    public static boolean checkConditionA(String str) {
	        if (str.length() == 0 || !Character.isDigit(str.charAt(0)) || str.charAt(0) == '0') {
	            return false;  // Перша цифра має бути ненульовою цифрою
	        }

	        int firstDigit = Character.getNumericValue(str.charAt(0));
	        String lettersPart = str.substring(1);

	        // Перевіряємо, чи всі символи після цифри є літерами, і чи їх кількість відповідає першій цифрі
	        if (lettersPart.length() == firstDigit && lettersPart.matches("[a-zA-Z]+")) {
	            return true;
	        }
	        return false;
	    }

	    // Умова B: у рядку одна цифра і її значення дорівнює довжині рядка
	    public static boolean checkConditionB(String str) {
	        int digitCount = 0;
	        int digitValue = -1;

	        // Перевіряємо, скільки цифр є в рядку і запам'ятовуємо її значення
	        for (char ch : str.toCharArray()) {
	            if (Character.isDigit(ch)) {
	                digitCount++;
	                digitValue = Character.getNumericValue(ch);
	            }
	        }

	        // Якщо є рівно одна цифра і вона дорівнює довжині рядка
	        return digitCount == 1 && digitValue == str.length();
	    }

	    // Умова C: сума всіх цифр у рядку дорівнює довжині рядка
	    public static boolean checkConditionC(String str) {
	        int sumOfDigits = 0;

	        // Рахуємо суму всіх цифр
	        for (char ch : str.toCharArray()) {
	            if (Character.isDigit(ch)) {
	                sumOfDigits += Character.getNumericValue(ch);
	            }
	        }

	        return sumOfDigits == str.length();
	    }
	}


