package _6_Reshima_Mekusheret;

import unit4.collectionsLib.Node;

import static _6_Reshima_Mekusheret.Ex1_CreateListFromArray.createList;
import static _6_Reshima_Mekusheret.Ex2_PrintList.printListInt;

public class baza {
    /*
    Basic methods and techniques for "Linked List" / "רשימה מקושרת"
    -- Node<Integer> head = null;
    -- current.getValue() -     get the value of the current node
    -- current.getNext()  -     get the value of the next node
    -- current.setNext(new Node<>(value)) - set the value of the next node
    -- current = current.getNext();   -- Move to the next node
    -- current.hasNext() -- boolean
    1 - create a list from array:   public static Node<Integer> createList(int[] values) { return head }
    2 - print the list:      public static void printList(Node<Integer> head){}


    */

    public static void main(String[] args) {

        Node<Integer> firstNode = new Node<>(5);
        System.out.println("f="+firstNode.getValue());
        Node<Integer> head = null;
    //  System.out.println(head.getValue()); - вызовет ошибку

        head  = new Node<>(10);
        System.out.println("h: " + head.getValue()); // 10
        head=new Node<>(firstNode.getValue());
        System.out.println("h: " + head.getValue()); // 5
        firstNode.setValue(130);
        System.out.println("h: " + head.getValue()); // 5
        head  = firstNode;
        System.out.println("h: " + head.getValue()); // 130
        firstNode.setValue(500);
        System.out.println("h: " + head.getValue()); // 500

        System.out.println("f= " + firstNode); //500
        System.out.println("f= " + firstNode+firstNode); //500500

        head.setNext(firstNode);
        System.out.println("h.getNext().getValue()=" + head.getNext().getValue());

        head.setNext(new Node<>(5));
        System.out.println("проверка след.: h.getNext().getValue()=" + head.getNext().getValue()); // 5
        head.getNext().setNext(new Node<>(99));
        System.out.println("проверка: h.getNext().getValue()=" + head.getNext().getNext().getValue()); // 99

        Node<Integer> c = new Node<>(7, firstNode);
        System.out.println(c); // 7
        System.out.println(c.getNext());  // 500
        System.out.println(c.toString());
        System.out.println(c.hasNext());
        Node<Integer> list = createList(new int[]{90, 5, 15, 5, 5, 25}); // Example list
        printListInt(list);
    }}


