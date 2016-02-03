public class UpdateAccountController {
    public List<Account> accList { get; set; }
    public double percent{get; set;}
    public boolean display{get;set;}
    public UpdateAccountController(){
        accList=new List<Account>();
        display=false;
    }
    public void updateAccount() {
        //fetching 10 accounts from database
        accList=[Select Id,Name from Account Limit 10];
        //updating account list
        update accList;
        display=true;
        //percent of DMLs were being consumed out of provided DMLs limit.
        percent=limits.getQueries();
        System.debug('No Of Queries Executed' +limits.getQueries());
        System.debug('Queries Limit' +limits.getLimitQueries());
    }
    
}