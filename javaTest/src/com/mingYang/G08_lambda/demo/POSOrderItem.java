package com.mingYang.G08_lambda.demo;
import java.io.Serializable;
public class POSOrderItem implements Serializable {

	private static final long serialVersionUID = 8285457832279014988L;

	public POSOrderItem(Double quantity, Double price, String goodsName) {
		this.quantity = quantity;
		this.price = price;
		this.goodsName = goodsName;
	}

	public POSOrderItem() {
	}

	@Override
	public String toString() {
		return "POSOrderItem{" +
				"quantity=" + quantity +
				", price=" + price +
				", goodsName='" + goodsName + '\'' +
				'}';
	}

	/**
	 * 主键id
	 */
	private Integer id;

	/**
	 *  商品数量
	 */
	private Double quantity;
	/**
	 * 原价单价
	 */
	private Double orgPrice;
	/**
	 * 优惠券使用金额(优惠券、代金券、折扣券等)
	 */
	private Double ticketPrice;
	/**
	 * 销售价   
	 * 计算规则  销售价= 原价*折扣(优惠活动) - 优惠券金额
	 */
	private Double price;
	/**
	 * 商品总额
	 */

	private Double total;
	/**
	 * 采购报价
	 */
	private Double stockPrice = 0.00;
	/**
	 * 商品单位
	 */
	private String unit;
	/**
	 * 商品名称
	 */
	private String goodsName;
	/**
	 * 商品规格
	 */
	private String spec;
	/**
	 * 芯片ID
	 */
	private String chipId;
	/**
	 * 行
	 */
	private Integer row;
	/**
	 * 列
	 */
	private Integer clum;
	/**
	 * 备注
	 */
	private String remark;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public Double getOrgPrice() {
		return orgPrice;
	}

	public void setOrgPrice(Double orgPrice) {
		this.orgPrice = orgPrice;
	}

	public Double getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(Double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Double getStockPrice() {
		return stockPrice;
	}

	public void setStockPrice(Double stockPrice) {
		this.stockPrice = stockPrice;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getSpec() {
		return spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}

	public String getChipId() {
		return chipId;
	}

	public void setChipId(String chipId) {
		this.chipId = chipId;
	}

	public Integer getRow() {
		return row;
	}

	public void setRow(Integer row) {
		this.row = row;
	}

	public Integer getClum() {
		return clum;
	}

	public void setClum(Integer clum) {
		this.clum = clum;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
