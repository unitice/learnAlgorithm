package com.it.api;

/**
 * @author LY
 * @PackageName:com.it.api
 * @ClassName:BreadthFirstSearch
 * @date 2021/6/1 10:22
 * 类说明: <br>
 */
public class BreadthFirstSearch {

    /**索引代表顶点，值表示当前顶点是否已经被搜索*/
    private boolean[] marked;
    /**记录有多少个顶点与s顶点相通*/
    private int count;
    /**用来存储待搜索邻接表的点*/
    private Queue<Integer> waitSearch;

    /**
     * 功能说明:构造广度优先搜索对象，使用广度优先搜索找出G图中s顶点的所有相邻顶点
     * @Param [G, s] 图集合 结点
     */
    public BreadthFirstSearch(Graph G, int s) {
        //创建一个和图的顶点数一样大小的布尔数组
        marked = new boolean[G.V()];
        //初始化待搜索顶点的队列
        waitSearch = new Queue<Integer>();
        //搜索G图中与顶点s相同的所有顶点
        dfs(G, s);
    }

    /**
     * 功能说明:使用广度优先搜索找出G图中v顶点的所有相邻顶点
     * @Param [G, v] 图集合，顶点v
     */
    private void dfs(Graph G, int v) {
        //把当前顶点v标记为已搜索
        marked[v]=true;
        //把当前顶点v放入到队列中，等待搜索它的邻接表
        waitSearch.enqueue(v);
        //使用while循环从队列中拿出待搜索的顶点wait，进行搜索邻接表
        while(!waitSearch.isEmpty()){
            Integer wait = waitSearch.dequeue();
            //遍历wait顶点的邻接表，得到每一个顶点w
            for (Integer w : G.adj(wait)) {
                //如果当前顶点w没有被搜索过，则递归搜索与w顶点相通的其他顶点
                if (!marked[w]) {
                    dfs(G, w);
                }
            }
        }
        //相通的顶点数量+1
        count++;
    }


    /**
     * 功能说明:判断w顶点与s顶点是否相通
     * @Param [w] 顶点w
     * @return boolean ture相通
     */
    public boolean marked(int w) {
        return this.marked[w];
    }


    /**
     * 功能说明:获取与顶点s相通的所有顶点的总数
     * @return int 总数
     */
    public int count() {
        return this.count;
    }


}
