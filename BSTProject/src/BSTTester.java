/*
 * Name: Meade Havenstein
 * Date: 2/24/26
 * Class Period: 4
 * TODO: Program Description: 
 */

 import java.lang.Comparable;

 public class BSTTester {
   public static void main(String[] args)
   {
    BST newBST = new BST();
    newBST.add("g");
    newBST.add("r");
    newBST.add("k");
    newBST.add("c");
    newBST.add("g");
    newBST.add("m");
    newBST.add("y");
    newBST.add("z");
    newBST.add("x");
    System.out.println("\n In-Order Traversal:");
    newBST.printInOrder();
    System.out.println("\n Pre-Order Traversal:");
    newBST.printPreOrder();
    System.out.println("\n Post-Order Traversal:");
    newBST.printPostOrder();
   }
 }