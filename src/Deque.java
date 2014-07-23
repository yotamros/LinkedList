import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {
    
    private Node first;
    private Node last;
    
    private class Node {
        Item item;
        Node next;
        Node prev;
    }
   
   /**
    * Is the deque empty?
    * @return
    */
   public boolean isEmpty() {
       return first == null;
   }
   
   /**
    * Return the number of items on the deque
    * @return
    */
   public int size() {
       int size = 0;
       for (Node n = first; n.next != null; n = n.next) {
           size++;
       }
       return size;
   }
   
   /**
    * Insert the item at the front
    * @param item
    */
   public void addFirst(Item item) {
       
   }
   
   /**
    * Insert the item at the end
    * @param item
    */
   public void addLast(Item item) {
   }
   
   /**
    * Delete and return the item at the front
    * @return
    */
   public Item removeFirst() {
       return null;
   }
   
   /**
    * Delete and return the item at the end
    * @return
    */
   public Item removeLast() {
       return null;
   }
   
   /**
    * Return an iterator over items in order from front to end
    * 
    */
   public Iterator<Item> iterator() {
       return null;
   }
   
   
   public static void main(String[] args) {
   }
   
}