package cn.springmvc.model;

/**
 * 
 * @author johnson
 *
 */
public class GSystem {
	int sysId;
	String sysName;
	String code;
	String sysUrl;
	String remark;

	@Override
	public String toString() {
		return "System [sysId=" + sysId + ", sysName=" + sysName + ", code=" + code + ", sysUrl=" + sysUrl + ", remark="
				+ remark + "]";
	}

	public int getSysId() {
		return sysId;
	}

	public void setSysId(int sysId) {
		this.sysId = sysId;
	}

	public String getSysName() {
		return sysName;
	}

	public void setSysName(String sysName) {
		this.sysName = sysName;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getSysUrl() {
		return sysUrl;
	}

	public void setSysUrl(String sysUrl) {
		this.sysUrl = sysUrl;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
