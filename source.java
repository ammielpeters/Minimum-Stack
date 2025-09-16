import java.util.Scanner;
import java.util.Stack;

/**
 * A stack that supports push, pop, top, and retrieving the minimum element in constant time.
 */
class MinStack {
    // The main stack to store all elements
    private Stack<Integer> mainStack;
    
    // A secondary stack to keep track of the minimum values
    private Stack<Integer> minStack;

    /**
     * Constructor to initialize the stacks.
     */
    public MinStack() {
        mainStack = new Stack<>();
        minStack = new Stack<>();
    }

    /**
     * Pushes an element onto the stack.
     * @param val The integer value to be pushed.
     */
    public void push(int val) {
        // Always push the new value onto the main stack
        mainStack.push(val);

        // If the minStack is empty or the new value is less than or equal to
        // the current minimum, push it onto the minStack as the new minimum.
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
        System.out.println("Pushed " + val);
    }

    /**
     * Removes the element on the top of the stack.
     */
    public void pop() {
        if (mainStack.isEmpty()) {
            System.out.println("Cannot pop from an empty stack.");
            return;
        }

        // If the element being popped is the current minimum,
        // we must also pop it from the minStack to reveal the previous minimum.
        // We use .equals() because comparing Integer objects with '==' for values > 127 can be tricky.
        if (mainStack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        
        // Always pop from the main stack
        int poppedValue = mainStack.pop();
        System.out.println("Popped " + poppedValue);
    }

    /**
     * Gets the top element of the stack.
     * @return The top element, or -1 if the stack is empty.
     */
    public int top() {
        if (mainStack.isEmpty()) {
            System.out.println("Stack is empty.");
            return -1; // Or some other indicator for empty
        }
        return mainStack.peek();
    }

    /**
     * Retrieves the minimum element in the stack.
     * @return The minimum element, or -1 if the stack is empty.
     */
    public int getMin() {
        if (minStack.isEmpty()) {
            System.out.println("Stack is empty.");
            return -1; // Or some other indicator for empty
        }
        return minStack.peek();
    }
}


// Main class to run the interactive program
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MinStack minStack = new MinStack();

        System.out.println("--- Minimum Stack Program ---");
        System.out.println("Commands: push [num], pop, top, getMin, exit");

        while (true) {
            System.out.print("> ");
            String command = scanner.next();

            if (command.equalsIgnoreCase("push")) {
                if (scanner.hasNextInt()) {
                    int val = scanner.nextInt();
                    minStack.push(val);
                } else {
                    System.out.println("Invalid number. Please enter a valid integer for push.");
                    scanner.next(); // Clear the invalid input
                }
            } else if (command.equalsIgnoreCase("pop")) {
                minStack.pop();
            } else if (command.equalsIgnoreCase("top")) {
                int topVal = minStack.top();
                if (topVal != -1) { // Assuming -1 indicates empty
                    System.out.println("Top element: " + topVal);
                }
            } else if (command.equalsIgnoreCase("getMin")) {
                int minVal = minStack.getMin();
                if (minVal != -1) {
                    System.out.println("Minimum element: " + minVal);
                }
            } else if (command.equalsIgnoreCase("exit")) {
                System.out.println("Exiting program.");
                break;
            } else {
                System.out.println("Unknown command. Please use: push, pop, top, getMin, exit");
            }
        }
        scanner.close();
    }
}
