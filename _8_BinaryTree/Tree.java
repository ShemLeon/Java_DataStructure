package _8_BinaryTree;
import unit4.binTreeUtilsLib.*;
import unit4.binTreeCanvasLib.*;
import unit4.collectionsLib.*;
import unit4.collectionsLib.BinNode;

public class Tree {
    public static void main(String[] args) {
        BinNode<Integer> t1 = BinTreeUtils.buildRandomTree(10, 1, 50);

        BinTreeCanvas.addTree(t1);
        System.out.println("1. Узлов в дереве: " + countTree(t1));
        System.out.println("2. Листьев в дереве: " + countLeaves(t1));
        System.out.println("3. Правых потомков в бинарном дереве: " + countRight(t1));
        System.out.println("Узлы с двойными внуками: " + count_double_grends(t1));
        System.out.println("8. Узлы с четными значениями: " + countEvenNodes(t1));
        System.out.println("Узлы с с значениями больше X: " + countNodesGreaterThanX(t1, 5));
        System.out.println("11. Узлы со значением меньше родителя: " + countNodesLessThanParent(t1));
    }

    public static void printPre_Order(BinNode<Integer> head) {
        BinNode<Integer> tmp = head;
        if (tmp == null) return;
        System.out.println(tmp.getValue());
        printPre_Order(tmp.getLeft());
        printPre_Order(tmp.getRight());
    }

    public static void print_in_order(BinNode<Integer> head) {
        if (head == null) return;
        BinNode<Integer> tmp = head;
        print_in_order(tmp.getLeft());
        System.out.println(tmp.getValue());
        print_in_order(tmp.getRight());
    }

    public static void print_post_order(BinNode<Integer> head) {
        if (head == null) return;
        BinNode<Integer> tmp = head;
        print_post_order(tmp.getLeft());
        print_post_order(tmp.getRight());
        System.out.println(tmp.getValue());
    }

    // задание 1
    // Ф-я получает бинарное дерево, содержащее целые числа,
    // и возвращает количество узлов в дереве."

    public static int countTree(BinNode<Integer> head) {
        if (head == null) return 0;
        return countTree(head.getLeft()) + countTree(head.getRight()) + 1;
    }

    // задание 2
    // Ф-я получает бинарное дерево, содержащее целые числа,
    // и возвращает количество листьев в дереве."
    public static int countLeaves(BinNode<Integer> head) {
        if (head == null) return 0;
        if (head.getLeft() != null || head.getRight() != null)
            return countLeaves(head.getLeft()) + countLeaves(head.getRight());
        return 1;
    }

    // задание 3
    // подсчитывает количество правых потомков в бинарном дереве.
    public static int countRight(BinNode<Integer> head) {
        if (head == null) return 0;
        return (head.hasRight() ? 1 : 0) + countRight(head.getLeft()) + countRight(head.getRight());
    }

    // задание 4
    public static int countLeft_final(BinNode<Integer> head) {
        if (head == null) return 0;
        return (!head.hasRight() && head.hasLeft() ? 1 : 0) + countLeft_final(head.getLeft()) + countLeft_final(head.getRight());
    }

    // задание 5
    public static int count_final_dots(BinNode<Integer> head) {
        if (head == null) return 0;
        if (!head.hasRight() && head.hasLeft())
            return 1 + count_final_dots(head.getLeft()) + count_final_dots(head.getRight());
        return (head.hasRight() && !head.hasLeft() ? 1 : 0) + count_final_dots(head.getLeft()) + count_final_dots(head.getRight());
    }

    // задание 6
    public static int count_double_dots(BinNode<Integer> head) {
        if (head == null) return 0;
        return (head.hasRight() && head.hasLeft() ? 1 : 0) + count_double_dots(head.getLeft()) + count_double_dots(head.getRight());
    }

    // задание 7
    public static int count_double_grends(BinNode<Integer> head) {
        if (head == null) return 0;
        if(head.hasRight())
            return (head.getRight().hasRight()||head.getRight().hasLeft() ? 1:0) + count_double_grends(head.getLeft()) + count_double_grends(head.getRight());
        return ( head.hasLeft() && (head.getLeft().hasRight()||head.getLeft().hasLeft()) ? 1 : 0) + count_double_grends(head.getLeft()) + count_double_grends(head.getRight());
    }

    // задание 8
//    Возвращает количество узлов с четными значениями в дереве.
    public static int countEvenNodes(BinNode<Integer> head) {
        if (head == null) return 0;
        
        // Проверяем, является ли значение текущего узла четным (делится на 2 без остатка)
        int currentNodeContribution = (head.getValue() % 2 == 0) ? 1 : 0;
        
        // Рекурсивно считаем четные узлы в левом и правом поддеревьях
        return currentNodeContribution + 
               countEvenNodes(head.getLeft()) + 
               countEvenNodes(head.getRight());
    }

    // задание 9
    //    Напишите функцию, которая получает бинарное дерево, содержащее целые числа,
    //    и возвращает количество узлов со значениями больше заданного X.
    public static int countNodesGreaterThanX(BinNode<Integer> head, int x) {
        if (head == null) return 0;

        // Проверяем, больше ли значение текущего узла чем X
        int currentNodeContribution = (head.getValue() > x) ? 1 : 0;

        // Рекурсивно считаем узлы со значениями больше X в левом и правом поддеревьях
        return currentNodeContribution +
                countNodesGreaterThanX(head.getLeft(), x) +
                countNodesGreaterThanX(head.getRight(), x);
    }

    // задание 10
    //  возвращает количество узлов  значение которого содержит число 5.
    public static int countNodesWithValue5(BinNode<Integer> head) {
        if (head == null) return 0;
        
        // Проверяем, равно ли значение текущего узла 5
        int currentNodeContribution = (head.getValue() == 5) ? 1 : 0;
        
        // Рекурсивно считаем узлы со значением 5 в левом и правом поддеревьях
        return currentNodeContribution + 
               countNodesWithValue5(head.getLeft()) + 
               countNodesWithValue5(head.getRight());
    }

    // задание 11
    // Напишите функцию, которая получает бинарное дерево, содержащее целые числа, и возвращает количество узлов,
    // значение которых меньше значения их родителя.
    public static int countNodesLessThanParent(BinNode<Integer> head) {
        if (head == null) return 0;
        
        // Корень не включаем в подсчет, так как у него нет родителя
        return countNodesLessThanParentHelper(head.getLeft(), head.getValue()) + 
               countNodesLessThanParentHelper(head.getRight(), head.getValue());
    }
    
    private static int countNodesLessThanParentHelper(BinNode<Integer> current, int parentValue) {
        if (current == null) return 0;
        
        // Проверяем, меньше ли значение текущего узла чем значение родителя
        int currentNodeContribution = (current.getValue() < parentValue) ? 1 : 0;
        
        // Получаем значение текущего узла для передачи в рекурсивные вызовы
        int currentValue = current.getValue();
        
        // Рекурсивно считаем узлы с значениями меньше родителя в левом и правом поддеревьях
        return currentNodeContribution + 
               countNodesLessThanParentHelper(current.getLeft(), currentValue) + 
               countNodesLessThanParentHelper(current.getRight(), currentValue);
    }
}