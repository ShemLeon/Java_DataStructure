package _4_Mahsanit;
import unit4.collectionsLib.Stack;
import static _4_Mahsanit.baza_mahsanit.printStack;

/*
Опишите операции, которые привели к появлению следующего стека:
а. ABCDE (E на вершине стека) ------> ABE
б. ABCG (G на вершине стека) ------> BG
 */

public class Ex4_letters {
    public static void main(String[] args) {
        // Task 2a: ABCDE -> ABE
        System.out.println("Task 2a: ABCDE -> ABE");
        Stack<Character> stack1 = new Stack<>();
        // Create the initial stack ABCDE
        stack1.push('A');
        stack1.push('B');
        stack1.push('C');
        stack1.push('D');
        stack1.push('E');
        System.out.println("Initial stack ABCDE:");
        printStack(stack1);

        // Transform into ABE
        stack1.pop();  // remove E
        stack1.pop();  // remove D
        stack1.pop();  // remove C
        stack1.push('E');  // add E
        System.out.println("After transformation into ABE:");
        printStack(stack1);

        // Task 2b: ABCG -> BG
        System.out.println("\nTask 2b: ABCG -> BG");
        Stack<Character> stack2 = new Stack<>();
        // Create the initial stack ABCG
        stack2.push('A');
        stack2.push('B');
        stack2.push('C');
        stack2.push('G');
        System.out.println("Initial stack ABCG:");
        printStack(stack2);

        // Transform into BG
        stack2.pop();  // remove G
        stack2.pop();  // remove C
        stack2.pop();  // remove B
        stack2.pop();  // remove A
        stack2.push('B');  // add B
        stack2.push('G');  // add G
        System.out.println("After transformation into BG:");
        printStack(stack2);
    }
}
