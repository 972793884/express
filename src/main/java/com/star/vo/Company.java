package com.star.vo;



import java.io.Serializable;
import java.util.Date;
import com.star.controller.Vo;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 
 * 
 * @author zzq
 * @email 972793884@qq.com
 * @date 2019-05-21 08:39:46
 */

public class Company extends Vo implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	
			private Integer id;
	/**
	 * 
	 */
			private String name;
	/**
	 * 
	 */
			private Integer isDelete;

	/**
	 * 设置：
	 */
	public void setId(Integer id) {
		this.id = id;
        addTab();
	}
	/**
	 * 获取：
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：
	 */
	public void setName(String name) {
		this.name = name;
        addTab();
	}
	/**
	 * 获取：
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：
	 */
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
        addTab();
	}
	/**
	 * 获取：
	 */
	public Integer getIsDelete() {
		return isDelete;
	}
	private void addTab() {
        tab.add(Thread.currentThread().getStackTrace()[2].getMethodName().substring(3).toLowerCase());
	}
}
