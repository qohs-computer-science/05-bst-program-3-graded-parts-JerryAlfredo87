import java.lang.Comparable;

public class BST implements BSTInterface
{
    TreeNode root;
    public BST()
    {
        root = null;
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
        if(val.compareTo(subroot.getValue()) <= 0)
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
    public void printInOrder()
    {
        if(root != null)
        {
            printInOrderHelper(root.getLeft());
            System.out.println(root.getValue());
            printInOrderHelper(root.getRight());
        }
    }
    public void printInOrderHelper(TreeNode subroot)
    {
        if(subroot != null)
        {
            printInOrderHelper(subroot.getLeft());
            System.out.println(subroot.getValue());
            printInOrderHelper(subroot.getRight());
        }
    }
    public void printPreOrder()
    {
        if(root != null)
        {
            System.out.println(root.getValue());
            printPreOrderHelper(root.getLeft());
            printPreOrderHelper(root.getRight());
        }
    }
    public void printPreOrderHelper(TreeNode subroot)
    {
        if(subroot != null)
        {
            System.out.println(subroot.getValue());
            printPreOrderHelper(subroot.getLeft());
            printPreOrderHelper(subroot.getRight());
        }
    }
    public void printPostOrder()
    {
        if(root != null)
        {
            printPostOrderHelper(root.getLeft());
            printPostOrderHelper(root.getRight());
            System.out.println(root.getValue());
        }
    }
    public void printPostOrderHelper(TreeNode subroot)
    {
        if(subroot != null)
        {
            printPostOrderHelper(subroot.getLeft());
            printPostOrderHelper(subroot.getRight());
            System.out.println(subroot.getValue());
        }
    }
    public boolean delete(Comparable old)
    {
        if(root != null)
        {
            if(root.getValue() == old)
            {
                if(root.getLeft() != null && root.getRight() != null)
                {
                    
                    return true;
                }
                else if(root.getLeft() != null)
                {
                    
                    return true;
                }
                else if(root.getRight() != null)
                {

                    return true;
                }
                else
                {
                    root.setValue(null);
                    return true;
                }
            }
        }
        else
        {
            return false;
        }
    }
    private boolean deleteHelper(Comparable old, TreeNode subroot)
    {
        if(old.compareTo(subroot.getValue()) == 0)
        {
            subroot.setValue()
        }
        else if(old.compareTo(subroot.getValue()) < 0)
        {
            if(subroot.getLeft() != null)
            {
                return deleteHelper(old, subroot.getLeft());
            }
            else
            {
                return false;
            }
        }
        else
        {
            if(subroot.getRight() != null)
            {
                return deleteHelper(old, subroot.getRight());
            }
            else
            {
                return false;
            }
        }
    }
}