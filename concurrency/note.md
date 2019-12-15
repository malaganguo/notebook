# 基本概念

并发：多个线程操作相同的资源，保证线程安全，合理使用。

高并发：服务能同时处理很多请求，提高程序性能。

**CPU多级缓存**

CPU缓存的意义：1）时间局部性：如果某个数据被访问，那么不久的将来它很可能被再次访问；2）空间局部性：如果某个数据被访问，那么与它相邻的数据很快也可能被访问。

CPU缓存一致性（MESI）:用于保证多个CPU缓存之间缓存共享数据的一致。

乱序执行优化：处理器为了提高运行速度而做出违背代码原有顺序的变化。在多核时可能带来问题。

## **Java内存模型**

Java虚拟机规范了一个线程如何和何时可以看到其他线程修改过后的共享变量的值以及必须时如何访问共享变量。

![image-20191119152702905](pic/image-20191119152702905.png)

堆Heap由垃圾回收负责，可以动态分布内存大小，生存期不用事先告诉编译器，因为是在运行时动态分配内存的，GC会自动回收这里不再使用的数据。因为动态分配内存的缘故，其存取速度要相对慢一些。

栈Stack的存取速度快于堆，速度仅次于寄存器，栈中数据可共享。但是栈中数据大小和生存期必须是确定的，缺乏灵活性，所以栈中主要存放一些基本类型的变量，如int、short、byte、char、boolean、long、对象句柄等。

java内存模型要求调用栈和本地变量存放在线程栈上，对象存放在堆上。本地变量存放在线程栈上。静态成员变量跟随类的定义存放在堆上。

如果两个线程同时调用了同一个对象的同一个方法，但是他们都拥有的是成员变量的私有拷贝。



多CPU

![6](pic/6.jpg)

​		寄存器是CPU内存的基础，CPU在寄存器上执行的速度很快。因为CPU和内存的速度差异是数量级的，所以使用缓存来作为缓冲，将运算需要的数据复制到缓存中，当运算结束后再存缓存同步到内存中，提高了CPU资源的使用率。



虚拟机和硬件之间的关系：

![7](pic/7.jpg)

### 同步的八种操作

lock ：作用于主内存的变量，把一个变量标记为一条线程的独占状态；

unlock：作用于主内存的变量，把一个锁定的变量释放出来，释放出来的变量可被其他线程锁定；

read： 作用于主内存的变量，把一个变量从主内存中传输到线程的工作内存中；

load：作用于工作内存中的变量，把read操作得到的变量放入工作内存的变量副本中；

use：作用于工作内存的变量，把工作内存中的一个变量传递给执行引擎；

assign：作用于工作内存的变量，把一个从执行引擎接受啊懂得值赋给工作内存的变量；

store：作用于工作内存的变量，把工作内存中的一个变量的值传递给主内存中；

write：作用于主内存的变量，把store操作工作内存中一个变量的值传送到主内存的变量中。

![9](pic/9.jpg)

## 并发的优势和风险

| 优势                                                         | 风险                                                         |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| 速度：同时处理多个请求，响应速度更快；复杂的操作可以分成多个进程同时进行 | 安全性：多个线程共享数据可能会产生与期望不符的后果           |
| 设计：程序设计再某些情况下更简单，也可以有更多选择           | 活跃性：某个操作无法继续进行下去的时候就会发生活跃性问题。如死锁、饥饿等问题 |
| 资源利用：CPU能在等候IO的时候做一些其他事情                  | 性能：线程过多时会使得CPU切换频繁，调度时间增多；同步机制；消耗过多内存 |





# 并发编程和线程安全

![image-20191119165756661](pic/image-20191119165756661.png)

## 工具模拟

### postman

### apache bench

