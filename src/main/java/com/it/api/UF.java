package com.it.api;

/**
 * @author LY
 * @PackageName:com.it.api
 * @ClassName:UF
 * @date 2021/5/31 17:54
 * 类说明: <br>并查集
 */
public class UF {

    /**记录结点元素和该元素所在分组的标识*/
    private int[] eleAndGroup;
    /**记录并查集中数据的分组个数*/
    private int count;

    public UF(int N) {
         //初始情况下，每个元素都在一个独立的分组中，
        // 所以，初始情况下，并查集中的数据默认分为N个组
        this.count = N;
        //初始化数组
        eleAndGroup = new int[N];
        //把eleAndGroup数组的索引看做是每个结点存储的元素，
        // 把eleAndGroup数组每个索引处的值看做是该结点所在的分组，那么初始化情况下，i索引处存储的值就是i
        for (int i = 0; i < N; i++) {
            eleAndGroup[i] = i;
        }
    }

    /**
     * 功能说明:获取当前并查集中的数据有多少个分组
     * @return int 返回分组数
     */
    public int count() {
        return count;
    }

    /**
     * 功能说明:元素p所在分组的标识符
     * @return int 返回标识
     */
    public int find(int p) {
        return eleAndGroup[p];
    }

    /**
     * 功能说明:判断并查集中元素p和元素q是否在同一分组中
     * @Param 元素p，元素q
     * @return true 在同意分组
     */
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * 功能说明:把p元素所在分组和q元素所在分组合并
     * @Param 元素p，元素q
     */
    public void union(int p, int q) {
        //如果p和q已经在同一个分组中，则无需合并；
        if (connected(p, q)) {
            return;
        }
        //如果p和q不在同一个分组，则只需要将p元素所在组的所有的元素的组标
        // 识符修改为q元素所在组的标识符即可
        int pGroup = find(p);
        int qGroup = find(q);
        for (int i = 0; i < eleAndGroup.length; i++) {
            if (eleAndGroup[i] == pGroup) {
                eleAndGroup[i] = qGroup;
            }
        }
        //分组数量-1
        count--;
    }


}
