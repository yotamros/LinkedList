import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {
    
    private Node first;
    private Node last;
    private int size = 0;
    
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
       return size;
   }
   
   /**
    * Insert the item at the front
    * @param item
    */
   public void addFirst(Item item) {
       if (item == null) {
           throw new NullPointerException("Can't add a null object.");
       }
       Node tempFirst = first;
       Node first = (Node) item;
       first.next = tempFirst;
       size++;
   }
   
   /**
    * Insert the item at the end
    * @param item
    */
   public void addLast(Item item) {
       if (item == null) {
           throw new NullPointerException("Can't add a null object.");
       }
       Node tempLast = last;
       Node last = (Node) item;
       last.prev = tempLast;
       size++;
   }
   
   /**
    * Delete and return the item at the front
    * @return
    */
   public Item removeFirst() {
       Item newFirst = (Item) first.next;
       Node first = (Node) newFirst;
       size--;
       return (Item) first;
   }
   
   /**
    * Delete and return the item at the end
    * @return
    */
   public Item removeLast() {
       if (first == null) {
           throw new java.util.NoSuchElementException("Can't remove. The list is empty");
       }
       Item newLast = (Item) last.prev;
       Node last = (Node) newLast;
       size--;
       return (Item) last;
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