使用：[获取链接](https://www.apachelounge.com/download/)

进入bin目录下执行  `E:\ApacheBanch\bin>ab.exe -c 50 -n 1000 http://localhost:8080/test`

-c 50:并发数50 ； -n 1000：执行1000次；

~~~
E:\ApacheBanch\bin>ab.exe -c 50 -n 1000 http://localhost:8080/test
This is ApacheBench, Version 2.3 <$Revision: 1843412 $>
Copyright 1996 Adam Twiss, Zeus Technology Ltd, http://www.zeustech.net/
Licensed to The Apache Software Foundation, http://www.apache.org/

Benchmarking localhost (be patient)
Completed 100 requests
Completed 200 requests
Completed 300 requests
Completed 400 requests
Completed 500 requests
Completed 600 requests
Completed 700 requests
Completed 800 requests
Completed 900 requests
Completed 1000 requests
Finished 1000 requests


Server Software:
Server Hostname:        localhost
Server Port:            8080

Document Path:          /test
Document Length:        4 bytes

Concurrency Level:      50
Time taken for tests:   0.257 seconds
Complete requests:      1000
Failed requests:        0
Total transferred:      136000 bytes
HTML transferred:       4000 bytes
Requests per second:    3893.55 [#/sec] (mean)
Time per request:       12.842 [ms] (mean)
Time per request:       0.257 [ms] (mean, across all concurrent requests)
Transfer rate:          517.11 [Kbytes/sec] received

Connection Times (ms)
              min  mean[+/-sd] median   max
Connect:        0    0   0.3      0       1
Processing:     2   12   1.6     12      15
Waiting:        1    8   3.0      8      14
Total:          2   12   1.6     13      15

Percentage of the requests served within a certain time (ms)
  50%     13
  66%     13
  75%     13
  80%     13
  90%     14
  95%     14
  98%     14
  99%     14
 100%     15 (longest request)

~~~

可以看出ab适合做性能测试工具。

### J-Meter

![image-20191119183341517](pic/image-20191119183341517.png)

![image-20191119183536182](pic/image-20191119183536182.png)

配置http请求：

![image-20191119183727206](pic/image-20191119183727206.png)

我们可以给test请求添加监听器，如图形结果和结果树方便观察。

![image-20191119184122316](pic/image-20191119184122316.png)

## 代码模拟

Semaphore和CountdownLatch类

~~~java
package com.mmall.concurrency;

import com.mmall.concurrency.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

@Slf4j
@NotThreadSafe
public class ConcurrencyTest {


    //请求数
    public static int clientTotal = 5000;

    //并发数
    public static int threadTotal = 200;

    //记录的值
    public static int count = 0;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);//信号量
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0;i < clientTotal; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (Exception e) {
                    log.error("exception:" + e);
                }
                countDownLatch.countDown();
            });
        }
        try {
            countDownLatch.await();//等待闭锁减为0
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
        log.info("count:{}", count);
    }

    private static void add() {
        count++;
    }
}

~~~

## 线程安全性

### 原子性

一个共享资源同一时间只能被一个线程使用。

原子性实现的方式，在竞争不激烈且不要求中断可使用synchronized关键字，在竞争激烈时，Atomic锁仅可以同步一个值，而Lock锁可以实现多样化同步，但是性能差于Atomic，且和Atomic的可读性都要逊色。

### 可见性

对组内存的修改可以被其他线程及时看到。

volatile不适合修饰计算量

### 有序性

Java内存模型中，允许编译器和处理器对指令进行重排序，但是重排序过程不会影响到单线程程序的执行，却会影响到多线程并发执行的正确性。

#### **Happens-before原则**

1. <font color="brwon">一个线程内</font>，代码按照从上到下的书写顺序执行；
2. 同一锁unLock后才可Lock；
3. 对一个变量，写操作先行于读操作；（volatile变量规则）；
4. 操作顺序传递，A早于B，B早于C，则A早于C；
5. Thread对象的start()方法早于此线程任一动作；
6. interrupt()执行后才可被检测到中断发生；
7. 线程中所有操作dou先行于线程的终止检测；
8. 对象初始化先行于finalize()方法。





### 安全发布对象



#### 单例模式

~~~java
/**
 * 线程安全的懒汉模式
 *  volatile + 双重检测机制 ->禁止指令重排
 */
@ThreadSafe
public class SingletonExample {

