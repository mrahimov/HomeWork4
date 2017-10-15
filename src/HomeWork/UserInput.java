package HomeWork;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

import static java.lang.System.in;

// Create class to allow user to input data and option to delete, copy, undo or quit.
public class UserInput {
    //create Stack to save data.
    private static Stack<String> stack = new Stack<>();
    private static String delete;
    private static String recentlyAdded;

    static void UserInput() {

        Scanner scanner = new Scanner(in);

        while (true) {
            String user = scanner.nextLine(); // waits for user to input data
            if (user.equalsIgnoreCase("copy")) { //if user inputs "copy"
                if(stack.size() == 10) { // if the stack size is 10, the last element is deleted and the newly copied item inserted
                    stack.pop();
                }
                recentlyAdded = stack.peek();
                stack.push(recentlyAdded);// if stack size is no more than 10 elements, the last element is copied to stack
            } else if (user.equalsIgnoreCase("delete")) { //if user inputs "delete"
                delete = stack.pop(); // deletes a last item in stack
            } else if (user.equalsIgnoreCase("undo")) { //if user inputs "undo"
                if(stack.size() ==10) {//if the stack size is 10, the last element is deleted
                    stack.pop();
                }
                stack.push(delete);// the latest deleted element is put back to stack
                delete = "";
            } else if (user.equalsIgnoreCase("quit")) { //if user inputs "quit"
                System.out.println("The program terminates"); // program terminates
                break;
            } else {
                if(stack.size() == 10) { //if the stack size is 10, the last element is deleted
                    stack.pop();
                }
                stack.push(user);// new string added to stack
            }
            System.out.println(Arrays.toString(stack.toArray()));
        }
    }

}

