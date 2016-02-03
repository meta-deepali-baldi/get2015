trigger sendEmailToOpportunityOwner on Opportunity (after update) {
    //getting template id
    Id templateId = [Select id from EmailTemplate where name = 'Opportunity_Status_Change'].Id;
    
    for (Opportunity opp : Trigger.New) {
        opportunity oldOpp = trigger.oldmap.get(opp.Id);
        //checking if stage name of opportunity is changed or not
        if (oldOpp.StageName != opp.StageName) {
            //if changed then sending mail
            Messaging.SingleEmailMessage mail = new Messaging.SingleEmailMessage();
            
            mail.setTargetObjectId(opp.OwnerId);
            //   mail.setWhatId(opp.Id);
            mail.setTemplateId(templateId);
            mail.setSaveAsActivity(false);
            
            Messaging.SendEmailResult[] result = Messaging.sendEmail(new Messaging.SingleEmailMessage[] {mail});
        }
    }
}