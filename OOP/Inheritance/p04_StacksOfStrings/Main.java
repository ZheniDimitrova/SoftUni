package Inheritance.p04_StacksOfStrings;

public class Main {
    public static void main(String[] args) {

        StackOfStrings stack = new StackOfStrings();

        stack.push("one");
        stack.push("two");
        stack.push("three");
        stack.push("four");

        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());
    }

}
