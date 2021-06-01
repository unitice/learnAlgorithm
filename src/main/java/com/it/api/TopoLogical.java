package com.it.api;

/**
 * @author LY
 * @PackageName:com.it.api
 * @ClassName:TopoLogical
 * @date 2021/6/1 10:47
 * 类说明: <br>
 */
public class TopoLogical {

    /**顶点的拓扑排序*/
    private Stack<Integer> order;

    /**
     * 功能说明:构造拓扑排序对象
     * @Param [G]
     */
    public TopoLogical(Digraph G) {
        //创建检测环对象，检测图G中是否有环
        DirectedCycle dCycle = new DirectedCycle(G);
        if (!dCycle.hasCycle()){
            //如果没有环，创建顶点排序对象，进行顶点排序
            DepthFirstOrder depthFirstOrder = new DepthFirstOrder(G);
            order = depthFirstOrder.reversePost();
        }
    }

    /**
     * 功能说明:判断图G是否有环
     * @Param []
     * @return boolean
     */
    private boolean isCycle(){
        return order==null;
    }

    /**
     * 功能说明:获取拓扑排序的所有顶点
     * @Param []
     * @return com.it.api.Stack<java.lang.Integer>
     */
    public Stack<Integer> order(){
        return order;
    }

}
