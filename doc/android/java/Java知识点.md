#Java核心技术36讲

## 1.对Java平台的理解
- Java 本身是一种面向对象的语言，最显著的特性有两个方面
1. 书写一次，到处运行（Write once, run anywhere），能够非常容易地获得跨平台能力；
2. 垃圾收集（GC, Garbage Collection），Java 通过垃圾收集器（Garbage Collector）回收分配内存，大部分情况下，程序员不需要自己操心内存的分配和回收。

- .Java是解释执行?
不正确！
1. Java源代码经过Javac编译成.class文件
2. .class文件经JVM解析或编译运行。
（1）解析:.class文件经过JVM内嵌的解析器解析执行。
（2）编译:存在JIT编译器（Just In Time Compile 即时编译器）把经常运行的代码作为"热点代码"编译为与本地平台相关的机器码，并进行各种层次的优化。
（3）AOT编译器: Java 9提供的直接将所有代码编译成机器码执行。  对应ART, jit对应dalvik虚拟机

- .java语言特性
1. 面向对象（封装，继承，多态）
2. 平台无关性（JVM运行.class文件）
3. 语言（泛型，Lambda）
4. 类库（集合，并发，网络，IO/NIO）
5. JRE（Java运行环境，JVM，类库）
6. JDK（Java开发工具，包括JRE，javac，诊断工具）
7. Java 的类加载机制

## 2.Exception 和 Error有什么区别
- Exception 和 Error 都是继承了 Throwable 类
- Exception是程序正常运行中，可以预料的意外情况，可能并且应该被捕获，进行相应处理。分为可检查（checked）异常和不检查（unchecked）异常，可检查异常在源代码里必须显式地进行捕获处理，这是编译期检查的一部分
- Error 是指在正常情况下，不大可能出现的情况，绝大部分的 Error 都会导致程序（比如 JVM 自身）处于非正常的、不可恢复状态。既然是非正常情况，所以不便于也不需要捕获，常见的比如 OutOfMemoryError 之类，都是 Error 的子类。
- NoClassDefFoundError 和 ClassNotFoundException 有什么区别?
1. NoClassDefFoundError是编译的时候是存在的，运行的时候却找不到
2. ClassNotFoundException Class.forName方法来动态地加载类，这个类在类路径中没有被找到
- Try-with-resources:JDK7开始，自动关闭实现了AutoCloseable或者Closeable接口的资源,若也写了finally方法则在close之后执行，例如
```
try (BufferedReader bufferedReader = new BufferedReader(new FileReader("file://aa.txt"))) {
     bufferedReader.readLine();
} catch (IOException e) {
     e.printStackTrace();
}
```
- Multiple catch 
```
try {
} catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
   e.printStackTrace();
}
```
- 不要捕获类似 Exception 这样的通用异常
- 不要生吞（swallow）异常
- try-catch 代码段会产生额外的性能开销，影响JVM对代码进行优化，所以尽量不要一个大的 try 包住整段的代码
- Java每实例化一个 Exception，都会对当时的栈进行快照，这是一个相对比较重的操作

## 3.final、finally、 finalize有什么不同？
- final 可以用来修饰类、方法、变量，分别有不同的意义，final 修饰的 class 代表不可以继承扩展，final 的变量是不可以修改的，而 final 的方法也是不可以重写的（override）。
- finally 则是 Java 保证重点代码一定要被执行的一种机制。我们可以使用 try-finally 或者 try-catch-finally 来进行类似关闭 JDBC 连接、保证 unlock 锁等动作。推荐使用 Java 7 中添加的 try-with-resources 语句
- finalize 是基础类 java.lang.Object 的一个方法，它的设计目的是保证对象在被垃圾收集前完成特定资源的回收。finalize 机制现在已经不推荐使用，会有性能影响，并且在 JDK 9 开始被标记为 deprecated。

- 注意，final 不是 immutable！
```
final List<String> strList = new ArrayList<>();
strList.add("Hello");
strList.add("world");
List<String> unmodifiableStrList = Collections.unmodifiableList(strList);
unmodifiableStrList.add("again");//抛出异常UnsupportedOperationException
```
- Immutable 在很多场景是非常棒的选择，某种意义上说，Java 语言目前并没有原生的不可变支持，如果要实现 immutable 的类，我们需要做到：
1. 将 class 自身声明为 final，这样别人就不能扩展来绕过限制了。
2. 将所有成员变量定义为 private 和 final，并且不要实现 setter 方法。
3. 通常构造对象时，成员变量使用深度拷贝来初始化，而不是直接赋值，这是一种防御措施，因为你无法确定输入对象不被其他人修改。
4. 如果确实需要实现 getter 方法，或者其他可能会返回内部状态的方法，使用 copy-on-write 原则，创建私有的 copy。

- 1，不要在 finally 中使用 return 语句。
- 2，finally 总是执行，除非程序或者线程被中断。
- cleaner

## 4.强引用、软引用、弱引用、幻象引用有什么区别？具体使用场景是什么？
