package com.yyl.blog.utils;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringEscapeUtils;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

public class StringUtils extends org.apache.commons.lang3.StringUtils {
    public static String toString(Object o) {
        if (o == null) {
            return null;
        }
        StringBuffer sb = new StringBuffer(1024);
        long beginTime = System.currentTimeMillis();
        sb.append("\n");
        sb.append(o.getClass().getSimpleName()).append("[");
        BeanInfo beanInfo = null;
        PropertyDescriptor[] descriptors = null;
        try {
            beanInfo = Introspector.getBeanInfo(o.getClass());
            descriptors = beanInfo.getPropertyDescriptors();
        } catch (IntrospectionException e) {
            descriptors = new PropertyDescriptor[0];
        }
        if (descriptors == null) {
            descriptors = new PropertyDescriptor[0];
        }
        for (int i = 0; i < descriptors.length; i++) {
            String name = descriptors[i].getDisplayName();
            //            if ("class".equals(name)) {
            //                continue;
            //            }
            if (i > 0) {
                sb.append(",");
            }
            sb.append("\n   ").append(name).append("=");
            Method readMethod = descriptors[i].getReadMethod();
            if (readMethod == null) {
                sb.append("{ has no getter method }");
            } else {
                try {
                    Object value = readMethod.invoke(o, (Object[]) null);
                    if (value == null) {
                        sb.append(value);
                        continue;
                    }
                    if (value.getClass().isArray()) {
                        sb.append(ArrayUtils.toString(value));
                        continue;
                    }
                    //Hibernate��˫�������һ��ѭ�����ã�������μ�@ManyToOneע�������
//                    if (value instanceof DomainObject) {
//                        continue;
                        //                        Field field = o.getClass().getDeclaredField(descriptors[i].getName());
                        //                        if (field.isAnnotationPresent(ManyToOne.class)) {
                        //                            continue;
                        //                        }
//                    }
                    sb.append(value.toString());
                } catch (Exception e) {
                    sb.append("{ invoke getter method error " + e.getMessage()).append("}");
                }
            }
        }
        sb.append("\n]");
        long endTime = System.currentTimeMillis();
        sb.append("[").append(endTime - beginTime).append("ms]");
        return sb.toString();
    }

    /**
     * ȥ���ַ������ҿո����ȫ�ǺͰ��2�ֿո�
     *
     * @param param ԭ�ַ���
     * @return String ȥ������2�ֿո����ַ��������ԭ�ַ���Ϊnull�򷵻�""
     */
    public static String trim2KindsSpace(String param) {
        if (param == null) {
            return "";
        }
        param = param.trim();
        if (isBlank(param)) {
            return param;
        }
        while (param.charAt(0) == '��') {
            param = param.substring(1, param.length()).trim();
        }
        while (param.endsWith("��")) {
            param = param.substring(0, param.length() - 1).trim();
        }
        return param;
    }

    /**
     * ת��HTML�����ַ�
     *
     * @param str ԭ�ַ���
     * @return String ת�����ı�
     */
    public static String escapeHtml(String str) {
        return StringEscapeUtils.escapeHtml4(str);
    }
    
    
    public static boolean equal(String str1, String str2){
    	return (str1 == null && str2 == null)
    			|| (str1 != null && str1.equals(str2));
    }
}
