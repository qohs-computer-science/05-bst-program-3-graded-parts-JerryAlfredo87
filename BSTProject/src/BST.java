import java.lang.Comparable;

public class BST implements BSTInterface
{
    TreeNode root;//field
    public BST()
    {
        root = null;
    }//end constructor
    //add
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
    }//end add
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
    }//end add helper
    //prints
    public void printInOrder()
    {
        if(root != null)
        {
            printInOrderHelper(root.getLeft());
            System.out.println(root.getValue());
            printInOrderHelper(root.getRight());
        }
    }//end in order
    public void printInOrderHelper(TreeNode subroot)
    {
        if(subroot != null)
        {
            printInOrderHelper(subroot.getLeft());
            System.out.println(subroot.getValue());
            printInOrderHelper(subroot.getRight());
        }
    }//end in order helper
    public void printPreOrder()
    {
        if(root != null)
        {
            System.out.println(root.getValue());
            printPreOrderHelper(root.getLeft());
            printPreOrderHelper(root.getRight());
        }
    }//end pre order
    public void printPreOrderHelper(TreeNode subroot)
    {
        if(subroot != null)
        {
            System.out.println(subroot.getValue());
            printPreOrderHelper(subroot.getLeft());
            printPreOrderHelper(subroot.getRight());
        }
    }//end pre order helper
    public void printPostOrder()
    {
        if(root != null)
        {
            printPostOrderHelper(root.getLeft());
            printPostOrderHelper(root.getRight());
            System.out.println(root.getValue());
        }
    }//end post order
    public void printPostOrderHelper(TreeNode subroot)
    {
        if(subroot != null)
        {
            printPostOrderHelper(subroot.getLeft());
            printPostOrderHelper(subroot.getRight());
            System.out.println(subroot.getValue());
        }
    }//end post order helper
    //delete
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
                if(root.getLeft() == null && root.getRight() == null)
                {
                    return false;
                }
                else if(old.compareTo(root.getValue()) <= 0)
                {
                    return deleteHelper(old, root.getLeft(), root);
                }
                else
                {
                    return deleteHelper(old, root.getRight(), root);
                }
            }
        }
        else
        {
            return false;
        }
    }//end delete
    private boolean deleteHelper(Comparable old, TreeNode subroot, TreeNode parent)
    {
        if(subroot != null)
        {
            if(subroot.getValue().equals(old))
            {
                if(subroot.getLeft() != null && subroot.getRight() != null)
                {
                    if(subroot == parent.getLeft())
                    {
                        parent.setLeft(subroot.getLeft());
                    }
                    else
                    {
                        parent.setRight(subroot.getLeft());
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
                    if(subroot == parent.getLeft())
                    {
                        parent.setLeft(subroot.getLeft());
                    }
                    else
                    {
                        parent.setRight(subroot.getLeft());
                    }
                    subroot = subroot.getLeft();
                    return true;
                }
                else if(subroot.getRight() != null)
                {
                    if(subroot == parent.getLeft())
                    {
                        parent.setLeft(subroot.getRight());
                    }
                    else
                    {
                        parent.setRight(subroot.getRight());
                    }
                    subroot = subroot.getRight();
                    return true;
                }
                else
                {
                    if(subroot == parent.getLeft())
                    {
                        parent.setLeft(null);
                    }
                    else
                    {
                        parent.setRight(null);
                    }
                    return true;
                }
            }
            else
            {
                if(subroot.getLeft() == null && subroot.getRight() == null)
                {
                    return false;
                }
                else if(old.compareTo(subroot.getValue()) <= 0)
                {
                    return deleteHelper(old, subroot.getLeft(), subroot);
                }
                else
                {
                    return deleteHelper(old, subroot.getRight(), subroot);
                }
            }
        }
        else
        {
            return false;
        }
    }//end delete helper
    public int size()
    {
        int num = 0;
        if(root != null)
        {
            num++;
            if(root.getLeft() != null)
            {
                num = sizeHelper(root.getLeft(), num);
            }
            if(root.getRight() != null)
            {
                num = sizeHelper(root.getRight(), num);
            }
        }
        return num;
    }//end size
    private int sizeHelper(TreeNode subroot, int num)
    {
        if(subroot != null)
        {
            num++;
            if(subroot.getLeft() != null)
            {
                num = sizeHelper(subroot.getLeft(), num);
            }
            if(subroot.getRight() != null)
            {
                num = sizeHelper(subroot.getRight(), num);
            }
        }
        return num;
    }//end size helper
    public boolean isEmpty()
    {
        if(root != null)
        {
            return false;
        }
        return true;
    }//end isEmpty
    public boolean find(Comparable val)
    {
        if(root != null)
        {
            if(root.getValue().compareTo(val) != 0)
            {
                if(root.getValue().compareTo(val) > 0)
                {
                    return findHelper(root.getLeft(), val);
                }
                if(root.getValue().compareTo(val) < 0)
                {
                    return findHelper(root.getRight(), val);
                }
                return false;
            }
            return true;
        }
        return false;
    }//end find
    public boolean findHelper(TreeNode subroot, Comparable val)
    {
        if(subroot != null)
        {
            if(subroot.getValue().compareTo(val) != 0)
            {
                if(subroot.getValue().compareTo(val) > 0)
                {
                    return findHelper(subroot.getLeft(), val);
                }
                if(subroot.getValue().compareTo(val) < 0)
                {
                    return findHelper(subroot.getRight(), val);
                }
                return false;
            }
            return true;
        }
        return false;
    }//end find helper
}//end class