import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class ControllerTest {
    @Test
    public void test01(){
        Map map =new HashMap<>();
        map.put("error", 1);
        map.put("url", "3456");
        System.out.println(JSON.toJSON(map));
    }
}
