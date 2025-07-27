package _7_BinNode.S7_DataBinNode;
import unit4.collectionsLib.BinNode;


public class Data {
    private boolean free;
    private int size;
    public Data(boolean free, int size) {
        this.free = free;
        this.size = size;
    }
    public boolean isFree(){return free;}
    public int getSize() {return size;}
    public void setSize(int size) {this.size = size;}
    public void setFree(boolean free) {this.free = free;}
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
