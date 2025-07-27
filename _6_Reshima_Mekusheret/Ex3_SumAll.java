package _6_Reshima_Mekusheret;
import unit4.collectionsLib.Node;
import static _6_Reshima_Mekusheret.Ex1_CreateListFromArray.createList;
import static _6_Reshima_Mekusheret.Ex2_PrintList.printListInt;


public class Ex3_SumAll {
    // считает сумму элементов листа
    public static int sumOfList(Node<Integer> head) {
        int sum = 0;
        Node<Integer> current = head;
        while (current != null) {
            sum += current.getValue();
            current = current.getNext();
        }
        return sum;
    }


    public static void main(String[] args) {
        Node<Integer> rm = createList(new int[]{5, 5, 15, 5, 5, 25}); // Example list
        System.out.println("Sum of list elements: " + sumOfList(rm)); // 60
        printListInt(rm);
    }





}