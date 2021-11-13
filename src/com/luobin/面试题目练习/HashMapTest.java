package com.luobin.面试题目练习;

import java.util.*;

/**
 * @author Doraemon
 * @version 1.0
 * @date 2021/11/12 10:25 上午
 */
class HashMapTest {
    public static void main(String[] args) {
        HashMap<Integer, User> users = new HashMap<>();
        users.put(1, new User("张三", 25));
        users.put(3, new User("李四", 22));
        users.put(2, new User("王五", 28));
        System.out.println(users);
        HashMap<Integer, User> sortHashMap = sortHashMap(users);
        System.out.println(sortHashMap);
        /**
         * 控制台输出内容
         * {1=User [name=张三, age=25], 2=User [name=王五,age=28], 3=User [name=李四, age=22]}
         * {2=User [name=王五, age=28], 1=User [name=张三, age=25], 3=User [name=李四, age=22]}
         */
    }

    /**
     * 对于哈希表中的额元素按照自己设定的排序方式进行排序
     *
     * @param map 传进来的 map 集合，就是一个键值对的哈希表，
     * @return
     */
    public static HashMap<Integer, User> sortHashMap(HashMap<Integer, User> map) {
        // 首先拿到 map 的键值对集合
        Set<Map.Entry<Integer, User>> entrySet = map.entrySet();

        // 将 set 集合转为 List 集合，为什么，为了使用工具类的排序方法
        List<Map.Entry<Integer, User>> list = new ArrayList<Map.Entry<Integer, User>>(entrySet);

        // 使用 Collections 集合工具类对 list 进行排序，排序规则使用匿名内部类来实现
        Collections.sort(list, new Comparator<Map.Entry<Integer, User>>() {
            @Override
            public int compare(Map.Entry<Integer, User> o1, Map.Entry<Integer, User> o2) {
                //按照要求根据 User 的 age 的倒序进行排
                return o2.getValue().getAge() - o1.getValue().getAge();
            }
        });

        //创建一个新的有序的 HashMap 子类的集合
        LinkedHashMap<Integer, User> linkedHashMap = new LinkedHashMap<Integer, User>();
        
        //将 List 中的数据存储在 LinkedHashMap 中
        for (Map.Entry<Integer, User> entry : list) {
            linkedHashMap.put(entry.getKey(), entry.getValue());
        }
        return linkedHashMap;
    }
}