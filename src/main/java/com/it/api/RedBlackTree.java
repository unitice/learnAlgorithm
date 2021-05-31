package com.it.api;

import java.util.jar.Pack200;

/**
 * @author LY
 * @PackageName:com.it.api
 * @ClassName:RedBlackTree
 * @date 2021/5/31 16:56
 * 类说明: <br> 红黑树
 */
public class RedBlackTree<Key extends Comparable<Key>,Value> {

    /**根结点*/
    private Node root;
    /**记录树中元素的个数*/
    private int N;
    /**红色连接*/
    private static final boolean RED = true;
    /**黑色连接*/
    private static final boolean BLACK = false;


   /**
    * 功能说明: 判断当前节点的父指向链接是否为红色
    * @Param [x] 结点
    * @return boolean true为红色，false为黑色
    */
    private boolean isRed(Node x){
        // 空结点默认是黑色链接
        if (x == null){
            return false;
        }
        // 非空结点需要判断结点color属性的值
        return x.color == RED;
    }

    /**
     * 功能说明: 左旋转
     * @Param [h] 当前结点
     * @return com.it.api.RedBlackTree<Key,Value>.Node 返回选择的结点
     */
    private Node rotateLeft(Node h){
        // 找出当前结点h的右子结点
        Node hRight = h.right;
        // 找处右子结点的左子结点
        Node lhRight = hRight.left;
        // 让当前结点h的右子结点的左子结点成为当前结点的右子结点
        h.right = lhRight;
        // 让当前结点h称为右子结点的左子结点
        hRight.left = h;
        // 让当前系欸但h的color编程右子结点的color
        hRight.color = h.color;
        // 让当前结点h的color变成RED
        h.color = RED;
        // 返回当前结点的右子结点
        return hRight;
    }


    /**
     * 功能说明: 右旋转
     * @Param [h] 当前结点
     * @return com.it.api.RedBlackTree<Key,Value>.Node 旋转后的左结点
     */
    private Node rotateRight(Node h){
        // 找出当前结点h的左子结点
        Node hLeft = h.left;
        // 找出当前结点h的左子结点的右子结点
        Node rHleft = hLeft.right;
        // 让当前结点h的左子结点的右子结点称为当前结点的左子结点
        h.left = rHleft;
        // 让当前结点左子结点的右子结点
        hLeft.right = h;
        // 让当前结点h的color值称为左子结点的color值
        hLeft.color = h.color;
        // 让当前结点h的color变成RED
        h.color = RED;
        // 返回当前结点的左子结点
        return hLeft;
    }

    /**
     * 功能说明:颜色反转,相当于完成拆分4-节点
     * @Param [h] 当前结点
     */
    private void flipColors(Node h){
        // 当前结点的color属性值变为RED
        h.color = RED;
        // 当前结点的左右子结点的color属性值变为黑色
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    /**
     * 功能说明:在整个树上完成插入操作
     * @Param [key, value] 带插入的key value值
     */
    public void put(Key key,Value value){
        // 在root整个树上插入key-val
        root = put(this.root,key,value);
        // 让根结点的颜色变为BLACK
        root.color = BLACK;
    }

    private Node put(Node h,Key key,Value value){
        if (h == null){
            // 标准的插入操作，和父节点用红链接相连
            N++;
            return new Node(key,value,null,null,RED);
        }

        // 比较要插入的键和当前结点的键
        int cmp = key.compareTo(h.key);
        if (cmp < 0){
            // 继续寻找左子树插入
            h.left = put(h.left,key,value);
        } else if (cmp > 0){
            // 继续寻找右子树插入
            h.right = put(h.right,key,value);
        } else {
            // 已经有相同的结点存在，修改节点的值
            h.value = value;
        }
        // 如果当前节点的右连接是红色，左链接是黑色，需要左旋
        if (isRed(h.right) && !isRed(h.left)){
            h = rotateLeft(h);
        }
        // 如果当前结点的左子结点和左子节点的左子节点都是红色链接，则需要右旋转
        if (isRed(h.left) && isRed(h.left.left)){
            h = rotateRight(h);
        }
        // 如果当前结点的左链接和右链接都是红色，需要颜色变换
        if (isRed(h.left) && isRed(h.right)){
            flipColors(h);
        }
        // 返回当前结点
        return h;
    }

    /**
     * 功能说明:根据key，从树中找出对应的值
     * @Param [key] 键
     * @return Value 对应值
     */
    public Value get(Key key){
        return get(this.root,key);
    }

    /**
     * 功能说明:从指定的树x中，查找key对应的值
     * @Param [x, key] 当前结点，查询key
     * @return Value key对应的val值
     */
    public Value get(Node x,Key key){
        // 如果当前结点为null 则没有找到，返回null
        if (x == null){
            return null;
        }

        // 比较当前结点的键和key
        int cmp = key.compareTo(x.key);
        if (cmp < 0){
            // 如果要查询key小于当前结点key。则继续找当前结点的左子结点
            return get(x.left,key);
        } else if (cmp > 0){
            // 如果要查询key大于当前结点的key，则继续找当前结点的右子系欸但
            return get(x.right,key);
        } else {
            // 如果要查询的key风云当前结点key，则树中返回当前结点的value
            return x.value;
        }

    }

    /**
     * @return int 队列元素个数
     * 功能说明: <br>
     *    获取树中元素个数
     */
    public int size(){
        return this.N;
    }

    private class Node {
        /**存储键*/
        public Key key;
        /**存储值*/
        private Value value;
        /**记录左子节点*/
        public Node left;
        /**记录右子节点*/
        public Node right;
        /**由其父节点指向它的连接的颜色*/
        public boolean color;

        public Node(Key key,Value value,Node left, Node right,boolean color){
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
            this.color = color;
        }
    }


}
