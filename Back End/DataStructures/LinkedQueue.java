package DataStructures;
/**
 * @Author: Zhisong Liang (no team)
 */

public final class LinkedQueue<T> implements QueueInterface<T>
{
    private Node<T> firstNode;
    private Node<T> lastNode;

    //default constructor
    public LinkedQueue(){
        firstNode = null;
        lastNode = null;
    }

    /** Adds a new entry to the back of this queue.
     @param newEntry  An object to be added. */
    public void enqueue(T newEntry){
        Node newNode = new Node(newEntry, null);

        if (isEmpty()){
            firstNode = newNode;
        }else{
            lastNode.setNextNode((newNode));
        }

        lastNode = newNode;
    }

    /** Removes and returns the entry at the front of this queue.
     @return  The object at the front of the queue.
     @throws  EmptyQueueException if the queue is empty before the operation. */
    public T dequeue(){
        T front = getFront();// throw EmptyQueueException if empty;
        firstNode.setData(null);
        firstNode = firstNode.getNextNode();

        if (firstNode == null){
            lastNode = null;
        }

        return front;
    }

    /**  Retrieves the entry at the front of this queue.
     @return  The object at the front of the queue.
     @throws  EmptyQueueException if the queue is empty. */
    public T getFront(){
        if (isEmpty()){
            throw new EmptyQueueException("The queue is empty.");
        }else{
            return firstNode.getData();
        }
    }

    /** Detects whether this queue is empty.
     @return  True if the queue is empty, or false otherwise. */
    public boolean isEmpty(){
        return firstNode == null && lastNode == null;
    }

    /** Removes all entries from this queue. */
    public void clear(){
        firstNode = null;
        lastNode = null;
    }


    public class Node <T> {
        private T data;
        private Node next;

        // two constructors
        private Node (T dataPortion){
            this (dataPortion, null);
        }

        private Node (T dataPortion, Node next){
            this.data = dataPortion;
            this.next = next;
        }

        // two accessors
        private T getData(){
            return data;
        }

        private Node getNextNode(){
            return next;
        }

        // two mutators
        private void setData(T newData){
            data = newData;
        }

        private void setNextNode(Node nextNode){
            next = nextNode;
        }

    } // end Node
} // end Linkedqueue