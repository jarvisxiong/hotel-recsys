/**
 * Autogenerated by Thrift Compiler (0.8.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.meituan.hotel.rec.poidetail;


import java.util.Map;
import java.util.HashMap;
import org.apache.thrift.TEnum;

public enum RecRequestType implements org.apache.thrift.TEnum {
  REC_NEAR_HOT_POI(0),
  REC_BRAND_POI(1),
  REC_PREORDER_POI(2),
  REC_VACATION_POI(3);

  private final int value;

  private RecRequestType(int value) {
    this.value = value;
  }

  /**
   * Get the integer value of this enum value, as defined in the Thrift IDL.
   */
  public int getValue() {
    return value;
  }

  /**
   * Find a the enum type by its integer value, as defined in the Thrift IDL.
   * @return null if the value is not found.
   */
  public static RecRequestType findByValue(int value) { 
    switch (value) {
      case 0:
        return REC_NEAR_HOT_POI;
      case 1:
        return REC_BRAND_POI;
      case 2:
        return REC_PREORDER_POI;
      case 3:
        return REC_VACATION_POI;
      default:
        return null;
    }
  }
}