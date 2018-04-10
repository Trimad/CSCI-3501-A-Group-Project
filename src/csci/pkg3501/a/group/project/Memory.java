package csci.pkg3501.a.group.project;

public class Memory {

    int cap; //capacity
    int[] cell; //Memory contains an array of integer cells

    //constructor
    Memory(int _cap) {

        cell = new int[cap];
    }

    int read(int _address) {
        return 0;
    }

    void setMemory() {
    }

    void write(int _address, int _data) {
    }

    void dump() {

        for (int i = 0; i < cell.length; i++) {
            System.out.println(cell[i]);
        }

    }
}
