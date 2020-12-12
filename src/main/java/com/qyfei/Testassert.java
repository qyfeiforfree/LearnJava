package com.qyfei;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.event.EventRecodingLogger;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.LongSupplier;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static java.time.DayOfWeek.*;

public class Testassert {

    static int findMissingNumber(int start, int end, List<Integer> list) {
        List<Integer> lists = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            lists.add(i);
        }
        for (int j : lists) {
            if (!list.contains(j)) {
                return j;
            }
        }
        return 0;
    }


    public static void main(String[] args) throws NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, IOException {
        java.util.logging.Logger log = Logger.getLogger(Testassert.class.getName());
        double x = Math.abs(-123.45);
        assert x <= 0 : "X must >=0";
        System.out.println(x);

        log.log(Level.INFO, String.valueOf(x));
        Class adder = Adder.class;
        System.out.println(adder.getDeclaredField("sum"));
        Field[] fields = adder.getDeclaredFields();
        //Field[] fields = adder.getFields();
        for (int i = 0; i <= fields.length - 1; i++) {
            System.out.println("For循环");
            System.out.println(fields[i]);
        }
        for (Field field : fields) {
            System.out.println("For each循环");
            System.out.println(field);
        }

        //Method[] methods = adder.getMethods();
        Method[] methods = adder.getDeclaredMethods();

        System.out.println(methods.toString());
        for (int i = 0; i <= methods.length - 1; i++) {
            System.out.println("For循环");
            System.out.println(methods[i]);
        }
        for (Method method : methods) {
            System.out.println("For each循环");
            System.out.println(method);
        }

        //Constructor con=Adder.class.getConstructor(Adder.class);
        //Adder adder1=(Adder)con.newInstance();
        // System.out.println(adder1.add(5));
        System.out.println(Adder.class.getClass());

        ArrayList<Number> integerArrayList = new ArrayList<>();
        integerArrayList.add(new Integer(123));
        ArrayList<Number> numberArrayList = integerArrayList;
        numberArrayList.add(new Float(12.34));
        System.out.println(numberArrayList.size());

        ArrayList arrayList = new ArrayList<>(Arrays.asList("apple", "pear", "banana"));
        //add方法
        arrayList.add("apple");
        arrayList.add("pear");
        arrayList.add("banana");
        String last = (String) arrayList.get(arrayList.size() - 1);
        System.out.println(last);

        for (Iterator<String> it = arrayList.iterator(); it.hasNext(); ) {
            String s = it.next();
            System.out.println(s);
        }
// 构造从start到end的序列：
        final int start = 10;
        final int end = 20;
        List<Integer> list = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            list.add(i);
        }
        // 随机删除List中的一个元素:
        int removed = list.remove((int) (Math.random() * list.size()));
        int found = findMissingNumber(start, end, list);
        System.out.println(list.toString());
        System.out.println("missing number: " + found);
        System.out.println(removed == found ? "测试成功" : "测试失败");

        ArrayList<Person> listp = new ArrayList<Person>();
        listp.add(new Person("Bob", 11, 20, 120, "Green", "two"));

        boolean exist = listp.contains(new Person("Bob", 11, 20, 120, "Green", "two"));

        System.out.println(exist ? "测试成功!" : "测试失败!");

        Map<String, Integer> map = new HashMap<>();
        map.put("apple", 123);
        map.put("pear", 456);
        map.put("banana", 789);
        for (String key : map.keySet()) {
            Integer value = map.get(key);
            System.out.println(key + " = " + value);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()
        ) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + " + " + value);
        }
        Map<DayOfWeek, String> mapOfWeek = new EnumMap<>(DayOfWeek.class);
        mapOfWeek.put(MONDAY, "星期一");
        mapOfWeek.put(TUESDAY, "星期二");
        mapOfWeek.put(WEDNESDAY, "星期三");
        mapOfWeek.put(THURSDAY, "星期四");
        mapOfWeek.put(FRIDAY, "星期五");
        mapOfWeek.put(SATURDAY, "星期六");
        mapOfWeek.put(SUNDAY, "星期日");
        System.out.println(mapOfWeek);
        System.out.println(mapOfWeek.get(MONDAY));

        String file = "setting.properties";
        Properties prop = new Properties();
        try {
            prop.load(new java.io.FileInputStream(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String filepath = prop.getProperty("last_open_file");
        String intervel = prop.getProperty("auto_save_interval");
        System.out.println("Set filepath " + filepath + " for intervel " + intervel + ".");

        prop.setProperty("url", "http://www.liaoxuefeng.com");
        prop.setProperty("language", "Java");
        try {
            prop.store(new FileOutputStream(file), "这是写入的注释");
            //log.info("写入成功");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //log.info("Set filepath "+filepath+" for intervel "+intervel+"." );

        Set<String> hashSet = new HashSet<>();
        hashSet.add("apple");
        hashSet.add("banana");
        hashSet.add("pear");
        hashSet.add("orange");
        for (String s : hashSet) {
            System.out.println(s);
        }
        Set<Integer> treeSet = new TreeSet<>();
        treeSet.add(1);
        treeSet.add(2);
        treeSet.add(3);
        treeSet.add(5);
        treeSet.add(4);
        for (int i : treeSet) {
            System.out.println(i);
            //log.info(String.valueOf(i));
        }
        Queue<String> queue = new LinkedList<>();
        queue.add("a");
        queue.add("b");
        queue.add("c");
        System.out.println(queue.size());
        for (int i = 0; i <= queue.size() + 1; i++) {
            System.out.println(queue.poll());
        }
/*
        InputStream input = Testassert.class.getResourceAsStream("/book.json");
        ObjectMapper mapper = new ObjectMapper();
// 反序列化时忽略不存在的JavaBean属性:
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Book book = mapper.readValue(input, Book.class);
        System.out.println(book.name);
        System.out.println(book.pubDate);
        System.out.println(book.isbn);
        */

        String[] array = new String[]{"apple", "Orange", "banana", "Lemon"};
        // 请使用忽略大小写排序，并改写为Lambda表达式:
        Arrays.sort(array, (s1, s2) -> s1.compareToIgnoreCase(s2));

        System.out.println(String.join(", ", array));
        Arrays.sort(array, new Comparator<String>() {
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        });
        System.out.println(String.join(", ", array));

        Stream<String> stream = Stream.of("A", "B", "C", "D");
        stream.forEach(System.out::println);
        ArrayList<String> a = new ArrayList<String>(Arrays.asList("A", "B", "C", "D"));
        a.forEach(System.out::println);
        Stream<Integer> nature = Stream.generate(new NatualSupplier());
        nature.limit(20).forEach(System.out::println);
        LongStream fls = LongStream.generate(new FibonacciStream());
        fls.limit(20).forEach(System.out::println);

        String[] arrayString = new String[] { " 2019-12-31 ", "2020 - 01-09 ", "2020- 05 - 01 ", "2022 - 02 - 01",
                " 2025-01 -01" };
        // 请使用map把String[]转换为LocalDate并打印:
        Arrays.stream(arrayString).map(s->s.replaceAll("\\s", "")).map(s->LocalDate.parse(s, DateTimeFormatter.ofPattern("yyyy-MM-dd"))).forEach(System.out::println);



    }

    public static class FibonacciStream implements LongSupplier {
        private long first = 0;
        private long second = 1;
        private long next;

        @Override
        public long getAsLong() {
            next = first + second;
            first = second;
            second = next;
            return first;
        }
    }


    static class NatualSupplier implements Supplier<Integer> {
        int n = 0;

        public Integer get() {
            n++;
            return n;
        }
    }

}


