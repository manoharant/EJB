package com.ejb3inaction.actionbazaar.persistence;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "ITEMS")
public class Item implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long itemId;
	private String title;
	private Set<Category> categories;
	private Double initialPrice;
	private Date bidStartDate;
	private Date bidEndDate;
	private Set<Bid> bids;
	private Seller seller;
	private Date createdDate;

	public Item() {
	}

	public Item(Long itemId) {
		this.itemId = itemId;
	}

	@TableGenerator(name = "ITEM_TABLE_GENERATOR", table = "TABLE_SEQUENCE_GENERATOR", pkColumnName = "SEQUENCE_NAME", valueColumnName = "SEQUENCE_COUNT", pkColumnValue = "ITEM_SEQUENCE")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ITEM_ID", nullable = false)
	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	@Column(name = "ITEM_NAME")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@ManyToMany(mappedBy = "items")
	public Set<Category> getCategories() {
		return categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

	public Category addCategory(Category category) {
		getCategories().add(category);
		return category;
	}

	public Category removeCategory(Category category) {
		getCategories().remove(category);
		return category;
	}

	@Column(name = "INITIAL_PRICE")
	public Double getInitialPrice() {
		return initialPrice;
	}

	public void setInitialPrice(Double initialPrice) {
		this.initialPrice = initialPrice;
	}

	@Column(name = "BID_START_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getBidStartDate() {
		return bidStartDate;
	}

	public void setBidStartDate(Date bidStartDate) {
		this.bidStartDate = bidStartDate;
	}

	@Column(name = "BID_END_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getBidEndDate() {
		return bidEndDate;
	}

	public void setBidEndDate(Date bidEndDate) {
		this.bidEndDate = bidEndDate;
	}

	@OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
	public Set<Bid> getBids() {
		return bids;
	}

	public void setBids(Set<Bid> bids) {
		this.bids = bids;
	}

	public Bid addBid(Bid bid) {
		getBids().add(bid);
		return bid;
	}

	public Bid removeBid(Bid bid) {
		getBids().remove(bid);
		return bid;
	}

	@ManyToOne
	@JoinColumn(name = "SELLER_ID", referencedColumnName = "USER_ID")
	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	@Column(name = "CREATED_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
}