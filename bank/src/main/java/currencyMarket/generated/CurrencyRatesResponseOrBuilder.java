// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: currencyMarket.proto

package currencyMarket.generated;

public interface CurrencyRatesResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:CurrencyRatesResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>repeated .CurrencyAndRate currencyAndRate = 1;</code>
   */
  java.util.List<currencyMarket.generated.CurrencyAndRate> 
      getCurrencyAndRateList();
  /**
   * <code>repeated .CurrencyAndRate currencyAndRate = 1;</code>
   */
  currencyMarket.generated.CurrencyAndRate getCurrencyAndRate(int index);
  /**
   * <code>repeated .CurrencyAndRate currencyAndRate = 1;</code>
   */
  int getCurrencyAndRateCount();
  /**
   * <code>repeated .CurrencyAndRate currencyAndRate = 1;</code>
   */
  java.util.List<? extends currencyMarket.generated.CurrencyAndRateOrBuilder> 
      getCurrencyAndRateOrBuilderList();
  /**
   * <code>repeated .CurrencyAndRate currencyAndRate = 1;</code>
   */
  currencyMarket.generated.CurrencyAndRateOrBuilder getCurrencyAndRateOrBuilder(
      int index);
}