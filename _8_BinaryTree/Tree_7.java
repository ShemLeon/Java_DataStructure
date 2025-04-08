package _8_BinaryTree;
import unit4.binTreeUtilsLib.*;
import unit4.binTreeCanvasLib.*;
import unit4.collectionsLib.*;
import unit4.collectionsLib.BinNode;
//
//כתוב פונקציה שמקבלת עץ בינארי המכיל מספרים שלמים ומחזירה את מספר סבים
//        בעץ.
public class Tree_7 {
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
        
        // Подсчитываем и выводим количество "дедушек" в дереве
        System.out.println("\nКоличество узлов, имеющих внуков (дедушек): " + countGrandfathers(root));
    }
    
    /**
     * Рекурсивная функция для подсчета количества "дедушек" в бинарном дереве
     * "Дедушка" - это узел, у которого есть хотя бы один внук
     * @param root корень дерева или поддерева
     * @return количество "дедушек" в дереве
     */
    public static int countGrandfathers(BinNode<Integer> root) {
        // Базовый случай: если узел null, возвращаем 0
        if (root == null) {
            return 0;
        }
        
        // Счетчик "дедушек"
        int count = 0;
        
        // Проверяем, является ли текущий узел "дедушкой"
        if (hasGrandchild(root)) {
            count++; // Увеличиваем счетчик, если узел имеет хотя бы одного внука
        }
        
        // Рекурсивно вызываем функцию для левого и правого поддеревьев
        // и добавляем результаты к общему счетчику
        count += countGrandfathers(root.getLeft());
        count += countGrandfathers(root.getRight());
        
        return count;
    }
    
    /**
     * Вспомогательная функция для проверки, имеет ли узел хотя бы одного внука
     * @param node узел для проверки
     * @return true, если узел имеет хотя бы одного внука, иначе false
     */
    private static boolean hasGrandchild(BinNode<Integer> node) {
        // Проверяем левого ребенка
        if (node.getLeft() != null) {
            // Если у левого ребенка есть дети, то у текущего узла есть внуки
            if (node.getLeft().getLeft() != null || node.getLeft().getRight() != null) {
                return true;
            }
        }
        
        // Проверяем правого ребенка
        if (node.getRight() != null) {
            // Если у правого ребенка есть дети, то у текущего узла есть внуки
            if (node.getRight().getLeft() != null || node.getRight().getRight() != null) {
                return true;
            }
        }
        
        // Если ни у левого, ни у правого ребенка нет детей, то у узла нет внуков
        return false;
    }
}
