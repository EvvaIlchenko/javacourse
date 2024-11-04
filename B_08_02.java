package Task_01;

import java.util.Stack;

public class B_08_02 {

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            // Додаємо відкриту дужку у стек
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
            // Перевіряємо закриту дужку
            else if (ch == ')' || ch == '}' || ch == ']') {
                // Якщо стек порожній, то немає відповідної відкритої дужки
                if (stack.isEmpty()) {
                    return false;
                }
                // Витягуємо верхній елемент зі стеку
                char top = stack.pop();

                // Перевіряємо, чи є верхній елемент парою для поточної закритої дужки
                if ((ch == ')' && top != '(') ||
                    (ch == '}' && top != '{') ||
                    (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }

        // Якщо стек порожній, то всі дужки розставлені правильно
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "({[]})";

        if (isValid(s)) {
            System.out.println("Розстановка дужок правильна.");
        } else {
            System.out.println("Розстановка дужок неправильна.");
        }
    }
}
