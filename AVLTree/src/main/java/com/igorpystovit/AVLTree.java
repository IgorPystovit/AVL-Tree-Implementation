package com.igorpystovit;

import lombok.Getter;

import java.util.Optional;

@Getter
public class AVLTree {
    private AVLTreeNode root;

    public AVLTreeNode insert(int value) {
        root = insert(value, root);
        return root;
    }

    private int maxHeight(int height1, int height2) {
        return Math.max(height1, height2);
    }

    private int heightOf(AVLTreeNode node) {
        return node == null ? -1 : node.getHeight();
    }

    public AVLTreeNode insert(int value, AVLTreeNode node) {
        if (node == null) {
            node = new AVLTreeNode(value);
        } else if (node.getValue() > value) {
            node.setLeft(insert(value, node.getLeft()));
            if (!balanceFactorValid(node)) {
                if (value < node.getLeft().getValue()) {
                    node = rightRotation(node);
                } else {
                    node = rightLeftRotation(node);
                }
            }
        } else if (node.getValue() <= value) {
            node.setRight(insert(value, node.getRight()));
            if (!balanceFactorValid(node)) {
                if (value > node.getRight().getValue()) {
                    node = leftRotation(node);
                } else {
                    node = leftRightRotation(node);
                }
            }
        }

        node.setHeight(maxHeight(heightOf(node.getLeft()), heightOf(node.getRight())) + 1);

        return node;
    }

    public void remove(int value) {
        root = remove(value, root);
    }

    private AVLTreeNode remove(int value, AVLTreeNode node) {
        if (node.containsChildOf(value)) {
            if (node.getValue() > value) {
                node.setLeft(null);
            } else {
                node.setRight(null);
            }
        } else if (node.getValue() > value) {
            node.setLeft(remove(value, node.getLeft()));
        } else if (node.getValue() < value) {
            node.setRight(remove(value, node.getRight()));
        }

        node.setHeight(maxHeight(heightOf(node.getLeft()), heightOf(node.getRight())) + 1);

        if (!balanceFactorValid(node)) {
            if (getBalanceFactor(node) >= 2) {
                if ((getBalanceFactor(node.getLeft()) == 1) || (getBalanceFactor(node.getLeft()) == 0)) {
                    node = rightRotation(node);
                } else {
                    node = rightLeftRotation(node);
                }
            } else if (getBalanceFactor(node) <= -2) {
                if ((getBalanceFactor(node.getRight()) == -1) || (getBalanceFactor(node.getRight()) == 0)) {
                    node = leftRotation(node);
                } else {
                    node = leftRightRotation(node);
                }
            }
        }

        return node;
    }

    public Optional<AVLTreeNode> find(int value) {
        return Optional.ofNullable(find(value, root));
    }

    public AVLTreeNode find(int value, AVLTreeNode node) {

        if (node != null) {
            if (node.getValue() > value) {
                node = find(value, node.getLeft());
            } else if (node.getValue() < value) {
                node = find(value, node.getRight());
            }
        }

        return node;
    }

    public boolean contains(int value) {
        return find(value).isPresent();
    }

    private boolean balanceFactorValid(AVLTreeNode node) {
        return (Math.abs(heightOf(node.getLeft()) - heightOf(node.getRight()))) <= 1;
    }

    private int getBalanceFactor(AVLTreeNode node) {
        return heightOf(node.getLeft()) - heightOf(node.getRight());
    }

    private AVLTreeNode rightRotation(AVLTreeNode node) {
        AVLTreeNode tempNode = node.getLeft();
        node.setLeft(tempNode.getRight());
        tempNode.setRight(node);
        node.setHeight(maxHeight(heightOf(node.getLeft()), heightOf(node.getRight())) + 1);
        tempNode.setHeight(maxHeight(heightOf(tempNode.getLeft()), heightOf(tempNode.getRight())) + 1);
        return tempNode;
    }

    private AVLTreeNode leftRotation(AVLTreeNode node) {
        AVLTreeNode tempNode = node.getRight();
        node.setRight(tempNode.getLeft());
        tempNode.setLeft(node);
        node.setHeight(maxHeight(heightOf(node.getRight()), heightOf(node.getLeft())) + 1);
        tempNode.setHeight(maxHeight(heightOf(tempNode.getRight()), heightOf(tempNode.getLeft())) + 1);
        return tempNode;
    }

    private AVLTreeNode rightLeftRotation(AVLTreeNode node) {
        node.setLeft(leftRotation(node.getLeft()));
        return rightRotation(node);
    }

    private AVLTreeNode leftRightRotation(AVLTreeNode node) {
        node.setRight(rightRotation(node.getRight()));
        return leftRotation(node);
    }
}
