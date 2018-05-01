
package project4;


public class ArrayStack implements MyStack<Room> {
    private Room[] array = new Room[7];
    private int first;

    @Override
    public void push(Room obj) {
        if(array[6] != null){
            System.out.println("The stack is full.");
        }else{
            first++;
            array[first] = obj;
        }
    }

    @Override
    public Room pop() {
        Room temp = array[first];
        array[first] = null;
        first--;
        return temp;
        
    }

    @Override
    public Room peek() {
        return array[first];
    }

    @Override
    public boolean empty() {
        if(array[0] == null){
            return true;
        }else{
            return false;
        }
        
    }
    
}
