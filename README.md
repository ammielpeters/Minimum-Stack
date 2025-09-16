# Java Minimum Stack Implementation

An interactive, command-line implementation of a **Minimum Stack** in Java. This data structure extends a standard stack with a `getMin()` operation that efficiently retrieves the smallest element in the stack.

The key feature is that all operations—`push`, `pop`, `top`, and `getMin`—are performed in **constant time**, or $O(1)$.

---

## Problem Description 

A standard stack allows you to `push`, `pop`, and view the `top` element. A Minimum Stack adds a crucial fourth operation:

* **`getMin()`**: Retrieves the current minimum element in the entire stack.

The main challenge is to design the stack so that `getMin()` does not require iterating through all the elements, which would be an $O(n)$ operation. This implementation solves that by achieving $O(1)$ time complexity for all functions.

---

## How It Works: The Two-Stack Approach 

This solution uses two stacks to efficiently track the minimum value.

1.  **`mainStack`**: This stack behaves like a normal stack, storing all the integer values that are pushed.
2.  **`minStack`**: This auxiliary stack's only job is to keep a running record of the minimums. The value at the top of `minStack` is always the current minimum for the entire `mainStack`.

### Logic
* **`push(x)`**: The element `x` is always pushed onto `mainStack`. It is only pushed onto `minStack` if it is less than or equal to the current minimum (the top of `minStack`).
* **`pop()`**: When an element is popped from `mainStack`, the code checks if this element is also the current minimum (by comparing it to the top of `minStack`). If it is, the element is also popped from `minStack` to reveal the *previous* minimum.
* **`getMin()`**: This operation is incredibly fast, as it simply returns the element at the top of `minStack`.



---

## How to Run the Code 

The program is interactive and reads commands from the user.

1.  **Save the Code**: Save the source code in a file named `Main.java`.

2.  **Compile**: Open a terminal or command prompt, navigate to the file's directory, and compile it:
    ```bash
    javac Main.java
    ```

3.  **Execute**: Run the compiled program:
    ```bash
    java Main
    ```

4.  **Interact**: The program will then prompt you for commands.

---

## Sample Session 💻

Here is an example of how to interact with the running program:
