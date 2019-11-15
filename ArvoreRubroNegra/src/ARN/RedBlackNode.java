package ARN;

enum Color{RED, BLACK}

public class RedBlackNode <U extends Comparable<U> & Indexable>{
    private Color color;
    private U value;
    private RedBlackNode<U> parent = null;
    private RedBlackNode<U> left = null;
    private RedBlackNode<U> right = null;

    //Métodos Especiais

    public RedBlackNode(U value){
        this.color = Color.RED;
        this.value = value;
    }

    public U getValue() {
        return value;
    }

    public void setValue(U value) {
        this.value = value;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        if(color == Color.BLACK){
            this.color = Color.BLACK;
            return;
        }
        this.color = Color.RED;
    }

    public RedBlackNode<U> getParent() {
        return parent;
    }

    public void setParent(RedBlackNode<U> parent) {
        this.parent = parent;
    }

    public RedBlackNode<U> getLeft() {
        return left;
    }

    public void setLeft(RedBlackNode<U> left) {
        this.left = left;
        left.setParent(this);
    }

    public RedBlackNode<U> getRight() {
        return right;

    }

    public void setRight(RedBlackNode<U> right) {
        this.right = right;
        right.setParent(this);
    }

    public int getBalanceFactor() {
        int leftHeight  = getLeft() == null ? 0 : 1 + getLeft().getHeight();
        int rightHeight = getRight() == null ? 0 : 1 + getRight().getHeight();

        return leftHeight - rightHeight;
    }

    public int getHeight() {
        return 0;
    }

    public void switchColor() {
        if(getColor().equals(Color.RED)){
            setColor(Color.BLACK);
        }else{
            setColor(Color.RED);
        }
    }
}
