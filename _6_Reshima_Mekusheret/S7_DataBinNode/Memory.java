package _6_Reshima_Mekusheret.S7_DataBinNode;
import unit4.collectionsLib.Node;


public class Memory {
    private Node<Data> start;
    public Memory(int totalSize){
        // Конструктор создает один большой свободный блок
        this.start = new Node<Data>(new Data(totalSize));
    }

    public boolean isDangerousState(Node<Data> start){
        // 1. Используем поле класса this.start
        Node<Data> pointer = start;
        if (pointer==null) return false;
        double totalMemorySize = 0;
        double freeMemorySize = 0;
        // 2. Цикл обхода списка
        while (pointer != null){
            int currentSize = pointer.getValue().getSize();
            // 3. Считаем ОБЩИЙ размер памяти
            totalMemorySize += currentSize;
            // Считаем размер только СВОБОДНОЙ памяти
            if (pointer.getValue().isFree())
                freeMemorySize += currentSize;
            pointer = pointer.getNext();
        }
        // Защита от деления на ноль, если память есть, но ее размер 0
        if (totalMemorySize == 0) return false;
        double freeRatio = freeMemorySize / totalMemorySize;
        return freeRatio < 0.1;
    }

    /**
     * Выделяет память по алгоритму First Fit.
     * @param num Размер памяти для выделения.
     * @return true, если выделение успешно, иначе false.
     */
    public boolean firstFit(int num) {
        if (isDangerousState(this.start)) return false;

        Node<Data> current = this.start;
        while (current != null) {
            Data currentData = current.getValue();
            if (currentData.isFree() && currentData.getSize() >= num) {
                int originalSize = currentData.getSize();
                
                if (originalSize > num) {
                    // Блок больше, чем нужно. Разделяем его.
                    // 1. Создаем новый узел для оставшейся свободной памяти.
                    //    Конструктор new Data() по умолчанию делает блок свободным (free=true).
                    Data remainingFreeData = new Data(originalSize - num);
                    Node<Data> newFreeNode = new Node<>(remainingFreeData, current.getNext());
                    
                    // 2. Обновляем размер текущего узла.
                    currentData.setSize(num);

                    // 3. Вставляем новый свободный узел после текущего.
                    current.setNext(newFreeNode);
                }
                
                // Помечаем текущий (подобранный по размеру или уменьшенный) блок как занятый.
                currentData.setFree(false);
                return true;
            }
            current = current.getNext();
        }
        
        // Подходящий блок не найден
        return false;
    }
}
