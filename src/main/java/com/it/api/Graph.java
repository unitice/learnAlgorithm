package com.it.api;

/**
 * @author LY
 * @PackageName:com.it.api
 * @ClassName:Graph
 * @date 2021/6/1 9:57
 * 类说明: <br> 图
 */
public class Graph {

    /**顶点数目*/
    private final int V;
    /**边的数目*/
    private int E;
    /**邻接表*/
    private Queue<Integer>[] adj;

    public Graph(int V){
        // 初始化顶点数量
        this.V = V;
        // 初始化边数量
        this.E = 0;
        // 初始化邻接表
        this.adj = new Queue[V];
        // 初始化邻接表中的空队列
        for (int i = 0; i < adj.length; i++){
            adj[i] = new Queue<Integer>();
        }
    }

    /**
     * 功能说明: 获取顶点数目
     * @return int 顶点数
     */
    public int V() {
        return this.V;
    }

    /**
     * 功能说明: 获取边的数目
     * @return int 边数
     */
    public int E() {
        return this.E;
    }

    /**
     * 功能说明: 向途中添加一条边v-w
     * @Param [v, w] 顶点v和顶点w
     */
    public void addEdge(int v,int w){
        // 把w添加到v的链表中，这样顶点v就多一个相邻点w
        this.adj[v].enqueue(w);
        // 把v添加到w的链表中，这样顶点w就多一个相邻点v
        this.adj[w].enqueue(v);
        // 边的数加一
        this.E++;
    }

    /**
     * 功能说明: 获取和顶点v相邻的所有顶点
     * @Param [v] 顶点v
     * @return com.it.api.Queue<java.lang.Integer> 相邻顶点队列
     */
    public Queue<Integer> adj(int v) {
        return adj[v];
    }

}
