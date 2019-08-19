package com.grammar2.G01_extends;
/**
 *  重写（Override）
 *      概念：在继承关系当中，方法的名称一样，参数列表也一样。
 *
 *  注意：重写和重载是两个不同的概念：
 *      重写（Override）:方法的名称一样，参数列表【也一样】。它也叫覆盖、覆写。
 *      重载（Overload）:方法的名称一样，参数列表【不一样】。
 *
 *  方法的覆盖重写特点：创建的是子类对象，则优先用子类方法。
 *
 *  方法覆盖重写的注意事项：
 *      1.必须保证父子类之间方法的名称相同，参数列表也相关。
 *          @Override:写在方法前面，用来检测是不是有效的正确覆盖重写。
 *          这个注解就算不写，只要满足要求，也是正确的方法覆盖重写。
 *
 *      2.子类方法的返回值必须【小于等于】父类方法的返回值范围。
 *          小提示：java.lang.Object类是所有类的公共最高父类（祖宗类），java.lang.String 就是Object的子类。
 *
 *      3.子类方法的权限必须【大于等于】父类方法的权限修饰符。
 *          小提示：public > protected > (default) > private
 *          备注：（default）不是关键字default，而是什么都不写，留空。
 *
 *  设计原则：
 *      对于已经投入使用的类，尽量不要进行修改。推荐定义一个行的类，来重复利用其中共性内容，并且添加改动新内容。
 *      这时候我们就可以利用“继承”。
 */
public class Demo03_extends_override {
    public static void main(String[] args) {
        Son son = new Son();
        son.m();//重新父类的m方法
    }
}
