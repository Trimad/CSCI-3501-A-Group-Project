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

    //returns true if the program should halt
    public boolean step() {
        IR = memory.read(PC);
        String cmd = Integer.toHexString(IR);
        if (cmd.equals("0")) {
            cmd = "000";
        } else if (cmd.matches("[1-9][1-9]")) {
            cmd = "0" + cmd;
        } else if (cmd.matches("[1-9]")) {
            cmd = "00" + cmd;
        }
        int opcode = getBase10(cmd.substring(0, 1));
        int a = getBase10(cmd.substring(1, 2));
        int b = getBase10(cmd.substring(2));

        if (opcode == 0) { //halt
            return true;
        } else if (opcode == 1) { //load
            reg[a] = memory.read(reg[b]);
        } else if (opcode == 2) { //loadc
            reg[a] = memory.read(++PC);
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
        PC++;
        return false;
    }

    public void dump() {
        for (int i = 0; i < reg.length; i++) {
            System.out.println(reg[i]);
        }

        System.out.println(PC);
        System.out.println(IR);

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
            case "A":
                return 10;
            case "B":
                return 11;
            case "C":
                return 12;
            case "D":
                return 13;
            case "E":
                return 14;
            case "F":
                return 15;
            default:
                return 0;
        }
    }

    private int getBase10FullString(String str) {

        String built = "";

        for (int i = 0; i < str.length(); i++) {
            char temp = str.charAt(i);

            switch (temp) {
                case '1':
                    built += '1';
                    break;
                case '2':
                    built += '2';
                    break;
                case '3':
                    built += '3';
                    break;
                case '4':
                    built += '4';
                    break;
                case '5':
                    built += '5';
                    break;
                case '6':
                    built += '6';
                    break;
                case '7':
                    built += '7';
                    break;
                case '8':
                    built += '8';
                    break;
                case '9':
                    built += '9';
                    break;
                case 'A':
                    built += "10";
                    break;
                case 'B':
                    built += "11";
                    break;
                case 'C':
                    built += "12";
                    break;
                case 'D':
                    built += "13";
                    break;
                case 'E':
                    built += "14";
                    break;
                case 'F':
                    built += "15";
                    break;

            }

        }

        return Integer.parseInt(built);
    }
}
