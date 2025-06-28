package _8_BinaryTree;
import unit4.binTreeUtilsLib.*;
import unit4.binTreeCanvasLib.*;
import unit4.collectionsLib.BinNode;
import unit4.collectionsLib.Queue;

public class Tree {
    public static void main(String[] args) {
        BinNode<Integer> t1 = BinTreeUtils.buildRandomTree(10, 1, 50);

        BinTreeCanvas.addTree(t1);

        System.out.println("A) Print Pre-Order: ");
        printPreOrder(t1);
        System.out.println("\nB) Print In-Order: ");
        printInOrder(t1);
        System.out.println("\nC) Print Post-Order: ");
        printPostOrder(t1);
        System.out.println("\nD) Print Order: ");
        printOrder(t1);
        System.out.println("\n1. Всего узлов в дереве: " + countNodes(t1));
        System.out.println("2. Листьев в дереве: " + countLeaves(t1));
        System.out.println("3. Правых потомков в бинарном дереве: " + countRight(t1));
        System.out.println("4. «Единственных» левых потомков в бинарном дереве: " + countLeftFinal(t1));
        System.out.println("5. «Единственных» потомков в бинарном дереве: " + countFinalDots(t1));
        System.out.println("6. Количество «родителей» с двумя детьми в бинарном дереве: " + count_double_dots(t1));
        System.out.println("7. Количество «дедов» в бинарном дереве: " + count_Grandfathers(t1));
        System.out.println("8. Количество узлов с четными значениями: " + countEvenNodes(t1));
        System.out.println("9.  Количество узлов с значениями больше X: " + countNodesGreaterX(t1, 5));
        System.out.println("10. Количество узлов значение которых содержит число 5: " + countNodesFive(t1));
        System.out.println("11. Количество узлов со значением меньше родителя: " + countNodesLessParent(t1));
        System.out.println("12. Количество узлов с у которых значение не равно их «брату»:"  + countNodesDifferentBrother(t1));
        System.out.println("13. Количество узлов, которые делятся без остатка на одного из детей:"  + countNodesDivChildren(t1));
        System.out.println("14. Количество узлов, сумма детей которых нечетная:"  + countNodesChildrenSumNotEven(t1));
        System.out.println("15. Количество узлов, 1 из детей которых лист:"  + countNodesWithLeafs(t1));
        System.out.println("16. Количество узлов, у которых число листьев в левом поддереве больше, чем в правом:"  +  countNodesLeftLeavesMore(t1));
        System.out.println("17. Количество узлов, у которых число листьев в правом поддереве меньше значения самого узла:"  +  countNodesRightLeavesLessThanValue(t1));
        System.out.println("18. Высота дерева:"  +  getTreeHeight(t1));
        System.out.println("19. Отзеркаливание дерева:"  +  mirrorTree(t1));
        System.out.println("20. Проверка, что все узлы четные:"  +  isAllEven(t1));
        System.out.println("21. Проверка, существует ли в дереве узел, сумма цифр которого делится на 5:"  +  hasSumDivFive(t1));
        System.out.println("22. Проверки, что все узлы дерева удовлетворяют трём условиям: \n"
                + "* 1. Цифры значения узла идут по убыванию (от старшей к младшей) \n"
                + "* 2. Количество листьев в правом поддереве <= значению узла. \n"
                + "* 3. Сумма всех левых потомков (прямых детей) чётная.+  checkAllConditions(t1))");
        System.out.println("23.3 Max значение узла:"  + findMaxSimple(t1));
        System.out.println("23.4 Min значение узла:"  + findMinSimple(t1));

        System.out.println(" -----------Order----------");
        System.out.println("23.1 Min значение узла:"  + findMinBST(t1));
        System.out.println("23.4 Max значение узла:"  + findMaxBST(t1));
        BinNode<Integer> t2 =createSearchFromSimple(t1);
        BinTreeCanvas.addTree(t2);
        System.out.println();

    }


    // Печать элементов дерева в Pre-Order
    public static void printPreOrder(BinNode<Integer> t) {
        if (t == null) return;
        System.out.print(" "+t.getValue());
        printPreOrder(t.getLeft());
        printPreOrder(t.getRight());
    }
    // Печать элементов дерева в In-Order
    public static void printInOrder(BinNode<Integer> t) {
        if (t == null) return;
        printInOrder(t.getLeft());
        System.out.print(" "+t.getValue());
        printInOrder(t.getRight());
    }
    // Печать элементов дерева в Post-Order
    public static void printPostOrder(BinNode<Integer> t) {
        if (t == null) return;
        printPostOrder(t.getLeft());
        printPostOrder(t.getRight());
        System.out.print(" "+t.getValue());
    }

