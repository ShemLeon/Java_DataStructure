package _8_BinaryTree;

import unit4.binTreeUtilsLib.*;
import unit4.binTreeCanvasLib.*;
import unit4.collectionsLib.BinNode;

public class HandleTest {
    public static void main(String[] args) {

        BinNode<Integer> n21 = new BinNode<>(21);
        BinNode<Integer> n49 = new BinNode<>(49);
        BinNode<Integer> n39 = new BinNode<>(39);
        BinNode<Integer> n27 = new BinNode<>(27);
        BinNode<Integer> n20 = new BinNode<>(20);
        BinNode<Integer> n18 = new BinNode<>(18);
        BinNode<Integer> n9  = new BinNode<>(9);

// Устанавливаем связи
        n21.setLeft(n49);
        n21.setRight(n39);
        n39.setLeft(n27);
        n39.setRight(n20);
        n27.setLeft(n18);
        n20.setRight(n9);
// Теперь n21 — корень твоего дерева
        BinNode<Integer> t1 = n21;
        System.out.println("18. Высота дерева:"  +  getTreeHeight(t1));
    }

    // Функция для "подсчета высоты дерева"
    public static int getTreeHeight(BinNode<Integer> current){
        if (current==null) return 0;
        int leftHeight = getTreeHeight(current.getLeft());
        int rightHeight = getTreeHeight(current.getRight());
        return  1 + Math.max(leftHeight, rightHeight);
    }
}
