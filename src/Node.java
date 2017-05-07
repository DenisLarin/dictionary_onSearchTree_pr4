import java.util.LinkedList;

/**
 * Created by denis__larin on 07.05.17.
 */
public class Node<E,X extends Comparable<X>> implements Comparable<X>{
    LinkedList<E> data = new LinkedList<>();
    X key;
    Node<E,X> rightChild;
    Node<E,X> leftChild;

    public Node() {
        this.data = null;
        this.key = null;
        rightChild = null;
        leftChild = null;
    }

    public Node(X key, E data) {
        this.data.add(data);
        this.key = key;
    }

    public LinkedList<E> getDataList() {
        return data;
    }

    public void addData(Node<E,X> insertNode) {
        E tempData = insertNode.getDataList().removeLast();//получаю элемет списка значений
        //если такого знаяения нет в списке
        if(!this.data.contains(tempData)){
            data.add(tempData);
        }
        else{
            data.set(data.indexOf(tempData),tempData);
        }
    }
    public X getKey() {
        return key;
    }

    public void setKey(X key) {
        this.key = key;
    }

    public Node<E, X> getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node<E, X> rightChild) {
        this.rightChild = rightChild;
    }

    public Node<E, X> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node<E, X> leftChild) {
        this.leftChild = leftChild;
    }

    @Override
    public int compareTo(X key) {
        return this.getKey().compareTo(key);
    }
    public void printNode(){
        System.out.println("key = " + key + " dataList = " + getDataList().toString() + " ");
    }
}
