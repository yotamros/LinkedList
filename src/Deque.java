import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {
    
    Node first = null;
    Node last = null;
    
    private class Node {
        Item item;
        Node next;
        Node prev;
    }

    /**
     * Construct an empty deque
     */
   public Deque() {
       first = new Node();
       last = new Node();
       first.next = last;
       last.prev = first;
       }
   
   /**
    * Is the deque empty?
    * @return
    */
   public boolean isEmpty() {
       return false;
   }
   
   /**
    * Return the number of items on the deque
    * @return
    */
   public int size() {
    return 0;
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