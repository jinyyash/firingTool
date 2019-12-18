package io.applova.model.businessDetails;

import java.util.List;

public class Product {
    private String productId;
    private List<String> addOnSubTypeIds;
    private List<String> variantIds;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public List<String> getAddOnSubTypeIds() {
        return addOnSubTypeIds;
    }

    public void setAddOnSubTypeIds(List<String> addOnSubTypeIds) {
        this.addOnSubTypeIds = addOnSubTypeIds;
    }

    public List<String> getVariantIds() {
        return variantIds;
    }

    public void setVariantIds(List<String> variantIds) {
        this.variantIds = variantIds;
    }
}
