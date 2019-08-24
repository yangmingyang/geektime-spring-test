package com.grammar2.G04_multi;

/**
 *  1.对象的向上转型，其实就是多态写法：
 *      格式：父类名称 对象名 = new 子类名称();
 *      含义：右侧创建一个子类对象，把他当做父类来看待使用。
 *      注意事项：
 *          向上转型一定是安全的。从小范围转向了大范围，比如从小范围的猫，向上转换成为更大范围的动物。
 *
 *      类似于：
 *      double num = 100; //正确，int  --> double,自动类型转换。
 *
 *  2.对象的向下转型，其实是一个【还原】的动作。
 *      格式：子类名称 对象名 = （子类名称）父类对象；
 *      含义：将父类对象，【还原】成为本来的子类对象。
 *      注意事项：
 *          a.必须保证对象本来创建的时候，就是猫，才能向下转型为猫。
 *          b.如果对象创建的时候本来不是猫，现在非要向下转型成为猫，就会报错。【ClassCastException】
 *
 *      类似于：
 *          int num = (int) 10.0;//可以   int num = （int） 10.5;//不可以，精度损失
 *
 */
public class Demo04_multi {
    public static void main(String[] args) {
        //对象的向上转型
        Demo041_animal animal = new Demo042_cat();
        animal.eat();//猫吃饭

        //对象的向下转型，其实是一个【还原】的动作。
        Demo042_cat cat = (Demo042_cat) animal;
        cat.catchMouse();

        //错误的转换
        Demo042_dog dog = (Demo042_dog) animal;//java.lang.ClassCastException
        dog.lookAfterHouse();
    }
}
