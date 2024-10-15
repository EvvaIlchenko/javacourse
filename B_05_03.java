package Task_01;

import java.io.*;
import java.util.*;

public class B_05_03 {
	public static void main(String[] args) {
        String inputFileName = "shapes.txt";  // Ім'я файлу з даними
        String outputFileName = "result.txt";  // Ім'я файлу для результатів

        try {
            List<String> lines = readFile(inputFileName);

            // Змінні для зберігання потрібних результатів
            double maxLineLength = -1;
            String longestLine = null;

            double maxRectanglePerimeter = -1;
            String largestPerimeterRectangle = null;

            double minCircleArea = Double.MAX_VALUE;
            String smallestCircle = null;

            // Перебираємо кожен рядок з файлу
            for (String line : lines) {
                String[] tokens = line.split("\\s+");

                // Перевіряємо тип фігури за її номером
                int shapeType = Integer.parseInt(tokens[0]);

                switch (shapeType) {
                    case 1: // Відрізок (номер 1)
                        double x1 = Double.parseDouble(tokens[1]);
                        double y1 = Double.parseDouble(tokens[2]);
                        double x2 = Double.parseDouble(tokens[3]);
                        double y2 = Double.parseDouble(tokens[4]);

                        double lineLength = calculateLineLength(x1, y1, x2, y2);
                        if (lineLength > maxLineLength) {
                            maxLineLength = lineLength;
                            longestLine = line;
                        }
                        break;

                    case 2: // Прямокутник (номер 2)
                        double xTopLeft = Double.parseDouble(tokens[1]);
                        double yTopLeft = Double.parseDouble(tokens[2]);
                        double xBottomRight = Double.parseDouble(tokens[3]);
                        double yBottomRight = Double.parseDouble(tokens[4]);

                        double perimeter = calculateRectanglePerimeter(xTopLeft, yTopLeft, xBottomRight, yBottomRight);
                        if (perimeter > maxRectanglePerimeter) {
                            maxRectanglePerimeter = perimeter;
                            largestPerimeterRectangle = line;
                        }
                        break;

                    case 3: // Коло (номер 3)
                        double xCenter = Double.parseDouble(tokens[1]);
                        double yCenter = Double.parseDouble(tokens[2]);
                        double radius = Double.parseDouble(tokens[3]);

                        double area = calculateCircleArea(radius);
                        if (area < minCircleArea) {
                            minCircleArea = area;
                            smallestCircle = line;
                        }
                        break;
                }
            }

            // Записуємо результати в новий файл
            writeResults(outputFileName, longestLine, maxLineLength, largestPerimeterRectangle, maxRectanglePerimeter, smallestCircle, minCircleArea);
        } catch (IOException e) {
            System.out.println("Помилка при читанні або запису файлу: " + e.getMessage());
        }
    }

    // Метод для читання рядків із файлу
    public static List<String> readFile(String fileName) throws IOException {
        List<String> lines = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = br.readLine()) != null) {
            lines.add(line);
        }
        br.close();
        return lines;
    }

    // Метод для запису результатів у файл
    public static void writeResults(String fileName, String longestLine, double maxLineLength,
                                    String largestPerimeterRectangle, double maxRectanglePerimeter,
                                    String smallestCircle, double minCircleArea) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));

        bw.write("Найдовший відрізок: " + longestLine + " Довжина: " + maxLineLength + "\n");
        bw.write("Прямокутник з найбільшим периметром: " + largestPerimeterRectangle + " Периметр: " + maxRectanglePerimeter + "\n");
        bw.write("Коло з найменшою площею: " + smallestCircle + " Площа: " + minCircleArea + "\n");

        bw.close();
    }

    // Метод для обчислення довжини відрізка
    public static double calculateLineLength(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    // Метод для обчислення периметра прямокутника
    public static double calculateRectanglePerimeter(double xTopLeft, double yTopLeft, double xBottomRight, double yBottomRight) {
        double width = Math.abs(xBottomRight - xTopLeft);
        double height = Math.abs(yBottomRight - yTopLeft);
        return 2 * (width + height);
    }

    // Метод для обчислення площі кола
    public static double calculateCircleArea(double radius) {
        return Math.PI * radius * radius;
    }
}
