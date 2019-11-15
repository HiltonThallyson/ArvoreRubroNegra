package ARN;

public class RedBlackTree<U extends Comparable<U> & Indexable>{
    private RedBlackNode<U> root;

    public void insert(U value){
        if(root == null){
            root = new RedBlackNode<>(value);
            root.setColor(Color.BLACK);
            return;
        }
        root = insert(new RedBlackNode(value), root);
    }
    private RedBlackNode<U> insert(RedBlackNode <U> node, RedBlackNode <U> parent) {
        if (parent == null) {
            return node;
        }

        if (node.getValue().getKey() == parent.getValue().getKey()) {
            parent.setValue(node.getValue());
            return parent;
        }

        if (node.getValue().getKey() < parent.getValue().getKey()) {
            parent.setLeft(insert(node, parent.getLeft()));

        } else {
            parent.setRight(insert(node, parent.getRight()));
        }

        return balance(node, parent);
    }


    private RedBlackNode<U> balance(RedBlackNode<U> node, RedBlackNode<U> parent) {
        //primeiro caso
        if(node.equals(root)){
            node.setColor(Color.BLACK);
            return node;
        }

        //segundo caso
        if(parent.getColor().equals(Color.BLACK)){
            return parent;
        }

        //terceiro caso
        if(parent.getColor().equals(Color.RED)) {
            RedBlackNode<U> uncle;
            if (parent.equals(parent.getParent().getRight())) {
                uncle = parent.getParent().getLeft();
            } else {
                uncle = parent.getParent().getRight();
            }

            if (uncle.getColor().equals(Color.RED)) {
                uncle.switchColor();
                parent.switchColor();
                parent.getParent().switchColor();
                balance(parent.getParent(), parent.getParent().getParent());
                return parent;
            }
        }
        return parent;
    }
}
