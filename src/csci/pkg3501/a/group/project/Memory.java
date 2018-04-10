package csci.pkg3501.a.group.project;

public class Memory {

    private int cap; //capacity
    private int[] cell;
    

    //constructor
    public Memory(int _cap) {
        cell = new int[cap];
    }

    public int read(int _address) {
        return cell[_address];
    }

//    public void setMemory(Memory _memory) {
//        memory = _memory;
//    }

    public void write(int _address, int _data) {
        cell[_address] = _data;
    }

    public void dump() {
        
        for (int i = 0; i < cell.length; i++) {
            cell[i] = -1; //-1 is how I'm defining an empty cell
        }
        
        System.out.println("\033[32m" +"Memory dump complete.");
    }
}
