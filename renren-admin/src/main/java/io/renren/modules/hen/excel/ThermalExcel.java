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
public class ThermalExcel {
    @ExcelProperty(value = "")
    private Long id;
    @ExcelProperty(value = "")
    private String time;
    @ExcelProperty(value = "")
    private String wendu;
    @ExcelProperty(value = "")
    private Integer type;
    @ExcelProperty(value = "")
    private Date createTime;

}