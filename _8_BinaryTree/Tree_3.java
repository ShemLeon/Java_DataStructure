package _7_BinNode;

import unit4.collectionsLib.BinNode;

// .3 כתוב פונקציה שמקבלת עץ בינארי המכיל מספרים שלמים ומחזירה את מספר בנים
//ימניים בעץ.
public class BiinNode_1 {
    public static void main(String[] args) {

    }

    /* Функция для "вывода списка слева направо"
     * @param h начальный узел списка
     * Complexity: O(n), где n - количество узлов в списке
     * Принцип работы:
     * 1. Начинаем с первого узла (h)
     * 2. Пока не дойдем до конца списка:
     *    - Выводим значение текущего узла
     *    - Переходим к следующему узлу (getRight)
     */
    public static void printToRight(BinNode<Integer> h) {
        BinNode<Integer> tmp = null;
        for (tmp = h; tmp != null; tmp = tmp.getRight()) {
            System.out.print(tmp.getValue() + " ");
        }
        System.out.println();
    }

    /* Функция для "вывода списка справа налево"
     * @param h начальный узел списка
     * Complexity: O(n), где n - количество узлов в списке
     * Принцип работы:
     * 1. Доходим до конца списка:
     *    - Идем вправо пока не дойдем до последнего узла
     * 2. Печатаем значения в обратном порядке:
     *    - Выводим значение текущего узла
     *    - Переходим к предыдущему узлу (getLeft)
     */
    public static void printToLeft(BinNode<Integer> h) {
        BinNode<Integer> tmp = null;
        // Доходим до конца списка
        for (tmp = h; tmp != null && tmp.getRight() != null; tmp = tmp.getRight());
        // Печатаем значения справа налево
        for (; tmp != null; tmp = tmp.getLeft()) {
            System.out.print(tmp.getValue() + " ");
        }
        System.out.println();
    }

    /* Функция для "добавления нового узла в двусвязный список"
     * @param h начальный узел списка
     * @param p узел, после которого нужно вставить новый (null для вставки в начало)
     * @param n значение для нового узла
     * Complexity: O(1) - все операции выполняются за постоянное время
     * Принцип работы:
     * 1. Если список пустой (h == null):
     *    - Создаем первый узел со значением n
     * 2. Если вставляем в начало (p == null):
     *    - Создаем новый узел
     *    - Связываем его справа с текущей головой
     *    - Связываем текущую голову слева с новым узлом
     *    - Делаем новый узел головой списка
     * 3. Если вставляем после узла p:
     *    - Создаем новый узел
     *    - Сохраняем ссылку на следующий узел после p
     *    - Связываем p с новым узлом
     *    - Связываем новый узел с сохраненным следующим
     */
    public static void addNode(BinNode<Integer> h, BinNode<Integer> p, int n) {
        if (h == null) {
            h = new BinNode<Integer>(n); // Создаем первый узел
        } else {
            if (p == null) { // Вставка в начало списка
                BinNode<Integer> newNode = new BinNode<Integer>(n);
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
    }
}
