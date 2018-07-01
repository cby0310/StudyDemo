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







### 1.1 Java版本
统一使用Java 1.7+。
### 1.2 IDE
统一使用Android Studio 2.2+。
### 1.3 Android SDK版本
统一使用sdk v18(4.3)+。

## 2. 代码规范

### 2.1 基本规范
1. 缩进 4个空格
2. 使用 `Unix` 换行符
3. 类型名称和源文件名称必须一致
4. 命名原则：使名称足够长以便有一定的意义，并且足够短以避免冗长。
5. 待完善的方法或逻辑，务必使用`TODO`来标识
```
public class UserManager {
        
      public void deleteUser(User user) {
        //TODO 等待开发完善
      }
}
```

### 2.2 注释

- 类型（类、接口）文件注释由IDE 自动生成,必要的时候需要对该文件进行描述
    ```
    /**
     * 说明：该类是用户实体类，包含普通用户和管理员
     * @author: JasonLee
     * @copyright 2014-2017 zhuolipu.inc
     * @created: 2017-04-25 11:26
     */
    public class User {
        //....
    }
    ```
- 属性注释，指对象的属性说明
    ```
    public class User {
        
        //是否是管理员用户
        private boolean isAdmin;
        
    }
    ```
- 方法注释，对方法进行说明
    
    ```
   public class UserManager {
        
       /**
         *  根据用户名返回用户ID
         * @param userName 用户名
         * @return 用户ID
         */
      private int getUserIdByName(String userName){
        
        return 0;
      }
    }
    ```
- 如果类型、属性、方法、方法参数的名称已经是自解释了，不需要加注释；否则需要添加注释。
- 主要业务逻辑部分，注释尽量详细，完善   
	```
     public class UserManager {
        
       /**
         *  根据用户名返回用户ID
         * @param userName 用户名
         * @return 用户ID
         */
      private int getUserIdByName(String userName){
        //1.从数据库获取用户列表
        //2.遍历用户列表
        //3.进行字符串匹配，匹配到则返回
        return 0;
      }
    }
    ```

## 3. 命名规范
### 3.1 编程基本命名规范 
1. 避免难懂的名称，如属性名a1,a2，这样的名称会导致多义性。
2. 编码：UTF-8 字符集、无 BOM。
3. 在面向对象的语言中，在类属性的名称中包含类名是多余的，如Book.BookTitle，而是应该使用Book.Title。
4. 在允许函数重载的语言中，所有重载都应该执行相似的函数。
5. 使用动词-名词的方法来命名对给定对象执行特定操作的例程，如CalculateInvoiceTotal()。（例程是某个系统对外提供的功能接口或服务的集合）
6. 只要合适，在变量名的末尾或开头加计算限定符（Avg、Sum、Min、Max、Index）
```
public class UserManager {
     private int mMaxCount;//最大用户数
}
```
7. 在变量名中使用互补对，如min/max、begin/end和open/close
```
public class UserManager {
     private int mMinAge;//用户最小年龄
     private int mMaxAge;//用户最大年龄
}
```
8. 即使对于可能仅出现在几个代码行中的生存期很短的变量，仍然使用有意义的名  称。仅对于短循环索引使用单字母变量名，如 i 或 j。
```
public class UserManager {

    /**
    *获取管理员总人数
    *@return totalCount
    */
    public int getAdminCount(){
        int totalCount = 0;
        //1.获取用户列表
        ArrayList<User> userList = getUserList();
        int size = userList.size();
        //2.对用户进行判断
        for(int i=0; i<size;i++){
          User user = userList.get(i);
          if(user.isAdmin()){
            totalCount ++;
          }
        }
        //3.返回总数
        return totalCount;
     }
}
```
9. 不要使用原义数字或原义字符串，而是使用命名常数，NUM_DAYS_IN_WEEK ，以便于维护和理解。

### 3.2 具体命名规范
1. 贯彻 基本命名规范
2. 包：Java包的名字都是由小写单词组成，为了保障每个Java包命名的唯一性，约定使用`com.zlp.项目名`。例如：com.zlp.heyzhima
3. 类： 类的名字必须由大写字母开头而单词中的其他字母均为小写；如果类名称由多个单词组成，则每个单词的首字母均应为大写例如TestPage；如果类名称中包含单词缩写，则这个所写词的每个字母均应大写。还有一点命名技巧就是由于类是设计用来代表对象的，所以在命名类时应尽量选择名词。例如：Person，YzxSDKHelper(云之讯SDK接入)
4. 方法：方法的名字的第一个单词应以小写字母作为开头，后面的单词则用大写字母开头。（驼峰命名规则），例如：`getUserId()`
5. 常量：常量的名字应该都使用大写字母，并且指出该常量完整含义。如果一个常量名称由多个单词组成，则应该用下划线来分割这些单词，例如：MAX_INPUT_LENGTH
6. 参数：参数的命名规范和方法的命名规范相同，而且为了避免阅读程序时造成迷惑，请在尽量保证参数名称为一个单词的情况下使参数的命名尽可能明确。 
   ```
    public class UserManager {
        public void AddUser(User user) {
            //TODO 添加用户到数据库
        }
    }
    ```
7. 可见性： 
    - 类的所有属性方法都要声明可见性 `public/protected/private`
	- `static` 放在可见性后
    - 对于类，`abstract/final` 放在`static`前；对于常量，`final`放在`static`后；
    ```
     public abstract class SerialPortActivity {
        
        private static final String MOUNT_POINT = "ttys3";//串口挂载点
        public abstract void dataReceived(int data);//需要子类实现该方法
        
        /**
        *获取挂载点
        *@return MOUNT_POINT
        */
        public static int getMountPoint() {
            return MOUNT_POINT;
        }
    } 
    ```
9. 控制结构： 
    - 控制结构关键字: `if、else if、else、switch、case、while、do while、for、foreach、try、catch`
    - 所有控制结构关键字后都要加 `空格`
    - 控制结构关键字后有圆括号，圆括号首尾不能有 `空格`
    - 控制结构关键字后的起始括号和关键字在同一行如：`if (isFinished) {`
    - 控制结构关键字的结束括号必须单独一行
	
### 3.3 变量命名规范
1. 普通变量命名：前缀+类型描述+意义描述
   - 前缀：  
	成员变量：`m***`  
	局部变量和形参：驼峰命名规则
	***控件:控件对象首字母缩写`tv***`(TextView控件变量)***
2. 资源文件命名：前缀+类型描述+意义描述  
	- 前缀：  
	图片文件：upload_clicked(上传点击效果),title_bg（标题背景）  
	布局文件：activity_main(MainActivity对应的布局)  
	控件ID：控件类型+描述（tv_login_username）  
	values资源：
	字符串资源分通用字符串和局部字符串，通用字符串比如：`确定`，`取消`，可命名为`OK`,`Cancel`  
	局部字符串指仅在某个布局使用,例如`忘记密码`。需要带上布局前缀 `activity_login_forget_pwd`。颜色值同  


## 4. 代码质量 
先把规范检测、质量检测、单元测试做好，后面统一接入持续集成工具自动检测
1. 选择一个代码规范检测工具 `CheckStyle`
2. 使用 ` Android Lint` 作为代码质量检测工具
3. 新特性的单元测试，使用 `Robolectric`或`AndroidTest`  单元测试
4. 开发文档管理，客户端、服务端及前端对接需求必须通过文档形式，拒绝口头对接。
5. 形成代码Review习惯，一能提升代码阅读能力、二能学习别人的思路、三能帮助别人及时发现问题。

## 5. 版本规范
请参考：[《卓利普版本发布流程规范》](http://baidu.com/)