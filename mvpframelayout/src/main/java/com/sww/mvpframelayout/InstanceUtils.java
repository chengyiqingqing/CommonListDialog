package com.sww.mvpframelayout;

import java.lang.reflect.ParameterizedType;

/**
 * 对象实例化工具类
 * @author zhz
 */
public class InstanceUtils {

    public static final int POSITION_FIRST = 0;

    /**
     * 通过实例工厂去实例化相应类
     * @param o 带泛型的对象
     * @param i 需要实例化的对象在泛型中的位置
     * @param <T> 返回实例的泛型类型
     */
    @SuppressWarnings("unchecked")
    public static <T> T getInstance(Object o, int i) {
        try {
            return ((Class<T>) ((ParameterizedType) (o.getClass()
                    .getGenericSuperclass())).getActualTypeArguments()[i])
                    .newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Class<?> forName(String className) {
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
