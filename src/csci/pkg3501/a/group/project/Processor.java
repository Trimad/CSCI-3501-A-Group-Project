package csci.pkg3501.a.group.project;

public class Processor {

    private Memory memory;
    private int[] reg = new int[8];
    private int PC; //program counter
    private int IR; //instruction register

    public void setPC(int pc) {
        PC = pc;
    }

    public void setMemory(Memory _memory) {
        memory = _memory;
    }

    public void reset() {
        for (int i = 0; i < reg.length; i++) {
            reg[i] = 0;
        }
        IR = 0;
    }

    //returns true if the program should halt
    public boolean step() {
        IR = memory.read(PC++);
        String cmd = Integer.toHexString(IR);
        if (cmd.equals("0")) {
            cmd = "000";
        } else if (cmd.matches("[1-9A-F][1-9A-F]|[1-9a-f][1-9a-f]")) {
            cmd = "0" + cmd;
        } else if (cmd.matches("[1-9A-F]|[1-9a-f]")) {
            cmd = "00" + cmd;
        }
        int opcode = getBase10(cmd.substring(0, 1));
        int a = getBase10(cmd.substring(1, 2));
        int b = getBase10(cmd.substring(2));

        if (opcode == 0) { //halt
            PC -= 1;
            IR = memory.read(PC - 1);
            return true;
        } else if (opcode == 1) { //load
            reg[a] = memory.read(reg[b]);
        } else if (opcode == 2) { //loadc
            reg[a] = memory.read(PC++);
        } else if (opcode == 3) { //store
            memory.write(reg[a], reg[b]);
        } else if (opcode == 4) { //add
            reg[a] = reg[a] + reg[b];
        } else if (opcode == 5) { //mul
            reg[a] = reg[a] * reg[b];
        } else if (opcode == 6) { //sub
            reg[a] = reg[a] - reg[b];
        } else if (opcode == 7) { //div
            reg[a] = reg[a] / reg[b];
        } else if (opcode == 8) { //and
            if (reg[a] != 0 && reg[b] != 0) {
                reg[a] = 1;
            } else {
                reg[a] = 0;
            }
        } else if (opcode == 9) { //or
            if (reg[a] != 0 || reg[b] != 0) {
                reg[a] = 1;
            } else {
                reg[a] = 0;
            }
        } else if (opcode == 10) { //not
            if (reg[b] != 0) {
                reg[a] = 0;
            } else {
                reg[a] = 1;
            }
        } else if (opcode == 11) { //lshift
            reg[a] = reg[b] << 1;
        } else if (opcode == 12) { //rshift
            reg[a] = reg[b] >> 1;
        } else if (opcode == 13) { //bwc
            reg[a] = reg[a] & reg[b];
        } else if (opcode == 14) { //bwd
            reg[a] = reg[a] | reg[b];
        } else if (opcode == 15) { //if
            if (reg[a] != 0) {
                PC = reg[b];
            }
        }
        return false;
    }

    public void dump() {
        for (int i = 0; i < reg.length; i++) {
            System.out.println("reg[" + i + "]: " + Integer.toHexString(reg[i]));
        }

        System.out.println("PC: " + Integer.toHexString(PC));
        System.out.println("IR: " + Integer.toHexString(IR));

    }

    //converts hex string to base 10 int
    private int getBase10(String c) {
        switch (c) {
            case "1":
                return 1;
            case "2":
                return 2;
            case "3":
                return 3;
            case "4":
                return 4;
            case "5":
                return 5;
            case "6":
                return 6;
            case "7":
                return 7;
            case "8":
                return 8;
            case "9":
                return 9;
            case "a":
                return 10;
            case "b":
                return 11;
            case "c":
                return 12;
            case "d":
                return 13;
            case "e":
                return 14;
            case "f":
                return 15;
            default:
                return 0;
        }
    }
    
    public int[] getRegisters() {
        int[] regs = new int[reg.length+2];
        for (int i = 0; i<reg.length; i++) {
            regs[i] = reg[i];
        }
        regs[reg.length] = PC;
        regs[reg.length+1] = IR;
        return regs;
    }
}
