/**
 * MacroHistory.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sforce.soap.enterprise.sobject;

public class MacroHistory  extends com.sforce.soap.enterprise.sobject.SObject  implements java.io.Serializable {
    private com.sforce.soap.enterprise.sobject.SObject createdBy;

    private java.lang.String createdById;

    private java.util.Calendar createdDate;

    private java.lang.String field;

    private java.lang.Boolean isDeleted;

    private com.sforce.soap.enterprise.sobject.Macro macro;

    private java.lang.String macroId;

    private java.lang.Object newValue;

    private java.lang.Object oldValue;

    public MacroHistory() {
    }

    public MacroHistory(
           java.lang.String[] fieldsToNull,
           java.lang.String id,
           com.sforce.soap.enterprise.sobject.SObject createdBy,
           java.lang.String createdById,
           java.util.Calendar createdDate,
           java.lang.String field,
           java.lang.Boolean isDeleted,
           com.sforce.soap.enterprise.sobject.Macro macro,
           java.lang.String macroId,
           java.lang.Object newValue,
           java.lang.Object oldValue) {
        super(
            fieldsToNull,
            id);
        this.createdBy = createdBy;
        this.createdById = createdById;
        this.createdDate = createdDate;
        this.field = field;
        this.isDeleted = isDeleted;
        this.macro = macro;
        this.macroId = macroId;
        this.newValue = newValue;
        this.oldValue = oldValue;
    }


    /**
     * Gets the createdBy value for this MacroHistory.
     * 
     * @return createdBy
     */
    public com.sforce.soap.enterprise.sobject.SObject getCreatedBy() {
        return createdBy;
    }


    /**
     * Sets the createdBy value for this MacroHistory.
     * 
     * @param createdBy
     */
    public void setCreatedBy(com.sforce.soap.enterprise.sobject.SObject createdBy) {
        this.createdBy = createdBy;
    }


    /**
     * Gets the createdById value for this MacroHistory.
     * 
     * @return createdById
     */
    public java.lang.String getCreatedById() {
        return createdById;
    }


    /**
     * Sets the createdById value for this MacroHistory.
     * 
     * @param createdById
     */
    public void setCreatedById(java.lang.String createdById) {
        this.createdById = createdById;
    }


    /**
     * Gets the createdDate value for this MacroHistory.
     * 
     * @return createdDate
     */
    public java.util.Calendar getCreatedDate() {
        return createdDate;
    }


    /**
     * Sets the createdDate value for this MacroHistory.
     * 
     * @param createdDate
     */
    public void setCreatedDate(java.util.Calendar createdDate) {
        this.createdDate = createdDate;
    }


    /**
     * Gets the field value for this MacroHistory.
     * 
     * @return field
     */
    public java.lang.String getField() {
        return field;
    }


    /**
     * Sets the field value for this MacroHistory.
     * 
     * @param field
     */
    public void setField(java.lang.String field) {
        this.field = field;
    }


    /**
     * Gets the isDeleted value for this MacroHistory.
     * 
     * @return isDeleted
     */
    public java.lang.Boolean getIsDeleted() {
        return isDeleted;
    }


    /**
     * Sets the isDeleted value for this MacroHistory.
     * 
     * @param isDeleted
     */
    public void setIsDeleted(java.lang.Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }


    /**
     * Gets the macro value for this MacroHistory.
     * 
     * @return macro
     */
    public com.sforce.soap.enterprise.sobject.Macro getMacro() {
        return macro;
    }


    /**
     * Sets the macro value for this MacroHistory.
     * 
     * @param macro
     */
    public void setMacro(com.sforce.soap.enterprise.sobject.Macro macro) {
        this.macro = macro;
    }


    /**
     * Gets the macroId value for this MacroHistory.
     * 
     * @return macroId
     */
    public java.lang.String getMacroId() {
        return macroId;
    }


    /**
     * Sets the macroId value for this MacroHistory.
     * 
     * @param macroId
     */
    public void setMacroId(java.lang.String macroId) {
        this.macroId = macroId;
    }


    /**
     * Gets the newValue value for this MacroHistory.
     * 
     * @return newValue
     */
    public java.lang.Object getNewValue() {
        return newValue;
    }


    /**
     * Sets the newValue value for this MacroHistory.
     * 
     * @param newValue
     */
    public void setNewValue(java.lang.Object newValue) {
        this.newValue = newValue;
    }


    /**
     * Gets the oldValue value for this MacroHistory.
     * 
     * @return oldValue
     */
    public java.lang.Object getOldValue() {
        return oldValue;
    }


    /**
     * Sets the oldValue value for this MacroHistory.
     * 
     * @param oldValue
     */
    public void setOldValue(java.lang.Object oldValue) {
        this.oldValue = oldValue;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof MacroHistory)) return false;
        MacroHistory other = (MacroHistory) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.createdBy==null && other.getCreatedBy()==null) || 
             (this.createdBy!=null &&
              this.createdBy.equals(other.getCreatedBy()))) &&
            ((this.createdById==null && other.getCreatedById()==null) || 
             (this.createdById!=null &&
              this.createdById.equals(other.getCreatedById()))) &&
            ((this.createdDate==null && other.getCreatedDate()==null) || 
             (this.createdDate!=null &&
              this.createdDate.equals(other.getCreatedDate()))) &&
            ((this.field==null && other.getField()==null) || 
             (this.field!=null &&
              this.field.equals(other.getField()))) &&
            ((this.isDeleted==null && other.getIsDeleted()==null) || 
             (this.isDeleted!=null &&
              this.isDeleted.equals(other.getIsDeleted()))) &&
            ((this.macro==null && other.getMacro()==null) || 
             (this.macro!=null &&
              this.macro.equals(other.getMacro()))) &&
            ((this.macroId==null && other.getMacroId()==null) || 
             (this.macroId!=null &&
              this.macroId.equals(other.getMacroId()))) &&
            ((this.newValue==null && other.getNewValue()==null) || 
             (this.newValue!=null &&
              this.newValue.equals(other.getNewValue()))) &&
            ((this.oldValue==null && other.getOldValue()==null) || 
             (this.oldValue!=null &&
              this.oldValue.equals(other.getOldValue())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (getCreatedBy() != null) {
            _hashCode += getCreatedBy().hashCode();
        }
        if (getCreatedById() != null) {
            _hashCode += getCreatedById().hashCode();
        }
        if (getCreatedDate() != null) {
            _hashCode += getCreatedDate().hashCode();
        }
        if (getField() != null) {
            _hashCode += getField().hashCode();
        }
        if (getIsDeleted() != null) {
            _hashCode += getIsDeleted().hashCode();
        }
        if (getMacro() != null) {
            _hashCode += getMacro().hashCode();
        }
        if (getMacroId() != null) {
            _hashCode += getMacroId().hashCode();
        }
        if (getNewValue() != null) {
            _hashCode += getNewValue().hashCode();
        }
        if (getOldValue() != null) {
            _hashCode += getOldValue().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(MacroHistory.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:sobject.enterprise.soap.sforce.com", "MacroHistory"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("createdBy");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:sobject.enterprise.soap.sforce.com", "CreatedBy"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:sobject.enterprise.soap.sforce.com", "sObject"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("createdById");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:sobject.enterprise.soap.sforce.com", "CreatedById"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("createdDate");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:sobject.enterprise.soap.sforce.com", "CreatedDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("field");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:sobject.enterprise.soap.sforce.com", "Field"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isDeleted");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:sobject.enterprise.soap.sforce.com", "IsDeleted"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("macro");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:sobject.enterprise.soap.sforce.com", "Macro"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:sobject.enterprise.soap.sforce.com", "Macro"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("macroId");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:sobject.enterprise.soap.sforce.com", "MacroId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("newValue");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:sobject.enterprise.soap.sforce.com", "NewValue"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "anyType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("oldValue");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:sobject.enterprise.soap.sforce.com", "OldValue"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "anyType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
