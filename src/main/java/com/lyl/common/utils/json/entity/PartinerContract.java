package com.lyl.common.utils.json.entity;

import java.io.Serializable;
import java.util.Date;

public class PartinerContract implements Serializable {
	
	private static final long serialVersionUID = -933013074275301636L;

	/**
	 * 2/8模式
	 * - 合作模式
	 * - Two Eight
	 */
	public static final String MODEL_TWO_EIGHT = "1";

	/**
	 * 品牌共创
	 * - 合作模式
	 * - Brand Co-creation
	 */
	public static final String MODEL_BRAND_CO_CREATION = "2";
	
	/**
	 * 平台输出
	 * - 合作模式
	 * - Platform output
	 */
	public static final String MODEL_PLATFORM_OUTPUT = "3";
	
	/**
	 * 系统定制
	 * - 合作模式
	 * - System Customize
	 */
	public static final String MODEL_SYSTEM_CUSTOMIZE = "4";
	
	/**
	 * 其它
	 * - 合作模式
	 * - Other
	 */
	public static final String MODEL_OTHER = "0";
	
	/**
	 * 草拟
	 * - 合同状态
	 */
	public static final String STATUS_DRAFT = "0";
	
	/**
	 * 审批中
	 * - 合同状态
	 */
	public final static String STATUS_AUDITING = "1";
	
	/**
	 * 生效
	 * - 合同状态
	 */
	public final static String STATUS_EFFECT = "2";	
	
	/**
	 * 待续签(合同已经到期,继续发送巡视任务)
	 * - 合同状态
	 */
	public final static String STATUS_WAITING = "10";
	
	/**
	 * 结束
	 * - 合同状态
	 */
	public final static String STATUS_FINISHED = "3";
	
	/**
	 * 正洽谈合同条款
	 * - 合同状态
	 */
	public final static String STATUS_DISCUSS = "4";
	/**
	 * 已呈送盖章纸质合同
	 * - 合同状态
	 */
	public final static String STATUS_STAMP = "5";
	/**
	 * 合同取消（流失）
	 * - 合同状态
	 */
	public final static String STATUS_CANCEL = "9";
	
	private String id;
	
	/**
	 * 合同名称
	 */
	
	private String contractName;
	
	/**
	 * 合同编号
	 */
	
	private String contractCode;
	
	/**
	 * 单位ID
	 */
	
	private String unitId;
	
	/**
	 * 单位名称
	 */
	
	private String unitName;
	
	/**
	 * 签订日期
	 */
	
	private Date signDate;
	
	/**
	 * 主要负责人
	 */
	
	private String principal;
	
	/**
	 * 联系电话
	 */
	
	private String contactPhone;
	
	/**
	 * 联系地址
	 */
	
	private String contactAddress;
	
	/**
	 * 合作模式
	 */
	
	private String cooperationModel;
	
	/**
	 * 合同状态
	 */
	
	private String status;
	
	/**
	 * 邮箱
	 */
	
	private String email;
	
	/**
	 * 备注
	 */
	
	private String remark;
	
	/**
	 * 培训费
	 */
	
	private Double trainCost;
	
	/**
	 * 培训费应收日期
	 */
	
	private Date trainCostEffectDate;
	
	/**
	 * 培训费实收日期
	 */
	
	private Date trainCostPayDate;
	
	/**
	 * 业务保证金
	 */
	
	private Double businessPledgeCost;
	
	/**
	 * 业务保证金应收日期
	 */
	
	private Date businessPledgeCostEffectDate;
	
	/**
	 * 业务保证金实收日期
	 */
	
	private Date businessPledgeCostPayDate;
	
	/**
	 * 考核周期
	 */
	
	private Integer assessPeriod;
	
	/**
	 * 考核上线台数
	 */
	
	private Integer assessOnLineZoneAreaQuantity;
	
	/**
	 * 平台初始使用费
	 */
	
	private Double platformInitalUseCost;
	
	/**
	 * 平台初始使用费应收日期
	 */
	
	private Date platformInitalUseCostEffectDate;
	
	/**
	 * 平台初始使用费实收日期
	 */
	
	private Date platformInitalUseCostPayDate;
	
	/**
	 * VI定制费
	 */
	
	private Double VICustomizeCost;
	