    // Печать элементов дерева в Order
    public static void printOrder(BinNode<Integer> t){
        if (t==null) return;
        Queue<BinNode<Integer>> q = new Queue<BinNode<Integer>>();
        q.insert(t);
        while (!q.isEmpty()) {
            BinNode<Integer> t1= q.remove();
            System.out.print(" "+t1.getValue());
            if (t1.getLeft()!=null)
                q.insert(t1.getLeft());
            if (t1.getRight()!=null)
                q.insert(t1.getRight());
    }
}

    // Задание 1
    // Ф-я получает бинарное дерево, содержащее целые числа,
    // и возвращает количество узлов в дереве."
    public static int countNodes(BinNode<Integer> t) {
        if (t == null) return 0;
        return 1 +
                + countNodes(t.getLeft())
                + countNodes(t.getRight());
    }

    // Задание 2
    // Ф-я получает бинарное дерево, содержащее целые числа,
    // и возвращает количество листьев в дереве."
    public static int countLeaves(BinNode<Integer> t) {
        if (t == null) return 0;
        // if (!t.hasLeft() && !t.hasRight()) - аналог
        if (t.getLeft() != null || t.getRight() != null)
            return countLeaves(t.getLeft()) + countLeaves(t.getRight());
        return 1;
    }

    // Задание 3
    // Подсчитывает количество правых потомков в бинарном дереве.
    public static int countRight(BinNode<Integer> t) {
        if (t == null) return 0;
        return (t.hasRight() ? 1 : 0)
                + countRight(t.getLeft())
                + countRight(t.getRight());
    }

    // Задание 4
    // Возвращает количество «единственных левых детей» в дереве.
    // —  у которого нет правого "брата".
    public static int countLeftFinal(BinNode<Integer> t) {
        if (t == null) return 0;
        return (!t.hasRight() && t.hasLeft() ? 1 : 0) +
                countLeftFinal(t.getLeft()) +
                countLeftFinal(t.getRight());
    }

    // Задание 5
    // Возвращает количество «единственных потомков» в дереве.
    public static int countFinalDots(BinNode<Integer> t) {
        if (t == null) return 0;
        if (!t.hasRight() && t.hasLeft())
            return 1
                    + countFinalDots(t.getLeft())
                    + countFinalDots(t.getRight());
        return (t.hasRight() && !t.hasLeft() ? 1 : 0)
                + countFinalDots(t.getLeft())
                + countFinalDots(t.getRight());
    }

    // Задание 6
    // Возвращает количество «родителей» с двумя детьми.
    public static int count_double_dots(BinNode<Integer> t) {
        if (t == null) return 0;
        return (t.hasRight() && t.hasLeft() ? 1 : 0)
                + count_double_dots(t.getLeft()) + count_double_dots(t.getRight());
    }

    // Задание 7
    // Возвращает количество «дедов».
    public static int count_Grandfathers(BinNode<Integer> t) {
        // Базовый случай: если узел null, возвращаем 0
        if (t == null) return 0;
        int count = 0; // Счетчик "дедушек"
        if (hasGrandchild(t)) count++;

        // Рекурсивно вызываем функцию для левого и правого поддеревьев
        // и добавляем результаты к общему счетчику
        count += count_Grandfathers(t.getLeft());
        count += count_Grandfathers(t.getRight());
        return count;
    }

    // Вспомогательная функция для проверки, имеет ли узел хотя бы одного внука
    private static boolean hasGrandchild(BinNode<Integer> t) {
        // Проверяем левого ребенка
        if (t.hasLeft()) {
            // Если у левого ребенка есть дети, то у текущего узла есть внуки
            if (t.getLeft().hasLeft() || t.getLeft().hasRight())
                return true;
        }
        // Проверяем правого ребенка
        if (t.hasRight()) {
            // Если у правого ребенка есть дети, то у текущего узла есть внуки
            return t.getRight().hasLeft() || t.getRight().hasRight();
        }
        // Если ни у левого, ни у правого ребенка нет детей, то у узла нет внуков
        return false;
    }

