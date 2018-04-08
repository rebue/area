package rebue.area.svc.impl;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import rebue.area.mapper.AreAreaMapper;
import rebue.area.mo.AreAreaMo;
import rebue.area.svc.AreAreaSvc;

import rebue.robotech.svc.impl.MybatisBaseSvcImpl;

@Service
/**
 * <pre>
 * 在单独使用不带任何参数 的 @Transactional 注释时，
 * propagation(传播模式)=REQUIRED，readOnly=false，
 * isolation(事务隔离级别)=READ_COMMITTED，
 * 而且事务不会针对受控异常（checked exception）回滚。
 * 注意：
 * 一般是查询的数据库操作，默认设置readOnly=true, propagation=Propagation.SUPPORTS
 * 而涉及到增删改的数据库操作的方法，要设置 readOnly=false, propagation=Propagation.REQUIRED
 * </pre>
 */
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class AreAreaSvcImpl extends MybatisBaseSvcImpl<AreAreaMo, java.lang.Long, AreAreaMapper> implements AreAreaSvc {

	private final static Logger _log = LoggerFactory.getLogger(AreAreaSvcImpl.class);
	
    /**
     * @mbg.generated
     */
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public int add(AreAreaMo mo) {
        // 如果id为空那么自动生成分布式id
        if (mo.getId() == null || mo.getId() == 0) {
            mo.setId(_idWorker.getId());
        }
        return super.add(mo);
    }

    /**
     * 查询所有省份信息
     * 2018年4月6日15:25:09
     */
	@Override
	public List<AreAreaMo> selectProvinceAll() {
		_log.info("开始查询所有的省份信息");
		return _mapper.selectProvinceAll();
	}

	/**
	 * 根据上级区域编号获取所有下级区域信息
	 * 2018年4月6日15:29:37
	 */
	@Override
	public List<AreAreaMo> selectLowerAreaAll(AreAreaMo record) {
		_log.info("开始查询所有下级区域信息的编号为：{}", record.getAreaCode());
		return _mapper.selectLowerAreaAll(record);
	}

	/**
	 * 根据城市编号查询所有直辖镇信息
	 * 2018年4月6日15:29:13
	 */
	@Override
	public List<AreAreaMo> selectCountyAllByCityCode(AreAreaMo record) {
		_log.info("开始查询所有直辖镇信息的城市编号为：{}", record.getAreaCode());
		return _mapper.selectCountyAllByCityCode(record);
	}

}
