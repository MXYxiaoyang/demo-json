import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TextJson {
    @Test
    public void testWriteJSon() throws JsonProcessingException {
        Dog dog = new Dog("小黄");
        Person person = new Person("张三",10,dog);
        //将Person对象转换成一个字符串     Gson JAckson  Fastjson

        ObjectMapper objectMapper = new ObjectMapper();
        String personStr = objectMapper.writeValueAsString(person);
        System.out.println(personStr);


    }
    /*Map格式*/
    @Test
    public void testMapToJson() throws JsonProcessingException {
        Map data = new HashMap();
        data.put("a","valuea");
        data.put("b","valueb");

        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(data);
        System.out.println(s);

    }
    @Test
    public void testListToJson () throws JsonProcessingException {
       /* List data = new ArrayList();
        data.add("a");
        data.add("b");
        data.add("c");*/
        Dog dog = new Dog("小黄");
        Person person = new Person("张三",10,dog);
        List data = new ArrayList<>();
        data.add(person);
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(data);
        System.out.println(s);
    }
}