	/**
	 * VI定制费应收日期
	 */
	
	private Date VICustomizeCostEffectDate;
	
	/**
	 * VI定制费实收日期
	 */
	
	private Date VICustomizeCostPayDate;
	
	/**
	 * 功能开发费
	 */
	
	private Double functionExploitCost;
	
	/**
	 * 功能开发费应收日期
	 */
	
	private Date functionExploitCostEffectDate;
	
	/**
	 * 功能开发费实收日期
	 */
	
	private Date functionExploitCostPayDate;
	
	/**
	 * 传输点保底额
	 */
	
	private Double transportNetityPledgeCost;
	
	/**
	 * 传输点保底额应收日期
	 */
	
	private Date transportNetityPledgeCostEffectDate;
	
	/**
	 * 传输点保底额实收日期
	 */
	
	private Date transportNetityPledgeCostPayDate;
	
	/**
	 * 考核传输点数
	 */
	
	private Integer assessTransportNetityQuantity;
	
	/**
	 * 考核监测点数
	 */
	
	private Integer assessWatchPointQuantity;
	
	/**
	 * 考核短信数
	 */
	
	private Integer assessShortMessageQuantity;
	
	/**
	 * 短信单价
	 */
	
	private Double shortMessageUnitPrice;
	
	/**
	 * 监测点费用
	 */
	
	private Double watchPointCost;
	
	/**
	 * 监测点费用应收日期
	 */
	
	private Date watchPointCostEffectDate;
	
	/**
	 * 监测点费用实收日期
	 */
	
	private Date watchPointCostPayDate;
	
	/**
	 * 监测点保底额
	 */
	
	private Double watchPointPledgeCost;
	
	/**
	 * 监测点保底额应收日期
	 */
	
	private Date watchPointPledgeCostEffectDate;
	
	/**
	 * 监测点保底额实收日期
	 */
	
	private Date watchPointPledgeCostPayDate;
	
	/**
	 * 传输点信息
	 */
	
	
	/**
	 * 组织id
	 */
	private String orgId;
	
	/**
     * 排序
     */
    private Integer orderNO;
    
    /**
     * 是否可用
     */
    private Boolean enabled;
    
    /**
     * 录入日期
     */
    private Date recordDate;
    
    /**
     * 修改人
     */
    
    /**
     * 修改日期
     */
    private Date modifyDate;
    
    /**
     * 删除人
     */
    
    /**
     * 删除日期
     */
    private Date disableDate;
	
	/**
	 * 附件id
	 */
	private String attId;
	
	/**
	 * 更新时删除的传输点
	 * id1,id2...
	 */
	private String delTransportNetitys;
	
	private Date cancelDate;
	
	private String reason;
	
	private String dataOwner;
	
	private String tenant;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContractName() {
		return contractName;
	}

	public void setContractName(String contractName) {
		this.contractName = contractName;
	}

	public String getContractCode() {
		return contractCode;
	}

	public void setContractCode(String contractCode) {
		this.contractCode = contractCode;
	}

	public String getUnitId() {
		return unitId;
	}

	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public Date getSignDate() {
		return signDate;
	}

	public void setSignDate(Date signDate) {
		this.signDate = signDate;
	}

	public String getPrincipal() {
		return principal;
	}

