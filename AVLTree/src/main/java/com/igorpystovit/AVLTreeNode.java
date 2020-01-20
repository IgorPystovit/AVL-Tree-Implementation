package com.igorpystovit;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AVLTreeNode {
    private int value;
    private int height;
    private AVLTreeNode right;
    private AVLTreeNode left;

    public AVLTreeNode(int value) {
        this.value = value;
        this.height = 0;
        this.right = null;
        this.left = null;
    }


    public boolean containsChildOf(Integer value) {
        return (getLeftValue() == value) ||
                (getRightValue() == value);
    }

    private Integer getLeftValue() {
        return left == null ? null : left.getValue();
    }


    private int getRightValue() {
        return right == null ? null : right.getValue();
    }
}
