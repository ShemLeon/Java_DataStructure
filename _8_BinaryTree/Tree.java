package _8_BinaryTree;
import unit4.binTreeUtilsLib.*;
import unit4.binTreeCanvasLib.*;
import unit4.collectionsLib.BinNode;

public class Tree {
    public static void main(String[] args) {
        BinNode<Integer> t1 = BinTreeUtils.buildRandomTree(10, 1, 50);

        BinTreeCanvas.addTree(t1);
        System.out.println("1. Узлов в дереве: " + countTree(t1));
        System.out.println("2. Листьев в дереве: " + countLeaves(t1));
        System.out.println("3. Правых потомков в бинарном дереве: " + countRight(t1));
        System.out.println("4. «Единственных» левых потомков в бинарном дереве: " + count_Left_Final(t1));
        System.out.println("5. «Единственных» потомков в бинарном дереве: " + count_Final_Dots(t1));
        System.out.println("6. Количество «родителей» с двумя детьми в бинарном дереве: " + count_double_dots(t1));
        System.out.println("7. Количество «дедов» в бинарном дереве: " + count_Grandfathers(t1));
        System.out.println("8. Количество узлов с четными значениями: " + countEvenNodes(t1));
        System.out.println("9.  Количество узлов с значениями больше X: " + countNodesGreaterX(t1, 5));
        System.out.println("10. Количество узлов значение которых содержит число 5: " + countNodesFive(t1));
        System.out.println("11. Количество узлов со значением меньше родителя: " + countNodesLessThanParent(t1));
        System.out.println("12. Количество узлов с у которых значение не равно их «брату»:"  + countNodesDifferentBrother(t1));
        System.out.println("13. Количество узлов, которые делятся без остатка на одного из детей:"  + countNodesDivChildren(t1));
        System.out.println("14. Количество узлов, сумма детей которых нечетная:"  + countNodesChildrenSumNotEven(t1));
        System.out.println("15. Количество узлов, 1 из детей которых лист:"  + countNodesWithLeafs(t1));
        System.out.println("16. Количество узлов, у которых число листьев в левом поддереве больше, чем в правом:"  +  countNodesLeftLeavesMore(t1));
        System.out.println("17. Количество узлов, у которых число листьев в правом поддереве меньше значения самого узла:"  +  countNodesRightLeavesLessThanValue(t1));
        System.out.println("18. Высота дерева:"  +  getTreeHeight(t1));
        System.out.println("19. Отзеркаливание дерева:"  +  mirrorTree(t1));
        System.out.println("20. Проверка, что все узлы четные:"  +  isAllEven(t1));
        System.out.println("21. Проверка, существует ли в дереве узел, сумма цифр которого делится на 5:"  +  hasNodeWithDigitsSumDiv5(t1));
        System.out.println("22. Проверки, что все узлы дерева удовлетворяют трём условиям\":"  +  checkAllConditions(t1));

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

    // Задание 1
    // Ф-я получает бинарное дерево, содержащее целые числа,
    // и возвращает количество узлов в дереве."
    public static int countTree(BinNode<Integer> head) {
        if (head == null) return 0;
        return countTree(head.getLeft()) + countTree(head.getRight()) + 1;
    }

    // Задание 2
    // Ф-я получает бинарное дерево, содержащее целые числа,
    // и возвращает количество листьев в дереве."
    public static int countLeaves(BinNode<Integer> head) {
        if (head == null) return 0;
        if (head.getLeft() != null || head.getRight() != null)
            return countLeaves(head.getLeft()) + countLeaves(head.getRight());
        return 1;
    }

    // Задание 3
    // подсчитывает количество правых потомков в бинарном дереве.
    public static int countRight(BinNode<Integer> head) {
        if (head == null) return 0;
        return (head.hasRight() ? 1 : 0) + countRight(head.getLeft()) + countRight(head.getRight());
    }

    // Задание 4
    // Возвращает количество «единственных левых детей» в дереве.
    // —  у которого нет правого "брата".
    public static int count_Left_Final(BinNode<Integer> head) {
        if (head == null) return 0;
        return (!head.hasRight() && head.hasLeft() ? 1 : 0) +
                count_Left_Final(head.getLeft()) +
                count_Left_Final(head.getRight());
    }

    // Задание 5
    // Возвращает количество «единственных детей» в дереве.
    public static int count_Final_Dots(BinNode<Integer> head) {
        if (head == null) return 0;
        if (!head.hasRight() && head.hasLeft())
            return 1 + count_Final_Dots(head.getLeft()) + count_Final_Dots(head.getRight());
        return (head.hasRight() && !head.hasLeft() ? 1 : 0) +
                count_Final_Dots(head.getLeft()) + count_Final_Dots(head.getRight());
    }

    // Задание 6
    // Возвращает количество «родителей» с двумя детьми.
    public static int count_double_dots(BinNode<Integer> head) {
        if (head == null) return 0;
        return (head.hasRight() && head.hasLeft() ? 1 : 0)
                + count_double_dots(head.getLeft()) + count_double_dots(head.getRight());
    }

    // Задание 7
    // Возвращает количество «дедов».
    public static int count_Grandfathers(BinNode<Integer> root) {
        // Базовый случай: если узел null, возвращаем 0
        if (root == null) return 0;
        int count = 0; // Счетчик "дедушек"
        if (hasGrandchild(root)) count++;

        // Рекурсивно вызываем функцию для левого и правого поддеревьев
        // и добавляем результаты к общему счетчику
        count += count_Grandfathers(root.getLeft());
        count += count_Grandfathers(root.getRight());
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
            if (node.getLeft().getLeft() != null || node.getLeft().getRight() != null)
                return true;
        }
        // Проверяем правого ребенка
        if (node.getRight() != null) {
            // Если у правого ребенка есть дети, то у текущего узла есть внуки
            if (node.getRight().getLeft() != null || node.getRight().getRight() != null)
                return true;
        }
        // Если ни у левого, ни у правого ребенка нет детей, то у узла нет внуков
        return false;
    }
    // второй вариант: количество "дедов"
    public static int count_grands(BinNode<Integer> head) {
        if (head == null) return 0;
        if(head.hasRight())
            return (head.getRight().hasRight()||head.getRight().hasLeft() ? 1:0)
                    + count_grands(head.getLeft()) + count_grands(head.getRight());
        return (head.hasLeft() && (head.getLeft().hasRight()||head.getLeft().hasLeft()) ? 1 : 0)
                + count_grands(head.getLeft()) + count_grands(head.getRight());
    }

