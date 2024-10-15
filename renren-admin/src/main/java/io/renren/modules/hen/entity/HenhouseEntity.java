package io.renren.modules.hen.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * 
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2024-06-28
 */
@Data
@TableName("henhouse")
public class HenhouseEntity {

    /**
     * 序号
     */
	private Long id;
    /**
     * 鸡舍名称
     */
	private String name;
    /**
     * 
     */
	private String weizhi;
    /**
     * 
     */
	private String mianji;
    /**
     * 数量
     */
	private String number;
}