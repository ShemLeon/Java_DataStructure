package _4_Mahsanit;
import unit4.collectionsLib.Stack;
/*
2. Describe the operations that led to the appearance of the following stack:
а. ABCDE (E at the top of the stack) ------> ABE 
б. ABCG (G at the top of the stack) ------> BG
3. Describe the sequence of operations that will lead to the reversal of the elements in the stack.
 */

public class Mahsanit_d2 {
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

        // Task 3: Reversing the stack
        System.out.println("\nTask 3: Reversing the stack");
        Stack<Character> stack3 = new Stack<>();
        stack3.push('A');
        stack3.push('B');
        stack3.push('C');
        stack3.push('D');
        System.out.println("Initial stack ABCD:");
        printStack(stack3);

        // Assign the result of the reversal
        stack3 = reverseStack(stack3);
        
        System.out.println("Stack after reversal DCBA:");
        printStack(stack3);
    }

    public static void printStack(Stack<Character> stack) {
        // Create a temporary stack to store elements
        Stack<Character> tempStack = new Stack<Character>();

        System.out.println("Stack contents (top to bottom):");

        // Transfer and print elements
        while (!stack.isEmpty()) {
            Character element = stack.pop();
            System.out.println(element);
            tempStack.push(element);
        }

        // Return elements back
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
    }

    // Simplified method for reversing the stack
    public static Stack<Character> reverseStack(Stack<Character> stack) {
        Stack<Character> tempStack = new Stack<>();

        // Simply transfer all elements to a temporary stack
        while (!stack.isEmpty()) {
            tempStack.push(stack.pop());
        }
        
        // Return the reversed stack
        return tempStack;
    }
}
