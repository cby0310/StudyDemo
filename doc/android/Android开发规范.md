# 开发流程规范

版本 | 修订时间 | 修订人 | 备注
------|------|------|------
V1.0 | 2017-04-24 | 李映 | 初稿

[TOC]


## 1. 统一开发环境

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