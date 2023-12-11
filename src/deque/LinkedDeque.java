package deque;

import java.util.ArrayList;
import java.util.List;

public final class LinkedDeque<T> implements DequeInterface<T> {
	private DLNode firstNode; // References node at front of deque
	private DLNode lastNode; // References node at back of deque

	public LinkedDeque()
	{
		firstNode = null;
		lastNode = null;
	} // end default constructor
	private class DLNode
	{
		private T data; // Deque entry
		private DLNode next; // Link to next node
		private DLNode previous; // Link to previous node
		
		private DLNode(DLNode previousNode, T dataPortion, DLNode nextNode) {
            data = dataPortion;
            next = nextNode;
            previous = previousNode;
        }
		
		private void setPreviousNode(DLNode previousNode) {
            previous = previousNode;
        }
		
		private void setNextNode(DLNode nextNode) {
            next = nextNode;
        }
		
		private DLNode getNextNode() {
            return next;
        }

        private DLNode getPreviousNode() {
            return previous;
        }

        private T getData() {
            return data;
        }
	} // end DLNode
	
	public void addToFront(T newEntry)
	{
	   DLNode newNode = new DLNode(null, newEntry, firstNode);

	   if (isEmpty())
	      lastNode = newNode;
	   else
	      firstNode.setPreviousNode(newNode);
	    
	   firstNode = newNode;
	} // end addToFront
	
	public void addToBack(T newEntry)
	{
	   DLNode newNode = new DLNode(lastNode, newEntry, null);

	   if (isEmpty())
	      firstNode = newNode;
	   else
	      lastNode.setNextNode(newNode);
	    
	   lastNode = newNode;
	} // end addToBack
	
	public T removeFront()
	{
	   T front = getFront();  // Might throw EmptyQueueException
	   // Assertion: firstNode != null
	   firstNode = firstNode.getNextNode();

	   if (firstNode == null)
	      lastNode = null;
	   else
	      firstNode.setPreviousNode(null);

	   return front;
	} // end removeFront

	public T removeBack()
	{
	   T back = getBack();  // Might throw EmptyQueueException
	   // Assertion: lastNode != null
	   lastNode = lastNode.getPreviousNode();

	   if (lastNode == null)
	      firstNode = null;
	   else
	      lastNode.setNextNode(null);
	    // end if

	   return back;
	} // end removeBack

	@Override
	public T getFront() {
		if (isEmpty())
            throw new EmptyQueueException();
        else
            return firstNode.getData();
	}

	@Override
	public T getBack() {
		if (isEmpty())
            throw new EmptyQueueException();
        else
            return lastNode.getData();
	}

	@Override
	public boolean isEmpty() {
		return firstNode == null && lastNode == null;
	}

	@Override
	public void clear() {
		firstNode = null;
        lastNode = null;		
	}

	 public List<T> getAll() {
	        List<T> list = new ArrayList<>();
	        DLNode currentNode = firstNode;
	        while (currentNode != null) {
	            list.add(currentNode.getData());
	            currentNode = currentNode.getNextNode();
	        }
	        return list;
	    }
	
} // end LinkedDeque

class EmptyQueueException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EmptyQueueException() {
        super("The deque is empty.");
    }
}


