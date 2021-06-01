package com.it.api;

/**
 * @author LY
 * @PackageName:com.it.api
 * @ClassName:DepthFirstOrder
 * @date 2021/6/1 10:44
 * 类说明: <br>
 */
public class DepthFirstOrder {

    /**索引代表顶点，值表示当前顶点是否已经被搜索*/
    private boolean[] marked;
    /**使用栈，存储顶点序列*/
    private Stack<Integer> reversePost;

    /**
     * 功能说明:创建一个检测环对象，检测图G中是否有环
     * @Param [G]
     * @return
     */
    public DepthFirstOrder(Digraph G){
        //创建一个和图的顶点数一样大小的marked数组
        marked = new boolean[G.V()];
        reversePost = new Stack<Integer>();
        //遍历搜索图中的每一个顶点
        for (int v = 0; v <G.V(); v++) {
            //如果当前顶点没有搜索过，则搜索
            if (!marked[v]){
                dfs(G,v);
            }
        }
    }

    /**
     * 功能说明:基于深度优先搜索，检测图G中是否有环
     * @Param [G, v]
     * @return void
     */
    private void dfs(Digraph G, int v){
        //把当前顶点标记为已搜索
        marked[v]=true;
        //遍历v顶点的邻接表，得到每一个顶点w
        for (Integer w : G.adj(v)){
            //如果当前顶点w没有被搜索过，则递归搜索与w顶点相通的其他顶点
            if (!marked[w]){
                dfs(G,w);
            }
        }
        //当前顶点已经搜索完毕，让当前顶点入栈
        reversePost.push(v);
    }

    /**
     * 功能说明:获取顶点线性序列
     * @Param []
     * @return com.it.api.Stack<java.lang.Integer>
     */
    public Stack<Integer> reversePost(){
        return reversePost;
    }

}
