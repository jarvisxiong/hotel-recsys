/**
 * Autogenerated by Thrift Compiler (0.8.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.meituan.hotel.rec.cross;


import java.util.Map;
import java.util.HashMap;
import org.apache.thrift.TEnum;

public enum OrderTypeEnum implements org.apache.thrift.TEnum {
  HOTEL_GROUP(1),
  HOTEL_PREPAY(2),
  TRAVEL_GROUP(3),
  TRAVEL_MTP(4),
  TRAIN(5),
  AIR(6),
  BackPayTravel(7);

  private final int value;

  private OrderTypeEnum(int value) {
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
  public static OrderTypeEnum findByValue(int value) { 
    switch (value) {
      case 1:
        return HOTEL_GROUP;
      case 2:
        return HOTEL_PREPAY;
      case 3:
        return TRAVEL_GROUP;
      case 4:
        return TRAVEL_MTP;
      case 5:
        return TRAIN;
      case 6:
        return AIR;
      case 7:
        return BackPayTravel;
      default:
        return null;
    }
  }
}