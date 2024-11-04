package Task_01;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class B_08_03 {
    // Кожна вершина асоціюється з множиною суміжних вершин
    private HashMap<Integer, Set<Integer>> adjList;

    public B_08_03() {
        adjList = new HashMap<>();
    }

    // Додавання вершини
    public void addVertex(int vertex) {
        adjList.putIfAbsent(vertex, new HashSet<>());
    }

    // Видалення вершини
    public void removeVertex(int vertex) {
        // Спочатку видаляємо вершину зі списку суміжності інших вершин
        if (adjList.containsKey(vertex)) {
            for (Integer adjacent : adjList.get(vertex)) {
                adjList.get(adjacent).remove(vertex);
            }
            // Потім видаляємо саму вершину
            adjList.remove(vertex);
        }
    }

    // Додавання ребра між двома вершинами
    public void addEdge(int vertex1, int vertex2) {
        // Додаємо вершини в граф, якщо вони ще не існують
        adjList.putIfAbsent(vertex1, new HashSet<>());
        adjList.putIfAbsent(vertex2, new HashSet<>());
        
        // Додаємо ребро з обох сторін, оскільки граф неорієнтований
        adjList.get(vertex1).add(vertex2);
        adjList.get(vertex2).add(vertex1);
    }

    // Видалення ребра між двома вершинами
    public void removeEdge(int vertex1, int vertex2) {
        Set<Integer> neighbors1 = adjList.get(vertex1);
        Set<Integer> neighbors2 = adjList.get(vertex2);

        if (neighbors1 != null) {
            neighbors1.remove(vertex2);
        }
        if (neighbors2 != null) {
            neighbors2.remove(vertex1);
        }
    }

    // Метод для друку графа
    public void printGraph() {
        for (Integer vertex : adjList.keySet()) {
            System.out.print(vertex + ": ");
            for (Integer neighbor : adjList.get(vertex)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    // Метод для перевірки наявності вершини
    public boolean hasVertex(int vertex) {
        return adjList.containsKey(vertex);
    }

    // Метод для перевірки наявності ребра між вершинами
    public boolean hasEdge(int vertex1, int vertex2) {
        return adjList.containsKey(vertex1) && adjList.get(vertex1).contains(vertex2);
    }
    
        public static void main(String[] args) {
            B_08_03 graph = new B_08_03();

            graph.addVertex(1);
            graph.addVertex(2);
            graph.addVertex(3);
            graph.addVertex(4);

            graph.addEdge(1, 2);
            graph.addEdge(2, 3);
            graph.addEdge(3, 4);
            graph.addEdge(4, 1);

            System.out.println("Graph adjacency list:");
            graph.printGraph();

            System.out.println("\nRemoving edge between 1 and 2");
            graph.removeEdge(1, 2);
            graph.printGraph();

            System.out.println("\nRemoving vertex 3");
            graph.removeVertex(3);
            graph.printGraph();
        }
}

