// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: currencyMarket.proto

package currencyMarket.generated;

public final class CurrencyMarketProto {
  private CurrencyMarketProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_WhichCurrencies_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_WhichCurrencies_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_CurrencyAndRate_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_CurrencyAndRate_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_CurrencyRatesResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_CurrencyRatesResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\024currencyMarket.proto\".\n\017WhichCurrencie" +
      "s\022\033\n\010currency\030\001 \003(\0162\t.Currency\"<\n\017Curren" +
      "cyAndRate\022\033\n\010currency\030\001 \001(\0162\t.Currency\022\014" +
      "\n\004rate\030\002 \001(\001\"B\n\025CurrencyRatesResponse\022)\n" +
      "\017currencyAndRate\030\001 \003(\0132\020.CurrencyAndRate" +
      "*.\n\010Currency\022\007\n\003USD\020\000\022\007\n\003EUR\020\001\022\007\n\003GBP\020\002\022" +
      "\007\n\003CHF\020\0032\225\001\n\rCurrencyRates\022?\n\021InitCurren" +
      "cyRates\022\020.WhichCurrencies\032\026.CurrencyRate" +
      "sResponse\"\000\022C\n\023StreamCurrencyRates\022\020.Whi" +
      "chCurrencies\032\026.CurrencyRatesResponse\"\0000\001" +
      "B7\n\030currencyMarket.generatedB\023CurrencyMa" +
      "rketProtoP\001\242\002\003HLWb\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_WhichCurrencies_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_WhichCurrencies_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_WhichCurrencies_descriptor,
        new java.lang.String[] { "Currency", });
    internal_static_CurrencyAndRate_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_CurrencyAndRate_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_CurrencyAndRate_descriptor,
        new java.lang.String[] { "Currency", "Rate", });
    internal_static_CurrencyRatesResponse_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_CurrencyRatesResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_CurrencyRatesResponse_descriptor,
        new java.lang.String[] { "CurrencyAndRate", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}