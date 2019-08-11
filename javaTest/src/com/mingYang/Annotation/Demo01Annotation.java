package com.mingYang.Annotation;

/**
 *  注解：
 *      概念：说明程序的。给计算机看的。
 *      注释：用文字描述程序。给程序员看的。
 *
 *      定义：注解（Annotation），也叫元数据。一种代码级别的说明。它是JDK1.5及以后版本引入的一个特性，与类、接口、
 *            枚举是在同一个层次。它可以声明在包、类、字段、方法、局部变量、方法参数等的前面，用来对这些元素进行说明，注释。
 *      概念描述：
 *          1.JDK1.5之后的新特性。
 *          2.说明程序的。
 *          3.使用注解：@注解名称
 *
 *      作用分类：
 *          ①编写文档：通过代码里标识的元数据生成文档【生成文档doc文档】
 *          ②代码分析：通过代码里标识的元数据对代码进行分析【使用反射】
 *          ③编译检查：通过代码里标识的元数据让编译器能够实现基本的编译检查【Override】
 *
 *  学习的目标：
 *      1.JDK中预定义的一些注解
 *          @Override：检测被该注解标注的方法是否是继承自父类（接口）的。
 *          @Deprecated：该注解标注的内容，表示已过时。
 *          @SuppressWarnings：压制警告。
 *              一般传递参数all   @SuppressWarnings("all")
 *
 *      2.自定义注解
 *          格式：
 *              元注解
 *              public @interface 注解名称{
 *                  属性列表；
 *              }
 *          本质：注解本质上就是一个接口，该接口默认继承Annotation接口
 *              public interface MyAnnotation extends java.lang.annotation.Annotation{ }
 *          属性：接口中抽象方法
 *              要求：
 *                  1.属性的返回值类型有下列取值
 *                      基本数据类型
 *                      String
 *                      枚举
 *                      注解
 *                      以上类型的数组
 *                  2.定义了属性，在使用时需要给属性赋值
 *                      1.如果定义属性时，使用default关键字给属性默认初始化值，则使用注解时，可以不进行属性赋值。
 *                      2.如果只有一个属性需要赋值，并且属性的名称是value,则value可以省略，直接定义值即可。
 *                      3.数组赋值时，值使用{ }包裹。如果数组中只有一个值，则{ }省略。
 *          元注解:用于描述注解的注解
 *              @Target:描述注解能够作用的位置。
 *                  ElementType取值：
 *                      TYPE:可以作用于类上。
 *                      METHOD:可以作用于方法上。
 *                      FIELD:可以作用于成员变量上。
 *
 *              @Retention:描述注解被保留的阶段。
 *                  @Retention(RetentionPolicy.RUNTIME):当前被描述的注解，会保留到class字节码文件中，并被JVM读取到。
 *
 *              @Documented:描述注解是否被抽取到api文档中。
 *
 *              @Inherited:描述注解是否被子类继承。
 *
 *
 *      3.在程序使用（解析）注解
 *          1.获取注解定义的位置对象 （class,Method,Field）
 *          2.获取指定的注解
 *              getAnnotation(class)：其实就是在内存中生成了一个该注解的子类实现对象。
 *              注意：我们实际上定义注解只是注意了一个抽象方法而已，但在实际使用的过程中，jvm会自动帮我们创建一个该子类的实现对象。
 *              public class ProImpl implements  Pro{
 *                 public String className(){
 *                     return "com.mingYang.Reflect.domain.Person";
 *                 }
 *                 public String methodName(){
 *                     return "eat";
 *                 }
 *              }
 *          3.调用注解中的抽象方法获取配置的属性值。
 *
 *  小结：
 *      1.以后大多数时候，我们会使用注解，而不是自定义注解。
 *      2.注解给谁用？
 *          a.编译器使用。
 *          b.给解析程序使用。
 *      3.注解不是程序得一部分，可以理解为注解就是一个标签。
 */

/**
 * 通过该注解，在类开通标识，就可以压制该类所有的警告信息
 */
//@SuppressWarnings("all")
public class Demo01Annotation {

    /**
     * 该方法就是重写了父类Object类中的toString方法
     * @return
     */
    @Override
    public String toString() {
        return "名扬";
    }

    /**
     * 该注解是标识该方法已经过时。一般老的方法不能直接删除，但可以通过该注解，提示后来的使用者，不建议使用这个方法
     */
    @Deprecated
    public static void eat(){
        System.out.println("eat");
    }

    public void show(){
        //被标识的过时的注解方法。在其他地方调用的时候，就会有一条行线。注意就算是被标识过时，但该方法照样还是能用的。
        eat();
    }

    /**
     * 这样就可以压制该方法的警告信息。
     */
    @SuppressWarnings("all")
    public void show2(){
        System.out.println("show2");
    }
}
