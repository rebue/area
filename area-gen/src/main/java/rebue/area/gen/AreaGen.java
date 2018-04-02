package rebue.area.gen;

import java.io.IOException;
import java.sql.SQLException;

import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;

import rebue.mbgx.MybatisGeneratorWrap;

public class AreaGen {

    public static void main(String[] args)
            throws IOException, SQLException, InterruptedException, XMLParserException, InvalidConfigurationException {
        MybatisGeneratorWrap.gen(true, "conf/mbg-area.properties");
    }

}
