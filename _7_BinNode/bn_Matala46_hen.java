package _7_BinNode;
import unit4.collectionsLib.BinNode;
import unit4.collectionsLib.Node;

/**
 * Program for managing a hen house
 * The hen house has M hens, each with its own ID (from 0 to M-1)
 * Each hen can lay eggs (ID and Date of laying), which are stored in a linked list
 * Operations performed in the hen house:

Initialization of the data structure - there are no eggs in the hen house. The operation should be performed with a complexity of O(M)
Adding an egg - the hen with the serial number i laid an egg with ID, weight W and laying date Date.
You need to add the egg to the structure with a complexity of O(1)
Printing the list of all eggs belonging to hen i. 
Complexity O(K), where K is the number of eggs belonging to hen i
The hen with the number i died and was removed from the hen house. 
All eggs belonging to her are transferred to hen j. The operation should be performed with a complexity of O(K), 
where K is the number of eggs of hen j
Required: a. Suggest a suitable data structure that will allow you to implement operations with the specified complexity.
Draw the structure. 
b. Implement the classes: house_Hen, Hen, Egg and all the functions defined above. 
c. Write a test program for Joseph's hen house.
  */
public class bn_Matala46_hen {
    /* Function to demonstrate the operation of the hen house
     * Complexity: O(1) for adding eggs, O(n) for printing and transferring
     * Working principle:
     * 1. Create a hen house with 3 hens
     * 2. Add eggs to different hens
     * 3. Print the state before transfer
     * 4. Transfer eggs from hen 0 to hen 1
     * 5. Print the state after transfer
     */
    public static void main(String[] args) {
        HenHouse house = new HenHouse(3);

        house.addEgg(0, 101, 55.5, "2025-02-13");
        house.addEgg(0, 102, 52.3, "2025-02-14");
        house.addEgg(1, 201, 60.2, "2025-02-15");

        System.out.println("\nState before transfer:");
        house.printEggs(0);
        house.printEggs(1);

        house.transferEggs(0, 1);

        System.out.println("\nState after transfer:");
        house.printEggs(0);
        house.printEggs(1);
    }
}

/**
 * Class to represent an egg
 * Stores a unique ID, weight and laying date
 */
class Egg {
    private int id;          // unique ID of the egg
    private double weight;   // weight of the egg in grams
    private String laidDate; // laying date

    /* Constructor for the Egg class
     * @param id       unique identifier of the egg
     * @param weight   weight of the egg in grams
     * @param laidDate laying date
     * Complexity: O(1)
     * Working principle:
     * 1. Initialize all fields of the egg with the passed values
     */
    public Egg(int id, double weight, String laidDate) {
        this.id = id;
        this.weight = weight;
        this.laidDate = laidDate;
    }

    /* Function for a string representation of the egg
     * @return a string with information about the egg
     * Complexity: O(1)
     */
    @Override
    public String toString() {
        return "Egg{" + "ID=" + id + ", weight=" + weight + "g, date=" + laidDate + '}';
    }
}

/**
 * Class to represent a hen
 * Stores the hen's ID and a linked list of its eggs
 */
class Hen {
    private int id;                  // ID of the hen
    private Node<Egg> eggsHead;     // head of the list of eggs

    /* Constructor for the Hen class
     * @param id ID of the hen
     * Working principle:
     * 1. Set the ID of the hen
     * 2. Initialize an empty list of eggs
     */
    public Hen(int id) {
        this.id = id;
        this.eggsHead = null;
    }

    /* Function to add a new egg
     * @param egg egg to add
     * Complexity: O(1) - adding to the beginning of the list
     * Working principle:
     * 1. Create a new node with the egg
     * 2. Set the next element of the current head of the list
     * 3. Make the new node the head of the list
     */
    public void layEgg(Egg egg) {
        Node<Egg> newNode = new Node<>(egg);
        newNode.setNext(eggsHead);
        eggsHead = newNode;
    }

    /* Function to print all eggs of the hen
     * Complexity: O(n), where n is the number of eggs
     * Working principle:
     * 1. Print the ID of the hen
     * 2. Go through the list of eggs
     * 3. Print information about each egg
     */
    public void printEggs() {
        System.out.println("Eggs of hen " + id + ":");
        Node<Egg> current = eggsHead;
        while (current != null) {
            System.out.println(current.getValue());
            current = current.getNext();
        }
    }

    /* Function to transfer all eggs to another hen
     * @param otherHen hen to transfer eggs to
     * Complexity: O(n), where n is the number of eggs to transfer
     * Working principle:
     * 1. Go through the list of eggs of the current hen
     * 2. Add each egg to the hen to transfer to
     * 3. Clear the list of eggs of the current hen
     */
    public void transferEggsTo(Hen otherHen) {
        Node<Egg> current = eggsHead;
        while (current != null) {
            otherHen.layEgg(current.getValue());
            current = current.getNext();
        }
        eggsHead = null;
    }
}

/**
 * Class to manage the hen house
 * Stores an array of hens of a fixed size
 */
class HenHouse {
    private Hen[] hens;     // array of hens

    /* Constructor for the hen house
     * @param hen number of places for hens
     * Complexity: O(n), where n is the number of hens
     * Working principle:
     * 1. Create an array of hens of the specified size
     * 2. Initialize each hen with a unique ID
     */
    public HenHouse(int hen) {
        hens = new Hen[hen];
        for (int i = 0; i < hen; i++) {
            hens[i] = new Hen(i);
        }
    }

    /* Function to add an egg to a hen
     * @param henId  ID of the hen
     * @param eggId  unique ID of the egg
     * @param weight weight of the egg in grams
     * @param date   laying date
     * Complexity: O(1)
     * Working principle:
     * 1. Check the correctness of the hen's ID
     * 2. Create a new egg
     * 3. Add the egg to the hen
     */
    public void addEgg(int henId, int eggId, double weight, String date) {
        if (henId >= 0 && henId < hens.length) {
            hens[henId].layEgg(new Egg(eggId, weight, date));
        }
    }

    /* Function to print all eggs of a hen
     * @param henId ID of the hen
     * Complexity: O(n), where n is the number of eggs of the hen
     * Working principle:
     * 1. Check the correctness of the hen's ID
     * 2. Call the function to print the eggs of the hen
     */
    public void printEggs(int henId) {
        if (henId >= 0 && henId < hens.length) {
            hens[henId].printEggs();
        }
    }

    /* Function to transfer all eggs from one hen to another
     * @param fromHenId ID of the hen to transfer eggs from
     * @param toHenId   ID of the hen to transfer eggs to
     * Complexity: O(n), where n is the number of eggs to transfer
     * Working principle:
     * 1. Check the correctness of the IDs of both hens
     * 2. Call the function to transfer eggs
     */
    public void transferEggs(int fromHenId, int toHenId) {
        if (fromHenId >= 0 && fromHenId < hens.length && toHenId >= 0 && toHenId < hens.length) {
            hens[fromHenId].transferEggsTo(hens[toHenId]);
        }
    }
}
