package com.wjcat.learn.datastructure.tree.SegmentTree;

public interface Merger<E> {
    E merge(E a, E b);
}