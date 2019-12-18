package io.applova.model.purchaseorder;

import io.applova.model.CollectionInfo;
import io.applova.model.DynamicFields;

public class PurchaseOrder {
    private CheckBill checkBill;
    private CollectionInfo collectionInfo;
    private DynamicFields dynamicFields;

    public CheckBill getCheckBill() {
        return checkBill;
    }

    public void setCheckBill(CheckBill checkBill) {
        this.checkBill = checkBill;
    }

    public CollectionInfo getCollectionInfo() {
        return collectionInfo;
    }

    public void setCollectionInfo(CollectionInfo collectionInfo) {
        this.collectionInfo = collectionInfo;
    }

    public DynamicFields getDynamicFields() {
        return dynamicFields;
    }

    public void setDynamicFields(DynamicFields dynamicFields) {
        this.dynamicFields = dynamicFields;
    }
}
