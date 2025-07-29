package _6_Reshima_Mekusheret;
import unit4.collectionsLib.Node;

import static _6_Reshima_Mekusheret.Ex1_CreateListFromArray.createList;

// проверка равенства количества элементов выше и ниже среднего в списке
public class Ex4_CheckAverage {
    public static void main(String[] args) {
        Node<Double> list = createList(new double[]{1.5, 2.0, 3.5, 6.0, 7.5, 9.0}); // Example list
        System.out.println("Result of equality check: " + isEqualAboveBelowAverage(list));
    }
    public static boolean isEqualAboveBelowAverage(Node<Double> head) {
        if (head == null) return false; // Empty list

        // Calculate the average value
        double sum = 0;
        int count = 0;
        Node<Double> current = head;

        while (current != null) {
            sum += current.getValue();
            count++;
            current = current.getNext();
        }

        double average = sum / count;

        // Count elements above and below the average
        int aboveCount = 0;
        int belowCount = 0;
        current = head;

        while (current != null) {
            if (current.getValue() > average) {
                aboveCount++;
            } else if (current.getValue() < average) {
                belowCount++;
            }
            current = current.getNext();
        }

        return aboveCount == belowCount;
    }

    /* Function to create a linked list from an array of real numbers
     * @param values array of real numbers to convert into a list
     * @return head node of the created linked list
     * Complexity: O(n) time, where n is the length of the array, O(n) memory
     * Working principle:
     * 1. Create the first node, if the array is not empty
     * 2. Add the remaining elements to the end of the list
     * 3. Return the head of the list
     */

}