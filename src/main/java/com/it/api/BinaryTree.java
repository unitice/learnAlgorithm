package com.it.api;

import com.sun.org.apache.regexp.internal.RE;

/**
 * @author LY
 * @PackageName:com.it.api
 * @ClassName:BinaryTree
 * @date 2021/5/26 17:02
 * 类说明: <br>
 */
public class BinaryTree<Key extends Comparable<Key>, Value> {

    /**
     * 记录根结点
     */
    private Node root;
    /**
     * 记录树中元素的个数
     */
    private int N;


    /**
     * @return int 元素个数
     * 功能说明: <br>
     * 获取树中元素个数
     */
    public int size() {
        return this.N;
    }

    /**
     * @Param [key, value] 添加key value键值对
     * 功能说明: <br>
     * 向数中添加元素key-value
     */
    public void put(Key key, Value value) {
        this.root = put(root, key, value);
    }

    /**
     * @return com.it.api.BinaryTree<Key, Value>.Node
     * 功能说明: <br>
     * 通过递归添加结点
     * @Param [x, key, value]
     */
    private Node put(Node x, Key key, Value value) {
        if (x == null) {
            // 元素加一
            N++;
            return new Node(key, value, null, null);
        }
        int cmp = key.compareTo(x.key);
        if (cmp > 0) {
            // 新结点的key大于当前结点的key，继续找当前结点的右子结点
            x.right = put(x.right, key, value);
        } else if (cmp < 0) {
            // 新结点的key小于当前结点的key。继续找当前系欸但那的左子结点
            x.left = put(x.left, key, value);
        } else {
            // 新结点的key等于当前结点的key，把当前结点的value进行替换
            x.value = value;
        }
        return x;
    }

    /**
     * @Param [key] 代删除树中key
     * 功能说明: <br>
     * 删除树中key对应的value值
     */
    public void delete(Key key) {
        root = delete(root, key);
    }

