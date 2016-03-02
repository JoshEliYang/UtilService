package cn.springmvc.model;

public class DailySalesAnalysis {

	private String order_CREATE_DATE;

	private String dayWeek;

	private String client_TYPENAME;

	private String store_TYPENAME;

	private String store_NAME;

	private String order_PRICE;

	private String order_NUMBER;

	private String orderamount;

	private String allyh;

	private String payment_AMOUNT;

	public String getORDER_CREATE_DATE() {
		return order_CREATE_DATE;
	}

	public void setORDER_CREATE_DATE(String oRDER_CREATE_DATE) {
		order_CREATE_DATE = oRDER_CREATE_DATE;
	}

	public String getDayWeek() {
		return dayWeek;
	}

	public void setDayWeek(String dayWeek) {
		this.dayWeek = dayWeek;
	}

	public String getCLIENT_TYPENAME() {
		return client_TYPENAME;
	}

	public void setCLIENT_TYPENAME(String cLIENT_TYPENAME) {
		client_TYPENAME = cLIENT_TYPENAME;
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

	public String getORDER_PRICE() {
		return order_PRICE;
	}

	public void setORDER_PRICE(String oRDER_PRICE) {
		order_PRICE = oRDER_PRICE;
	}

	public String getORDER_NUMBER() {
		return order_NUMBER;
	}

	public void setORDER_NUMBER(String oRDER_NUMBER) {
		order_NUMBER = oRDER_NUMBER;
	}

	public String getORDERAMOUNT() {
		return orderamount;
	}

	public void setORDERAMOUNT(String oRDERAMOUNT) {
		orderamount = oRDERAMOUNT;
	}

	public String getALLYH() {
		return allyh;
	}

	public void setALLYH(String aLLYH) {
		allyh = aLLYH;
	}

	public String getPAYMENT_AMOUNT() {
		return payment_AMOUNT;
	}

	public void setPAYMENT_AMOUNT(String pAYMENT_AMOUNT) {
		payment_AMOUNT = pAYMENT_AMOUNT;
	}

	public DailySalesAnalysis(String order_CREATE_DATE, String dayWeek,
			String client_TYPENAME, String store_TYPENAME, String store_NAME,
			String order_PRICE, String order_NUMBER, String orderamount,
			String allyh, String payment_AMOUNT) {
		super();
		this.order_CREATE_DATE = order_CREATE_DATE;
		this.dayWeek = dayWeek;
		this.client_TYPENAME = client_TYPENAME;
		this.store_TYPENAME = store_TYPENAME;
		this.store_NAME = store_NAME;
		this.order_PRICE = order_PRICE;
		this.order_NUMBER = order_NUMBER;
		this.orderamount = orderamount;
		this.allyh = allyh;
		this.payment_AMOUNT = payment_AMOUNT;
	}

	public DailySalesAnalysis() {
		super();
		// TODO Auto-generated constructor stub
	}

}
