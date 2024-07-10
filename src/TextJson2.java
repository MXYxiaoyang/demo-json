/**
 * ClassName：TextJson2
 * Package:PACKAGE_NAME
 * Description:
 *
 * @Author:XiaoYang
 * @Create:2024/2/1 - 22:07
 */
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;
public class TextJson2 {
    @Test
    public void testReadJson() throws JsonProcessingException {
        String personStr = "{\"name\":\"张三\",\"age\":10,\"dog\":{\"name\":\"小黄\"}}";

        ObjectMapper objectMapper = null;
        objectMapper = new ObjectMapper();
        Person person = objectMapper.readValue(personStr, Person.class);
        System.out.println(person);
    }
}
