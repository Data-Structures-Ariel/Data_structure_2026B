package Week04;

import java.util.*;

public class Mahat_Summer_2024A {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    static Random rd = new Random();
    static Scanner in = new Scanner(System.in);

    static void main() {
        while (true) {
            System.out.println("Enter q number");
            int num = in.nextInt();
            switch (num) {
                case 1:
                    Stack<Integer> st = new Stack<>() {{
                        int size = rd.nextInt(15);
                        for (int i = 0; i < size; i++) {
                            push(rd.nextInt(50));
                        }
                    }};
                    System.out.println(st);
                    boolean bool = isBalanced(st);
                    System.out.println(bool);
                    System.out.println(st);
                    break;
                case 2:
                    Queue<Integer> qu = new LinkedList<>() {{
                        int size = rd.nextInt(15);
                        for (int i = 0; i < size; i++) {
                            add(rd.nextInt(50));
                        }
                    }};
                    int x = rd.nextInt(500), y = rd.nextInt(500);
                    System.out.println(qu);
                    func(qu, x, y);
                    System.out.println(qu);
                    break;
                case 3:
                    break;
                case 4:
                    Vehicle v1 = new Vehicle();
                    Vehicle v2 = new Car();
                    Vehicle v3 = new Truck();
                    Car c = new Truck();

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

    public static Motorcycle maxSpeed(Vehicle[] arr) {

        double max = 0;
        Motorcycle maxim = null;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] instanceof Motorcycle) {
                if (max < arr[i].speed()) {
                    maxim = (Motorcycle) arr[i];
                    max = maxim.speed();
                }
            }
        }

        return (max == 0) ? null : maxim;
    }

    public static void func(Queue<Integer> qu, int x, int y) {
        if (qu == null)
            return;

        Queue<Integer> qTemp = new LinkedList<>();
        int size = 0;

        while (!qu.isEmpty()) {
            qTemp.add((qu.poll()));
            size++;
        }
        int mid = size / 2 - 1;
        for (int i = 0; i < mid; i++) {
            qu.add(qTemp.poll());
        }
        if (size % 2 == 0) {
            qu.add(x);
            qu.add(y);
            qTemp.poll();
            qTemp.poll();
        } else {
            int rand = rd.nextInt(x, y) + 1;
            qu.add(qTemp.poll());
            qTemp.poll();
            qu.add(rand);
        }
        while (!qTemp.isEmpty())
            qu.add((qTemp.poll()));

    }

    //O(n) - סיבוכיות לינארית כיווןן ואנחנו עוברים על כל איבר לכל היותר פעמיים
    public static boolean isBalanced(Stack<Integer> st) {

        if (st == null)
            return true;

        int pos = 0, neg = 0, zero = 0;
        Stack<Integer> stTemp = new Stack<>();


        while (!st.isEmpty())
            stTemp.push(st.pop());

        while (!stTemp.isEmpty()) {
            int num = stTemp.pop();
            if (num > 0) pos++;
            if (num < 0) neg++;
            if (num == 0) zero++;
            st.push(num);
        }
        return pos == neg && pos == zero;
    }


}


// Base class
class Vehicle {

    public double speed() {
        return 0;
    }

    public void displayInfo() {
        System.out.println("This is a vehicle.");
    }
}

// Derived class Bus
class Bus extends Vehicle {
    @Override
    public void displayInfo() {
        System.out.println("This is a bus.");
    }
}

// Derived class Motorcycle
class Motorcycle extends Vehicle {
    @Override
    public void displayInfo() {
        System.out.println("This is a motorcycle.");
    }
}

// Derived class Car (which is further subclassed)
class Car extends Vehicle {
    @Override
    public void displayInfo() {
        System.out.println("This is a car.");
    }
}

// Derived class Truck
class Truck extends Car {
    @Override
    public void displayInfo() {
        System.out.println("This is a truck.");
    }
}

// Derived class RacingCar
class RacingCar extends Car {
    @Override
    public void displayInfo() {
        System.out.println("This is a racing car.");
    }
}



