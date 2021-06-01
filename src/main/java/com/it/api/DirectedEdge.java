package com.it.api;

/**
 * @author LY
 * @PackageName:com.it.api
 * @ClassName:DirectedEdge
 * @date 2021/6/1 11:04
 * 类说明: <br>
 */
public class DirectedEdge {

    /**
     * 起点
     */
    private final int v;
    /**
     * 终点
     */
    private final int w;
    /**
     * 当前边的权重
     */
    private final double weight;

    /**
     * 功能说明:通过顶点v和w，以及权重weight值构造一个边对象
     *
     * @Param [v, w, weight]
     */
    public DirectedEdge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    /**
     * 功能说明:获取边的权重值
     *
     * @return double
     */
    public double weight() {
        return weight;
    }

    /**
     * 功能说明:获取有向边的起点
     *
     * @return int
     */
    public int from() {
        return v;
    }

    /**
     * 功能说明:获取有向边的终点
     *
     * @return int
     */
    public int to() {
        return w;
    }


}
