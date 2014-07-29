import java.util.Iterator;
import java.util.Random;

public class RandomizedQueue<Item> implements Iterable<Item> {
    
    private Item[] array = (Item[]) new Object[1];
    private int size = 0;
    
    /*
     * Is the queue empty?
     */
    public boolean isEmpty() {
        return ( size == 0 );
    }
    
    /*
     * Return the number of items on the queue
     */
    public int size() {
        return size;
    }
    
    
    /*
     * Add the item
     */
    public void enqueue(Item item) {
        
        if (item == null) {
            throw new NullPointerException("Can't add a null item");
        }
        
        if (array.length == size ) {
            resize(array.length*2);
        }
        
        array[size] = item;
        System.out.println("added " + item + " at " + size);
        size++;
        System.out.println("there are " + size + " items in the array and the "
                + "array length is " + array.length);
    }
    
    private void resize(int i) {
        Item[] copyArray = (Item[]) new Object[i];
        for (int j = 0; j < size; j++) {
            copyArray[j] = array[j];
        }
        array = copyArray;
        System.out.println("Created a new array of size " + i);
    }

    private void printArray() {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
    
    /*
     * Delete and return a random item
     */
    public Item dequeue() {
        
        if (size == 0) {
            throw new java.util.NoSuchElementException("The queue is empty");
        }
        
        Item itemToRemove = array[rand(size)];
        array[rand(size)] = array[size-1];
        array[size-1] = null;
        size--;
        if (size > 0 && size == array.length/4) {
            resize(array.length/2);
        }
        System.out.println("removed " + itemToRemove + " there are " + 
        size + " items and the length is " + array.length);
        return itemToRemove;
    }
    
    private int rand(int size) {
        Random rand = new Random();
        int randNum = rand.nextInt(size);
        return randNum;
    }
    
    /*
     * Return (but do not delete) a random item
     */
    public Item sample() {
        if (size == 0) {
            throw new java.util.NoSuchElementException("The queue is empty");
        }
        
        Item sample = array[rand(size)];
        System.out.println("sample: " + sample);
        return sample;
    }
    
    
    /*
     * (non-Javadoc) Return an independent iterator over items in random order
     * @see java.lang.Iterable#iterator()
     */
    public Iterator<Item> iterator() {
        return new QueueIterator();
    }
    
    private class QueueIterator implements Iterator<Item> {
        
        int current = rand(size);
        
        public boolean hasNext() {
            return array[current] == null;
        }

        public Item next() {
            if (array[current] == null) {
                throw new java.util.NoSuchElementException("There are no more items.");
            }
            Item next = array[current];
            current++;
            return next;
        }

        public void remove() { 
            /* not supported */ 
            throw new UnsupportedOperationException("Remove method is not supported");
        } 
        
    }
    
    
    public static void main(String[] args) {
        RandomizedQueue<String> rq = new RandomizedQueue<String>();
        rq.enqueue("jojo");
        rq.enqueue("momo");
        rq.enqueue("toto");
        rq.enqueue("lolo");
        rq.enqueue("vovo");
        rq.printArray();
        rq.dequeue();
        rq.dequeue();
        rq.dequeue();
        rq.sample();
    }
}