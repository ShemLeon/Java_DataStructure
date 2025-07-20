package _4_Mahsanit;

import unit4.collectionsLib.Stack;

public class Ex14_MerhakGadol {
    // Функция вычисляет максимальное расстояние между двумя одинаковыми элементами в стеке.
    // По условию, каждый элемент появляется ровно дважды.
    // Сложность этого подхода - O(n^2).
    public static int maxDistance(Stack<Integer> st) {
            if (st.isEmpty()) return -1;

            Stack<Integer> temp = new Stack<>();
            Stack<Integer> temp2 = new Stack<>();
            int curDis = 0, maxD = 0, curValue = st.top();

            while (!st.isEmpty()) {
                curValue = st.top();
                temp.push(st.pop());
                while (!st.isEmpty()) {
                    if (curValue != st.top()) {
                        curDis++;
                        temp2.push(st.pop());
                    }
                    if (curValue == st.top()) {
                        if (maxD < curDis) maxD = curDis;
                        curDis = 0;
                        break;
                    }
                }
            }
            while (!temp2.isEmpty()) {
                st.push(temp2.pop());
            }
            return maxD;
        }
    }



            