package io.renren.modules.hen.controller;

import io.renren.common.annotation.LogOperation;
import io.renren.common.constant.Constant;
import io.renren.common.page.PageData;
import io.renren.common.utils.ExcelUtils;
import io.renren.common.utils.Result;
import io.renren.common.validator.AssertUtils;
import io.renren.common.validator.ValidatorUtils;
import io.renren.common.validator.group.AddGroup;
import io.renren.common.validator.group.DefaultGroup;
import io.renren.common.validator.group.UpdateGroup;
import io.renren.modules.hen.dto.HumidityDTO;
import io.renren.modules.hen.dto.ShidutuDTO;
import io.renren.modules.hen.dto.ThermalDTO;
import io.renren.modules.hen.dto.WenduDTO;
import io.renren.modules.hen.excel.ThermalExcel;
import io.renren.modules.hen.service.ThermalService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * 
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2024-06-28
 */
@RestController
@RequestMapping("demo/thermal")
@Api(tags="")
public class ThermalController {
    @Autowired
    private ThermalService thermalService;

    @GetMapping("page")
    @ApiOperation("分页")
    @ApiImplicitParams({
        @ApiImplicitParam(name = Constant.PAGE, value = "当前页码，从1开始", paramType = "query", required = true, dataType="int") ,
        @ApiImplicitParam(name = Constant.LIMIT, value = "每页显示记录数", paramType = "query",required = true, dataType="int") ,
        @ApiImplicitParam(name = Constant.ORDER_FIELD, value = "排序字段", paramType = "query", dataType="String") ,
        @ApiImplicitParam(name = Constant.ORDER, value = "排序方式，可选值(asc、desc)", paramType = "query", dataType="String")
    })
    public Result<PageData<ThermalDTO>> page(@ApiIgnore @RequestParam Map<String, Object> params){
        PageData<ThermalDTO> page = thermalService.page(params);

        return new Result<PageData<ThermalDTO>>().ok(page);
    }

    @GetMapping("{id}")
    @ApiOperation("信息")
    public Result<ThermalDTO> get(@PathVariable("id") Long id){
        ThermalDTO data = thermalService.get(id);

        return new Result<ThermalDTO>().ok(data);
    }

    @PostMapping
    @ApiOperation("保存")
    @LogOperation("保存")
    public Result save(@RequestBody ThermalDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, AddGroup.class, DefaultGroup.class);
        dto.setCreateTime(new Date());
        thermalService.save(dto);

        return new Result();
    }

    @PutMapping
    @ApiOperation("修改")
    @LogOperation("修改")
    public Result update(@RequestBody ThermalDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);

        thermalService.update(dto);

        return new Result();
    }

    @DeleteMapping
    @ApiOperation("删除")
    @LogOperation("删除")
    public Result delete(@RequestBody Long[] ids){
        //效验数据
        AssertUtils.isArrayEmpty(ids, "id");

        thermalService.delete(ids);

        return new Result();
    }

    @GetMapping("export")
    @ApiOperation("导出")
    @LogOperation("导出")
    public void export(@ApiIgnore @RequestParam Map<String, Object> params, HttpServletResponse response) throws Exception {
        List<ThermalDTO> list = thermalService.list(params);

        ExcelUtils.exportExcelToTarget(response, null, "", list, ThermalExcel.class);
    }
    @GetMapping("getList")
    @ApiOperation("信息")
    public Result<WenduDTO> getList(){
        Map<String,Object> map=new HashMap<>();
        List<ThermalDTO> data = thermalService.list(map);
        List<Integer> zuida=data.stream().map(ThermalDTO::getWendu).collect(Collectors.toList());

        WenduDTO res = new WenduDTO();
        res.setWendu(zuida);
        res.setTime(data.stream().map(ThermalDTO::getTime).collect(Collectors.toList()));
        return new Result<WenduDTO>().ok(res);
    }
}