    private SingletonExample(){}
    //volatile保证创建对象的有序性
    public static volatile SingletonExample instance = null;

    public static SingletonExample getInstance() {
        if(instance == null) {//双重锁
            synchronized (SingletonExample.class) {
                if(instance == null) {
                    instance = new SingletonExample();
                }
            }
        }
        return instance;
    }
}

~~~

new操作会有三个步骤：

1、memory=allocate()分配对象的内存空间

2、createInstance()初始化对象

3、instance = memory 将instance指向刚分配的内存



以上三步存在有序性问题，所以即使是双重锁也无法保证线程安全，所有需要使用volatile来保证有序执行。





~~~java
/**
 * 饿汉模式本来就是线程安全的
 * 线程安全的饿汉模式二
 */
public class SingletonExample1 {

    private SingletonExample1(){}
    //必须写在静态代码块前，否则会NPE
    private static SingletonExample1 instance = null;

    static {
        instance =new SingletonExample1();
    }

    public static SingletonExample1 getInstance() {
        return instance;
    }
}
~~~







~~~java
/**
 * 枚举实现线程安全
 */
@ThreadSafe
@Recommand
public class SingletonExample2 {
    private SingletonExample2(){}

    public static SingletonExample2 getInstance() {
        return Singleton.INSTANCE.getInstance();
    }

    private enum Singleton {
        INSTANCE;
        private SingletonExample2 singleton;
        //JVM保证这个方法绝对只调用一次
        Singleton() {
            singleton = new SingletonExample2();
        }

        public SingletonExample2 getInstance() {
            return singleton;
        }
    }
}
~~~





## 线程安全策略

### 线程封闭

堆栈封闭：局部变量，无并发问题；全局变量容易引起并发问题；

**ThreadLocal线程封闭**：封装了一个map，key是线程，value是值。



### 常见线程安全类

StringBuffer、org.joda.time.format.DateTimeFormatter、Hashtable、concurrentHashMap

### 同步容器

Vector、Stack、Hashtable、Collections.synchronizedXXX(List/Map/Set)这些容器都是使用`synchronized`关键字修饰的同步方法，因为使用的同步方法，所以性能方面会差一些，且不能做到完全的线程安全，所以为了解决这些问题，引入了并发容器以更好解决并发中对容器的需要。

### 并发容器J.U.C

| 原容器    | 并发容器              | 备注                                        |
| --------- | --------------------- | ------------------------------------------- |
| ArrayList | CopyOnWriteArrayList  | 慎用！需要明确存取数量，读写不频繁          |
| HashSet   | CopyOnWriteArraySet   |                                             |
| TreeSet   | ConcurrentSkipListSet |                                             |
| HashMap   | ConcurrentHashMap     | 效率高                                      |
| TreeMap   | ConcurrentSkipListMap | key有序；存取时间和线程数无关——支持更高并发 |

#### AbstractQueuedSynchronizer - AQS

AQS是J.U.C的核心，AQS底层使用双向列表，是队列的一种实现。

##### AQS同步组件

###### CountDownLatch

​	是一个同步辅助类，可以完成阻塞当前线程的功能。换句话说就是实现一个或多个线程一直等待，直到其他线程的操作完成。CountDownLatch用了一个给定的计数器进行初始化，这个计数器的操作是原子性的操作，即同时仅能有一个线程操作该计数器。调用改类await()方法的线程会一直处于阻塞状态，直到其他线程调用countDown()方法使当前计数器的值减为0（countDown()调用一次，计数器的值减一）时，处于await()的线程才可以执行，这个过程只出现一次。

###### Semaphore

​		信号量，可以控制某个资源并发访问的线程个数，Semaphore可以在Java中完成操作系统里信号量的控制，可以控制某个资源可以被同时访问的个数。提供两个核心方法：acquire()和release()，分别是获取和释放一个许可，这个类可以实现有限大小的列表。Semaphore类的构造可初始化许可信号量（并发数）。

**使用场景**：常用于仅能提供有限访问的资源，比如数据库的连接数。即做并发访问控制的场景，

CyclicBarrier

ReentrantLock

Condition

FutureTask