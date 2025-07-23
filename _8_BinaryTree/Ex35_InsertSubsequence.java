package _8_BinaryTree;
import unit4.binTreeUtilsLib.*;
import unit4.binTreeCanvasLib.*;
import unit4.collectionsLib.BinNode;

public class Ex35_InsertSubsequence {
    /**
     * Задание: Вставить все элементы из отсортированного массива в бинарное дерево поиска.
     * Complexity: O(N^2)
     * Эта функция-обертка принимает корень дерева и массив. Она перебирает
     * все элементы массива и для каждого вызывает вспомогательную
     * рекурсивную функцию insertValue для его вставки.
     *
     * @param t   Корень бинарного дерева поиска. Может быть null, если дерево пустое.
     * @param arr Массив целых чисел, которые нужно вставить в дерево.
     * @return    Корень дерева после вставки всех элементов массива.
     * */
    public static BinNode<Integer> insertArrayIntoBST(BinNode<Integer> t, int[] arr) {
        // Проходим по каждому числу в массиве
        for (int i = 0; i < arr.length; i++) {
            int valueToInsert = arr[i];
            // Вызываем функцию вставки для текущего числа и обновляем корень дерева 't'.
            // Это важно, так как первая вставка в пустое дерево изменит корень с null на новый узел.
            t = insertValue(t, valueToInsert);
        }
        // Возвращаем итоговый корень дерева
        return t;
    }


    /**
     * Вспомогательная рекурсивная функция для вставки ОДНОГО значения в дерево.
     * Она находит правильное место для нового значения согласно правилам бинарного дерева поиска.
     * @param node  Текущий узел, который мы рассматриваем в процессе спуска по дереву.
     * @param value Значение, которое нужно вставить.
     * @return      Узел, который должен быть на этом месте в дереве после вставки.
     */
    private static BinNode<Integer> insertValue(BinNode<Integer> node, int value) {
        if (node == null) {
            return new BinNode<>(value);
        }
        if (value < node.getValue()) {
            node.setLeft(insertValue(node.getLeft(), value));
        }
        // Иначе, если значение для вставки БОЛЬШЕ...
        else if (value > node.getValue()) {
            // ...то мы должны вставить его где-то в ПРАВОМ поддереве.
            // Делаем то же самое для правого потомка.
            node.setRight(insertValue(node.getRight(), value));
        }
        // Если value == node.getValue(), мы ничего не делаем, чтобы избежать дубликатов.
        // Возвращаем текущий узел (с возможно обновленными ссылками на потомков).
        // Это нужно, чтобы связать дерево обратно во время возврата из рекурсии.
        return node;
    }
}
