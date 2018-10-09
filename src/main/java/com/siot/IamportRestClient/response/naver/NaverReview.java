package com.siot.IamportRestClient.response.naver;

import java.util.Date;

import com.google.gson.annotations.SerializedName;

public class NaverReview {

	@SerializedName("review_id")
	String review_id;
	
	@SerializedName("score")
	String score;
	
	@SerializedName("title")
	String title;
	
	@SerializedName("content")
	String content;
	
	@SerializedName("product_order_id")
	String product_order_id;
	
	@SerializedName("product_id")
	String product_id;
	
	@SerializedName("product_name")
	String product_name;
	
	@SerializedName("product_option_name")
	String product_option_name;
	
	@SerializedName("writer")
	String writer;
	
	@SerializedName("created_at")
	long created_at;
	
	@SerializedName("modified_at")
	long modified_at;

	public String getReviewId() {
		return review_id;
	}

	public String getScore() {
		return score;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public String getProductOrderId() {
		return product_order_id;
	}

	public String getProductId() {
		return product_id;
	}

	public String getProductName() {
		return product_name;
	}

	public String getProductOptionName() {
		return product_option_name;
	}

	public String getWriter() {
		return writer;
	}

	public Date getCreatedAt() {
		return new Date( created_at * 1000L );
	}

	public Date getModifiedAt() {
		return new Date( modified_at * 1000L );
	}
	
}
