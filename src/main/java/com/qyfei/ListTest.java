package com.qyfei;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListTest {
    public List coursesToSelect;

    public ListTest() {
        this.coursesToSelect = new ArrayList();
    }

    public void testAdd() {
        Course cr1 = new Course("1", "数据结构");
        coursesToSelect.add(cr1);
        Course tmp = (Course) coursesToSelect.get(0);
        System.out.println("添加了课程：" + tmp.id + ":" + tmp.name);

        Course cr2 = new Course("2", "C++语言");
        coursesToSelect.add(0, cr2);
        Course tmp2 = (Course) coursesToSelect.get(0);
        System.out.println("添加了课程：" + tmp2.id + ":" + tmp2.name);

//       Course cr3 = new Course("3", "操作系统原理");
//       coursesToSelect.add(4, cr3);

//        Course tmp3 = (Course) coursesToSelect.get(0);
//        System.out.println("添加了课程：" + tmp3.id + ":" + tmp3.name);

        Course[] course = {new Course("3", "离散数学"), new Course("4", "汇编语言")};
        coursesToSelect.addAll(Arrays.asList(course));
        Course tmp4 = (Course) coursesToSelect.get(2);
        Course tmp5 = (Course) coursesToSelect.get(3);
        System.out.println("添加了两满课程：" + tmp4.id + ":" + tmp4.name + "；" + tmp5.id + ":" + tmp5.name);

        Course[] course2 = {new Course("5", "高等数学"), new Course("6", "大学英语")};
        coursesToSelect.addAll(2, Arrays.asList(course2));
        Course tmp6 = (Course) coursesToSelect.get(2);
        Course tmp7 = (Course) coursesToSelect.get(3);
        System.out.println("添加了两满课程：" + tmp6.id + ":" + tmp6.name + "；" + tmp7.id + ":" + tmp7.name);
    }

    public void testGet() {
        int size = coursesToSelect.size();
        System.out.println("有如下课程：" + size + "门待选");
        for (int i = 0; i < size; i++) {
            Course cr = (Course) coursesToSelect.get(i);
            System.out.println("课程：" + cr.id + ":" + cr.name);
        }

    }

    public  void testIterrator(){

        Iterator it = coursesToSelect.iterator();
        System.out.println("有如下课程待选(迭代器访问)");
        while (it.hasNext()){
            Course cr = (Course)it.next();
            System.out.println("课程：" + cr.id + ":" + cr.name);
        }
    }
    public void testForEath(){

    }

    public static void main(String[] args) {
        ListTest lt = new ListTest();
        lt.testAdd();
        lt.testGet();
        lt.testIterrator();
    }
}
