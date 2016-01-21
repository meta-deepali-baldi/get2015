public class FilterInAccount {

      public string getBillingCitystring{get;set;}
   public string getBillingStatestring{get;set;}
   public string getBillingCountrystring{get;set;}

   public List<Account> createAccountList{get;set;}

   public void searchRecords(){
       createAccountList= new list<Account>();
       if(string.isBlank(getBillingCitystring)&&string.isBlank(getBillingStatestring)&&string.isBlank(getBillingCountrystring)) 
      {
           createAccountList= Database.query('SELECT id,name,billingcity,billingCountry,billingState FROM Account limit 100');
   	}    
       else 
       {
            createAccountList= Database.query('SELECT id,name,billingcity,billingCountry,billingState FROM Account WHERE billingcity LIKE \'%'+getBillingCitystring+'%\'  AND billingcountry  LIKE  \'%'+getBillingCountrystring+'%\' AND billingstate LIKE  \'%'+getBillingStatestring+'%\' Limit 100');                    
       
       }
   }
}