package csci.pkg3501.a.group.project;

public class Memory {

    int cap; //capacity
    int[] cell; //Memory contains an array of integer cells

    //constructor
    Memory(int _cap) {
        cell = new int[_cap];
    }

    int read(int _address) {
        return 0;
    }

    void write(int _address, int _data) {
        cell[_address] = _data;

    }

    void dump() {

        for (int i = 0; i < cell.length; i++) {
            //String formatted = String.format("%03d", i);
            //System.out.println(formatted + ": " +cell[i]);
            
            System.out.println(cell[i]);
        }

    }
}
