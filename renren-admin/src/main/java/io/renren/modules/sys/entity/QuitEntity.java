package io.renren.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * 
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2024-06-10
 */
@Data
@TableName("quit")
public class QuitEntity {

    /**
     * 
     */
	private Integer id;
    /**
     * 
     */
	private Integer companyid;
    /**
     * 
     */
	private Integer studentid;
    /**
     * 
     */
	private String quittime;
    /**
     * 
     */
	private String quitreason;
    /**
     * 
     */
	private String companyname;
}