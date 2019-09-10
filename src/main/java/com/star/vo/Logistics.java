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

public class Logistics extends Vo implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	
			private Integer id;
	/**
	 * 
	 */
			private Integer expressId;
	/**
	 * 
	 */
			@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date createTime;
	/**
	 * 
	 */
			private String currentAdress;
	/**
	 * 
	 */
			private String nextAdress;
	/**
	 * 
	 */
			private Integer createUser;
	/**
	 * 
	 */
			@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date arriveTime;
	/**
	 * 
	 */
			private Integer isDelete;
	/**
	 * 
	 */
			private Integer companyId;
			private String companyName;

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

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
	public void setExpressId(Integer expressId) {
		this.expressId = expressId;
        addTab();
	}
	/**
	 * 获取：
	 */
	public Integer getExpressId() {
		return expressId;
	}
	/**
	 * 设置：
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
        addTab();
	}
	/**
	 * 获取：
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：
	 */
	public void setCurrentAdress(String currentAdress) {
		this.currentAdress = currentAdress;
        addTab();
	}
	/**
	 * 获取：
	 */
	public String getCurrentAdress() {
		return currentAdress;
	}
	/**
	 * 设置：
	 */
	public void setNextAdress(String nextAdress) {
		this.nextAdress = nextAdress;
        addTab();
	}
	/**
	 * 获取：
	 */
	public String getNextAdress() {
		return nextAdress;
	}
	/**
	 * 设置：
	 */
	public void setCreateUser(Integer createUser) {
		this.createUser = createUser;
        addTab();
	}
	/**
	 * 获取：
	 */
	public Integer getCreateUser() {
		return createUser;
	}
	/**
	 * 设置：
	 */
	public void setArriveTime(Date arriveTime) {
		this.arriveTime = arriveTime;
        addTab();
	}
	/**
	 * 获取：
	 */
	public Date getArriveTime() {
		return arriveTime;
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
	/**
	 * 设置：
	 */
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
        addTab();
	}
	/**
	 * 获取：
	 */
	public Integer getCompanyId() {
		return companyId;
	}
	private void addTab() {
        tab.add(Thread.currentThread().getStackTrace()[2].getMethodName().substring(3).toLowerCase());
	}
}
