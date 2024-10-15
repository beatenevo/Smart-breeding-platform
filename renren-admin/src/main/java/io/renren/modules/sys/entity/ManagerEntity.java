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
@TableName("manager")
public class ManagerEntity {

    /**
     * 
     */
	private String username;
    /**
     * 
     */
	private String id;
    /**
     * 
     */
	private String password;
}