    // Задание 8
    // Возвращает количество узлов с четными значениями в дереве.
    public static int countEvenNodes(BinNode<Integer> t) {
        if (t == null) return 0;
        // Проверяем, является ли значение текущего узла четным (делится на 2 без остатка)
        int currentNodeContribution = (t.getValue() % 2 == 0) ? 1 : 0;
        // Рекурсивно считаем четные узлы в левом и правом поддеревьях
        return currentNodeContribution
                + countEvenNodes(t.getLeft())
                + countEvenNodes(t.getRight());
    }

    // Задание 9
    // Возвращает количество узлов со значениями больше заданного X.
    public static int countNodesGreaterX(BinNode<Integer> t, int x) {
        if (t == null) return 0;
        // Проверяем, больше ли значение текущего узла чем X
        int currentNodeContribution = (t.getValue() > x) ? 1 : 0;
        // Рекурсивно считаем узлы со значениями больше X в левом и правом поддеревьях
        return currentNodeContribution
                + countNodesGreaterX(t.getLeft(), x)
                + countNodesGreaterX(t.getRight(), x);
    }

    // Задание 10
    // Возвращает количество узлов значение которых содержит число 5.
    public static int countNodesFive(BinNode<Integer> t) {
        if (t == null) return 0;
        // Проверяем, равно ли значение текущего узла 5
        int currentNodeContribution = 0;
        int temp = t.getValue();
        while (temp>0){
            if (temp%5==0) {
                currentNodeContribution++;
                break;
            }
            temp /=10;
        }
        // Рекурсивно считаем узлы со значением 5 в левом и правом поддеревьях
        return currentNodeContribution + 
               + countNodesFive(t.getLeft())
               + countNodesFive(t.getRight());
    }

    // Задание 11
    // Напишите функцию, которая получает бинарное дерево, содержащее целые числа, и возвращает количество узлов,
    // значение которых меньше значения их родителя.
    public static int countNodesLessParent(BinNode<Integer> t) {
        if (t == null) return 0;
        // Корень не включаем в подсчет, так как у него нет родителя
        return countHelper(t.getLeft(), t.getValue()) +
                + countHelper(t.getRight(), t.getValue());
    }
    public static int countHelper(BinNode<Integer> current, int parentValue) {
        if (current == null) return 0;
        // Проверяем, меньше ли значение текущего узла чем значение родителя
        int currentNodeContribution = (current.getValue() < parentValue) ? 1 : 0;
        // Получаем значение текущего узла для передачи в рекурсивные вызовы
        int currentValue = current.getValue();
        // Рекурсивно считаем узлы с значениями меньше родителя в левом и правом поддеревьях
        return currentNodeContribution + 
               + countHelper(current.getLeft(), currentValue)
               + countHelper(current.getRight(), currentValue);
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
                + countNodesDifferentBrother(current.getLeft())
                + countNodesDifferentBrother(current.getRight());
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
        // Рекурсивно считаем узлы в левом и правом поддеревьях
        return currentNodeContribution +
                + countNodesDivChildren(current.getLeft())
                + countNodesDivChildren(current.getRight());
    }

    // Задание 14
    // Возвращает количество узлов, сумма детей которых нечетная
    public static int countNodesChildrenSumNotEven(BinNode<Integer> t) {
        if (t == null) return 0;
        // Проверяем, имеет ли текущий узел хотя бы 1 ребенка
        if (!(t.hasRight() || t.hasLeft())) return 0;
        int sum = 0;
        if (t.hasLeft())
            sum += t.getLeft().getValue();
        if (t.hasRight())
            sum += t.getRight().getValue();
        int currentNodeContribution = (sum%2 !=0) ? 1 : 0;
        // Рекурсивно считаем узлы с разными значениями братьев в левом и правом поддеревьях
        return currentNodeContribution +
                + countNodesChildrenSumNotEven(t.getLeft())
                + countNodesChildrenSumNotEven(t.getRight());
    }

