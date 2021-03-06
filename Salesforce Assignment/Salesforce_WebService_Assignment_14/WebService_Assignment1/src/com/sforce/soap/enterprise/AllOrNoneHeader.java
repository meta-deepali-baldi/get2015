/**
 * AllOrNoneHeader.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sforce.soap.enterprise;

public class AllOrNoneHeader  implements java.io.Serializable {
    private boolean allOrNone;

    public AllOrNoneHeader() {
    }

    public AllOrNoneHeader(
           boolean allOrNone) {
           this.allOrNone = allOrNone;
    }


    /**
     * Gets the allOrNone value for this AllOrNoneHeader.
     * 
     * @return allOrNone
     */
    public boolean isAllOrNone() {
        return allOrNone;
    }


    /**
     * Sets the allOrNone value for this AllOrNoneHeader.
     * 
     * @param allOrNone
     */
    public void setAllOrNone(boolean allOrNone) {
        this.allOrNone = allOrNone;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AllOrNoneHeader)) return false;
        AllOrNoneHeader other = (AllOrNoneHeader) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.allOrNone == other.isAllOrNone();
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        _hashCode += (isAllOrNone() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AllOrNoneHeader.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:enterprise.soap.sforce.com", ">AllOrNoneHeader"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("allOrNone");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:enterprise.soap.sforce.com", "allOrNone"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
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
