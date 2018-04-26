package csci.pkg3501.a.group.project;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
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
        memory.reset();
        try {
            File f = new File(fName);
            Scanner scan = new Scanner(f);
            int address = 0;

            while (scan.hasNext()) {

                boolean assembly = false;
                String line = scan.nextLine();

                /*
                |* This console iterates through every character in every line
                |* entered. It checks whether or not that character is a
                |* hexadecimal number. If it is not a hecadecimal number,
                |* the console assumes the entire line is an assembly instruction.
                 */
                if (!line.isEmpty()) {
                    byte[] lineBytes = line.getBytes();
                    for (int i = 0; i < lineBytes.length; i++) {
                        if (Character.digit(lineBytes[i], 16) == -1) {
                            assembly = true;
                            break;
                        }
                    }
                } else {
                    break;
                }

                if (assembly) {

                    int output = 0;
                    /*
                    |* The decimal value of the arguments for the op-code
                    |* are calculated first. This involves bit-shifting within a
                    |* for-loop because depending on the op-code, there can be
                    |* 1 or there can be 2 arguments. The for-loop starts
                    |* incrementing at 1 and not 0 to skip the op-code.
                     */
                    String[] pab = line.split(" ");
                    if (pab.length > 1) {
                        output += Integer.parseInt(pab[1]) * 10;
                        if (pab.length == 3) {
                            output += Integer.parseInt(pab[2]);
                        }
                    }
                    switch (pab[0]) {
                        case "halt":
                            //Do nothing
                            break;
                        case "load":
                            output += 100;
                            break;
                        case "loadc":
                            output += 200;
                            break;
                        case "store":
                            output += 300;
                            break;
                        case "add":
                            output += 400;
                            break;
                        case "mul":
                            output += 500;
                            break;
                        case "sub":
                            output += 600;
                            break;
                        case "div":
                            output += 700;
                            break;
                        case "and":
                            output += 800;
                            break;
                        case "or":
                            output += 900;
                            break;
                        case "not":
                            output += 1000;
                            break;
                        case "lshift":
                            output += 1100;
                            break;
                        case "rshift":
                            output += 1200;
                            break;
                        case "bwc":
                            output += 1300;
                            break;
                        case "bwd":
                            output += 1400;
                            break;
                        case "if":
                            output += 1500;
                            break;
                    }

                    //These two lines convert the decimal output to hexadecimal.
                    String toBeWritten = Integer.toString(output);
                    memory.write(address++, Integer.parseInt(toBeWritten, 16));

                } else {
                    memory.write(address++, Integer.parseInt(line, 16));

                }

            }

            cpu.setPC(0);
        } catch (Exception e) {
            System.out.println(e);
        }
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

    public void step(int num) {
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
    
    public Memory getMemory() {
        return memory;
    }
    
    public Processor getProcessor() {
        return cpu;
    }
}
