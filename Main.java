package project_02;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
        Necklace necklace = new Necklace();

        // Створюємо дорогоцінні та напівдорогоцінні камені
        Stones diamond = new PreciousStone("Diamond", 2.5, 0.9, 5000);
        Stones ruby = new PreciousStone("Ruby", 3.0, 0.85, 3000);
        Stones emerald = new PreciousStone("Emerald", 1.8, 0.8, 4000);
        Stones amethyst = new SemiPreciousStone("Amethyst", 5.0, 0.7, 500);
        Stones topaz = new SemiPreciousStone("Topaz", 4.2, 0.6, 700);

        // Додаємо камені до намиста
        necklace.addStone(diamond);
        necklace.addStone(ruby);
        necklace.addStone(emerald);
        necklace.addStone(amethyst);
        necklace.addStone(topaz);
        
     // Підрахунок загальної ваги і вартості
        System.out.println("Загальна вага намиста: " + necklace.getTotalWeight() + "  карат ");
        System.out.println("Загальна вартість намиста:   " + necklace.getTotalCost() + "  доларів ");

        // Сортування каменів за вартістю
        System.out.println("\nСортування каменів за вартістю:");
        necklace.sortByValue();
        necklace.displayStones();

        // Пошук каменів за діапазоном прозорості
        System.out.println("\nКамені з прозорістю від 0.7 до 0.9:");
        ArrayList<Stones> filteredStones = necklace.findStonesByTransparency(0.7, 0.9);
        for (Stones stone : filteredStones) {
            System.out.println(stone);
        }
    }

}

