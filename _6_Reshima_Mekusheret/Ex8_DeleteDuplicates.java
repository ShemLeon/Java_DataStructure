package _6_Reshima_Mekusheret;
import unit4.collectionsLib.Node;
import static _6_Reshima_Mekusheret.Ex1_CreateListFromArray.createList;
import static _6_Reshima_Mekusheret.Ex2_PrintList.printListDouble;


public class Ex8_DeleteDuplicates {
    // удаляет дубликаты из списка
    // Complexity: O(n^2),
    public static Node<Double> removeDuplicates(Node<Double> head) {
        if (head == null) return null; // Empty list
        Node<Double> current = head;
        while (current != null) {
            Node<Double> runner = current; // For checking all subsequent elements
            while (runner.getNext() != null) {
                if (runner.getNext().getValue().equals(current.getValue())) {
                    // Remove duplicate
                    runner.setNext(runner.getNext().getNext());
                } else {
                    runner = runner.getNext();
                }
            }
            current = current.getNext();
        }

        return head; // Return the list without duplicates
    }

    public static void main(String[] args) {
        Node<Double> list = createList(new double[]{1.2, 3.5, 4.5, 3.5, 6.7, 1.2, 4.0, 4.0});
        // Example list with duplicates
        System.out.println("Original list:");
        printListDouble(list);

        Node<Double> uniqueList = removeDuplicates(list);
        System.out.println("List without duplicates:");
        printListDouble(uniqueList);
    }




}
