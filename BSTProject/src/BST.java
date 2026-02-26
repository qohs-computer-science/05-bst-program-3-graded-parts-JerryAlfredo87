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
            if(root.getValue().equals(old))
            {
                if(root.getLeft() != null && root.getRight() != null)
                {
                    TreeNode temp = root.getLeft();
                    while(temp.getRight() != null)
                    {
                        temp = temp.getRight();
                    }
                    temp.setRight(root.getRight());
                    root = root.getLeft();
                    return true;
                }
                else if(root.getLeft() != null)
                {
                    root = root.getLeft();
                    return true;
                }
                else if(root.getRight() != null)
                {
                    root = root.getRight();
                    return true;
                }
                else
                {
                    root = null;
                    return true;
                }
            }
            else
            {
                if(root.getLeft() != null)
                {
                    return deleteHelper(old, root.getLeft(), root);
                }
                else if(root.getRight() != null)
                {
                    return deleteHelper(old, root.getRight(), root);
                }
                else
                {
                    return false;
                }
            }
        }
        else
        {
            return false;
        }
    }
    private boolean deleteHelper(Comparable old, TreeNode subroot, TreeNode root)
    {
        if(subroot != null)
        {
            if(subroot.getValue().equals(old))
            {
                if(subroot.getLeft() != null && subroot.getRight() != null)
                {
                    if(subroot == root.getLeft())
                    {
                        root.setLeft(subroot.getLeft());
                    }
                    else
                    {
                        root.setRight(subroot.getRight());
                    }
                    TreeNode temp = subroot.getLeft();
                    while(temp.getRight() != null)
                    {
                        temp = temp.getRight();
                    }
                    temp.setRight(subroot.getRight());
                    subroot = subroot.getLeft();
                    return true;
                }
                else if(subroot.getLeft() != null)
                {
                    if(subroot == root.getLeft())
                    {
                        root.setLeft(subroot.getLeft());
                    }
                    else
                    {
                        root.setLeft(subroot.getRight());
                    }
                    subroot = subroot.getLeft();
                    return true;
                }
                else if(subroot.getRight() != null)
                {
                    if(subroot == root.getLeft())
                    {
                        root.setLeft(subroot.getRight());
                    }
                    else
                    {
                        root.setLeft(subroot.getRight());
                    }
                    subroot = subroot.getRight();
                    return true;
                }
                else
                {
                    subroot = null;
                    return true;
                }
            }
            else
            {
                if(subroot.getLeft() != null)
                {
                    return deleteHelper(old, subroot.getLeft(), subroot);
                }
                else if(subroot.getRight() != null)
                {
                    return deleteHelper(old, subroot.getRight(), subroot);
                }
                else
                {
                    return false;
                }
            }
        }
        else
        {
            return false;
        }
    }
}