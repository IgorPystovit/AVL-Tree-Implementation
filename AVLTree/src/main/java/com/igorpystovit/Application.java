package com.igorpystovit;

public class Application {

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        tree.insert(10);
        tree.insert(15);
        tree.insert(20);
        tree.insert(6);
        tree.insert(7);
        tree.insert(4);
        System.out.println(tree.find(15).get());
    }

}
