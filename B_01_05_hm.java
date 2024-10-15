package Task_01;

public class B_01_05_hm {
	public static void main(String[] args) {
        String input = "Текст (який потрібно) відредагувати";
        
        try {
            String result = removeBrackets(input);
            System.out.println("Результат: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Помилка: " + e.getMessage());
        }
	}
	// Метод для видалення груп символів між дужками
    public static String removeBrackets(String str) throws IllegalArgumentException {
        // Перевіряємо правильність дужок
        if (!areBracketsValid(str)) {
            throw new IllegalArgumentException("Дужки розставлено неправильно.");
        }

        // Видаляємо всі символи між дужками разом з дужками
        StringBuilder result = new StringBuilder();
        boolean insideBrackets = false;

        for (char ch : str.toCharArray()) {
            if (ch == '(') {
                insideBrackets = true;
            } else if (ch == ')') {
                insideBrackets = false;
            } else if (!insideBrackets) {
                result.append(ch);
            }
        }

        return result.toString();
    }

    // Метод для перевірки правильності дужок
    private static boolean areBracketsValid(String str) {
        int openBrackets = 0;
        boolean insideBrackets = false;

        for (char ch : str.toCharArray()) {
            if (ch == '(') {
                if (insideBrackets) {
                    return false; // Якщо є вкладені дужки
                }
                insideBrackets = true;
                openBrackets++;
            } else if (ch == ')') {
                if (!insideBrackets) {
                    return false; // Закриваюча дужка без відкриваючої
                }
                insideBrackets = false;
                openBrackets--;
            }
        }

        return openBrackets == 0; // Перевіряємо, чи всі дужки закриті
    }
}



