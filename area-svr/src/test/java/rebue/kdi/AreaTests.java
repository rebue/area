package rebue.kdi;

import java.io.IOException;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import rebue.wheel.OkhttpUtils;

public class AreaTests {
    private final static Logger _log = LoggerFactory.getLogger(AreaTests.class);

    private String              _hostUrl = "http://localhost:20080";
//    private String _hostUrl = "http://120.79.251.116/area-svr";

    @Test
    public void test01() throws IOException {
    	String result = OkhttpUtils.get(_hostUrl + "/are/area/provinceall");
    	System.out.println(result);
    }

}
