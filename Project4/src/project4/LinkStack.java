
package project4;

public class LinkStack implements MyStack<Room>{
    private Room first;
    private Room next;

    @Override
    public void push(Room obj) {
      if(first == null){
          first = obj;
      }else{
          first = obj;
          next = first;
      }
    }

    @Override
    public Room pop() {
        Room temp = first;
        first = next;
        next = null;
        return temp;
    }

    @Override
    public Room peek() {
        return first;
    }

    @Override
    public boolean empty() {
        if(first == null){
            return true;
        }else{
            return false;
        }
    }
    
}
