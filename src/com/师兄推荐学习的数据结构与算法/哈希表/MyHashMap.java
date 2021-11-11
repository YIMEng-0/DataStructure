package com.师兄推荐学习的数据结构与算法.哈希表;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * @author Doraemon
 * @version 1.0
 * @date 2021/11/4 4:25 下午
 */

/**
 * command + shift + (+ - )进行方法体的展开以及合并
 *
 * @param <K>
 * @param <V>
 */
public class MyHashMap<K, V> implements Map {
    private int size;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public Object get(Object key) {
        return null;
    }

    @Override
    public Object put(Object key, Object value) {
        return null;
    }

    @Override
    public Object remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set keySet() {
        return null;
    }

    @Override
    public Collection values() {
        return null;
    }

    @Override
    public Set<Entry> entrySet() {
        return null;
    }
}