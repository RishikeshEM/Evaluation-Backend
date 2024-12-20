package com.evalutation.cartcrud.dto;

public class GetOrderResponse {
    private Long id;
    private Long userId;
    private Long productId;
    private String username;
    private String productName;
    private int purchaseQuantity;
    private double totalPrice;

    public GetOrderResponse(Long id,Long userId, Long productId, String username, String productName, int purchaseQuantity, double totalPrice) {
        this.id = id;
        this.userId = userId;
        this.productId = productId;
        this.username = username;
        this.productName = productName;
        this.purchaseQuantity = purchaseQuantity;
        this.totalPrice = totalPrice;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPurchaseQuantity() {
        return purchaseQuantity;
    }

    public void setPurchaseQuantity(int purchaseQuantity) {
        this.purchaseQuantity = purchaseQuantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
