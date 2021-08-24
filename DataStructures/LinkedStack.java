package DataStructures;
/**
 * @Author Zhisong Liang (No team)
 */

public final class LinkedStack<T> implements StackInterface<T>
{

    private Node<T> topNode; // References the first node in the chain

//default constructor
    public LinkedStack(){
        topNode = null;
    }

// Implement the unimplemented methods

    /** Adds a new entry to the top of this stack.
     @param newEntry  An object to be added to the stack. */
    public void push(T newEntry){
        Node node = new Node(newEntry, topNode);
        topNode = node;
    }

    /** Removes and returns this stack's top entry.
     @return  The object at the top of the stack.
     @throws  RuntimeException if the stack is empty before the operation. */
    public T pop(){
        T popNode = peek(); // throw EmptyStackException if the stack is empty;
        topNode = topNode.getNextNode();
        return popNode;
    }

    /** Retrieves this stack's top entry.
     @return  The object at the top of the stack.
     @throws  RuntimeException if the stack is empty. */
    public T peek(){
        if(!isEmpty()) {
            return topNode.getData();
        }else{
            throw new RuntimeException("The stack is empty");
        }
    }

    /** Detects whether this stack is empty.
     @return  True if the stack is empty. */
    public boolean isEmpty(){
        return topNode == null;
    }

    /** Removes all entries from this stack. */
    public void clear(){
        topNode = null;
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

    }
}// end LinkedStack
