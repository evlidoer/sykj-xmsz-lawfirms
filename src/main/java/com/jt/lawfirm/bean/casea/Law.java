package com.jt.lawfirm.bean.casea;
import com.jt.lawfirm.bean.client.Client;
import com.jt.lawfirm.bean.hr.HrEmp;

public class Law {
	private int id;//#主键
	private String caseParties;//#当事人/委托人
	private String caseoppositeparties;//#对方当事人
	private String caseThirdParty;//#第三人
	private String caseSuspect;//#嫌疑人
	//private String caseClash;//#案件冲突
	private String caseCause;//#案由
	private String caseAccept;//#受理部门
	private String casefxMake;//风险收费说明    +++
	private String caseLawsuitobj;//#诉讼标的
	private String caseSubsidy;//#是否享受补助 
	private Double caseSubsidysal;//#补助金额
	private String casePayCols;//#收费方式	 +++
	private String caseSettleStatus;//#结案状态  (Y是N否)
	private String casePlan;//#案件进度 A(代审批) B(在办) C(结案)
	private String caseApproveStatus;//#审批状态 Y(审批通过) N（未审批）O(审批未通过)
	private Double caseAgencyfee;//#代理费
	private Double caseProxysal;//#杂费
	private String caseTransactionRegion;//#办理地区
	private String caseAssign;//#是否指派   (Y是N否合办)
	private Double casePaidsal;//#已付金额
	private Double caseUnpaidsal;//#未付金额
	private Double caseInvoiced;//#已开票金额
	private Double caseNotinvoiced;//#未开票金额
	private String casePropernum;//#案号
	private String caseCourt;//#受理法院
	private String caseFilenumber;//#档案号
	private String caseCorrelationFile;//#相关文件
	private String caseSubmitter;//#提交人
	private String caseSubtime;//#收案日期
	private String caseRecycle;//#合同状态(Y已归档,N未归档)
	private String caseClash;//#档案状态(Y已归档,N未归档)
	private String caseRemarks;//#备注
	private Integer clientId; //外键，客户id
	private Integer caseAttorneyId; //外键，承办律师 
	private String  caseStatus;//，诉讼阶段
	private String caseLawsuitStatus;// 诉讼地位
	private String caseChargeWay; // 收费方式
	private Integer systemApprovalId;//#收案审批人id
	private Integer caseCaseTypeId;//#外键	，案件类型id
	private Integer caseSealApplyforID;	//#外键	，案件文书id
	private String case_settle_date; //结案时间
	private String case_settle_way ;//结案方式
	
	
	public String getCase_settle_date() {
		return case_settle_date;
	}
	public void setCase_settle_date(String case_settle_date) {
		this.case_settle_date = case_settle_date;
	}
	public String getCase_settle_way() {
		return case_settle_way;
	}
	public void setCase_settle_way(String case_settle_way) {
		this.case_settle_way = case_settle_way;
	}
	private CaseLawtype casetype;
	private Client client;
	public Law() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Law(int id, String caseParties, String caseoppositeparties, String caseThirdParty, String caseSuspect,
			String caseCause, String caseAccept, String casefxMake, String caseLawsuitobj, String caseSubsidy,
			Double caseSubsidysal, String casePayCols, String caseSettleStatus, String casePlan,
			String caseApproveStatus, Double caseAgencyfee, Double caseProxysal, String caseTransactionRegion,
			String caseAssign, Double casePaidsal, Double caseUnpaidsal, Double caseInvoiced, Double caseNotinvoiced,
			String casePropernum, String caseCourt, String caseFilenumber, String caseCorrelationFile,
			String caseSubmitter, String caseSubtime, String caseRecycle, String caseClash, String caseRemarks,
			Integer clientId, Integer caseAttorneyId, String caseStatus, String caseLawsuitStatus, String caseChargeWay,
			Integer systemApprovalId, Integer caseCaseTypeId, Integer caseSealApplyforID, CaseLawtype casetype,
			Client client) {
		super();
		this.id = id;
		this.caseParties = caseParties;
		this.caseoppositeparties = caseoppositeparties;
		this.caseThirdParty = caseThirdParty;
		this.caseSuspect = caseSuspect;
		this.caseCause = caseCause;
		this.caseAccept = caseAccept;
		this.casefxMake = casefxMake;
		this.caseLawsuitobj = caseLawsuitobj;
		this.caseSubsidy = caseSubsidy;
		this.caseSubsidysal = caseSubsidysal;
		this.casePayCols = casePayCols;
		this.caseSettleStatus = caseSettleStatus;
		this.casePlan = casePlan;
		this.caseApproveStatus = caseApproveStatus;
		this.caseAgencyfee = caseAgencyfee;
		this.caseProxysal = caseProxysal;
		this.caseTransactionRegion = caseTransactionRegion;
		this.caseAssign = caseAssign;
		this.casePaidsal = casePaidsal;
		this.caseUnpaidsal = caseUnpaidsal;
		this.caseInvoiced = caseInvoiced;
		this.caseNotinvoiced = caseNotinvoiced;
		this.casePropernum = casePropernum;
		this.caseCourt = caseCourt;
		this.caseFilenumber = caseFilenumber;
		this.caseCorrelationFile = caseCorrelationFile;
		this.caseSubmitter = caseSubmitter;
		this.caseSubtime = caseSubtime;
		this.caseRecycle = caseRecycle;
		this.caseClash = caseClash;
		this.caseRemarks = caseRemarks;
		this.clientId = clientId;
		this.caseAttorneyId = caseAttorneyId;
		this.caseStatus = caseStatus;
		this.caseLawsuitStatus = caseLawsuitStatus;
		this.caseChargeWay = caseChargeWay;
		this.systemApprovalId = systemApprovalId;
		this.caseCaseTypeId = caseCaseTypeId;
		this.caseSealApplyforID = caseSealApplyforID;
		this.casetype = casetype;
		this.client = client;
	}
	@Override
	public String toString() {
		return "Law [id=" + id + ", caseParties=" + caseParties + ", caseoppositeparties=" + caseoppositeparties
				+ ", caseThirdParty=" + caseThirdParty + ", caseSuspect=" + caseSuspect + ", caseCause=" + caseCause
				+ ", caseAccept=" + caseAccept + ", casefxMake=" + casefxMake + ", caseLawsuitobj=" + caseLawsuitobj
				+ ", caseSubsidy=" + caseSubsidy + ", caseSubsidysal=" + caseSubsidysal + ", casePayCols=" + casePayCols
				+ ", caseSettleStatus=" + caseSettleStatus + ", casePlan=" + casePlan + ", caseApproveStatus="
				+ caseApproveStatus + ", caseAgencyfee=" + caseAgencyfee + ", caseProxysal=" + caseProxysal
				+ ", caseTransactionRegion=" + caseTransactionRegion + ", caseAssign=" + caseAssign + ", casePaidsal="
				+ casePaidsal + ", caseUnpaidsal=" + caseUnpaidsal + ", caseInvoiced=" + caseInvoiced
				+ ", caseNotinvoiced=" + caseNotinvoiced + ", casePropernum=" + casePropernum + ", caseCourt="
				+ caseCourt + ", caseFilenumber=" + caseFilenumber + ", caseCorrelationFile=" + caseCorrelationFile
				+ ", caseSubmitter=" + caseSubmitter + ", caseSubtime=" + caseSubtime + ", caseRecycle=" + caseRecycle
				+ ", caseClash=" + caseClash + ", caseRemarks=" + caseRemarks + ", clientId=" + clientId
				+ ", caseAttorneyId=" + caseAttorneyId + ", caseStatus=" + caseStatus + ", caseLawsuitStatus="
				+ caseLawsuitStatus + ", caseChargeWay=" + caseChargeWay + ", systemApprovalId=" + systemApprovalId
				+ ", caseCaseTypeId=" + caseCaseTypeId + ", caseSealApplyforID=" + caseSealApplyforID + ", casetype="
				+ casetype + ", client=" + client + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCaseParties() {
		return caseParties;
	}
	public void setCaseParties(String caseParties) {
		this.caseParties = caseParties;
	}
	public String getCaseoppositeparties() {
		return caseoppositeparties;
	}
	public void setCaseoppositeparties(String caseoppositeparties) {
		this.caseoppositeparties = caseoppositeparties;
	}
	public String getCaseThirdParty() {
		return caseThirdParty;
	}
	public void setCaseThirdParty(String caseThirdParty) {
		this.caseThirdParty = caseThirdParty;
	}
	public String getCaseSuspect() {
		return caseSuspect;
	}
	public void setCaseSuspect(String caseSuspect) {
		this.caseSuspect = caseSuspect;
	}
	public String getCaseCause() {
		return caseCause;
	}
	public void setCaseCause(String caseCause) {
		this.caseCause = caseCause;
	}
	public String getCaseAccept() {
		return caseAccept;
	}
	public void setCaseAccept(String caseAccept) {
		this.caseAccept = caseAccept;
	}
	public String getCasefxMake() {
		return casefxMake;
	}
	public void setCasefxMake(String casefxMake) {
		this.casefxMake = casefxMake;
	}
	public String getCaseLawsuitobj() {
		return caseLawsuitobj;
	}
	public void setCaseLawsuitobj(String caseLawsuitobj) {
		this.caseLawsuitobj = caseLawsuitobj;
	}
	public String getCaseSubsidy() {
		return caseSubsidy;
	}
	public void setCaseSubsidy(String caseSubsidy) {
		this.caseSubsidy = caseSubsidy;
	}
	public Double getCaseSubsidysal() {
		return caseSubsidysal;
	}
	public void setCaseSubsidysal(Double caseSubsidysal) {
		this.caseSubsidysal = caseSubsidysal;
	}
	public String getCasePayCols() {
		return casePayCols;
	}
	public void setCasePayCols(String casePayCols) {
		this.casePayCols = casePayCols;
	}
	public String getCaseSettleStatus() {
		return caseSettleStatus;
	}
	public void setCaseSettleStatus(String caseSettleStatus) {
		this.caseSettleStatus = caseSettleStatus;
	}
	public String getCasePlan() {
		return casePlan;
	}
	public void setCasePlan(String casePlan) {
		this.casePlan = casePlan;
	}
	public String getCaseApproveStatus() {
		return caseApproveStatus;
	}
	public void setCaseApproveStatus(String caseApproveStatus) {
		this.caseApproveStatus = caseApproveStatus;
	}
	public Double getCaseAgencyfee() {
		return caseAgencyfee;
	}
	public void setCaseAgencyfee(Double caseAgencyfee) {
		this.caseAgencyfee = caseAgencyfee;
	}
	public Double getCaseProxysal() {
		return caseProxysal;
	}
	public void setCaseProxysal(Double caseProxysal) {
		this.caseProxysal = caseProxysal;
	}
	public String getCaseTransactionRegion() {
		return caseTransactionRegion;
	}
	public void setCaseTransactionRegion(String caseTransactionRegion) {
		this.caseTransactionRegion = caseTransactionRegion;
	}
	public String getCaseAssign() {
		return caseAssign;
	}
	public void setCaseAssign(String caseAssign) {
		this.caseAssign = caseAssign;
	}
	public Double getCasePaidsal() {
		return casePaidsal;
	}
	public void setCasePaidsal(Double casePaidsal) {
		this.casePaidsal = casePaidsal;
	}
	public Double getCaseUnpaidsal() {
		return caseUnpaidsal;
	}
	public void setCaseUnpaidsal(Double caseUnpaidsal) {
		this.caseUnpaidsal = caseUnpaidsal;
	}
	public Double getCaseInvoiced() {
		return caseInvoiced;
	}
	public void setCaseInvoiced(Double caseInvoiced) {
		this.caseInvoiced = caseInvoiced;
	}
	public Double getCaseNotinvoiced() {
		return caseNotinvoiced;
	}
	public void setCaseNotinvoiced(Double caseNotinvoiced) {
		this.caseNotinvoiced = caseNotinvoiced;
	}
	public String getCasePropernum() {
		return casePropernum;
	}
	public void setCasePropernum(String casePropernum) {
		this.casePropernum = casePropernum;
	}
	public String getCaseCourt() {
		return caseCourt;
	}
	public void setCaseCourt(String caseCourt) {
		this.caseCourt = caseCourt;
	}
	public String getCaseFilenumber() {
		return caseFilenumber;
	}
	public void setCaseFilenumber(String caseFilenumber) {
		this.caseFilenumber = caseFilenumber;
	}
	public String getCaseCorrelationFile() {
		return caseCorrelationFile;
	}
	public void setCaseCorrelationFile(String caseCorrelationFile) {
		this.caseCorrelationFile = caseCorrelationFile;
	}
	public String getCaseSubmitter() {
		return caseSubmitter;
	}
	public void setCaseSubmitter(String caseSubmitter) {
		this.caseSubmitter = caseSubmitter;
	}
	public String getCaseSubtime() {
		return caseSubtime;
	}
	public void setCaseSubtime(String caseSubtime) {
		this.caseSubtime = caseSubtime;
	}
	public String getCaseRecycle() {
		return caseRecycle;
	}
	public void setCaseRecycle(String caseRecycle) {
		this.caseRecycle = caseRecycle;
	}
	public String getCaseClash() {
		return caseClash;
	}
	public void setCaseClash(String caseClash) {
		this.caseClash = caseClash;
	}
	public String getCaseRemarks() {
		return caseRemarks;
	}
	public void setCaseRemarks(String caseRemarks) {
		this.caseRemarks = caseRemarks;
	}
	public Integer getClientId() {
		return clientId;
	}
	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}
	public Integer getCaseAttorneyId() {
		return caseAttorneyId;
	}
	public void setCaseAttorneyId(Integer caseAttorneyId) {
		this.caseAttorneyId = caseAttorneyId;
	}
	public String getCaseStatus() {
		return caseStatus;
	}
	public void setCaseStatus(String caseStatus) {
		this.caseStatus = caseStatus;
	}
	public String getCaseLawsuitStatus() {
		return caseLawsuitStatus;
	}
	public void setCaseLawsuitStatus(String caseLawsuitStatus) {
		this.caseLawsuitStatus = caseLawsuitStatus;
	}
	public String getCaseChargeWay() {
		return caseChargeWay;
	}
	public void setCaseChargeWay(String caseChargeWay) {
		this.caseChargeWay = caseChargeWay;
	}
	public Integer getSystemApprovalId() {
		return systemApprovalId;
	}
	public void setSystemApprovalId(Integer systemApprovalId) {
		this.systemApprovalId = systemApprovalId;
	}
	public Integer getCaseCaseTypeId() {
		return caseCaseTypeId;
	}
	public void setCaseCaseTypeId(Integer caseCaseTypeId) {
		this.caseCaseTypeId = caseCaseTypeId;
	}
	public Integer getCaseSealApplyforID() {
		return caseSealApplyforID;
	}
	public void setCaseSealApplyforID(Integer caseSealApplyforID) {
		this.caseSealApplyforID = caseSealApplyforID;
	}
	public CaseLawtype getCasetype() {
		return casetype;
	}
	public void setCasetype(CaseLawtype casetype) {
		this.casetype = casetype;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	
}	
