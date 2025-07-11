package _6_Reshima_Mekusheret;
import unit4.collectionsLib.Node;

/* Class contains functions for working with a linked list of real numbers,
 * including checking for equality of the number of elements above and below the average value
 */
public class Ex4_Matala_29 {
    public static void main(String[] args) {
        Node<Double> list = createList(new double[]{1.5, 2.0, 3.5, 6.0, 7.5, 9.0}); // Example list
        System.out.println("Result of equality check: " + isEqualAboveBelowAverage(list));
    }

    /* Function to check for equality of the number of elements above and below the average in the list
     * @param head head node of the linked list of real numbers
     * @return true if the number of elements above the average equals the number below, otherwise false
     * Complexity: O(n) time, where n is the number of nodes (two passes through the list), O(1) memory
     * Working principle:
     * 1. First pass: calculate the sum and count of elements for the average
     * 2. Calculate the average value
     * 3. Second pass: count elements above and below the average
     * 4. Compare the counts of elements above and below the average
     */
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
    public static Node<Double> createList(double[] values) {
        Node<Double> head = null;
        Node<Double> current = null;
        for (double value : values) {
            if (head == null) {
                head = new Node<>(value);
                current = head;
            } else {
                current.setNext(new Node<>(value));
                current = current.getNext();
            }
        }
        return head;
    }
}