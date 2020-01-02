package xyz.fanchw.hutool;

import cn.hutool.http.HttpUtil;
import org.junit.Test;
import xyz.fanchw.pojo.LombokAnno;

import java.util.HashMap;
import java.util.Map;

public class HuToolTest {
    public static String BAI_DU = "https://www.sogou.com";

    @Test
    public void httpClient() {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("query", 10086);
        // 无参GET请求
        String noArgResult = HttpUtil.get(BAI_DU);
        System.out.println(noArgResult);
        // 带参GET请求
        String argResult = HttpUtil.get(BAI_DU, paramMap);
        System.out.println(argResult);
    }

    @Test
    public void lombokAnnotation(){
        LombokAnno lombokAnno=new LombokAnno("123");
    }
}
