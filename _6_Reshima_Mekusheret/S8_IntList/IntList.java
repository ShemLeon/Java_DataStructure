package _6_Reshima_Mekusheret.S8_IntList;
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

    public static void main(String[] args) {
        System.out.println("=== Тестирование класса IntList ===\n");
        // Тест 1: Создание пустого списка
        IntList list = new IntList();
        System.out.println("1. Пустой список: " + list.toString());

        // Тест 2: Добавление одного элемента
        list.add(5);
        System.out.println("2. После добавления 5: " + list.toString());

        // Тест 3: Добавление нескольких элементов
        list.add(10);
        list.add(15);
        list.add(20);
        System.out.println("3. После добавления 10, 15, 20: " + list.toString());
        System.out.println("   (элементы добавляются в начало)");




    }
}
