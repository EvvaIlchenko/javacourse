package Task_01;

import java.util.PriorityQueue;

class Point {
    int x;
    int y;

    // Конструктор для створення точки
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int distanceFromOrigin() {
        return x * x + y * y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}

public class B_08_04 {
    public static void main(String[] args) {
        Point[] points = { 
            new Point(1, 2), 
            new Point(3, 4), 
            new Point(0, 1), 
            new Point(2, 2), 
            new Point(-1, -1) 
        };

        // Створюємо PriorityQueue з компаратором для сортування за відстанню
        PriorityQueue<Point> pq = new PriorityQueue<>(
            (p1, p2) -> Integer.compare(p1.distanceFromOrigin(), p2.distanceFromOrigin())
        );

        // Додаємо всі точки у чергу
        for (Point point : points) {
            pq.add(point);
        }

        // Виводимо точки у порядку зростання їх відстаней до початку координат
        System.out.println("Points sorted by distance from origin:");
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }
}

