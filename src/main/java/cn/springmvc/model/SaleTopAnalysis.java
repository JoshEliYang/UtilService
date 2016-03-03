package cn.springmvc.model;

// resources ： r_base_dict_item、e_order_info、e_order_extinfo、e_order_detail
public class SaleTopAnalysis {

	private String order_CREATE_DATE;

	private String store_TYPENAME;

	private String store_NAME;

	private String client_TYPENAME;

	private String goods_class_name;

	private String cargo_NAME;

	private String purchaseAmount;

	private String payamount;

	private String saleCount;

	private String saleamount;

	private String totalRate;

	private String ratePercent;

	private String jinbuCount;

	private String jinbuAmount;

	public String getORDER_CREATE_DATE() {
		return order_CREATE_DATE;
	}

	public void setORDER_CREATE_DATE(String oRDER_CREATE_DATE) {
		order_CREATE_DATE = oRDER_CREATE_DATE;
	}

	public String getSTORE_TYPENAME() {
		return store_TYPENAME;
	}

	public void setSTORE_TYPENAME(String sTORE_TYPENAME) {
		store_TYPENAME = sTORE_TYPENAME;
	}

	public String getSTORE_NAME() {
		return store_NAME;
	}

	public void setSTORE_NAME(String sTORE_NAME) {
		store_NAME = sTORE_NAME;
	}

	public String getCLIENT_TYPENAME() {
		return client_TYPENAME;
	}

	public void setCLIENT_TYPENAME(String cLIENT_TYPENAME) {
		client_TYPENAME = cLIENT_TYPENAME;
	}

	public String getGoods_class_name() {
		return goods_class_name;
	}

	public void setGoods_class_name(String goods_class_name) {
		this.goods_class_name = goods_class_name;
	}

	public String getCARGO_NAME() {
		return cargo_NAME;
	}

	public void setCARGO_NAME(String cARGO_NAME) {
		cargo_NAME = cARGO_NAME;
	}

	public String getPurchaseAmount() {
		return purchaseAmount;
	}

	public void setPurchaseAmount(String purchaseAmount) {
		this.purchaseAmount = purchaseAmount;
	}

	public String getPAYAMOUNT() {
		return payamount;
	}

	public void setPAYAMOUNT(String pAYAMOUNT) {
		payamount = pAYAMOUNT;
	}

	public String getSaleCount() {
		return saleCount;
	}

	public void setSaleCount(String saleCount) {
		this.saleCount = saleCount;
	}

	public String getSALEAMOUNT() {
		return saleamount;
	}

	public void setSALEAMOUNT(String sALEAMOUNT) {
		saleamount = sALEAMOUNT;
	}

	public String getTotalRate() {
		return totalRate;
	}

	public void setTotalRate(String totalRate) {
		this.totalRate = totalRate;
	}

	public String getRatePercent() {
		return ratePercent;
	}

	public void setRatePercent(String ratePercent) {
		this.ratePercent = ratePercent;
	}

	public String getJinbuCount() {
		return jinbuCount;
	}

	public void setJinbuCount(String jinbuCount) {
		this.jinbuCount = jinbuCount;
	}

	public String getJinbuAmount() {
		return jinbuAmount;
	}

	public void setJinbuAmount(String jinbuAmount) {
		this.jinbuAmount = jinbuAmount;
	}

	public SaleTopAnalysis(String order_CREATE_DATE, String store_TYPENAME,
			String store_NAME, String client_TYPENAME, String goods_class_name,
			String cargo_NAME, String purchaseAmount, String payamount,
			String saleCount, String saleamount, String totalRate,
			String ratePercent, String jinbuCount, String jinbuAmount) {
		super();
		this.order_CREATE_DATE = order_CREATE_DATE;
		this.store_TYPENAME = store_TYPENAME;
		this.store_NAME = store_NAME;
		this.client_TYPENAME = client_TYPENAME;
		this.goods_class_name = goods_class_name;
		this.cargo_NAME = cargo_NAME;
		this.purchaseAmount = purchaseAmount;
		this.payamount = payamount;
		this.saleCount = saleCount;
		this.saleamount = saleamount;
		this.totalRate = totalRate;
		this.ratePercent = ratePercent;
		this.jinbuCount = jinbuCount;
		this.jinbuAmount = jinbuAmount;
	}

	public SaleTopAnalysis() {
		super();
		// TODO Auto-generated constructor stub
	}

}
