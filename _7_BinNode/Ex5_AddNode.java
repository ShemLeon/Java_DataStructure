package _7_BinNode;
import unit4.collectionsLib.BinNode;

public class Ex5_AddNode {
    public static void addNode(BinNode<Integer> h, BinNode<Integer> p, int n) {
        if (h == null) {
            h = new BinNode<Integer>(n); // Создаем первый узел
        } else {
            if (p == null) { // Вставка в начало списка
                BinNode<Integer> newNode = new BinNode<Integer>(n); // Создаем новый узел
                newNode.setRight(h);      // Связываем справа с текущей головой
                h.setLeft(newNode);       // Связываем голову слева с новым узлом
                h = newNode;              // Делаем новый узел головой
            } else {
                // Создаем новый узел
                BinNode<Integer> newNode = new BinNode<Integer>(n);

                // Сохраняем ссылку на следующий узел после p
                BinNode<Integer> next = p.getRight();

                // Связываем p с новым узлом
                p.setRight(newNode);
                newNode.setLeft(p);

                // Если был следующий узел, связываем его с новым
                if (next != null) {
                    newNode.setRight(next);
                    next.setLeft(newNode);
                }
            }
        }


    }}
