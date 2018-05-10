package rebue.area.ctrl;

import java.util.List;
import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import rebue.area.mo.AreAreaMo;
import rebue.area.svc.AreAreaSvc;
import io.swagger.annotations.Api;

@Api(tags = "区域信息")
@RestController
public class AreAreaCtrl {
    /**
     * @mbg.generated
     */
    private final static Logger _log = LoggerFactory.getLogger(AreAreaCtrl.class);

    /**
     * @mbg.generated
     */
	@Resource
    private AreAreaSvc svc;

    /**
     * 获取所有省份信息
     * Title: selectProvinceAll
     * Description: 
     * @return
     * @date 2018年4月6日 下午3:31:20
     */
    @GetMapping("/are/area/provinceall")
    List<AreAreaMo> selectProvinceAll() {
    	_log.info("开始获取所有省份信息");
    	return svc.selectProvinceAll();
    }
    
    /**
     * 根据上级区域编号获取所有下级区域信息
     * Title: selectLowerAreaAll
     * Description: 
     * @param qo
     * @return
     * @date 2018年4月6日 下午3:33:28
     */
    @GetMapping("/are/area/lowerareaall")
    List<AreAreaMo> selectLowerAreaAll(@RequestBody AreAreaMo qo) {
    	_log.info("开始获取所有下级区域信息的参数为：{}" + qo.getAreaCode());
    	return svc.selectLowerAreaAll(qo);
    }
    
    /**
     * 根据城市编号获取所有直辖镇信息
     * Title: selectCountyAllByCityCode
     * Description: 
     * @param qo
     * @return
     * @date 2018年4月6日 下午3:36:04
     */
    @GetMapping("/are/area/countyall")
    List<AreAreaMo> selectCountyAllByCityCode(@RequestBody AreAreaMo qo) {
    	_log.info("开始获取所有直辖镇信息的参数为：{}" + qo.getAreaCode());
    	return svc.selectCountyAllByCityCode(qo);
    }
}
