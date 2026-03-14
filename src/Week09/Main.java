package Week09;

public class Main {
    static void main() {
        Alpha a1 = new Beta();
        Alpha a2 = new Gamma();
        Beta b1 = new Delta();

        // Alpha
        //     |
        //  Beta
        //   _______
        // |        |
        //Gamma     Delta
/*
        // Alpha
        //     |
        //   _______
        // |        |
        //Gamma     Beta
        //            |
        //          Delta
*/
        Beta b2 = (Beta) new Gamma();

        /*

        Beta b3 = (Beta)a1;
        Gamma g1 = (Gamma)a2;
        Gamma g2 = (Gamma)b1;

         */


        Parent p1 = new Parent("P");

        Child c1 = new Child("C");

        Parent p2 = new Child("X");

        System.out.println(p1);
        System.out.println(c1);
        System.out.println(p2);

        // Parent {tag=P, id=1,live=3}
        // Child {tag=C, id=2,live=3, ChildNo=1}
        // Child {tag=X, id=3,live=3,  ChildNo=2}
        Parent p3 = new Child("XxX");

        System.out.println(p1);
        System.out.println(c1);
        System.out.println(p2);
        System.out.println(p3);

    }


}

class SmartUnit extends BaseUnit {
    private int level;

    public SmartUnit(String name) {
        super(name, 10);
        this.level = 1;

    }

    public SmartUnit(String name, int basePower, int level) {
        super(name, basePower);
        this.level = level;
    }

    public int power() {
        return super.power() + bonus(level);
    }

    private int bonus(int level) {
        return level * 3;
    }

    public void upgrade() {
        this.level++;
        setPower(getPower() + 2);
        onUpgrade(level);

    }


    @Override
    public String toString() {
        return "SmartUnit{" +
                "level=" + level +
                '}';
    }
}

class BaseUnit {
    private int power;

    protected void onUpgrade(int level) {
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public BaseUnit(String name, int basePower) {
    }

    public int power() {
        return 1;
    }
}

class Parent {
    public static int counter = 0;
    protected static int live = 0;
    protected String tag;
    protected int id;


    public Parent() {
        this.id = ++counter;
        live++;
    }

    public Parent(String tag) {
        this.tag = tag;
        this();
    }

    @Override
    public String toString() {
        return "Parent{" +
                "tag='" + tag + '\'' +
                ", id=" + id +
                ", live=" + live +
                '}';
    }
}

class Child extends Parent {

    public static int counter = 0;
    protected int childNo;

    public Child() {
        this.childNo = ++counter;
    }

    public Child(String tag) {
        super(tag);
        this.childNo = ++counter;
    }

    @Override
    public String toString() {
        return "Child{" +

                ", tag='" + tag + '\'' +
                ", id=" + id +
                ", live=" + live + " childNo=" + childNo + " " +
                '}';
    }
}
