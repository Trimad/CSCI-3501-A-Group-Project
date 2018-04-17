package csci.pkg3501.a.group.project;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Instances of this class represent console user interfaces to a simulated
 * computer equipped with a Micro-1 processor.
 */
public class Console {

    /**
     * Representation of the keyboard
     */
    private Scanner kbd = new Scanner(System.in);
    /**
     * Main memory of the simulated computer
     */
    private Memory memory;
    /**
     * Processor of the simulated computer
     */
    private Processor cpu;

    /**
     * Constructs a memory with specified number of cells, and constructs an
     * associated processor.
     *
     * @param cap the specified amount of memory
     */
    public Console(int cap) {
        memory = new Memory(cap);
        cpu = new Processor();
        cpu.setMemory(memory);
        //memory.setMemory(memory);
    }

    /**
     * Constructs a processor and a memory with 256 cells
     */
    public Console() {
        this(256);
    }

    /**
     * Loads hexadecimal numbers stored in fName into memory starting at address
     * 0. Resets PC to 0.
     *
     * @param fName the name of a file containing hex numbers
     */
    public void load(String fName) {
        cpu.reset();
        try {
            File f = new File(fName);
            Scanner scan = new Scanner(f);
            int address = 0;

            while (scan.hasNext()) {

                boolean assembly = false;
                String line = scan.nextLine();
                byte[] lineBytes;

                if (!line.isEmpty()) {
                    lineBytes = line.getBytes();
                    for (int i = 0; i < lineBytes.length; i++) {
                        if (Character.digit(lineBytes[i], 16) == -1) {
                            assembly = true;
                        }
                    }
                } else {
                    break;
                }

                String[] temp = line.split(" ");

                if (!assembly) {
                    memory.write(address++, Integer.parseInt(line, 16));
                } else {
                    int output = 0;

                    switch (temp[0]) {
                        case "halt":
                            //Do nothing
                            break;
                        case "load":
                            output += getPAB(100, temp);
                            break;
                        case "loadc":
                            output += getPAB(200, temp);
                            break;
                        case "store":
                            output += getPAB(300, temp);
                            break;
                        case "add":
                            output += getPAB(400, temp);
                            break;
                        case "mul":
                            output += getPAB(500, temp);
                            break;
                        case "sub":
                            output += getPAB(600, temp);
                            break;
                        case "div":
                            output += getPAB(700, temp);
                            break;
                        case "and":
                            output += getPAB(800, temp);
                            break;
                        case "or":
                            output += getPAB(900, temp);
                            break;
                        case "not":
                            output += getPAB(1000, temp);
                            break;
                        case "lshift":
                            output += getPAB(1100, temp);
                            break;
                        case "rshift":
                            output += getPAB(1200, temp);
                            break;
                        case "bwc":
                            output += getPAB(1300, temp);
                            break;
                        case "bwd":
                            output += getPAB(1400, temp);
                            break;
                        case "if":
                            output += getPAB(1500, temp);
                            break;
                    }

                    String outString = Integer.toString(output);
                    memory.write(address++, Integer.parseInt(outString, 16));
                }

            }

            cpu.setPC(0);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    int getPAB(int _p, String[] _temp) {
        int pab = _p;
        for (int i = 1; i < _temp.length; i++) {
            pab += Integer.valueOf(String.valueOf(_temp[i]), 16) * 100 >> i;
        }
        return pab;
    }

    /**
     * Displays synopsis of all commands in the console window
     */
    public void help() {
        System.out.println("load fileName \t loads hex memory image into memory");
        System.out.println("memory \t\t dumps memory to console");
        System.out.println("registers \t dumps registers to console");
        System.out.println("step N \t\t executes next N instructions or until halt");
        System.out.println("help \t\t displays this message");
        System.out.println("quit \t\t terminate console");
    }

    /**
     * This is the read-execute-print loop for the console. It perpetually
     *
     * 1) displays a prompt 2) reads a command from the keyboard 3) executes the
     * command 4) displays the result Commands include quit, help, load (a
     * program from a file), memory (display contents of memory), registers
     * (display contents of registers), and step N (execute the next N
     * instructions.
     */
    public void controlLoop() throws FileNotFoundException {
        System.out.println("type \"help\" for commands");
        while (true) {
            System.out.print("-> ");
            String cmmd = kbd.next();
            if (cmmd.equals("quit")) {
                break;
            } else if (cmmd.equals("help")) {
                help();
            } else if (cmmd.equals("load")) {
                load(kbd.next());
                System.out.println("done");
            } else if (cmmd.equals("memory")) {
                memory.dump();
            } else if (cmmd.equals("registers")) {
                cpu.dump();
            } else if (cmmd.equals("step")) {
                int num;
                if (!kbd.hasNextInt()) {
                    num = 0;
                    kbd.nextLine();
                    System.out.println("invalid number of steps");
                } else {
                    num = kbd.nextInt();
                    boolean halt = false;
                    for (int i = 0; i < num && !halt; i++) {
                        if (!halt) {
                            halt = cpu.step();
                        }
                        if (halt) {
                            System.out.println("program terminated");
                            break;
                        }
                    }
                    System.out.println("done");
                }
            } else {
                System.out.println("unrecognized command: " + cmmd);
                if (kbd.hasNext()) {
                    kbd.nextLine();
                }
            }
        }
        System.out.println("bye");
    }

}
