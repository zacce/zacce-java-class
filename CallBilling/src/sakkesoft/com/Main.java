package sakkesoft.com;



    global virtual class CallUpdateAssetSystemInterface extends vlocity_cmt.DefaultSystemInterface implements vlocity_cmt.XOMOrchestrationInterfaces.ISystemInterface{

    private String payload = null;
    private vlocity_cmt.XOMOrderDomainObject orderObj = null;

    global virtual override String generatePayload(vlocity_cmt__OrchestrationItem__c item, vlocity_cmt.XOMOrderDomainObject orderObj){
        this.orderObj = orderObj;
        return JSON.serialize(orderObj);
    }

    global virtual override void endBatch(String url, String path) {
        saveOrderMessage(this.payload, this.orderObj.getId());
        updateAssetStartDate(this.orderObj.getId());
    }

    public void updateAssetStartDate(String orderId) {
        List<OrderItem> ois= [SELECT id, vlocity_cmt__ParentItemId__c FROM OrderItem WHERE OrderId =:orderId];
        Map<Id,OrderItem> OrderItemIdsMap = new Map<Id,OrderItem> (ois);
        List<Asset> assetsToOI = [SELECT Id, vlocity_cmt__OrderProductId__c, Billing_Start_Date__c FROM Asset WHERE vlocity_cmt__OrderProductId__c IN :OrderItemIdsMap.keyset()];

        for (Asset a : assetsToOI) {
            if (a.Billing_Start_Date__c < Date.today() || a.Billing_Start_Date__c == null){
                a.Billing_Start_Date__c = Date.today();
                a.DateOfAction__c = Date.today();
                a.vlocity_cmt__ActivationDate__c = Date.today();
                a.vlocity_cmt__ProvisioningStatus__c = 'Active';
            }
        }
        update assetsToOI;
    }


    public virtual void saveOrderMessage(String requestPayload, Id orderId) {
        OrderMessage__c orderMessage = new OrderMessage__c();
        orderMessage.orderId__c = orderId;
        orderMessage.Type__c = 'Startup';
        insert orderMessage;
        Attachment attachment = new Attachment();
        attachment.Name = 'StartupOrderMessage.json';
        attachment.Description = 'Startup Order Message';
        attachment.Body = blob.valueof(requestPayload);
        attachment.ParentId = orderMessage.Id;
        insert attachment;
    }
}