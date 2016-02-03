trigger MailServiceTrigger on Loan__c (before insert) {
    
    List<Loan__c> loanList = new List<Loan__c>();
    //getting all loan whose status is changed to Accepted or Reject
    for(Loan__c loan : Trigger.new) {
        if((loan.status__c == 'Accepted' || loan.status__c == 'Reject')) {
            loanList.add(loan);
            System.debug(loan.status__c);
        }
    }
    if(loanList.size() > 0) {
        try{
            System.debug(loanList.size());
            //Sending mail to loan applicant if status is changed
            Messaging.SingleEmailMessage email = new Messaging.SingleEmailMessage();
            for(Loan__c loan : loanList) {
                String[] toAddress = new List<String>() ;
                toAddress.add(loan.Applicant_Email__c);
                email.setSenderDisplayName(loan.Manager__c);  
                Id toId =  loan.Id;
                email.setToAddresses(toAddress);
                email.plainTextBody = 'Hii Your Status for Loan is '+loan.status__c;
                System.debug('email' + email);
                Messaging.SendEmail(New Messaging.SingleEmailMessage[] {email});
            }
        }catch(Exception e) {
            System.debug(e);
        }
        
    }  
}