package _4_Mahsanit;
import unit4.collectionsLib.Stack;

public class Ex6b {

    public static boolean f1(Stack<Integer> stack){
        Stack<Integer> temp = new Stack<Integer>();
        boolean flag = true;
        int prev = stack.pop();
        temp.push(prev);
        while (!stack.isEmpty()){
            int curr = stack.pop();
            temp.push(curr);
            if (curr>prev)
                flag = false;
            prev=curr;
        }
        while (!temp.isEmpty())
            stack.push(temp.pop());
        return flag;
    }

}
