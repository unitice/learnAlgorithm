package com.it.api;

/**
 * @author LY
 * @PackageName:com.it.api
 * @ClassName:DepthFirstSearch
 * @date 2021/6/1 10:10
 * 类说明: <br>
 */
public class DepthFirstSearch {
    /**索引代表顶点，值表示当前顶点是否已经被搜索*/
    private boolean[] marked;
    /**记录有多少个顶点与s顶点相遇*/
    private int count;

    /**
     * 功能说明: 构造深度优先搜索对象，使用深度优先搜索找出G图中s顶点的所有相邻顶点
     * @Param [G, s] 图集合，s顶点
     */
    public DepthFirstSearch(Graph G,int s){
        // 创建一个和图的顶点数一样大小的布尔数组
        marked = new boolean[G.V()];
        // 搜索G图中与顶点s相同的所有顶点
        dfs(G, s);
    }

    /**
     * 功能说明:使用深度优先搜索找出G图中v顶点的所有相邻顶点
     * @Param [G, v] 图集合，顶点v
     */
    private void dfs(Graph G, int v) {
        // 把当前顶点标记为已搜索
        marked[v] = true;
        // 遍历v顶点的邻接表，得到每一个顶点w
        for (Integer w : G.adj(v)){
            // 如果当前顶点w没有被搜索过，则递归搜索与w顶点想吐的其他顶点
            if (!marked[w]){
                dfs(G, w);
            }
        }
        // 相通的顶点数量+1
        count++;
    }

    /**
     * 功能说明:判断w顶点与s顶点是否相通
     * @Param [w]顶点
     * @return boolean true相遇
     */
    public boolean marked(int w){
        return marked[w];
    }

    /**
     * 功能说明:获取与顶点s相通的所有顶点的总数
     * @return int 返回顶点总数
     */
    public int count(){
        return count;
    }


}
