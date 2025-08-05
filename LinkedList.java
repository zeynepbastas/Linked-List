public class LinkedList{
  
  //a variable that represents the head node of the linked list
  public static Node header;
  
  public static class Node{
    public int data;
    public Node next;
    
    // a constructor for the Node class that takes an int as an input
    public Node(int data) {
      this.data = data;
      this.next = null;
    }
  }
  
  // a method to reverse a single linked list
  public static void reverse() {
    Node prev = null; // a variable to keep track of the previous node
    Node current = header; // a variable to keep track of the current node
    Node next = null; // a variable to keep track of the next node
    // a while loop to traverse the linked list
    while(current!= null) {
      next = current.next;
      current.next = prev;
      prev = current;
      current = next;
    }
    header=prev;
  }
  
  // a method to print the linked list because their elements cannot be directly printed in the main method
  public static void printLinkedList(Node trav) {
    while (trav != null) {
      System.out.print(trav.data + " ");
      trav = trav.next;
    }
  }
 
    // The main method to see the outputs
    public static void main(String[] args)
    {
      //Trying the example in the question given in the assignment
      LinkedList list = new LinkedList();
      Node n1 = new Node(44);
      Node n2 = new Node(37);
      Node n3 = new Node(56);
      Node n4 = new Node(13);
      Node n5 = new Node(9);
      list.header = n1;
      n1.next = n2;
      n2.next = n3;
      n3.next = n4;
      n4.next = n5;
 
      
      System.out.println("Linked List in the beginning:");
      list.printLinkedList(header);
      list.reverse();
      System.out.println(" ");
      System.out.println("Linked List after the reverse method:");
      list.printLinkedList(header);
    
      
      System.out.println(" ");
      System.out.println(" ");
      System.out.println("----SECOND EXAMPLE----");
        
      //Trying the numbers given in the example outputs
      //This time, I will try out another way to assign the nodes and put them in order
      LinkedList list2 = new LinkedList();
      list2.header = new Node(5);
      list2.header.next = new Node(6);
      list2.header.next.next = new Node(7);
      list2.header.next.next.next = new Node(8);
      list2.header.next.next.next.next = new Node(9);

      
      System.out.println("Linked List in the beginning:");
      list2.printLinkedList(header);
      list2.reverse();
      System.out.println(" ");
      System.out.println("Linked List after the reverse method:");
      list2.printLinkedList(header);
    }
}