package _6_Reshima_Mekusheret;

import unit4.collectionsLib.Node;

import static _6_Reshima_Mekusheret.Ex1_CreateListFromArray.createList;

// Проверка наличия заданного числа в списке

public class Ex7_CheckNumberInList {
    public static boolean containsNumber(Node<Double> head, double target) {
        Node<Double> current = head;
        while (current != null) {
            if (current.getValue() == target) return true; // Number found
            current = current.getNext();
        }
        return false; // Number not found
    }


    public static void main(String[] args) {
        Node<Double> list = createList(new double[]{1.2, 3.5, 4.0, 6.7}); // Example list
        double number = 4.0; // Target number
        System.out.println("Number " + number + " found in list: " + containsNumber(list, number));

        number = 5.5;
        System.out.println("Number " + number + " found in list: " + containsNumber(list, number));
    }





}
