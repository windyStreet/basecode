package com.learn.jdk8.streamapi;

/**
 * @author windyStreet
 * @codetime 2021-04-16 18:08
 */

/**
 * Stream 关注的是对数据的运算，与cpu打交道
 *          集合关注的是数据的存储，与内存打交道
 * 1、Stream 自己不会存储元素
 * 2、Stream 不会改变源对象，相反，会返回一个持有结果的新Stream
 * 3、Stream 操作是延迟执行的，这意味着他们会等到需要结果的时候才执行
 * Stream 执行流程
 * A、Stram 的实例化
 * B、一系类中的操作（过滤、映射...）
 * C、终止操作
 * 说明：
 * 一个中间操作链，岁数据源的数据进行处理
 * 一旦执行终止操作，就执行中间操作链，并产生记过，之后，不会再被使用
 */
public class StreamApiTest {
}