    // Задание 15
    // Возвращает количество узлов,у которых хотя-бы 1 ребенок - лист
    public static int countNodesWithLeafs(BinNode<Integer> t){
        if (t==null) return 0;
        int count=0;
        if (t.hasLeft()){
            BinNode<Integer> left = t.getLeft();
            if ( !left.hasLeft() && !left.hasRight()) count++;
        }
        if (t.hasRight()){
            BinNode<Integer> right = t.getRight();
            if ( !right.hasLeft() && !right.hasRight()) count++;
        }

        return (count > 0 ? 1 : 0) +
               + countNodesWithLeafs(t.getLeft())
               + countNodesWithLeafs(t.getRight());
    }

    // Задание 16
    // Возвращает количество узлов,у которых количество листьев в левом поддереве больше, чем в правом.
    // Делим дерево на лево и право, а дальше используем вспомогательную функцию из ex2

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
    // Функция для "подсчета количества узлов, у которых число листьев в правом поддереве меньше значения самого узла"
    public static int countNodesRightLeavesLessThanValue(BinNode<Integer> t) {
        if (t == null) return 0;
        // Не считаем листья
        if (!t.hasLeft() && !t.hasRight()) return 0;
        // Не считаем, если правого поддерева нет
        if (!t.hasRight())
            return countNodesRightLeavesLessThanValue(t.getLeft()) +
                    countNodesRightLeavesLessThanValue(t.getRight());

        int rightLeaves = countLeaves(t.getRight());
        int pointResult = (rightLeaves < t.getValue()) ? 1 : 0;

        return pointResult
                + countNodesRightLeavesLessThanValue(t.getLeft())
                + countNodesRightLeavesLessThanValue(t.getRight());
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
    public static BinNode<Integer> mirrorTree(BinNode<Integer> t) {
        if (t == null) return null;
        BinNode<Integer> mirrored = new BinNode<>(t.getValue());
        mirrored.setLeft(mirrorTree(t.getRight()));
        mirrored.setRight(mirrorTree(t.getLeft()));
        return mirrored;
    }

    // Задание 20
    // Проверка, что все узлы четные:"
    public static boolean isAllEven(BinNode<Integer> t) {
        if (t == null) return true;
        if (t.getValue() % 2 != 0) return false;
        return isAllEven(t.getLeft()) && isAllEven(t.getRight());
    }

    // Задание 21
    // Проверка, существует ли в дереве узел, сумма цифр которого делится на 5:"
    public static boolean hasSumDivFive(BinNode<Integer> t) {
        if (t == null) return false;
        if (sumOfDigits(t.getValue()) % 5 == 0) return true;
        return hasSumDivFive(t.getLeft()) || hasSumDivFive(t.getRight());
    }

    /* Вспомогательная функция для подсчёта суммы цифр числа */
    public static int sumOfDigits(int n) {
        n = Math.abs(n); // возводим в модуль число
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    // Задание 22
    /* Функция для "проверки, что все узлы дерева удовлетворяют трём условиям"
     * 1. Цифры значения узла идут по убыванию (от старшей к младшей).
     * 2. Количество листьев в правом поддереве <= значению узла.
     * 3. Сумма всех левых потомков (прямых детей) чётная.
     * Принцип работы:
     * 1. Если узел пустой — возвращаем true.
     * 2. Проверяем три условия для текущего узла.
     * 3. Рекурсивно проверяем левое и правое поддерево.
     */
    public static boolean checkAllConditions(BinNode<Integer> t) {
        if (t == null) return true;

        // Проверка условия 1: Цифры значения узла идут по убыванию.
        if (!isDigitsDecreasing(t.getValue())) return false;

        // Проверка условия 2: Количество листьев в правом поддереве <= значению узла
        int rightLeaves = countLeaves(t.getRight());
        if (rightLeaves > t.getValue()) return false;

        // Проверка условия 3: Сумма всех потомков в левом поддереве каждого узла четная.
        // Если левого поддерева нет, его сумма 0 - это четное число.
        if (t.hasLeft()){
            int leftSubtreeSum = sumSubtreeRecursive(t.getLeft());
            if (leftSubtreeSum % 2 != 0) return false;
        }

        // Рекурсивно проверяем поддеревья
        return checkAllConditions(t.getLeft()) && checkAllConditions(t.getRight());
    }

    // Вспомогательная функция: проверяет, что цифры числа идут по убыванию */
    public static boolean isDigitsDecreasing(int n) {
        if (n < 10) return true; // базовй случай для остановки рекурсии
        // Проверка условия
        if ((n%10) >= ((n/10) % 10)) return false;
        return isDigitsDecreasing(n/10);
    }

    // Условие 3: Считает сумму значений всех узлов в подДереве.
     public static int sumSubtreeRecursive(BinNode<Integer> t) {
        if (t == null) return 0;
        return t.getValue() // 1. Берем ЗНАЧЕНИЕ текущего узла
                + sumSubtreeRecursive(t.getLeft())  // 2. ПРИБАВЛЯЕМ сумму левого поддерева
                + sumSubtreeRecursive(t.getRight()); // 3. ПРИБАВЛЯЕМ сумму правого поддерева
    }

    // Задание 23.1
    // Поиск максимума в бинарном дереве поиска
    // Сложность: O(h), где h — это высота дерева
    public static BinNode<Integer> findMaxBST(BinNode<Integer> t) {
        if (t == null) return null;
        // Двигаемся вправо до самого конца
        while (t.hasRight()) {
            t = t.getRight();
        }
        return t; // Возвращаем самый правый узел
    }

    // Задание 23.3
    // Поиск минимума в бинарном дереве поиска
    // Сложность: O(h), где h — это высота дерева
    // Лучший/Средний случай (сбалансированное дерево): В хорошо сбалансированном дереве высота h примерно равна log(n).
    // Поэтому сложность будет O(log n). Это очень быстро.
    public static BinNode<Integer> findMinBST(BinNode<Integer> t) {
        if (t == null) return null;
        // Двигаемся вправо до самого конца
        while (t.hasLeft()) {
            t = t.getLeft();
        }
        return t; // Возвращаем самый правый узел
    }

    // Задание 23.4:
    //  Поиск минимума в обычном бинарном дереве
    // Сложность: O(n), где n — это общее количество узлов в дереве.
    public static int findMinSimple(BinNode<Integer> t) {
        // Если дерево изначально пустое, в нем нет минимума.
        if (t == null) {
            throw new IllegalArgumentException("Нельзя найти минимум в пустом дереве.");
        }
        // Запускаем рекурсивный поиск с корневого узла.
        return findMinHelper(t);
    }

    private static int findMinHelper(BinNode<Integer> t) {
        // Начинаем с предположения, что минимум - это значение текущего узла.
        int minimum = t.getValue();
        // Если есть левый потомок, рекурсивно ищем минимум в левом поддереве
        // и сравниваем с нашим текущим минимумом.
        if (t.hasLeft()) {
            minimum = Math.min(minimum, findMinHelper(t.getLeft()));
        }
        // То же самое делаем для правого потомка.
        if (t.hasRight()) {
            minimum = Math.min(minimum, findMinHelper(t.getRight()));
        }
        // Возвращаем найденное минимальное значение для этого поддерева.
        return minimum;
    }

    // Задание 23.2:
    //  Поиск максимума в обычном бинарном дереве
    // Сложность: O(n), где n — это общее количество узлов в дереве.
    public static int findMaxSimple(BinNode<Integer> t) {
        // Если дерево изначально пустое, в нем нет минимума.
        if (t == null) {
            throw new IllegalArgumentException("Нельзя найти минимум в пустом дереве.");
        }
        // Запускаем рекурсивный поиск с корневого узла.
        return findMaxHelper(t);
    }

    private static int findMaxHelper(BinNode<Integer> t) {
        // Начинаем с предположения, что минимум - это значение текущего узла.
        int maximum = t.getValue();
        // Если есть левый потомок, рекурсивно ищем минимум в левом поддереве
        // и сравниваем с нашим текущим минимумом.
        if (t.hasLeft()) {
            maximum = Math.max(maximum, findMaxHelper(t.getLeft()));
        }
        // То же самое делаем для правого потомка.
        if (t.hasRight()) {
            maximum = Math.max(maximum, findMaxHelper(t.getRight()));
        }
        // Возвращаем найденное максимальное значение для этого поддерева.
        return maximum;
    }

    // Задание 24
    // Преобразование обычного бинарного дерева в поиска
    public static BinNode<Integer> createSearchFromSimple(BinNode<Integer> t) {
        // Сложность: O(n^2), где n — это общее количество узлов в дереве.
        // Создаем пустой корень для нашего будущего дерева поиска.
        BinNode<Integer> bstRoot = null;
        // Запускаем рекурсивный процесс обхода и вставки.
        // Функция вернет нам полностью построенное дерево.
        return traverseAndInsert(t, bstRoot);
    }

    private static BinNode<Integer> traverseAndInsert(BinNode<Integer> simpleNode, BinNode<Integer> bstRoot) {
        // в исходном дереве дошли до пустого места, просто возвращаем то дерево, что уже успели построить.
        if (simpleNode == null) return bstRoot;
        // 1. Вставляем значение текущего узла из простого дерева в наше новое дерево поиска.
        bstRoot = insertIntoBst(bstRoot, simpleNode.getValue());

        // 2. Рекурсивно делаем то же самое для левого поддерева.
        bstRoot = traverseAndInsert(simpleNode.getLeft(), bstRoot);

        // 3. Рекурсивно делаем то же самое для правого поддерева.
        bstRoot = traverseAndInsert(simpleNode.getRight(), bstRoot);

        return bstRoot;
    }

    // Вспомогательная функция для вставки
    private static BinNode<Integer> insertIntoBst(BinNode<Integer> bstNode, int value) {
        if (bstNode == null) {
            return new BinNode<>(value);
        }

        if (value < bstNode.getValue()) {
            bstNode.setLeft(insertIntoBst(bstNode.getLeft(), value));
        } else if (value > bstNode.getValue()) {
            bstNode.setRight(insertIntoBst(bstNode.getRight(), value));
        }

        return bstNode;
    }

    // Задание 25.1
    // Поиск (Predecessor) предшественника узла `x` в бинарном дереве поиска с корнем `root`
    public static BinNode<Integer> findPredecessor(BinNode<Integer> root, BinNode<Integer> x) {
        // Сложность: O(n^2), где n — это общее количество узлов в дереве.
        // Создаем пустой корень для нашего будущего дерева поиска.
        if (x == null) {return null;}

        // Случай 1: У узла `x` есть левое поддерево.
        // Предшественник - это максимальный узел в его левом поддереве.
        // Используем вспомогательную функцию findMaxBST.
        if (x.hasLeft()) {
            return findMaxBST(x.getLeft());
        }

        // Случай 2: У узла `x` нет левого поддерева.
        // Ищем предшественника, спускаясь от корня. Предшественник - это самый нижний
        // предок `x`, чей правый дочерний узел также является предком `x`.
        BinNode<Integer> predecessor = null;
        BinNode<Integer> current = root;
        while (current != null) {
            if (x.getValue() > current.getValue()) {
                // Если `x` больше текущего узла, то `current` может быть предшественником.
                // Запоминаем его и идем вправо, чтобы найти более близкого (большего) предшественника.
                predecessor = current;
                current = current.getRight();
            } else if (x.getValue() < current.getValue()) {
                // Если `x` меньше, то `current` не может быть предшественником. Идем влево.
                current = current.getLeft();
            } else {
                // Мы нашли узел `x`. Цикл можно остановить.
                break;
            }
        }
        return predecessor;
    }


    // Задание 25.2
    // Поиск (Successor) преемника узла `x` в бинарном дереве поиска с корнем `root`
    public static BinNode<Integer> findSuccessor(BinNode<Integer> root, BinNode<Integer> x) {
        // Сложность: O(h), где h - высота дерева. В худшем случае O(n).
        if (x == null) {
            return null;
        }

        // Случай 1: У узла `x` есть правое поддерево.
        // Преемник - это минимальный узел в его правом поддереве.
        // Используем вспомогательную функцию findMinBST.
        if (x.hasRight()) {
            return findMinBST(x.getRight());
        }

        // Случай 2: У узла `x` нет правого поддерева.
        // Ищем преемника, спускаясь от корня. Преемник - это самый нижний
        // предок `x`, чей левый дочерний узел также является предком `x`.
        BinNode<Integer> successor = null;
        BinNode<Integer> current = root;
        while (current != null) {
            if (x.getValue() < current.getValue()) {
                // Если `x` меньше текущего узла, то `current` может быть преемником.
                // Запоминаем его и идем влево, чтобы найти более близкого (меньшего) преемника.
                successor = current;
                current = current.getLeft();
            } else if (x.getValue() > current.getValue()) {
                // Если `x` больше, то `current` не может быть преемником. Идем вправо.
                current = current.getRight();
            } else {
                // Мы нашли узел `x`. Цикл можно остановить.
                break;
            }
        }
        return successor;
    }





}