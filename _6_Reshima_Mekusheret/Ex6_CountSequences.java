package _6_Reshima_Mekusheret;
import unit4.collectionsLib.Node;
import static _6_Reshima_Mekusheret.Ex1_CreateListFromArray.createList;
import static _6_Reshima_Mekusheret.Ex2_PrintList.printListInt;


// Подсчет количества последовательностей заданного числа.
public class Ex6_CountSequences {
    public static void main(String[] args) {
        Node<Integer> list = createList(new int[]{2, 7, 5, 3, 2, 2, 1, 1, 2, 2}); // Example list
        printListInt(list);
        int number = 2; // Target number
        System.out.println("Number of sequences of " + number + ": " + countSequences(list, number));
    }

    public static int countSequences(Node<Integer> head, int target) {
        if (head == null) return 0; // Empty list
        int count = 0;
        boolean inSequence = false; // Flag to track the current sequence
        Node<Integer> current = head;
        while (current != null) {
            if (current.getValue() == target) {
                if (!inSequence) {
                    count++; // New sequence found
                    inSequence = true;
                }
            } else {
                inSequence = false; // End of the current sequence
            }
            current = current.getNext();
        }
        return count;
    }
}
