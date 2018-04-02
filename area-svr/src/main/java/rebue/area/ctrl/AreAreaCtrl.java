package rebue.area.ctrl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import rebue.area.mo.AreAreaMo;
import rebue.area.svc.AreAreaSvc;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

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
     * @mbg.generated
     */
    @ApiOperation("添加区域信息")
    @PostMapping("/are/area")
    @ResponseBody
    Map<String, Object> add(AreAreaMo vo) throws Exception {
        _log.info("add AreAreaMo:" + vo);
        svc.add(vo);
        Map<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("id", vo.getId());
        _log.info("add AreAreaMo success!");
        return result;
    }

    /**
     * @mbg.generated
     */
    @ApiOperation("修改区域信息")
    @PutMapping("/are/area")
    @ResponseBody
    Map<String, Object> modify(AreAreaMo vo) throws Exception {
        _log.info("modify AreAreaMo:" + vo);
        svc.modify(vo);
        Map<String, Object> result = new HashMap<>();
        result.put("success", true);
        _log.info("modify AreAreaMo success!");
        return result;
    }

    /**
     * @mbg.generated
     */
    @ApiOperation("删除区域信息")
    @ApiImplicitParam(name = "id", value = "要删除的区域信息id", dataType = "long", paramType = "path", required = true)	
    @DeleteMapping("/are/area/{id}")
    @ResponseBody
    Map<String, Object> del(@PathVariable("id") java.lang.Long id) {
        _log.info("save AreAreaMo:" + id);
        svc.del(id);		
        Map<String, Object> result = new HashMap<>();
        result.put("success", true);
        _log.info("delete AreAreaMo success!");
        return result;
    }

    /**
     * @mbg.generated
     */
    @ApiOperation("查询区域信息")
    @ApiImplicitParams({ //
            @ApiImplicitParam(name = "pageNum", value = "查询第几页", dataType = "int", paramType = "query", required = true), //
            @ApiImplicitParam(name = "pageSize", value = "分页记录数", dataType = "int", paramType = "query", required = true) })
    @GetMapping("/are/area")
    @ResponseBody
    PageInfo<AreAreaMo> list(AreAreaMo qo, @RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize) {
    		_log.info("list AreAreaMo:" + qo+", pageNum = " + pageNum + ", pageSize = " + pageSize);

        if (pageSize > 50) {
            String msg = "pageSize不能大于50";
            _log.error(msg);
            throw new IllegalArgumentException(msg);
        }

        PageInfo<AreAreaMo> result = svc.list(qo, pageNum, pageSize);
        _log.info("result: " + result);
        return result;
    }

    /**
     * @mbg.generated
     */
    @ApiOperation("获取单个区域信息")
    @ApiImplicitParam(name = "id", value = "要获取区域信息的id", dataType = "long", paramType = "path", required = true)
    @GetMapping("/are/area/{id}")
    @ResponseBody
    AreAreaMo get(@PathVariable("id") java.lang.Long id) {
        _log.info("get AreAreaMo by id: " + id);
        AreAreaMo result = svc.getById(id);
        _log.info("get: " + result);
        return result;
    }

}
