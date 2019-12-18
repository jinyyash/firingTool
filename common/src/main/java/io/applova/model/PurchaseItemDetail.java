package io.applova.model;

import java.util.List;

public class PurchaseItemDetail {
    private String productId;
    private String variantId;
    private List<String> addOnSubTypeIds;
    private Integer quantity;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getVariantId() {
        return variantId;
    }

    public void setVariantId(String variantId) {
        this.variantId = variantId;
    }

    public List<String> getAddOnSubTypeIds() {
        return addOnSubTypeIds;
    }

    public void setAddOnSubTypeIds(List<String> addOnSubTypeIds) {
        this.addOnSubTypeIds = addOnSubTypeIds;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
