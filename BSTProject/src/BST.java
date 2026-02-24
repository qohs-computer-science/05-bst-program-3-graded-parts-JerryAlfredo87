import java.lang.Comparable;

public class BST implements BSTInterface
{
    TreeNode root;
    public BST()
    {
        root = new TreeNode(null);
    }
    public void add(Comparable val)
    {
        if (root != null)
        {
            addHelper(val, root);
        }
        else
        {
            root = new TreeNode(val);
        }
    }
    public void addHelper(Comparable val, TreeNode subroot)
    {
        if(val.compareTo(subroot) <= 0)
        {
            if(subroot.getLeft() != null)
            {
                addHelper(val, subroot.getLeft());
            }
            else
            {
                subroot.setLeft(new TreeNode(val));
            }
        }
        else
        {
            if(subroot.getRight() != null)
            {
                addHelper(val, subroot.getRight());
            }
            else
            {
                subroot.setRight(new TreeNode(val));
            }
        }
    }
    /*public void printInOrder()
    {

    }
    public void printPreOrder()
    {
        
    }
    public void printPostOrder()
    {
        
    }*/
}