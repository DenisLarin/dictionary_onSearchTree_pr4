import com.sun.glass.events.mac.NpapiEvent;

/**
 * Created by denis__larin on 07.05.17.
 */
public class BinarySearchTree<X extends Comparable<X>,E> {
    private Node<E,X> root;
    private Node<E,X> parent;
    private int size;

    public BinarySearchTree() {
        root = null;
        size = 0;
    }
    public void insert(X key,E data){
        Node<E,X> insertNode = new Node<>(key,data);
        //дерево пустое
        if(root == null){
            root = insertNode;
        }
        //дерево не путое => ищем место, куда добавить новый узел
        else{
            addTo(root,insertNode);
        }
        size++;
    }
    //поиск по дереву вернет узел
    public Node<E,X> search(X key){
        Node<E,X> returnElement = root;
        while (returnElement!=null){
            int compareResult = returnElement.compareTo(key);
            //если ключ текущего элемента больше чем ключ искомого, то идем влево
            if(compareResult>0){
                parent = returnElement;
                returnElement = returnElement.getLeftChild();
            }
            else if(compareResult<0){
                parent = returnElement;
                returnElement = returnElement.getRightChild();
            }
            else
                break;
        }
        return returnElement;
    }

    public Node<E,X> remove(X key) {
        Node<E, X> removeNode = search(key);
        if (removeNode == null) {
            return null;
        }
        if(removeNode.getRightChild() == null) {
            //если удаляем корень то
            if (parent == null) {
                root = removeNode.getLeftChild();
            }
            //если не корень
            else {
                int compareResult = parent.compareTo(removeNode.getKey());
                //ключ родителя больше удаляемого ключа
                if (compareResult > 0) {
                    parent.setLeftChild(removeNode.getLeftChild());
                } else if (compareResult < 0) {
                    parent.setRightChild(removeNode.getRightChild());
                }
            }
        }
        else if (removeNode.getRightChild().getLeftChild() ==null){
            removeNode.getRightChild().setLeftChild(removeNode.getLeftChild());
            if(parent == null){
                root = removeNode.getRightChild();
            }
            else{
                int compareResult = parent.compareTo(removeNode.getKey());
                if(compareResult>0){
                    parent.setLeftChild(removeNode.getRightChild());
                }
                else if (compareResult<0){
                    parent.setRightChild(removeNode.getRightChild());
                }
            }
        }
        else{
            Node<E,X> leftMost = removeNode.getRightChild().getLeftChild();
            Node<E,X> leftMostParent = removeNode.getRightChild();
            while (leftMost.getLeftChild()!=null){
                leftMostParent = leftMost;
                leftMost = leftMost.getLeftChild();
            }
            leftMostParent.setLeftChild(leftMost.getRightChild());
            leftMost.setLeftChild(removeNode.getLeftChild());
            leftMostParent.setRightChild(removeNode.getRightChild());
            if(parent == null){
                root = leftMost;
            }
            else{
                int compareResult = parent.compareTo(removeNode.getKey());
                if(compareResult>0){
                    parent.setLeftChild(leftMost);
                }
                else if (compareResult<0){
                    parent.setRightChild(leftMost );
                }
            }
        }
        size--;
        return removeNode;
    }

    //обход дерева inOrder -- левый=>корень=>правый
    public void inOrder(){
        inOrder(root);
    }

    private void inOrder(Node<E, X> curElement) {
        if(curElement.getLeftChild()!=null){
            inOrder(curElement.getLeftChild());
        }
        curElement.printNode();
        if(curElement.getRightChild()!=null){
            inOrder(curElement.getRightChild());
        }
    }
    public void postOrder(){
        postOrder(root);
    }

    private void postOrder(Node<E, X> curElement)  {
        if(curElement.getLeftChild()!=null){
            postOrder(curElement.getLeftChild());
        }
        if(curElement.getRightChild()!=null){
            postOrder(curElement.getRightChild());
        }
        curElement.printNode();
    }
    public void preOrder(){
        preOrder(root);
    }

    private void preOrder(Node<E, X> curElement) {
        curElement.printNode();
        if(curElement.getLeftChild()!=null){
            preOrder(curElement.getLeftChild());
        }
        if(curElement.getRightChild()!=null){
            preOrder(curElement.getRightChild());
        }
    }

    public int getSize() {
        return size;
    }

    private void addTo(Node<E,X> curNode, Node<E,X> insertNode) {
        //если ключ добавляемгого элемента меньше чем ключ текущего элемента
        if(insertNode.getKey().compareTo(curNode.getKey()) < 0){
            //если нет левого ребенка, то добаляем его
            if(curNode.getLeftChild() == null){
                curNode.setLeftChild(insertNode);
                return;
            }
            else
                addTo(curNode.getLeftChild(),insertNode);
        }
        //заначение добавляемого ключа больше
        else if (insertNode.getKey().compareTo(curNode.getKey()) > 0){
            if(curNode.rightChild == null){
                curNode.setRightChild(insertNode);
                return;
            }
            else
                addTo(curNode.getRightChild(),insertNode);
        }
        //значение ключа равно ключу текущего элемента
        //добавляем данные в список данных внутри Node
        else{
            curNode.addData(insertNode);
            size--;
        }
    }

    public Node<E, X> getRoot() {
        return root;
    }
}
