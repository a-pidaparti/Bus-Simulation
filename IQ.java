// Interface for a Queue

//written/provided by dovol002
//used by pidap008

public interface IQ<T> {
  
    /** 
     * Adds an object o to a queue placing it in the order of arrival 
     * relative to other items added to the queue--first in, first out
     * (FIFO) 
     */
    void add(T o);

    /**
     * Removes and returns the object placed in a queue prior
     * to any other items presently in the queue
     */
    T remove();
 

    /**
     * Returns the quantity of items currently present in the queue
     */ 
    int length();


}  // IQ Interface
