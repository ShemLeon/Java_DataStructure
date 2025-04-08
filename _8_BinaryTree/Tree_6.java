package _8_BinaryTree;

import unit4.collectionsLib.BinNode;

//כתוב פונקציה שמקבלת עץ בינארי המכיל מספרים שלמים ומחזירה את מספר הורים
//        לשני בנים בעץ.
public class Tree_6 {
    public static void main(String[] args) {
        // Создаем бинарное дерево
        BinNode<Integer> root = new BinNode<>(10);
        BinNode<Integer> node1 = new BinNode<>(5);
        BinNode<Integer> node2 = new BinNode<>(15);
        BinNode<Integer> node3 = new BinNode<>(3);
        BinNode<Integer> node4 = new BinNode<>(7);
        BinNode<Integer> node5 = new BinNode<>(12);
        BinNode<Integer> node6 = new BinNode<>(20);
        BinNode<Integer> node7 = new BinNode<>(1);
        BinNode<Integer> node8 = new BinNode<>(25);
        
        // Связываем узлы, формируя дерево
        root.setLeft(node1);
        root.setRight(node2);
        node1.setLeft(node3);
        node1.setRight(node4);
        node2.setLeft(node5);
        node2.setRight(node6);
        node6.setRight(node8);
        node3.setLeft(node7);
        
        // Выводим структуру дерева
        System.out.println("Структура дерева:");
        System.out.println("        10");
        System.out.println("       /  \\");
        System.out.println("      5    15");
        System.out.println("     / \\   / \\");
        System.out.println("    3   7 12  20");
        System.out.println("   /         \\");
        System.out.println("  1          25");
        
        // Подсчитываем и выводим количество узлов с двумя дочерними элементами
        System.out.println("\nКоличество узлов с двумя дочерними элементами: " + countNodesWithTwoChildren(root));
    }
    
    /**
     * Рекурсивная функция для подсчета количества узлов с двумя дочерними элементами
     * @param root корень дерева или поддерева
     * @return количество узлов с двумя дочерними элементами
     */
    public static int countNodesWithTwoChildren(BinNode<Integer> root) {
        // Базовый случай: если узел null, возвращаем 0
        if (root == null) {
            return 0;
        }
        
        // Счетчик узлов с двумя дочерними элементами
        int count = 0;
        
        // Проверяем, есть ли у текущего узла оба дочерних элемента
        if (root.getLeft() != null && root.getRight() != null) {
            count++; // Увеличиваем счетчик, если у узла есть оба дочерних элемента
        }
        
        // Рекурсивно вызываем функцию для левого и правого поддеревьев
        // и добавляем результаты к общему счетчику
        count += countNodesWithTwoChildren(root.getLeft());
        count += countNodesWithTwoChildren(root.getRight());
        
        return count;
    }
}
