package Week02;

public class Main {

    public static void main(String[] args) {
        // ----------------- 0 ------------
        BinNode<Integer> root = new BinNode<>(17);
        // ----------------- 1 ------------
        root.setLeft(new BinNode<>(36));
        root.setRight(new BinNode<>(7));
        // ----------------- 2 ------------
        root.getLeft().setLeft(new BinNode<>(12));

        root.getRight().setLeft(new BinNode<>(28));
        root.getRight().setRight(new BinNode<>(0));
        // ----------------- 3 ------------
        root.getLeft().getLeft().setLeft(new BinNode<>(10));
        root.getLeft().getLeft().setRight(new BinNode<>(42));

        root.getRight().getRight().setRight(new BinNode<>(1));
        // ----------------- 4 ------------
        root.getRight().getRight().getRight().setRight(new BinNode<>(70));


    }
}