    // Задание 8
    // Возвращает количество узлов с четными значениями в дереве.
    public static int countEvenNodes(BinNode<Integer> head) {
        if (head == null) return 0;
        
        // Проверяем, является ли значение текущего узла четным (делится на 2 без остатка)
        int currentNodeContribution = (head.getValue() % 2 == 0) ? 1 : 0;
        
        // Рекурсивно считаем четные узлы в левом и правом поддеревьях
        return currentNodeContribution + 
               countEvenNodes(head.getLeft()) + 
               countEvenNodes(head.getRight());
    }

    // Задание 9
    // Возвращает количество узлов со значениями больше заданного X.
    public static int countNodesGreaterX(BinNode<Integer> head, int x) {
        if (head == null) return 0;
        // Проверяем, больше ли значение текущего узла чем X
        int currentNodeContribution = (head.getValue() > x) ? 1 : 0;
        // Рекурсивно считаем узлы со значениями больше X в левом и правом поддеревьях
        return currentNodeContribution +
                countNodesGreaterX(head.getLeft(), x) +
                countNodesGreaterX(head.getRight(), x);
    }

    // Задание 10
    // Возвращает количество узлов значение которых содержит число 5.
    public static int countNodesFive(BinNode<Integer> head) {
        if (head == null) return 0;
        // Проверяем, равно ли значение текущего узла 5
        int currentNodeContribution = 0;
        int temp = head.getValue();
        while (temp>0){
            if (temp%5==0) {
                currentNodeContribution++;
                break;
            }
            temp /=10;
        }
        // Рекурсивно считаем узлы со значением 5 в левом и правом поддеревьях
        return currentNodeContribution + 
               countNodesFive(head.getLeft()) +
               countNodesFive(head.getRight());
    }
    // Задание 11
    // Напишите функцию, которая получает бинарное дерево, содержащее целые числа, и возвращает количество узлов,
    // значение которых меньше значения их родителя.
    public static int countNodesLessThanParent(BinNode<Integer> head) {
        if (head == null) return 0;
        // Корень не включаем в подсчет, так как у него нет родителя
        return countNodesLessThanParentHelper(head.getLeft(), head.getValue()) + 
               countNodesLessThanParentHelper(head.getRight(), head.getValue());
    }
    public static int countNodesLessThanParentHelper(BinNode<Integer> current, int parentValue) {
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
    // Задание 12
    // Возвращает количество узлов, значение которых не равно значению их "брата".
    public static int countNodesDifferentBrother(BinNode<Integer> current) {
        if (current == null) return 0;
        int count =0;

        // Проверяем, имеет ли текущий узел 2 "братьев"
        if (current.hasRight() && current.hasLeft()) {
            if (current.getLeft().getValue() != current.getRight().getValue())
                count++;
        }
        // Рекурсивно считаем узлы с разными значениями братьев в левом и правом поддеревьях
        return count +
                countNodesDifferentBrother(current.getLeft()) +
                countNodesDifferentBrother(current.getRight());
    }

    // Задание 13
    // Возвращает количество узлов, которые делятся без остатка на одного из детей
    public static int countNodesDivChildren(BinNode<Integer> current) {
        if (current == null) return 0;
        boolean flag = false;
        // Проверяем, имеет ли текущий узел хотя бы 1 ребенка
        if (current.hasLeft()) {
            if (current.getValue() % current.getLeft().getValue() == 0)
                 flag = true;
        }
        if (current.hasRight()) {
            if (current.getValue() % current.getRight().getValue() == 0)
                flag = true;
        }
        int currentNodeContribution = (flag) ? 1 : 0;
        // Рекурсивно считаем узлы с разными значениями братьев в левом и правом поддеревьях
        return currentNodeContribution +
                countNodesDivChildren(current.getLeft()) +
                countNodesDivChildren(current.getRight());
    }

    // Задание 14
    // Возвращает количество узлов, сумма детей которых нечетная
    public static int countNodesChildrenSumNotEven(BinNode<Integer> current) {
        if (current == null) return 0;
        // Проверяем, имеет ли текущий узел хотя бы 1 ребенка
        if (!(current.hasRight() || current.hasLeft())) return 0;
        int sum = 0;
        if (current.hasLeft())
            sum +=current.getLeft().getValue();
        if (current.hasRight())
            sum +=current.getRight().getValue();
        int currentNodeContribution = (sum%2 !=0) ? 1 : 0;
        // Рекурсивно считаем узлы с разными значениями братьев в левом и правом поддеревьях
        return currentNodeContribution +
                countNodesChildrenSumNotEven(current.getLeft()) +
                countNodesChildrenSumNotEven(current.getRight());
    }

    // Задание 15
    // Возвращает количество узлов,у которых хотя-бы 1 ребенок - лист
    public static int countNodesWithLeafs(BinNode<Integer> current){
        if (current==null) return 0;
        int count=0;
        if (current.hasLeft()){
            BinNode<Integer> left = current.getLeft();
            if ( !left.hasLeft() && !left.hasRight()) count++;
        }
        if (current.hasRight()){
            BinNode<Integer> right = current.getRight();
            if ( !right.hasLeft() && !right.hasRight()) count++;
        }

        return (count > 0 ? 1 : 0) +
                countNodesWithLeafs(current.getLeft()) +
                countNodesWithLeafs(current.getRight());
    }

    // Задание 16
    // Возвращает количество узлов,у которых количество листьев в левом поддереве больше, чем в правом поддереве.
    /*
     * @param current - текущий узел дерева
     * @return количество таких узлов
     * Принцип работы:
     * 1. Если узел пустой — возвращаем 0.
     * 2. Для текущего узла считаем количество листьев в левом и правом поддеревьях через вспомогательную ф-ю.
     * 3. Если в левом больше, увеличиваем счетчик.
     * 4. Рекурсивно вызываем функцию для левого и правого поддерева.
     */
    public static int countNodesLeftLeavesMore(BinNode<Integer> current){
        if (current == null) return 0;
        int leftLeaves = countLeaves(current.getLeft());
        int rightLeaves = countLeaves(current.getRight());
        int currentNodeContribution = (leftLeaves > rightLeaves) ? 1 : 0;
        return currentNodeContribution
                + countNodesLeftLeavesMore(current.getLeft())
                + countNodesLeftLeavesMore(current.getRight());
    }

    // Задание 17
    /* Функция для "подсчета количества узлов, у которых число листьев в правом поддереве меньше значения самого узла"
     * Принцип работы:
     * 1. Если узел пустой — возвращаем 0.
     * 2. Считаем количество листьев в правом поддереве.
     * 3. Если это количество меньше значения текущего узла — увеличиваем счетчик.
     * 4. Рекурсивно вызываем функцию для левого и правого поддерева.
     */
    public static int countNodesRightLeavesLessThanValue(BinNode<Integer> current) {
        if (current == null) return 0;
        // Не считаем листья
        if (!current.hasLeft() && !current.hasRight()) return 0;
        // Не считаем, если правого поддерева нет
        if (!current.hasRight())
            return countNodesRightLeavesLessThanValue(current.getLeft()) +
                    countNodesRightLeavesLessThanValue(current.getRight());

        int rightLeaves = countLeaves(current.getRight());
        int currentNodeContribution = (rightLeaves < current.getValue()) ? 1 : 0;

        return currentNodeContribution
                + countNodesRightLeavesLessThanValue(current.getLeft())
                + countNodesRightLeavesLessThanValue(current.getRight());
    }
    // Задание 18
    // Функция для "подсчета высоты дерева"
    public static int getTreeHeight(BinNode<Integer> current){
        if (current==null) return 0;
        int leftHeight = getTreeHeight(current.getLeft());
        int rightHeight = getTreeHeight(current.getRight());
        return  1 + Math.max(leftHeight, rightHeight);
    }
    // Задание 19
    // Построение зеркального дерева
    public static BinNode<Integer> mirrorTree(BinNode<Integer> current) {
        if (current == null) return null;
        BinNode<Integer> mirrored = new BinNode<>(current.getValue());
        mirrored.setLeft(mirrorTree(current.getRight()));
        mirrored.setRight(mirrorTree(current.getLeft()));
        return mirrored;
    }

    // Задание 20
    // Проверка, что все узлы четные:"
    public static boolean isAllEven(BinNode<Integer> current) {
        if (current == null) return true;
        if (current.getValue() % 2 != 0) return false;
        return isAllEven(current.getLeft()) && isAllEven(current.getRight());
    }
    // Задание 21
    // Проверка, существует ли в дереве узел, сумма цифр которого делится на 5:"
    public static boolean hasNodeWithDigitsSumDiv5(BinNode<Integer> current) {
        if (current == null) return false;
        if (sumOfDigits(current.getValue()) % 5 == 0) return true;
        return hasNodeWithDigitsSumDiv5(current.getLeft()) || hasNodeWithDigitsSumDiv5(current.getRight());
    }

    /* Вспомогательная функция для подсчёта суммы цифр числа */
    public static int sumOfDigits(int n) {
        n = Math.abs(n);
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
    // Задание 22
    /* Функция для "проверки, что все узлы дерева удовлетворяют трём условиям"
     * @param current - корень дерева
     * @return true, если все условия выполняются для всех узлов, иначе false
     * Условия:
     * 1. Цифры значения узла идут по убыванию (от старшей к младшей).
     * 2. Количество листьев в правом поддереве <= значению узла.
     * 3. Сумма всех левых потомков (прямых детей) чётная.
     * Принцип работы:
     * 1. Если узел пустой — возвращаем true.
     * 2. Проверяем три условия для текущего узла.
     * 3. Рекурсивно проверяем левое и правое поддерево.
     */
    public static boolean checkAllConditions(BinNode<Integer> current) {
        if (current == null) return true;

        // 1. Проверка, что цифры идут по убыванию
        if (!isDigitsDecreasing(current.getValue())) return false;

        // 2. Количество листьев в правом поддереве <= значению узла
        int rightLeaves = countLeaves(current.getRight());
        if (rightLeaves > current.getValue()) return false;

        // 3. Сумма всех левых потомков чётная
        int leftSum = 0;
        if (current.hasLeft()) leftSum += current.getLeft().getValue();
        if (current.hasRight()) leftSum += current.getRight().getValue();
        if (leftSum % 2 != 0) return false;

        // Рекурсивно проверяем поддеревья
        return checkAllConditions(current.getLeft()) && checkAllConditions(current.getRight());
    }

    /* Вспомогательная функция: проверяет, что цифры числа идут по убыванию */
    public static boolean isDigitsDecreasing(int n) {
        int prev = 10;
        while (n > 0) {
            int digit = n % 10;
            if (digit >= prev) return false;
            prev = digit;
            n /= 10;
        }
        return true;
    }


}