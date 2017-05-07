import java.util.ArrayList;

/**
 * Created by denis__larin on 07.05.17.
 */
public class Main {
    public static void main(String[] args) {
        BinarySearchTree<Integer,String> binarySearchTree = new BinarySearchTree<>();
        binarySearchTree.insert(8,"8");
        binarySearchTree.insert(5,"5");
        binarySearchTree.insert(12,"12");
        binarySearchTree.insert(3,"3");
        binarySearchTree.insert(7,"7");
        binarySearchTree.insert(10,"10");
        binarySearchTree.insert(15,"15");

        binarySearchTree.insert(8,"81");
        binarySearchTree.insert(5,"51");
        binarySearchTree.insert(12,"121");
        binarySearchTree.insert(3,"31");
        binarySearchTree.insert(7,"71");
        binarySearchTree.insert(10,"101");
        binarySearchTree.insert(15,"151");

        binarySearchTree.insert(8,"8");
        binarySearchTree.insert(5,"5");
        binarySearchTree.insert(12,"12");
        binarySearchTree.insert(3,"3");
        binarySearchTree.insert(7,"7");
        binarySearchTree.insert(10,"10");
        binarySearchTree.insert(15,"1");
        System.out.println("inorder");
        binarySearchTree.inOrder();
        System.out.println("postOrder");
        binarySearchTree.postOrder();
        System.out.println("preorder");
        binarySearchTree.preOrder();

    }
}
