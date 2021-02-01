package com.hehe.DesignPatten;


/**
 *
 * 1、仅三行 简洁
 * 2、天然的线程安全与单一实例
 * 3、枚举保护单例模式不被破坏  （防反射 防序列化和反序列化）
 */

/**
 * 枚举创建实例的过程：在程序启动时，会调用 Singleton 的空参构造器，实例化好一个Singleton 对象赋给 INSTANCE，之后再也不会实例化
 */
public enum Singleton_enum {
    INSTANCE;

//    public void doSomething() {
//        System.out.println("这是枚举类型的单例模式！");
//    }
}
/**
 * （1）Enum 类内部使用Enum 类型判定防止通过反射创建多个对象
 * （2）Enum 类通过写出（读入）对象类型和枚举名字将对象序列化（反序列化），通过 valueOf() 方法匹配枚举名找到内存中的唯一的对象实例，防止通过反序列化构造多个对象
 * （3）枚举类不需要关注线程安全、破坏单例和性能问题，因为其创建对象的时机与饿汉式单例有异曲同工之妙。
 */

/**
 * （1）单例模式常见的写法有两种：懒汉式、饿汉式
 * （2）懒汉式：在需要用到对象时才实例化对象，正确的实现方式是：Double Check + Lock，解决了并发安全和性能低下问题
 * （3）饿汉式：在类加载时已经创建好该单例对象，在获取单例对象时直接返回对象即可，不会存在并发安全和性能问题。
 * （4）在开发中如果对内存要求非常高，那么使用懒汉式写法，可以在特定时候才创建该对象；
 * （5）如果对内存要求不高使用饿汉式写法，因为简单不易出错，且没有任何并发安全和性能问题
 * （6）为了防止多线程环境下，因为指令重排序导致变量报NPE，需要在单例对象上添加 volatile 关键字防止指令重排序
 * （7）最优雅的实现方式是使用枚举，其代码精简，没有线程安全问题，且 Enum 类内部防止反射和反序列化时破坏单例。
 */
