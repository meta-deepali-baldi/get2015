<?xml version="1.0" encoding="UTF-8"?>
<Workflow xmlns="http://soap.sforce.com/2006/04/metadata">
    <alerts>
        <fullName>Birthday_Notification</fullName>
        <description>Birthday Notification</description>
        <protected>false</protected>
        <recipients>
            <field>Email</field>
            <type>email</type>
        </recipients>
        <senderType>CurrentUser</senderType>
        <template>unfiled$public/Birthday_Notification</template>
    </alerts>
    <alerts>
        <fullName>Teacher_field_is_updated</fullName>
        <description>Teacher field is updated</description>
        <protected>false</protected>
        <recipients>
            <field>Email</field>
            <type>email</type>
        </recipients>
        <senderType>CurrentUser</senderType>
        <template>unfiled$public/Teacher_field_is_updated</template>
    </alerts>
    <rules>
        <fullName>Birthday Notification</fullName>
        <active>true</active>
        <description>Send an email to the contact two days before the contact&apos;s birthday.  (You can use Scheduler API also, Now it is available, but  You can 
try with Formula fields + Time dependent WF)</description>
        <formula>MOD(Birthdate  - TODAY(),365)   = 363</formula>
        <triggerType>onCreateOrTriggeringUpdate</triggerType>
        <workflowTimeTriggers>
            <actions>
                <name>Birthday_Notification</name>
                <type>Alert</type>
            </actions>
            <offsetFromField>Contact.Birthdate</offsetFromField>
            <timeLength>-2</timeLength>
            <workflowTimeTriggerUnit>Days</workflowTimeTriggerUnit>
        </workflowTimeTriggers>
    </rules>
    <rules>
        <fullName>Teacher field is updated</fullName>
        <actions>
            <name>Teacher_field_is_updated</name>
            <type>Alert</type>
        </actions>
        <active>true</active>
        <criteriaItems>
            <field>Contact.Experience__c</field>
            <operation>greaterThan</operation>
            <value>5</value>
        </criteriaItems>
        <description>Add workflow to teacher(insert/update) if his experience is more then 5 then send mail</description>
        <triggerType>onAllChanges</triggerType>
    </rules>
</Workflow>
