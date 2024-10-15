package io.renren.modules.hen.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import lombok.Data;

import java.util.Date;

/**
 * 
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2024-06-28
 */
@Data
public class HenhouseExcel {
    @ExcelProperty(value = "序号")
    private Long id;
    @ExcelProperty(value = "鸡舍名称")
    private String name;
    @ExcelProperty(value = "")
    private String weizhi;
    @ExcelProperty(value = "")
    private String mianji;
    @ExcelProperty(value = "数量")
    private String number;

}