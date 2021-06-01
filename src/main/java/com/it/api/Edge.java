package com.it.api;

/**
 * @author LY
 * @PackageName:com.it.api
 * @ClassName:Edge
 * @date 2021/6/1 10:49
 * 类说明: <br>
 */
public class Edge implements Comparable<Edge> {

    /**
     * 顶点一
     */
    private final int v;
    /**
     * 顶点二
     */
    private final int w;
    /**
     * 当前边的权重
     */
    private final double weight;

    /**
     * 功能说明:通过顶点v和w，以及权重weight值构造一个边对象
     *
     * @return
     * @Param [v, w, weight]
     */
    public Edge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    /**
     * 功能说明:获取边的权重值
     *
     * @return double
     * @Param []
     */
    public double weight() {
        return this.weight;
    }

    /**
     * 功能说明:获取边上的一个点
     *
     * @return int
     * @Param []
     */
    public int either() {
        return v;
    }

    /**
     * 功能说明:获取边上除了顶点vertex外的另外一个顶点
     *
     * @return int
     * @Param [vertex]
     */
    public int other(int vertex) {
        if (vertex == v) {
            //如果传入的顶点vertext是v，则返回另外一个顶点w
            return w;
        } else {
            //如果传入的顶点vertext不是v，则返回v即可
            return v;
        }
    }

    @Override
    public int compareTo(Edge that) {
        int cmp;
        if (this.weight() > that.weight()) {
            //如果当前边的权重大于参数边that的权重，返回1
            cmp = 1;
        } else if (this.weight() < that.weight()) {
            //如果当前边的权重小于参数边that的权重，返回-1
            cmp = -1;
        } else {
            //如果当前边的权重等于参数边that的权重，返回0
            cmp = 0;
        }
        return cmp;
    }

}
