package _8_BinaryTree;

import unit4.collectionsLib.BinNode;
/*//     כתוב פונקציה שמקבלת עץ בינארי המכיל מספרים שלמים ומחזירה את מספר בנים
        היחידים בעץ.*/
public class Tree_5  {
    public static void main(String[] args) {
        // Создаем бинарное дерево
        BinNode<Integer> root = new BinNode<>(10);
        BinNode<Integer> node1 = new BinNode<>(5);
        BinNode<Integer> node2 = new BinNode<>(15);
        BinNode<Integer> node3 = new BinNode<>(3);
        BinNode<Integer> node4 = new BinNode<>(7);
        BinNode<Integer> node5 = new BinNode<>(12);
        BinNode<Integer> node6 = new BinNode<>(20);
        
        // Связываем узлы, формируя дерево
        root.setLeft(node1);
        root.setRight(node2);
        node1.setLeft(node3);
        node1.setRight(node4);
        node2.setLeft(node5);
        node2.setRight(node6);
        
        // Выводим структуру дерева
        System.out.println("Структура дерева:");
        System.out.println("       10");
        System.out.println("      /  \\");
        System.out.println("     5    15");
        System.out.println("    / \\   / \\");
        System.out.println("   3   7 12  20");
        
        // Подсчитываем и выводим количество правых детей
        System.out.println("\nКоличество правых детей в дереве: " + countRightChildren(root));
    }
    
    /**
     * Рекурсивная функция для подсчета количества правых детей в бинарном дереве
     * @param root корень дерева или поддерева
     * @return количество правых детей
     */
    public static int countRightChildren(BinNode<Integer> root) {
        // Базовый случай: если узел null, возвращаем 0
        if (root == null) {
            return 0;
        }
        
        // Счетчик правых детей
        int count = 0;
        
        // Проверяем, есть ли у текущего узла правый ребенок
        if (root.getRight() != null) {
            count++; // Увеличиваем счетчик, если есть правый ребенок
        }
        
        // Рекурсивно вызываем функцию для левого и правого поддеревьев
        // и добавляем результаты к общему счетчику
        count += countRightChildren(root.getLeft());
        count += countRightChildren(root.getRight());
        
        return count;
    }
}
