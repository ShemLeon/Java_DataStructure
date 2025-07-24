package _8_BinaryTree;
import unit4.collectionsLib.BinNode;

import static _8_BinaryTree.Tree.isLeaf;

public class Ex36_CheckLeavesAndRoots {
    /**
     * Задание: Напишите рекурсивную функцию, которая получает указатель на корень бинарного дерева и возвращает true (истина), если выполняются два условия:
     * Все внутренние узлы (узлы, у которых есть хотя бы один потомок) являются нечетными числами.
     * Все листья (узлы без потомков) являются четными числами.
     * В противном случае функция должна вернуть false (ложь).
     * */
    public static boolean zugTree(BinNode<Integer> t) {
        if (t==null) return true;
        if (isLeaf(t)) return (t.getValue()%2)==0;
        return (t.getValue()%2) != 0 && zugTree(t.getLeft()) && zugTree(t.getRight());
    }
}
