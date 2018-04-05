package csci.pkg3501.a.group.project;

public class Memory {

    private int cap; //capacity
    private int[] cell;
    private Memory memory;

    //constructor
    public Memory(int _cap) {
        cell = new int[cap];
    }

    //stub
    public int read(int _address) {
        return memory.cell[_address];
    }

    //stub
    public void setMemory(Memory _memory) {
        memory = _memory;
    }

    //stub
    public void write(int _address, int _data) {
        memory.cell[_address] = _data;
    }

    //stub
    public void dump() {

        for (int i = 0; i < cell.length; i++) {
            System.out.println(cell[i]);
        }

    }
}
