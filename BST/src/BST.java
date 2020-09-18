/*
Quan Do
CECS 274 Sec 5
Program Binary Search Tree
May 7, 2020
 */

import java.util.Random;
import java.util.Scanner;

public class BST {
    public static void main(String[] args){
       Scanner scan = new Scanner(System.in);
       boolean loop = true;
       BST newBST = new BST();
       while(loop){
           int input;
           System.out.printf("\n1) Create empty BST\n" +
                   "2) Add a number to the BST\n" +
                   "3) Add 20 random numbers to your BST\n" +
                   "4) Display the BST in sorted order\n" +
                   "5) Show Stats\n");
           input = scan.nextInt();
           if(input == 1) {
               newBST = new BST();
           }
           else if(input == 2){
               System.out.println("Add a number to the BST");
               int num = scan.nextInt();
               newBST.add(num);
           }
           else if(input == 3){
               Random rand = new Random();
               for(int i = 0; i < 20; i++){
                   newBST.add(rand.nextInt(1001)); //between 0 and 1000
               }
           }
           else if(input == 4){
               newBST.display();
               System.out.println();
           }
           else if(input == 5){
               if (newBST.size() == 0 || newBST.root == null){
                   System.out.println("Empty Tree\n");
               }
               else{
                   double avg = newBST.sum() / newBST.size();
                   System.out.printf("1) Root: %d\n" +
                           "2) Tree height: %d\n" +
                           "3) Number of items in the tree: %d\n" +
                           "4) Minimum value: %d\n" +
                           "5) Maximum value: %d\n" +
                           "6) Average value: %d\n", newBST.root.getValue(), newBST.height(), newBST.size(), newBST.min(), newBST.max(), (int)avg);
               }
           }
       }
    }
        private Node root;
        public BST() {
            root = null;
        }
        public void display(){
            if(root == null){
                System.out.println("Empty Tree");
            }
            else{
                display(root);
            }
        }
        private void display(Node n){
            if (n == null){
                return;
            }
            else{
                display(n.lc);
                System.out.print(n.getValue() + ", ");
                display(n.rc);
            }
        }
        public void add(int x){
            if (root == null){
                root = new Node(x);
                System.out.println("New root: " + x);
            }
            else{
                add(root,x);
            }
        }
        private void add(Node n, int x){
            if (x == n.getValue()){
                System.out.println("Duplicate Value "+ x +" will not be added");
            }
            else{
                if(x < n.getValue()){
                    if(n.lc == null){
                        n.lc = new Node(x);
                    }
                    else{
                        add(n.lc, x);
                    }
                }
                else{
                    if(n.rc == null){
                        n.rc = new Node(x);
                    }
                    else{
                        add(n.rc, x);
                    }
                }
            }
        }
        public int size() {   //size of the tree
            if(root == null){
                return 0;
            }
            else{
                return 1 + size(root.lc) + size(root.rc);
            }
        }
        private int size(Node n){
            if (n == null){
                return 0;
            }
            else{
                return 1 + size(n.lc) + size(n.rc);
            }
        }
        public int sum(){
            if(root == null){
                return 0;
            }
            else{
                return root.getValue() + sum(root.lc) + sum(root.rc);
            }
        }
        private int sum(Node n){
            if (n == null){
                return 0;
            }
            else{
                return n.getValue() + sum(n.lc) + sum(n.rc);
            }
        }
        public int height(){
            if(root == null){
                return 0;
            }
            else{
                return 1 + Math.max(height(root.lc), height(root.rc));
            }
        }
        private int height(Node n){
            if(n == null){
                return 0;
            }
            else{
                return 1 + Math.max(height(n.lc), height(n.rc));
            }
         }
        public int min(){
            if(root.lc==null){
                return root.getValue();
            }
            return min(root.lc);
        }
        private int min(Node n){
            if(n.lc==null){
                return n.getValue();
            }
            return min(n.lc);
        }
        public int max(){
            if(root.rc==null){
                return root.getValue();
            }
            return max(root.rc);
        }
        private int max(Node n){
            if(n.rc==null){
            return n.getValue();
            }
            return max(n.rc);
        }
        class Node { //node class start
            private int value;
            private Node lc;
            private Node rc;

            public Node(int x) {
                value = x;
                lc = null;
                rc = null;
            }

            public int getValue() {
                return value;
            }

//            public void setRight(Node n) {
//                rc = n;
//            }
//
//            public void setLeft(Node n) {
//                lc = n;
//            }
//
//            public Node getRight() {
//                return rc;
//            }
//
//            public Node getLeft() {
//                return lc;
//            }
        }
    }