	public void setPrincipal(String principal) {
		this.principal = principal;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public String getContactAddress() {
		return contactAddress;
	}

	public void setContactAddress(String contactAddress) {
		this.contactAddress = contactAddress;
	}

	public String getCooperationModel() {
		return cooperationModel;
	}

	public void setCooperationModel(String cooperationModel) {
		this.cooperationModel = cooperationModel;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Double getTrainCost() {
		return trainCost;
	}

	public void setTrainCost(Double trainCost) {
		this.trainCost = trainCost;
	}

	public Date getTrainCostEffectDate() {
		return trainCostEffectDate;
	}

	public void setTrainCostEffectDate(Date trainCostEffectDate) {
		this.trainCostEffectDate = trainCostEffectDate;
	}

	public Date getTrainCostPayDate() {
		return trainCostPayDate;
	}

	public void setTrainCostPayDate(Date trainCostPayDate) {
		this.trainCostPayDate = trainCostPayDate;
	}

	public Double getBusinessPledgeCost() {
		return businessPledgeCost;
	}

	public void setBusinessPledgeCost(Double businessPledgeCost) {
		this.businessPledgeCost = businessPledgeCost;
	}

	public Date getBusinessPledgeCostEffectDate() {
		return businessPledgeCostEffectDate;
	}

	public void setBusinessPledgeCostEffectDate(Date businessPledgeCostEffectDate) {
		this.businessPledgeCostEffectDate = businessPledgeCostEffectDate;
	}

	public Date getBusinessPledgeCostPayDate() {
		return businessPledgeCostPayDate;
	}

	public void setBusinessPledgeCostPayDate(Date businessPledgeCostPayDate) {
		this.businessPledgeCostPayDate = businessPledgeCostPayDate;
	}

	public Integer getAssessPeriod() {
		return assessPeriod;
	}

	public void setAssessPeriod(Integer assessPeriod) {
		this.assessPeriod = assessPeriod;
	}

	public Integer getAssessOnLineZoneAreaQuantity() {
		return assessOnLineZoneAreaQuantity;
	}

	public void setAssessOnLineZoneAreaQuantity(Integer assessOnLineZoneAreaQuantity) {
		this.assessOnLineZoneAreaQuantity = assessOnLineZoneAreaQuantity;
	}

	public Double getPlatformInitalUseCost() {
		return platformInitalUseCost;
	}

	public void setPlatformInitalUseCost(Double platformInitalUseCost) {
		this.platformInitalUseCost = platformInitalUseCost;
	}

	public Date getPlatformInitalUseCostEffectDate() {
		return platformInitalUseCostEffectDate;
	}

	public void setPlatformInitalUseCostEffectDate(Date platformInitalUseCostEffectDate) {
		this.platformInitalUseCostEffectDate = platformInitalUseCostEffectDate;
	}

	public Date getPlatformInitalUseCostPayDate() {
		return platformInitalUseCostPayDate;
	}

	public void setPlatformInitalUseCostPayDate(Date platformInitalUseCostPayDate) {
		this.platformInitalUseCostPayDate = platformInitalUseCostPayDate;
	}

	public Double getVICustomizeCost() {
		return VICustomizeCost;
	}

	public void setVICustomizeCost(Double vICustomizeCost) {
		VICustomizeCost = vICustomizeCost;
	}

	public Date getVICustomizeCostEffectDate() {
		return VICustomizeCostEffectDate;
	}

	public void setVICustomizeCostEffectDate(Date vICustomizeCostEffectDate) {
		VICustomizeCostEffectDate = vICustomizeCostEffectDate;
	}

	public Date getVICustomizeCostPayDate() {
		return VICustomizeCostPayDate;
	}

	public void setVICustomizeCostPayDate(Date vICustomizeCostPayDate) {
		VICustomizeCostPayDate = vICustomizeCostPayDate;
	}

	public Double getFunctionExploitCost() {
		return functionExploitCost;
	}

	public void setFunctionExploitCost(Double functionExploitCost) {
		this.functionExploitCost = functionExploitCost;
	}

	public Date getFunctionExploitCostEffectDate() {
		return functionExploitCostEffectDate;
	}

	public void setFunctionExploitCostEffectDate(Date functionExploitCostEffectDate) {
		this.functionExploitCostEffectDate = functionExploitCostEffectDate;
	}

	public Date getFunctionExploitCostPayDate() {
		return functionExploitCostPayDate;
	}

	public void setFunctionExploitCostPayDate(Date functionExploitCostPayDate) {
		this.functionExploitCostPayDate = functionExploitCostPayDate;
	}

	public Double getTransportNetityPledgeCost() {
		return transportNetityPledgeCost;
	}

	public void setTransportNetityPledgeCost(Double transportNetityPledgeCost) {
		this.transportNetityPledgeCost = transportNetityPledgeCost;
	}

	public Date getTransportNetityPledgeCostEffectDate() {
		return transportNetityPledgeCostEffectDate;
	}

	public void setTransportNetityPledgeCostEffectDate(Date transportNetityPledgeCostEffectDate) {
		this.transportNetityPledgeCostEffectDate = transportNetityPledgeCostEffectDate;
	}

	public Date getTransportNetityPledgeCostPayDate() {
		return transportNetityPledgeCostPayDate;
	}

	public void setTransportNetityPledgeCostPayDate(Date transportNetityPledgeCostPayDate) {
		this.transportNetityPledgeCostPayDate = transportNetityPledgeCostPayDate;
	}

	public Integer getAssessTransportNetityQuantity() {
		return assessTransportNetityQuantity;
	}

	public void setAssessTransportNetityQuantity(Integer assessTransportNetityQuantity) {
		this.assessTransportNetityQuantity = assessTransportNetityQuantity;
	}

	public Integer getAssessWatchPointQuantity() {
		return assessWatchPointQuantity;
	}

	public void setAssessWatchPointQuantity(Integer assessWatchPointQuantity) {
		this.assessWatchPointQuantity = assessWatchPointQuantity;
	}

	public Integer getAssessShortMessageQuantity() {
		return assessShortMessageQuantity;
	}

	public void setAssessShortMessageQuantity(Integer assessShortMessageQuantity) {
		this.assessShortMessageQuantity = assessShortMessageQuantity;
	}

	public Double getShortMessageUnitPrice() {
		return shortMessageUnitPrice;
	}

	public void setShortMessageUnitPrice(Double shortMessageUnitPrice) {
		this.shortMessageUnitPrice = shortMessageUnitPrice;
	}

	public Double getWatchPointCost() {
		return watchPointCost;
	}

	public void setWatchPointCost(Double watchPointCost) {
		this.watchPointCost = watchPointCost;
	}

	public Date getWatchPointCostEffectDate() {
		return watchPointCostEffectDate;
	}

	public void setWatchPointCostEffectDate(Date watchPointCostEffectDate) {
		this.watchPointCostEffectDate = watchPointCostEffectDate;
	}

	public Date getWatchPointCostPayDate() {
		return watchPointCostPayDate;
	}

	public void setWatchPointCostPayDate(Date watchPointCostPayDate) {
		this.watchPointCostPayDate = watchPointCostPayDate;
	}

	public Double getWatchPointPledgeCost() {
		return watchPointPledgeCost;
	}

	public void setWatchPointPledgeCost(Double watchPointPledgeCost) {
		this.watchPointPledgeCost = watchPointPledgeCost;
	}

	public Date getWatchPointPledgeCostEffectDate() {
		return watchPointPledgeCostEffectDate;
	}

	public void setWatchPointPledgeCostEffectDate(Date watchPointPledgeCostEffectDate) {
		this.watchPointPledgeCostEffectDate = watchPointPledgeCostEffectDate;
	}

	public Date getWatchPointPledgeCostPayDate() {
		return watchPointPledgeCostPayDate;
	}

	public void setWatchPointPledgeCostPayDate(Date watchPointPledgeCostPayDate) {
		this.watchPointPledgeCostPayDate = watchPointPledgeCostPayDate;
	}

	public Integer getOrderNO() {
		return orderNO;
	}

	public void setOrderNO(Integer orderNO) {
		this.orderNO = orderNO;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}


	public Date getRecordDate() {
		return recordDate;
	}

	public void setRecordDate(Date recordDate) {
		this.recordDate = recordDate;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public Date getDisableDate() {
		return disableDate;
	}

	public void setDisableDate(Date disableDate) {
		this.disableDate = disableDate;
	}
	
	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getAttId() {
		return attId;
	}

	public void setAttId(String attId) {
		this.attId = attId;
	}

	public String getDelTransportNetitys() {
		return delTransportNetitys;
	}

	public void setDelTransportNetitys(String delTransportNetitys) {
		this.delTransportNetitys = delTransportNetitys;
	}

	public Date getCancelDate() {
		return cancelDate;
	}

	public void setCancelDate(Date cancelDate) {
		this.cancelDate = cancelDate;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getDataOwner() {
		return dataOwner;
	}

	public void setDataOwner(String dataOwner) {
		this.dataOwner = dataOwner;
	}

	public String getTenant() {
		return tenant;
	}

	public void setTenant(String tenant) {
		this.tenant = tenant;
	}

	/**
	 * 是否为平台输出模式, 用于判断是否需要关联传输点信息
	 */
	public boolean isPlatformOutput() {
		return PartinerContract.MODEL_PLATFORM_OUTPUT.equals(this.getCooperationModel());
	}

}
