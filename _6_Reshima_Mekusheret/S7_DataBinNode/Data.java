package _6_Reshima_Mekusheret.S7_DataBinNode;
import unit4.collectionsLib.Node;

public class Data {
    private boolean free;
    private int size;
    public Data(int size) {
        this.free = true;
        this.size = size;
    }
    public boolean isFree(){return free;}
    public int getSize() {return size;}
    public void setFree(boolean free) {
        this.free = free;
    }
    public void setSize(int size) {
        this.size = size;
    }
}

/*
Можно представить память в компьютере с помощью списка (цепочки узлов),
где каждый элемент в списке содержит размер сегмента памяти (в байтах) и указывает,
свободен ли сегмент или занят. Каждый сегмент представлен с помощью класса Data.**
Другими словами, это описание структуры данных для управления памятью компьютера, где:
- Используется связанный список для представления сегментов памяти
- Каждый узел содержит информацию о размере сегмента и его статусе (свободен/занят)
- Класс `Data` используется для представления каждого сегмента памяти
 */
