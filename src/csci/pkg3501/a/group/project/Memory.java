package csci.pkg3501.a.group.project;

public class Memory {

    int cap; //capacity
    int[] cell; //Memory contains an array of integer cells

    //constructor
    public Memory(int _cap) {

        cell = new int[_cap];
    }
    
    public Memory() {
        this(256);
    }

    public int read(int _address) {
        return cell[_address];
    }

    public void setMemory() {
    }

    public void write(int _address, int _data) {
        cell[_address] = _data;
    }

    public void dump() {

        for (int i = 0; i < cell.length; i++) {
            System.out.println(cell[i]);
        }

    }
}
