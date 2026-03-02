/*
 * Name: Meade Havenstein
 * Date: 2/24/26
 * Class Period: 4
 * Program Description: Create a BST class that impements multiple BST functions to 
 * alter, traverse, and output tree nodes in a BST. Test code by creating a BST in
 * the tester file and calling functions on it to see it work correctly.
 */

 import java.lang.Comparable;

 public class BSTTester {
   public static void main(String[] args)
   {
    BST newBST = new BST();
    //isEmpty
    System.out.println("\n Is the tree empty: " + newBST.isEmpty());
    //add
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
    //isEmpty
    System.out.println("\n Is the tree empty: " + newBST.isEmpty());
    //delete
    newBST.delete("g");
    newBST.delete("k");
    newBST.delete("z");
    newBST.delete("r");
    System.out.println("\n In-Order Traversal after deletion:");
    newBST.printInOrder();
    System.out.println("\n Pre-Order Traversal after deletion:");
    newBST.printPreOrder();
    System.out.println("\n Post-Order Traversal after deletion:");
    newBST.printPostOrder();
    //size
    System.out.println("\n Size of BST: " + newBST.size());
    //find
    System.out.println("\n a is in list: " + newBST.find("a"));
    System.out.println(" c is in list: " + newBST.find("c"));
    System.out.println(" g is in list: " + newBST.find("g"));
    System.out.println(" m is in list: " + newBST.find("m"));
    System.out.println(" x is in list: " + newBST.find("x"));
    System.out.println(" y is in list: " + newBST.find("y"));
    System.out.println(" z is in list: " + newBST.find("z"));
    //replace
    System.out.println("\n replace m with a: " + newBST.replace("m", "a"));
    System.out.println(" replace m with a: " + newBST.replace("m", "a"));

    System.out.println("\n In-Order Traversal after replacement:");
    newBST.printInOrder();
    System.out.println("\n Pre-Order Traversal after replacement:");
    newBST.printPreOrder();
    System.out.println("\n Post-Order Traversal after replacement:");
    newBST.printPostOrder();
   }
 }