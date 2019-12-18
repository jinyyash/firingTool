package io.applova.model.businessDetails;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class BusinessDetails {
    @JsonProperty("business-id")
    private String businessId;
    private List<Product> products;

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
