package _6_Reshima_Mekusheret;
import unit4.collectionsLib.Node;

import static _6_Reshima_Mekusheret.baza.createList;
import static _6_Reshima_Mekusheret.baza.printList;

// в решима мекушерет надо каждые 3 узла проверить и оставить только максимальный из нх
public class Ex16_3maximum {
    public static Node<Integer> reorgList(Node<Integer> head){

        Node<Integer> current = head;

        if (head == null || !head.hasNext()) return head;
        int count=3;
        int maxValue;

        while (!head.getNext().hasNext() || !head.hasNext()){
            maxValue = current.getValue();
            for (int i = 0; i<3; i++){
                maxValue = Math.max(head.getValue(), head.getNext().getValue());
                current = current.getNext();
            }
            head.setValue(maxValue);
        }
        return head;
    }


        public static void main(String[] args){
            Node<Integer> head = createList(new int[]{22, 21, 14, 13, 8, 4, 6, 7, 9});
            printList(head);


        }
    }



