package com.grammar2.G04_multi;

/**
 *  如何才能知道一个父类引用的对象，本来是什么子类?
 *  格式：
 *      对象 instanceof 类名称
 *      这将会得到一个boolean值结果，也就是判断前面的对象能不能当做后面类型的实例。
 */
public class Demo05_multi_instanceof {
    public static void main(String[] args) {
        //getAnimal(new Demo042_cat());
        getAnimal(new Demo042_dog());
    }

    public static void getAnimal(Demo041_animal animal){
        if (animal instanceof Demo042_dog){
            Demo042_dog dog = (Demo042_dog) animal;
            dog.lookAfterHouse();
        }

        if (animal instanceof Demo042_cat){
            Demo042_cat cat = (Demo042_cat) animal;
            cat.catchMouse();
        }
    }
}
