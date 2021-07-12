package com.wjcat.learn.io;

import java.lang.reflect.Field;
import java.nio.ByteBuffer;

public class BufferLearn {

    private static void printMarkPositionCapacityLimit(String msg, ByteBuffer buffer) {
        System.out.println(msg + "<mark:" + mark(buffer) + ", position:" + buffer.position() + ", limit:" + buffer.limit() + ", capacity:" + buffer.capacity() + ", offset:" + buffer.arrayOffset());
        System.out.println();
    }

    private static int mark(ByteBuffer buffer) {
        try {
            Field mark = buffer.getClass().getSuperclass().getSuperclass().getDeclaredField("mark");
            mark.setAccessible(true);
            return mark.getInt(buffer);
        } catch (Exception e) {
            System.out.println("get mark error:" + e);
        }
        return -100;
    }

    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        printMarkPositionCapacityLimit("allocate 10", buffer);
        for (int i = 1; i < 6; i++) {
            buffer.put((byte) (i + 100));
            printMarkPositionCapacityLimit("allocate 10", buffer);
        }
        buffer.flip();

        ByteBuffer slice = buffer.slice();
        printMarkPositionCapacityLimit("slice 10", slice);



//        buffer.mark();
//
//        for (int i = 0; i < 5; i++) {
//            buffer.flip();
//            byte b = buffer.get();
//            System.out.println(b);
//            printMarkPositionCapacityLimit("allocate 10", buffer);
//        }
//
//        buffer.clear();
//        for (int i = 0; i < 5; i++) {
//            System.out.print(buffer.get() + ",");
//            printMarkPositionCapacityLimit("allocate 10", buffer);
//        }
    }

}
