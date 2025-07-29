package Exercices_OOP.Mivhan.M_2021A.S8_IntList;
import unit4.collectionsLib.Node;

public class IntList {
    private Node<Integer> head;
    public IntList(){
        head=null;
    }
    public void add(int a){
        // Новый узел со значением "int a" становится новым `head` (первым элементом)
        head = new Node<Integer> (a, head);
    }
    public String toString(){
        String s = "{";
        Node<Integer> h = head;
        while(h.getNext()!= null){
            s += h.getValue()+",";
            h = h.getNext();
        }
        return s + h.getValue()+"}";
    }

    public boolean what1 (IntList list) {
        // роверит, что начало второго списка будет идентично первому.
        Node<Integer> h1 = head;
        Node<Integer> h2 = list.head;
        while ((h1 != null) && (h2 != null)) {
            if (h1.getValue()!= h2.getValue())
                return false;
            h1 = h1.getNext();
            h2 = h2.getNext();
        }
        return true;
    }

    public boolean what2 (IntList list) {
        // классическая проверка на **подмножество** (subset)
        Node<Integer> h1 = head;
        while (h1 != null) {
            boolean found = false;
            Node<Integer> h2 = list.head;

            while ((h2 != null) && (!found)) {
                if (h1.getValue()== h2.getValue())
                    found = true;
                h2 = h2.getNext();
            }

            if (!found) return false;
            h1 = h1.getNext();
        }
        return true;
    }


    public static void main(String[] args){
        IntList testList = new IntList();
        testList.add(2); testList.add(3); testList.add(6);
        testList.add(1); testList.add(4);
        System.out.println(testList); // 4 1 6 3 2


    }
}