    /**
     * @return com.it.api.BinaryTree<Key, Value>.Node
     * 功能说明: <br>
     * 通过递归删除结点
     * @Param [x, key] 删除递归key
     */
    public Node delete(Node x, Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp > 0) {
            // 新结点的key大于当前结点的key，继续找当前结点的右子结点
            x.right = delete(x.right, key);
        } else if (cmp < 0) {
            // 新结点的key小于当前结点的key，继续找当前结点的左子结点
            x.left = delete(x.left, key);
        } else {
            // 新系欸但的key等于当前结点的key，当前x就是要删除的结点
            // 1.如果当前结点的右子树不存在，则直接返回当前结点的左子结点
            if (x.right == null) {
                this.N--;
                return x.left;
            }
            //2.如果当前结点的左子树不存在，则直接返回当前结点的右子结点
            if (x.left == null) {
                this.N--;
                return x.right;
            }
            // 3.当前结点的左右子树都存在
            // 3.1 找到右子树中最小的结点
            Node minNode = x.right;
            while (minNode.left != null) {
                minNode = minNode.left;
            }
            // 3.2删除右子树中最小的结点
            Node n = x.right;
            while (n.left != null) {
                if (n.left.left == null) {
                    n.left = null;
                } else {
                    n = n.left;
                }
            }
            // 3.3让被删除结点的左子树称为最小结点minNode的左子树，让被删除结点的右子树称为最小结点minNode的右子树
            minNode.left = x.left;
            minNode.right = x.right;
            // 3.4 让被删除结点的父节点指向最小结点minNode
            x = minNode;
            // 个数-1
            this.N--;
        }
        return x;
    }

    /**
     * @return Value 返回值
     * 功能说明: <br>
     * 查询树总指定key对应的value
     * @Param [key] 索引值key
     */
    public Value get(Key key) {
        return get(this.root, key);
    }

    /**
     * @return Value
     * 功能说明: <br>
     * 通过key查找对应的value值
     * @Param [x, key]
     */
    public Value get(Node x, Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp > 0) {
            // 如果要查询的key大于当前结点的key，则继续找当前结点的右子结点
            return get(x.right, key);
        } else if (cmp < 0) {
            // 如果要查询的key小于当前结点的key，则继续找当前结点的左子节点
            return get(x.left, key);
        } else {
            // 如果查询的key等于当前结点的key，则树返回当前结点的value
            return x.value;
        }
    }

    /**
     * @return Key 返回最小key
     * 功能说明: <br>
     * 获取树中最小的key
     */
    public Key getMin() {
        return min(this.root).key;
    }

    /**
     * @return com.it.api.BinaryTree<Key, Value>.Node
     * 功能说明: <br>
     * 找出指定树x最小键所在结点
     * @Param [x]
     */
    private Node min(Node x) {
        if (x.left != null) {
            return min(x.left);
        } else {
            return x;
        }
    }

    /**
     * @return Key 返回最大键值
     * 功能说明: <br>
     * 找出整个树中最小的键
     */
    public Key getMax() {
        return max(this.root).key;
    }

    /**
     * @return com.it.api.BinaryTree<Key, Value>.Node
     * 功能说明: <br>
     * 找出指定树中最大key所在结点
     * @Param [x] 最大结点
     */
    private Node max(Node x) {
        if (x.right != null) {
            return max(x.right);
        } else {
            return x;
        }
    }

    /**
     * @return com.it.api.Queue<Key> 返回队列
     * 功能说明: <br>
     * 使用前序遍历，获取整个树中所有键
     */
    public Queue<Key> perErgodices() {
        Queue<Key> keys = new Queue<>();
        perErgodices(this.root, keys);
        return keys;
    }

    /**
     * @Param [x, keys] 跟结点和存储的队列
     * 功能说明: <br>
     * 使用前序遍历，把指定树x中的所有键放入到keys队列中
     */
    private void perErgodices(Node x, Queue<Key> keys) {
        if (x == null) {
            return;
        }
        // 1.把当前结点的key放入队列中
        keys.enqueue(x.key);
        // 2.找到当前结点的左子树，如果不为空，递归遍历左子树
        if (x.left != null) {
            perErgodices(x.left, keys);
        }
        // 3.找到当前结点的右子树，如果不为空，递归遍历右子树
        if (x.right != null) {
            perErgodices(x.right, keys);
        }
    }

    /**
     * @return com.it.api.Queue<Key> 返回中序遍历
     * 功能说明: <br>
     * 使用中序遍历，获取整个树中所有的键
     */
    public Queue<Key> midErgodic() {
        Queue<Key> keys = new Queue<>();
        midErgodic(this.root, keys);
        return keys;
    }

    /**
     * @Param [x, keys] 结点，队列
     * 功能说明: <br>
     * 使用中序遍历，把指定树x中的所有键放入到keys队列中
     */
    private void midErgodic(Node x, Queue<Key> keys) {
        if (x == null) {
            return;
        }
        // 1.找到当前结点的左子树，如果不为空，递归遍历左子树
        if (x.left != null) {
            midErgodic(x.left, keys);
        }
        // 把当前结点key放入队列中；
        keys.enqueue(x.key);
        // 3.找到当前结点的右子树，如果不为空，递归遍历右子树
        if (x.right != null) {
            midErgodic(x.right, keys);
        }
    }


    /**
     * @return com.it.api.Queue<Key> key值的队列
     * 功能说明: <br>
     * 使用后序遍历，获取整个树中所有键
     */
    public Queue<Key> afterErgodic() {
        Queue<Key> keys = new Queue<>();
        afterErgodic(this.root, keys);
        return keys;
    }

    /**
     * @Param [x, keys] 当前结点，存储队列
     * 功能说明: <br>
     * 使用后序遍历，把指定树x中的所有键放入到keys队列中
     */
    private void afterErgodic(Node x, Queue<Key> keys) {
        if (x == null) {
            return;
        }
        // 1.找到当前结点的左子树，如果不为空遍历左子树
        if (x.left != null) {
            afterErgodic(x.left, keys);
        }
        // 2.遍历当前结点的右子树，如果不为空，遍历右子树
        if (x.right != null) {
            afterErgodic(x.right, keys);
        }
        // 3.把当前结点的key值放入队列中
        keys.enqueue(x.key);
    }

    /**
     * @return com.it.api.Queue<Key> 通过队列存储key
     * 功能说明: <br>
     *     使用层序遍历得到树中所有的键
     */
    public Queue<Key> layerErgodic() {
        // 存key值
        Queue<Key> keys = new Queue<>();
        // 通过队列存树结点
        Queue<Node> nodes = new Queue<>();
        // 存入跟结点
        nodes.enqueue(this.root);
        while (!nodes.isEmpty()) {
            Node dequeue = nodes.dequeue();
            keys.enqueue(dequeue.key);
            if (dequeue.left != null) {
                nodes.enqueue(dequeue.left);
            }
            if (dequeue.right != null) {
                nodes.enqueue(dequeue.right);
            }
        }
        return keys;
    }

    /**
     * @return int 树的深度
     * 功能说明: <br>
     *    计算整个树的最大深度
     */
    public int maxDepth() {
        return maxDepth(this.root);
    }

    /**
     * @Param [x] 当前跟结点
     * @return int 返回最大深度
     * 功能说明: <br>
     *    递归获取整个树的最大深度
     */
    private int maxDepth(Node x){
        if (x == null){
            return 0;
        }
        int max = 0;
        int leftMax = 0;
        int rightMax = 0;
        // 计算左子树最大深度
        if (x.left != null){
            leftMax = maxDepth(x.left);
        }
        // 计算右子树最大深度
        if (x.right != null){
            rightMax = maxDepth(x.right);
        }
        return max = leftMax > rightMax ? leftMax+1 : rightMax+1;
    }



    private class Node {
        /**
         * 存储键
         */
        public Key key;
        /**
         * 存储值
         */
        private Value value;
        /**
         * 记录左子结点
         */
        public Node left;
        /**
         * 记录右子结点
         */
        public Node right;

        public Node(Key key, Value value, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }

    }

}
