package rebue.area.svc;

import rebue.robotech.svc.MybatisBaseSvc;

import java.util.List;

import rebue.area.mo.AreAreaMo;

public interface AreAreaSvc extends MybatisBaseSvc<AreAreaMo, java.lang.Long>{

	/**
     * 获取所有省份信息
     * Title: selectProvinceAll
     * Description: 
     * @return
     * @date 2018年4月6日 下午3:05:11
     */
    List<AreAreaMo> selectProvinceAll();
    
    /**
     * 根据上级区域编号获取所有下级信息
     * Title: selectCityAllByProvinceCode
     * Description: 
     * @param record
     * @return
     * @date 2018年4月6日 下午3:09:08
     */
    List<AreAreaMo> selectLowerAreaAll(AreAreaMo record);
    
    /**
     * 根据城市查询直辖镇信息
     * Title: selectCountyAllByCityCode
     * Description: 
     * @param record
     * @return
     * @date 2018年4月6日 下午3:22:21
     */
    List<AreAreaMo> selectCountyAllByCityCode(AreAreaMo record);
}