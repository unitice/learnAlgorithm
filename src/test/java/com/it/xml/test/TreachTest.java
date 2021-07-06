package com.it.xml.test;

import com.alibaba.fastjson.JSONObject;
import com.sun.deploy.util.JVMParameters;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author LY
 * @PackageName:com.it.xml.test
 * @ClassName:TreachTest
 * @date 2021/6/23 17:17
 * 类说明: <br>
 */
@SpringBootTest
public class TreachTest {

    @Test
    public void test01() throws ExecutionException, InterruptedException {
        // 创建一个固定数量的线程池
        ExecutorService executor = Executors.newFixedThreadPool(5);
        List listFuture = new ArrayList();
        for (int i = 0; i < 5; i++) {
            Callable<String> myCallable = new Callable<String>() {
                @Override
                public String call(){
                    return new XmlTest().getString();
                }
            };
            Future<String> submit = executor.submit(myCallable);
            listFuture.add(submit);
        }
        executor.shutdown();
        while (true) {
            if (executor.isTerminated()) {
                // 线程执行完成
                for (int i = 0; i < listFuture.size(); i++) {
                    Future<List> listFuture1 = (Future<List>) listFuture.get(i);
                    System.out.println(JSONObject.toJSONString(listFuture1.get()));
                }
                break;
            }
            Thread.sleep(200);
        }
    }

    @Test
    public void test02() throws InterruptedException, ExecutionException {
        ExecutorService executor = new ThreadPoolExecutor(
                10,
                10,
                60L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10));
        /*
         *corePoolSize：核心池的大小。在创建了线程池后，默认情况下，线程池中并没有任何线程，
         * 而是等待有任务到来才创建线程去执行任务，除非调用了prestartAllCoreThreads()
         * 或者prestartCoreThread()方法，从这2个方法的名字就可以看出，是预创建线程的意思，
         * 即在没有任务到来之前就创建corePoolSize个线程或者一个线程。默认情况下，在创建了线程池后，
         * 线程池中的线程数为0，当有任务来之后，就会创建一个线程去执行任务，当线程池中的线程数目达到corePoolSize后，
         * 就会把到达的任务放到缓存队列当中；

         maximumPoolSize：线程池最大线程数。这个参数也是一个非常重要的参数，它表示在线程池中最多能创建多少个线程；

         keepAliveTime：表示线程没有任务执行时最多保持多久时间会终止。默认情况下，只有当线程池中的线程数大于
         * corePoolSize时，keepAliveTime才会起作用，直到线程池中的线程数不大于corePoolSize，
         * 即当线程池中的线程数大于corePoolSize时，如果一个线程空闲的时间达到keepAliveTime，则会终止，
         * 直到线程池中的线程数不超过corePoolSize。但是如果调用了allowCoreThreadTimeOut(boolean)方法，
         * 在线程池中的线程数不大于corePoolSize时，keepAliveTime参数也会起作用，直到线程池中的线程数为0；

         unit：参数keepAliveTime的时间单位，有7种取值，在TimeUnit类中有7种静态属性

         workQueue：一个阻塞队列，用来存储等待执行的任务，这个参数的选择也很重要，会对线程池的运行过程
         * 产生重大影响，一般来说，这里的阻塞队列有以下几种选择：ArrayBlockingQueue;　
         * LinkedBlockingQueue;　SynchronousQueue;　PriorityBlockingQueue
         * ArrayBlockingQueue和PriorityBlockingQueue使用较少，
         * 一般使用LinkedBlockingQueue和SynchronousQueue。线程池的排队策略与BlockingQueue有关。
         */
        List listFuture = new ArrayList();
        for (int i = 0; i < 5; i++) {
            Callable<String> myCallable = new Callable<String>() {
                @Override
                public String call(){
                    return new XmlTest().getString();
                }
            };
            Future<String> submit = executor.submit(myCallable);
            listFuture.add(submit);
        }
        executor.shutdown();
        while (true) {
            if (executor.isTerminated()) {
                // 线程执行完成
                for (int i = 0; i < listFuture.size(); i++) {
                    Future<List> listFuture1 = (Future<List>) listFuture.get(i);
                    System.out.println(JSONObject.toJSONString(listFuture1.get()));
                }
                break;
            }
            Thread.sleep(200);
        }


    }

    @Test
    public void test03(){
        List list = new ArrayList();
        List list2 = new ArrayList();
        List list1 = new ArrayList();
        Map map = new HashMap();
        Map map1 = new HashMap();
        map1.put("11","11");
        map1.put("22","11");
        map1.put("44","11");
        map1.put("33","11");
        Map map2 = new HashMap();
        map2.put("11","11");
        map2.put("22","11");
        map2.put("44","22");
        map2.put("33","11");
        Map map3 = new HashMap();
        map3.put("11","11");
        map3.put("22","33");
        map3.put("44","44");
        map3.put("33","11");
        list1.add(map1);
//        map1.put("44", "55");
        list1.add(map1);
        list1.add(map2);
        list1.add(map3);


        map.put("aaa", list1);
        map.put("bbb", 111);
        list.add(map);
        list.add(map);
        list.add(map);
        list2.add(map);
        list2.add(map);
        list2.add(map);

        List<List> aaa1 = (List) list.stream().map(n -> {
            Map n1 = (Map) n;
            List aaa = (List) n1.get("aaa");
            List collect = (List) aaa.stream().map(n3 -> {
                Map n2 = (Map) n3;
                n2.put("data", n1.get("bbb"));
                return n2;
            }).collect(Collectors.toList());
            return collect;
        }).collect(Collectors.toList());

        System.out.println(aaa1);
        List<Map> nnn = new ArrayList();
        /*for(List a : aaa1){
           nnn.addAll(a);
        }*/
        aaa1.forEach(a ->nnn.addAll(a));

        System.out.println(nnn);

        Map<String, List<Map>> collect = nnn.stream().collect(Collectors.groupingBy(m -> (m.get("22").toString()+m.get("44").toString())));
        System.out.println(collect);


    }

}
