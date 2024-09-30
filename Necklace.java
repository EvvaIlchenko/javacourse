package project_02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Necklace {
	private ArrayList<Stones> stones;

    public Necklace() {
        stones = new ArrayList<>();
    }
 // Додаємо камінь до намиста
    public void addStone(Stones stone) {
        stones.add(stone);
    }
    
 // Підрахунок загальної ваги каменів у намисті
    public double getTotalWeight() {
        double totalWeight = 0;
        for (Stones stone : stones) {
            totalWeight += stone.getWeight();
        }
        return totalWeight;
    }
    
 // Підрахунок загальної вартості намиста
    public double getTotalCost() {
        double totalCost = 0;
        for (Stones stone : stones) {
            totalCost += stone.getPrice();
        }
        return totalCost;
    }
    
 // Сортування каменів за вартістю
    public void sortByValue() {
        Collections.sort(stones, new Comparator<Stones>() {
            @Override
            public int compare(Stones s1, Stones s2) {
                return Double.compare(s2.getPrice(), s1.getPrice());
            }
        });
    }
    
 // Пошук каменів за діапазоном прозорості
    public ArrayList<Stones> findStonesByTransparency(double minTransparency, double maxTransparency) {
        ArrayList<Stones> result = new ArrayList<>();
        for (Stones stone : stones) {
            if (stone.getTransparency() >= minTransparency && stone.getTransparency() <= maxTransparency) {
                result.add(stone);
            }
        }
        return result;
    }
    
 // Виведення списку каменів у намисті
    public void displayStones() {
        for (Stones stone : stones) {
            System.out.println(stone);
        }
    }


}
