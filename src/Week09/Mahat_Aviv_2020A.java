package Week09;

import Week01.Node;

import java.util.Scanner;

public class Mahat_Aviv_2020A {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    static Scanner in = new Scanner(System.in);

    static void main() {
        while (true) {
            System.out.println("Enter q number");
            int num = in.nextInt();
            switch (num) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    break;
                case 11:
                    break;
                case 12:
                    break;
                case 13:
                    break;
                case -1:
                    return;
            }
        }
    }
}


 class Data{
    private boolean free;
    private int size;
    //constructor
    public Data (int size) {
        this.free = true;
        this.size = size;
    }
    public boolean isFree() { return free; }
    public int getSize() { return size; }
    public void setFree(boolean free) {this.free = free; }
    public void setSize(int size){ this.size = size;}
}

 class Memory {
    private Node<Data> start;
    public Memory(int totalSize) {
        this.start = new Node<Data>(new Data(totalSize));
    }


    
}