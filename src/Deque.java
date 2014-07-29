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
       return size == 0;
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
       Node node = new Node();
       node.item = item;
       node.next = first;
       first = node;
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
       Node node = new Node();
       node.item = item;
       node.prev = last;
       last = node;
       size++;
   }
   
   /**
    * Delete and return the item at the front
    * @return
    */
   public Item removeFirst() {
       if (size == 0) {
           throw new java.util.NoSuchElementException("Can't remove. The list is empty");
       }
       Node copyOfFirst = first;
       first = first.next;
       size--;
       return copyOfFirst.item;
   }
   
   /**
    * Delete and return the item at the end
    * @return
    */
   public Item removeLast() {
       if (size == 0) {
           throw new java.util.NoSuchElementException("Can't remove. The list is empty");
       }
       Node copyOfLast = last;
       Node node = last.prev;
       last = node;
       size--;
       return copyOfLast.item;
   }
   
   /**
    * Return an iterator over items in order from front to end
    * 
    */
   public Iterator<Item> iterator() { 
       return new ListIterator(); 
   }
   
   private class ListIterator implements Iterator<Item> {
       
       private Node current = first;
       
       public boolean hasNext() { 
           return current != null; 
       }
       
       public void remove() { 
           /* not supported */ 
           throw new UnsupportedOperationException("Remove method is not supported");
       } 
       
       public Item next() {
           if ( current.item == null) {
               throw new java.util.NoSuchElementException("There are no more items in the list");
           }
           Item item = current.item;
           current = current.next; 
           return item;
       }
   }
   
   private void printItemsFromBeginning() {
       while (first != null) {
           System.out.println(first.item);
           first = first.next;
       }
   }
   
   private void printItemsFromEnd() {
       while (last != null) {
           System.out.println(last.item);
           last = last.prev;
       }
   }
   
   public static void main(String[] args) {
       Deque<String> test = new Deque<String>();
       test.addFirst("jojo");
       test.addFirst("momo");
       test.printItemsFromEnd();
   }
}