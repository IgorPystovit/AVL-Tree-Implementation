package com.igorpystovit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AVLTreeTest {

    @Test
    public void removalIn3HeightTree() {
        AVLTree tree = new AVLTree();
        tree.insert(10);
        tree.insert(15);
        tree.insert(20);
        tree.insert(6);
        tree.insert(7);
        tree.insert(4);
        tree.insert(8);
        tree.remove(20);

        assertEquals(7, tree.getRoot().getValue());
        assertEquals(2, tree.getRoot().getHeight());

        //Left subtree
        assertEquals(6, tree
                .getRoot()
                .getLeft()
                .getValue());
        assertEquals(1, tree
                .getRoot()
                .getLeft()
                .getHeight());

        assertEquals(4, tree
                .getRoot()
                .getLeft()
                .getLeft()
                .getValue());
        assertEquals(0, tree
                .getRoot()
                .getLeft()
                .getLeft()
                .getHeight());

        //Right subtree
        assertEquals(10, tree
                .getRoot()
                .getRight()
                .getValue());
        assertEquals(1, tree
                .getRoot()
                .getRight()
                .getHeight());

        assertEquals(15, tree
                .getRoot()
                .getRight()
                .getRight()
                .getValue());
        assertEquals(0, tree
                .getRoot()
                .getRight()
                .getRight()
                .getHeight());

        assertEquals(8, tree
                .getRoot()
                .getRight()
                .getLeft()
                .getValue());
        assertEquals(0, tree
                .getRoot()
                .getRight()
                .getLeft()
                .getHeight());
    }

    @Test
    public void removalWithRightLeftRotation() {
        AVLTree tree = new AVLTree();
        tree.insert(10);
        tree.insert(15);
        tree.insert(6);
        tree.insert(20);
        tree.insert(4);
        tree.insert(9);
        tree.insert(7);

        //Assertions before removal
        //Root test
        assertEquals(10, tree.getRoot().getValue());
        assertEquals(3, tree.getRoot().getHeight());

        //Left subtree test
        assertEquals(6, tree
                .getRoot()
                .getLeft()
                .getValue());
        assertEquals(2, tree
                .getRoot()
                .getLeft()
                .getHeight());
        assertEquals(9, tree
                .getRoot()
                .getLeft()
                .getRight()
                .getValue());
        assertEquals(1, tree
                .getRoot()
                .getLeft()
                .getRight()
                .getHeight());
        assertEquals(7, tree
                .getRoot()
                .getLeft()
                .getRight()
                .getLeft()
                .getValue());
        assertEquals(0, tree
                .getRoot()
                .getLeft()
                .getRight()
                .getLeft()
                .getHeight());
        assertEquals(4, tree
                .getRoot()
                .getLeft()
                .getLeft()
                .getValue());
        assertEquals(0, tree
                .getRoot()
                .getLeft()
                .getLeft()
                .getHeight());
        //Right subtree test
        assertEquals(15, tree
                .getRoot()
                .getRight()
                .getValue());
        assertEquals(1, tree
                .getRoot()
                .getRight()
                .getHeight());
        assertEquals(20, tree
                .getRoot()
                .getRight()
                .getRight()
                .getValue());
        assertEquals(0, tree
                .getRoot()
                .getRight()
                .getRight()
                .getHeight());

        tree.remove(20);

        //Assertions after removal
        //Root test
        assertEquals(9, tree.getRoot().getValue());
        assertEquals(2, tree.getRoot().getHeight());

        //Left subtree

        assertEquals(6, tree
                .getRoot()
                .getLeft()
                .getValue());
        assertEquals(1, tree
                .getRoot()
                .getLeft()
                .getHeight());

        assertEquals(7, tree
                .getRoot()
                .getLeft()
                .getRight()
                .getValue());
        assertEquals(0, tree
                .getRoot()
                .getLeft()
                .getRight()
                .getHeight());

        assertEquals(4, tree
                .getRoot()
                .getLeft()
                .getLeft()
                .getValue());
        assertEquals(0, tree
                .getRoot()
                .getLeft()
                .getLeft()
                .getHeight());

        //Right subtree

        assertEquals(10, tree
                .getRoot()
                .getRight()
                .getValue());
        assertEquals(1, tree
                .getRoot()
                .getRight()
                .getHeight());

        assertEquals(15, tree
                .getRoot()
                .getRight()
                .getRight()
                .getValue());
        assertEquals(0, tree
                .getRoot()
                .getRight()
                .getRight()
                .getHeight());
    }

    @Test
    public void removalWithLeftRightRotation() {
        AVLTree tree = new AVLTree();
        tree.insert(10);
        tree.insert(15);
        tree.insert(6);
        tree.insert(20);
        tree.insert(13);
        tree.insert(4);
        tree.insert(14);

        //Assertions before removal
        //Root test
        assertEquals(10, tree.getRoot().getValue());
        assertEquals(3, tree.getRoot().getHeight());

        //Left subtree test
        assertEquals(6, tree
                .getRoot()
                .getLeft()
                .getValue());
        assertEquals(1, tree
                .getRoot()
                .getLeft()
                .getHeight());
        assertEquals(4, tree
                .getRoot()
                .getLeft()
                .getLeft()
                .getValue());
        assertEquals(0, tree
                .getRoot()
                .getLeft()
                .getLeft()
                .getHeight());
        //Right subtree test
        assertEquals(15, tree
                .getRoot()
                .getRight()
                .getValue());
        assertEquals(2, tree
                .getRoot()
                .getRight()
                .getHeight());
        assertEquals(20, tree
                .getRoot()
                .getRight()
                .getRight()
                .getValue());
        assertEquals(0, tree
                .getRoot()
                .getRight()
                .getRight()
                .getHeight());

        assertEquals(13, tree
                .getRoot()
                .getRight()
                .getLeft()
                .getValue());
        assertEquals(1, tree
                .getRoot()
                .getRight()
                .getLeft()
                .getHeight());

        assertEquals(14, tree
                .getRoot()
                .getRight()
                .getLeft()
                .getRight()
                .getValue());
        assertEquals(0, tree
                .getRoot()
                .getRight()
                .getLeft()
                .getRight()
                .getHeight());

        tree.remove(4);

        //Assertions after removal
        //Root test
        assertEquals(13, tree.getRoot().getValue());
        assertEquals(2, tree.getRoot().getHeight());

        //Left subtree
        assertEquals(10, tree
                .getRoot()
                .getLeft()
                .getValue());
        assertEquals(1, tree
                .getRoot()
                .getLeft()
                .getHeight());

        assertEquals(6, tree
                .getRoot()
                .getLeft()
                .getLeft()
                .getValue());
        assertEquals(0, tree
                .getRoot()
                .getLeft()
                .getLeft()
                .getHeight());

        //Right subtree
        assertEquals(15, tree
                .getRoot()
                .getRight()
                .getValue());
        assertEquals(1, tree
                .getRoot()
                .getRight()
                .getHeight());

        assertEquals(20, tree
                .getRoot()
                .getRight()
                .getRight()
                .getValue());
        assertEquals(0, tree
                .getRoot()
                .getRight()
                .getRight()
                .getHeight());

        assertEquals(14, tree
                .getRoot()
                .getRight()
                .getLeft()
                .getValue());
        assertEquals(0, tree
                .getRoot()
                .getRight()
                .getLeft()
                .getHeight());
    }

    @Test
    public void removalWithLeftRotation() {
        AVLTree tree = new AVLTree();

        tree.insert(10);
        tree.insert(20);
        tree.insert(6);
        tree.insert(4);

        //Assertions before removal
        //Root test
        assertEquals(10, tree
                .getRoot()
                .getValue());
        assertEquals(2, tree
                .getRoot()
                .getHeight());

        //Left subtree
        assertEquals(6, tree
                .getRoot()
                .getLeft()
                .getValue());
        assertEquals(1, tree
                .getRoot()
                .getLeft()
                .getHeight());
        assertEquals(4, tree
                .getRoot()
                .getLeft()
                .getLeft()
                .getValue());
        assertEquals(0, tree
                .getRoot()
                .getLeft()
                .getLeft()
                .getHeight());

        //Right subtree
        assertEquals(20, tree
                .getRoot()
                .getRight()
                .getValue());
        assertEquals(0, tree
                .getRoot()
                .getRight()
                .getHeight());

        tree.remove(20);

        //Assertions after removal
        //Root test

        assertEquals(6, tree
                .getRoot()
                .getValue());
        assertEquals(1, tree
                .getRoot()
                .getHeight());


        //Left subtree
        assertEquals(4, tree
                .getRoot()
                .getLeft()
                .getValue());
        assertEquals(0, tree
                .getRoot()
                .getLeft()
                .getHeight());

        //Right subtree
        assertEquals(10, tree
                .getRoot()
                .getRight()
                .getValue());
        assertEquals(0, tree
                .getRoot()
                .getRight()
                .getHeight());
    }

    @Test
    public void removalWithRightRotation() {
        AVLTree tree = new AVLTree();

        tree.insert(10);
        tree.insert(20);
        tree.insert(6);
        tree.insert(30);

        //Assertions before removal
        //Root test
        assertEquals(10, tree
                .getRoot()
                .getValue());
        assertEquals(2, tree
                .getRoot()
                .getHeight());

        //Left subtree
        assertEquals(6, tree
                .getRoot()
                .getLeft()
                .getValue());
        assertEquals(0, tree
                .getRoot()
                .getLeft()
                .getHeight());

        //Right subtree
        assertEquals(20, tree
                .getRoot()
                .getRight()
                .getValue());
        assertEquals(1, tree
                .getRoot()
                .getRight()
                .getHeight());

        assertEquals(30, tree
                .getRoot()
                .getRight()
                .getRight()
                .getValue());
        assertEquals(0, tree
                .getRoot()
                .getRight()
                .getRight()
                .getHeight());

        tree.remove(6);

        //Assertions after removal
        //Root test

        assertEquals(20, tree
                .getRoot()
                .getValue());
        assertEquals(1, tree
                .getRoot()
                .getHeight());


        //Left subtree
        assertEquals(10, tree
                .getRoot()
                .getLeft()
                .getValue());
        assertEquals(0, tree
                .getRoot()
                .getLeft()
                .getHeight());

        //Right subtree
        assertEquals(30, tree
                .getRoot()
                .getRight()
                .getValue());
        assertEquals(0, tree
                .getRoot()
                .getRight()
                .getHeight());
    }

}
