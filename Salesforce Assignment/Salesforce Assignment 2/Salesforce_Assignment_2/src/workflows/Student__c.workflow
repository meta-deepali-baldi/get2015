<?xml version="1.0" encoding="UTF-8"?>
<Workflow xmlns="http://soap.sforce.com/2006/04/metadata">
    <alerts>
        <fullName>Records_are_updated</fullName>
        <description>Records are updated</description>
        <protected>false</protected>
        <recipients>
            <field>email__c</field>
            <type>email</type>
        </recipients>
        <senderType>CurrentUser</senderType>
        <template>unfiled$public/Record_is_updated</template>
    </alerts>
    <fieldUpdates>
        <fullName>status_update</fullName>
        <field>Married__c</field>
        <literalValue>1</literalValue>
        <name>status update</name>
        <notifyAssignee>false</notifyAssignee>
        <operation>Literal</operation>
        <protected>false</protected>
    </fieldUpdates>
    <rules>
        <fullName>Record is updated</fullName>
        <actions>
            <name>Records_are_updated</name>
            <type>Alert</type>
        </actions>
        <active>true</active>
        <formula>ISCHANGED( LastModifiedDate )</formula>
        <triggerType>onAllChanges</triggerType>
    </rules>
    <rules>
        <fullName>student married status change</fullName>
        <actions>
            <name>status_update</name>
            <type>FieldUpdate</type>
        </actions>
        <active>true</active>
        <description>If any student have wife name then automatically its married = true.</description>
        <formula>NOT( ISBLANK( Spouse_Name__c ) )</formula>
        <triggerType>onAllChanges</triggerType>
    </rules>
</Workflow>
