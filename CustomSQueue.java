import java.util.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//Queues and Stacks Encupsulation: Users have access to the top element in Stacks or the front and rear in Queues
// In this implementation, there are places where the code traverses through the stack to be able to bring the implementation to life
//Trying to go from First In Last Out to First In First Out
//This basically uses an exchange of elements between two stacks to act as a queue

// A class to demonstrate that stacks can be modified to act like queues
public class CustomSQueue {
  private Stack<Integer> stack1;
  private Stack<Integer> stack2;
  
  // constructor that takes two Stack<Integer> objects as input
  public CustomSQueue(Stack<Integer> stack1, Stack<Integer> stack2) {
    this.stack1 = stack1;
    this.stack2 = stack2;
  }
  
  public boolean add(Integer i) {
    
    //if the stack is full, we cannot add a new element but the isEmpty() method does not work so I left it as a comment. It gives an exception in that case:
    /**if (stack1.isFull()){
      throw new IllegalStateException("Trying to add to a full CustomSQueue");
    }**/
    
    stack1.push(i); //adds to the top of the stack but it won't be the first one to be deleted
    
    //A different way of doing it if you think from the other direction but I did it based on the example output you gave us
    //This was the element is added to the bottom of the stack. This is how it is discussed in the lecture slides but it does not fit the examples given in the assignment
    //so I will just leave it as a comment
    //It works by pushing the elments in stack1 to stack2 and then pushing the item to stack 1 and bringing the others back in
    /**while(stack1.empty()==false){
      stack2.push(stack1.pop());
    }
    stack1.push(i);
    while(stack2.empty()==false){
      stack1.push(stack2.pop());
    }**/
    return true;
  }
  
  // a method to remove the head of the queue, which is the bottom of the stack
  public Integer poll(){
    //it throws an exception if trying to remove from an empty CustomSQueue
    if (stack1.empty()){
      throw new RuntimeException("Trying to remove from empty CustomSQueue");
    }
    
    while(stack1.empty()==false){
      stack2.push(stack1.pop());
    }
    Integer removed = stack2.pop();
    while(stack2.empty()==false){
      stack1.push(stack2.pop());
    }
    return removed;
  }
  
  public static void main(String[] args) {
    
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    stack1.push(5);
    stack1.push(6);
    stack1.push(7);
    stack1.push(8);
    stack1.push(9);
    
    
    System.out.println(stack1.toString());
    System.out.println("Should be empty: " + stack2.toString());
    //stack2 remains empty for us to transfer elements in it
    
    CustomSQueue custom = new CustomSQueue(stack1,stack2);
    
    System.out.println("poll(): "+ custom.poll());
    
    System.out.println("poll(): "+ custom.poll());
    
    System.out.println(custom.add(2));
    
    System.out.println(stack1);
    
    System.out.println(custom.poll());
    System.out.println(custom.poll());
    System.out.println(custom.poll());
    System.out.println(custom.poll());
    
    System.out.println("The final one should be empty: " + stack1);
    System.out.println("Should throw an extension because it's empty: " + custom.poll());
  }
}
    
    
  