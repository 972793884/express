package com.star.vo;



import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import com.star.controller.Vo;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 
 * 
 * @author zzq
 * @email 972793884@qq.com
 * @date 2019-05-21 14:56:15
 */

public class Express extends Vo implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	
			private Integer id;
	/**
	 * 单号
	 */
			private String code;
	/**
	 * 
	 */
			private String userNameSend;
	/**
	 * 
	 */
			private String userNameRecive;
	/**
	 * 
	 */
			private String phoneSend;
	/**
	 * 
	 */
			private String phoneRecive;
	/**
	 * 
	 */
			private String adressSend;
	/**
	 * 
	 */
			private String adressRecive;
	/**
	 * 
	 */
			private String content;
	/**
	 * 
	 */
			private BigDecimal price;
	/**
	 * 
	 */
			private BigDecimal weight;
	/**
	 * 
	 */
			private Integer createUser;
	/**
	 * 
	 */
			@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date createTime;
	/**
	 * 
	 */
			@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date updateTime;
	/**
	 * 0代发件1已发件2已到件3已完成
	 */
			private Integer status;
	/**
	 * 
	 */
			private Integer isDelete;
	/**
	 * 
	 */
			private Integer overtime;
	/**
	 * 
	 */
			@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date overtimeTime;
	/**
	 * 
	 */
			private Integer companyId;
	/**
	 * 
	 */
			private Integer expressOrderId;
	/**
	 * 
	 */
			private String pickupCode;
	/**
	 * 
	 */
		@JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
		private Date latestPickupTime;

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
	 * 设置：单号
	 */
	public void setCode(String code) {
		this.code = code;
        addTab();
	}
	/**
	 * 获取：单号
	 */
	public String getCode() {
		return code;
	}
	/**
	 * 设置：
	 */
	public void setUserNameSend(String userNameSend) {
		this.userNameSend = userNameSend;
        addTab();
	}
	/**
	 * 获取：
	 */
	public String getUserNameSend() {
		return userNameSend;
	}
	/**
	 * 设置：
	 */
	public void setUserNameRecive(String userNameRecive) {
		this.userNameRecive = userNameRecive;
        addTab();
	}
	/**
	 * 获取：
	 */
	public String getUserNameRecive() {
		return userNameRecive;
	}
	/**
	 * 设置：
	 */
	public void setPhoneSend(String phoneSend) {
		this.phoneSend = phoneSend;
        addTab();
	}
	/**
	 * 获取：
	 */
	public String getPhoneSend() {
		return phoneSend;
	}
	/**
	 * 设置：
	 */
	public void setPhoneRecive(String phoneRecive) {
		this.phoneRecive = phoneRecive;
        addTab();
	}
	/**
	 * 获取：
	 */
	public String getPhoneRecive() {
		return phoneRecive;
	}
	/**
	 * 设置：
	 */
	public void setAdressSend(String adressSend) {
		this.adressSend = adressSend;
        addTab();
	}
	/**
	 * 获取：
	 */
	public String getAdressSend() {
		return adressSend;
	}
	/**
	 * 设置：
	 */
	public void setAdressRecive(String adressRecive) {
		this.adressRecive = adressRecive;
        addTab();
	}
	/**
	 * 获取：
	 */
	public String getAdressRecive() {
		return adressRecive;
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
	/**
	 * 设置：
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
        addTab();
	}
	/**
	 * 获取：
	 */
	public BigDecimal getPrice() {
		return price;
	}
	/**
	 * 设置：
	 */
	public void setWeight(BigDecimal weight) {
		this.weight = weight;
        addTab();
	}
	/**
	 * 获取：
	 */
	public BigDecimal getWeight() {
		return weight;
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
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
        addTab();
	}
	/**
	 * 获取：
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
	/**
	 * 设置：0代发件1已发件2已到件3已完成
	 */
	public void setStatus(Integer status) {
		this.status = status;
        addTab();
	}
	/**
	 * 获取：0代发件1已发件2已到件3已完成
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
	public void setOvertime(Integer overtime) {
		this.overtime = overtime;
        addTab();
	}
	/**
	 * 获取：
	 */
	public Integer getOvertime() {
		return overtime;
	}
	/**
	 * 设置：
	 */
	public void setOvertimeTime(Date overtimeTime) {
		this.overtimeTime = overtimeTime;
        addTab();
	}
	/**
	 * 获取：
	 */
	public Date getOvertimeTime() {
		return overtimeTime;
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
	/**
	 * 设置：
	 */
	public void setExpressOrderId(Integer expressOrderId) {
		this.expressOrderId = expressOrderId;
        addTab();
	}
	/**
	 * 获取：
	 */
	public Integer getExpressOrderId() {
		return expressOrderId;
	}
	/**
	 * 设置：
	 */
	public void setPickupCode(String pickupCode) {
		this.pickupCode = pickupCode;
        addTab();
	}
	/**
	 * 获取：
	 */
	public String getPickupCode() {
		return pickupCode;
	}
	/**
	 * 设置：
	 */
	public void setLatestPickupTime(Date latestPickupTime) {
		this.latestPickupTime = latestPickupTime;
        addTab();
	}
	/**
	 * 获取：
	 */
	public Date getLatestPickupTime() {
		return latestPickupTime;
	}
	private void addTab() {
        tab.add(Thread.currentThread().getStackTrace()[2].getMethodName().substring(3).toLowerCase());
	}
}
