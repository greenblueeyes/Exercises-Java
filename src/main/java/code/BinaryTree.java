package code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class BinaryTree<T extends Comparable<T>> {
    enum Child {
        LEFT,
        RIGHT;
    }

    /**
     * Represents nodes in BinaryTree
     * @param <T> type of values store in BinaryTree
     */
    public static class Node<T> {
        private Node<T> childLeft;
        private Node<T> childRight;
        private final T value;

        public Node(final T value) {
            this.value = value;
        }

        public Node<T> setLeft(final T leftValue) {
            this.childLeft = new Node<T>(leftValue);

            return this.childLeft;
        }

        public Node<T> setRight(final T rightValue) {
            this.childRight = new Node<T>(rightValue);

            return this.childRight;
        }

        public T getValue() {
            return this.value;
        }

        public Node<T> getLeft() {
            return this.childLeft;
        }

        public Node<T> getRight() {
            return this.childRight;
        }
    }

    private int size = 0;
    private Node<T> root = null;

    /**
     * Default constructor
     */
    public BinaryTree() {
        // empty
    }

    /**
     * Constructor
     * Initialize binary tree with root value
     * @param rootValue initial value to add to binary tree
     */
    public BinaryTree(final T rootValue) {
        initialize(rootValue);
    }

    /**
     * Constructor
     * Initialize binary tree with list of values added in order they appear in List
     * @param values Collection of values to add to binaryTrue
     */
    public BinaryTree(final List<T> values) {
        initialize(values);
    }

    /**
     * Initialize binary tree with root value
     * @param rootValue initial value to add to binary tree
     */
    private void initialize(final T rootValue){
        this.root = new Node<T>(rootValue);
        size++;
    }

    private void initialize(final List<T> values) {
        if (values == null || values.isEmpty()) {
            return;
        }

        boolean first = true;

        for(T item: values) {
            if (!first) {
                append(item);
            } else {
                initialize(item);
                first = false;
            }
        }
    }

    /**
     * Appends values to the Binary Tree; if a node already exists with the
     * value, the existing node is returned (no duplicates in the binary tree)
     * @param value value to add to the binary tree
     * @return inserted node or existing node
     */
    public Node<T> append(final T value) {
        Node<T> prevNode = null;
        Node<T> currNode = root;
        Child whichChild = null;

        if (value == null) {
            throw new IllegalArgumentException("attempted to append null to binary tree");
        }

        // find location for value in tree
        while (currNode != null) {
            int compareResult = value.compareTo(currNode.value);
            prevNode = currNode;

            if (compareResult < 0) {
                currNode = currNode.childLeft;
                whichChild = Child.LEFT;
            } else if (compareResult > 0) {
                currNode = currNode.childRight;
                whichChild = Child.RIGHT;
            } else {
                return currNode;
            }
        }

        // Add node to tree
        Node<T> createdNode = null;
        if (whichChild != null) {
            if (whichChild == Child.LEFT) {
                createdNode = prevNode.setLeft(value);
            } else {
                createdNode = prevNode.setRight(value);
            }
            size++;
        }
        return createdNode;
    }

    /**
     * Return items in binary tree as @java.util.List in sequence from left-to-right,
     * @return empty list if BinaryTree contains no nodes; otherwise List<T>
     */
    public List<T> toList() {
        final List<T> result = size == 0? Collections.emptyList() : new ArrayList<T>(size);

        if (size == 0) {
            return result;
        }

        navigate(this.root, result::add);

        return result;
    }

    /**
     * Navigates through BinaryTree in order from left-most to right-most item
     * @param node
     * @param consumer
     */
    public void navigate(final Node<T> node, final Consumer<T> consumer) {
        if (node.getLeft() != null) {
            navigate(node.getLeft(), consumer);
        }

        consumer.accept(node.value);

        if (node.getRight() != null) {
            navigate(node.getRight(), consumer);
        }
    }
 }
