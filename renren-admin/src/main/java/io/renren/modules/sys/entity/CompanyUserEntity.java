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
@TableName("company_user")
public class CompanyUserEntity {

    /**
     * 
     */
	private Long id;
    /**
     * 
     */
	private Long conpanyId;
    /**
     * 
     */
	private Long userId;

    private String yuanyin;
}