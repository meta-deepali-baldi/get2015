public class ProductPurchaseController {

      public List<Product2> productList{get;set;}
    public List<PurchaseOrderLineItem__c> productsToPurchase{get;set;}
    public Set<ID> productsToPurchaseItem{get;set;}
    public String productId{get;set;}
    public Integer quantity{get;set;}
    public Product2 selectedProduct{get;set;}
    public PurchaseOrder__c order{get;set;}
 	public List<PurchaseOrder__c> ListOfOrder{get;set;}    
    public boolean purchaseOrderLineItemsdisplayPopUp {get; set;}     
    public boolean purchaseOrderdisplayPopUp {get; set;}  
    public boolean informationDisplayPopUp {get; set;} 
    public boolean OrderDisplayPopUp{get;set;}
    
    
    public ProductPurchaseController(ApexPages.StandardController controller){
        purchaseOrderLineItemsdisplayPopUp = false;
        purchaseOrderdisplayPopUp = false;
        informationDisplayPopUp = false;
        OrderDisplayPopUp=false;
        getProductList();
        
        productsToPurchase = new List<PurchaseOrderLineItem__c>();
        ListOfOrder=new List<PurchaseOrder__c>();
        productsToPurchaseItem = new Set<ID>();
        
    }
    
    
    public Void getProductList(){
        string Query = 'SELECT id,name,price__c FROM Product2';
        productList = Database.query(Query);
    }
    
    public Void addToCart(){
       
        ListOfOrder=[Select id,Name,Name__c,Address__c,Phone__c,Total_Payment__c,Order_Status__c from PurchaseOrder__c];
    
        List<PurchaseOrder__c> orderList=[Select id,Name,Name__c,Address__c,Phone__c,Total_Payment__c from PurchaseOrder__c where Order_Status__c=false];
        if(orderList.size()>0){
            order=orderList.get(0);     
        }else{
            order=new PurchaseOrder__c(Name='OrderNew');
            insert order;
        }
        
        
        productsToPurchase= [Select id,name,Product__c,Quantity__c,ESmartPack__c,UnitPrice__c,TotalPrice__c from PurchaseOrderLineItem__c where OrderId__c=:order.Id];
        for(PurchaseOrderLineItem__c item:productsToPurchase){
            productsToPurchaseItem.add(item.Product__c);
        }
        
        System.debug('In add to cart');
          purchaseOrderLineItemsdisplayPopUp = true;
        if(productsToPurchaseItem.contains(productId)){
            System.debug('ashgdcfsdgvjd');
             OrderDisplayPopUp = true;
       
            for(PurchaseOrderLineItem__c productInLineItem : productsToPurchase){
                if(productInLineItem.Product__c == productId){
                    productInLineItem.Quantity__c = ++productInLineItem.Quantity__c;
                    upsert productInLineItem;
                }
         	}   
        }
        else if(productId!=null){
             OrderDisplayPopUp = true;
        selectedProduct = [Select id,name,price__C from Product2 where id=:productId];
        PurchaseOrderLineItem__c lineItem = new PurchaseOrderLineItem__c();
            System.debug(lineItem);
        lineItem.Name = selectedProduct.Name;
        lineItem.Product__c = selectedProduct.id;
        lineItem.Quantity__c = 1;
      	lineItem.UnitPrice__c = selectedProduct.price__C; 
        lineItem.OrderId__c=order.Id;
            System.debug(lineItem);
        insert lineItem;
            System.debug(lineItem);
        ID lineItemId = lineItem.id;
        PurchaseOrderLineItem__c p = [Select id,name,Product__c,Quantity__c,ESmartPack__c,UnitPrice__c,TotalPrice__c from PurchaseOrderLineItem__c where id=:lineItemId];
        productsToPurchase.add(p);
        productsToPurchaseItem.add(p.Product__c);
        }
     }    
   
     public Void removeFromCart(){
         purchaseOrderLineItemsdisplayPopUp = true;
         PurchaseOrderLineItem__c productInCart = [Select id, name,Quantity__c,ESmartPack__c,UnitPrice__c,TotalPrice__c from PurchaseOrderLineItem__c where id=:productId];
         Integer index = 0;
         for(PurchaseOrderLineItem__c purchaseOrder : productsToPurchase){
             if(purchaseOrder.Id == productInCart.Id){
                 break;
             }
               index++;
         }
         productsToPurchaseItem.remove(productsToPurchase.get(index).Product__c);
         productsToPurchase.remove(index);
      
         Delete productInCart;
    }
    
    
    public void pay(){
        for(PurchaseOrderLineItem__c purchaseOrder : productsToPurchase){
           System.debug('\nnew  '+ purchaseOrder.Quantity__c + '   '+purchaseOrder.ESmartPack__c);
           
         }
       informationDisplayPopUp = true;
        upsert productsToPurchase;
    }
    
    public void confirm(){
        order.Order_Status__c=true;
        double price=0;
         for(PurchaseOrderLineItem__c purchaseOrder : productsToPurchase){
           price= price+purchaseOrder.TotalPrice__c;
         }
        if(order.Total_Payment__c!=null){
        order.Total_Payment__c=order.Total_Payment__c+price;
        }else{
            order.Total_Payment__c=price;
        }
        system.debug(order);
            upsert order;
          system.debug(order);
         ListOfOrder=[Select id,Name,Name__c,Address__c,Phone__c,Total_Payment__c,Order_Status__c from PurchaseOrder__c];
     OrderDisplayPopUp = true;
          system.debug(ListOfOrder);
        
		productsToPurchase.clear();
        productsToPurchaseItem.clear();
        purchaseOrderLineItemsdisplayPopUp = false;
        purchaseOrderdisplayPopUp = false;
        informationDisplayPopUp = false;
    }
}