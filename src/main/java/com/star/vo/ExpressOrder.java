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
 * @date 2019-05-21 08:39:45
 */

public class ExpressOrder extends Vo implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	
			private Integer id;
	/**
	 * 
	 */
			private String phone;
	/**
	 * 
	 */
			private String userName;
	/**
	 * 
	 */
			@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date createTime;
	/**
	 * 
	 */
			private String doorAdress;
	/**
	 * 
	 */
			@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date doorTime;
	/**
	 * 
	 */
			private Integer status;
	/**
	 * 
	 */
			private Integer isDelete;
	/**
	 * 
	 */
			private String content;

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
	public void setPhone(String phone) {
		this.phone = phone;
        addTab();
	}
	/**
	 * 获取：
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * 设置：
	 */
	public void setUserName(String userName) {
		this.userName = userName;
        addTab();
	}
	/**
	 * 获取：
	 */
	public String getUserName() {
		return userName;
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
	public void setDoorAdress(String doorAdress) {
		this.doorAdress = doorAdress;
        addTab();
	}
	/**
	 * 获取：
	 */
	public String getDoorAdress() {
		return doorAdress;
	}
	/**
	 * 设置：
	 */
	public void setDoorTime(Date doorTime) {
		this.doorTime = doorTime;
        addTab();
	}
	/**
	 * 获取：
	 */
	public Date getDoorTime() {
		return doorTime;
	}
	/**
	 * 设置：
	 */
	public void setStatus(Integer status) {
		this.status = status;
        addTab();
	}
	/**
	 * 获取：
	 */
	public Integer getStatus() {
		return status;
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
	public void setContent(String content) {
		this.content = content;
        addTab();
	}
	/**
	 * 获取：
	 */
	public String getContent() {
		return content;
	}
	private void addTab() {
        tab.add(Thread.currentThread().getStackTrace()[2].getMethodName().substring(3).toLowerCase());
	}
}
