public class TreeTest {
    public static void main(String[] args) {
        MyBinaryTree tree1 = new MyBinaryTree(5);
        tree1.insertData(2);
        tree1.insertData(7);
        tree1.insertData(10);
        tree1.insertData(15);
        tree1.insertData(20);
        tree1.insertData(12);
        System.out.println("Pré delete.");
        tree1.print2D();

        tree1.deleteData(15);
        System.out.println(tree1.searchTree(15));
        
        System.out.println("Pós delete.");
        tree1.print2D();

    }
}
