import java.util.Iterator;
import java.util.Random;

public class RandomizedQueue<Item> implements Iterable<Item> {
    
    private Object[] array = new Object[1];
    private int size = 0;
    
    /*
     * Is the queue empty?
     */
    public boolean isEmpty() {
        return size == 0;
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
        //System.out.println("there are " + size + " items in the array and the "
        //        + "array length is " + array.length);
    }
    
    private void resize(int newSize) {
        Object[] copyArray = new Object[newSize];
        for (int i = 0; i < size; i++) {
            copyArray[i] = array[i];
        }
        array = copyArray;
        //System.out.println("Created a new array of size " + newSize);
    }

    public void printArray() {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
    
    /*
     * Delete and return a random item
     */
    @SuppressWarnings("unchecked")
    public Item dequeue() {
        if (size == 0) {
            throw new java.util.NoSuchElementException("The queue is empty");
        }
        
        int rand = rand(size);
        Item itemToRemove = (Item) array[rand];
        array[rand] = array[size-1];
        array[size-1] = null;
        size--;
        if (size > 0 && size == array.length/4) {
            resize(array.length/2);
        }
        //System.out.println("removed " + itemToRemove + " there are " + 
        //size + " items and the length is " + array.length);
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
    @SuppressWarnings("unchecked")
    public Item sample() {
        if (size == 0) {
            throw new java.util.NoSuchElementException("The queue is empty");
        }
        
        Item sample = (Item) array[rand(size)];
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
        RandomizedQueue<Item> copy = new RandomizedQueue<Item>();
        
        @SuppressWarnings("unchecked")
        public QueueIterator() {
            for (int i = 0; i<size; i++) {
                copy.enqueue((Item) array[i]);
            }
        }
        
        public boolean hasNext() {
            return copy.size != 0;
        }

        public Item next() {
            if (copy.array[rand(copy.size)] == null) {
                throw new java.util.NoSuchElementException("There are no more items.");
            }
            return copy.dequeue();
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
        rq.enqueue("koko");
        rq.enqueue("roro");
        Iterator<String> iterator = rq.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            System.out.println(item);
        }
    }
}