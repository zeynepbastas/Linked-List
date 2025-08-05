import java.util.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//Queues and Stacks Encupsulation: Users have access to the top element in Stacks or the front and rear in Queues
// In this implementation, there are places where the code traverses through the queue to be able to bring the implementation to life
//Trying to go from First In First Out to First In Last Out
//This basically chnages the places of elements in a queue for it to act as a stack

// A class to demonstrate that queues can be modified to act like stacks
public class CustomQStack {
  
  //creating a queue using linked lists
  public static Queue<Integer> q = new LinkedList<Integer>();
  
  //a CustomQStack constructor which takes a Queue<Integer> as the input
  public CustomQStack(Queue<Integer> q){
    this.q = q; //the input is assigned to the static Queue<Integer> object declared in the class
  }
  
  // a class to check if the the CustomQStack object is empty and returns true or false
  public static boolean empty(){
    if(q.size()==0){
      return true; //returns true if the size of the CustomQStack object is 0 which means if it is empty
    }
    else
      return false; // returns false if the size of the CustomQStack object is not 0 which means if it is not empty
  }
  
  //removes the object from the top of the stack and returns that object
  public int pop(){
    int size = q.size();
    //it throws an exception if trying to remove from an empty CustomQStack
    if(size==0){
      throw new RuntimeException("Trying to remove from empty CustomQStack");
    }
    else{
      for (int i=0; i<size-1;i++) {
        //it removes the header of the queue using the poll() method in the Queue class
        int z = q.poll();
        //then they are added to the end of the queue
        q.add(z);
      }
      //after this for loop, the last element in the original queue becomes the header, and the remaining part turns back to original
      //the header of the new queue is removed using the poll() method
      return this.q.poll();
      //this way the last element of the original queue is removed just like the top element of a stack
    }
  }
  
  //a method to add an element in the queue
  //the way queues and stacks work is similar. It is added on top in stacks and it is added from the rear in queues
  public void push(int item){
    q.add(item);
  }
  
  public static void main(String[] args) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(5);
    queue.add(6);
    queue.add(7);
    queue.add(8);
    queue.add(9);
    System.out.println(queue);
    CustomQStack custom = new CustomQStack(queue);
    System.out.println("Should print 9: " + (custom.pop()));
    System.out.println("Should print 8: " + (custom.pop()));
    System.out.println("Should print false: "+ (custom.empty()));
    custom.push(1);
    System.out.println(custom.q);
    System.out.println("Should print 1: "+(custom.pop()));
  }
}