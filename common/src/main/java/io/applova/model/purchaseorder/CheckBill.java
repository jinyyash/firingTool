package io.applova.model.purchaseorder;

import io.applova.model.Client;
import io.applova.model.PurchaseItemDetail;

import java.util.List;

public class CheckBill {
    private List<PurchaseItemDetail> purchases;
    private Long externalTransactionId;
    private String additionalComments;
    private String collectionMethod;
    private String paymentMethod;
    private Client client;

    public List<PurchaseItemDetail> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<PurchaseItemDetail> purchases) {
        this.purchases = purchases;
    }

    public Long getExternalTransactionId() {
        return externalTransactionId;
    }

    public void setExternalTransactionId(Long externalTransactionId) {
        this.externalTransactionId = externalTransactionId;
    }

    public String getAdditionalComments() {
        return additionalComments;
    }

    public void setAdditionalComments(String additionalComments) {
        this.additionalComments = additionalComments;
    }

    public String getCollectionMethod() {
        return collectionMethod;
    }

    public void setCollectionMethod(String collectionMethod) {
        this.collectionMethod = collectionMethod;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
