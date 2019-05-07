package currencyMarket.generated;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.20.0)",
    comments = "Source: currencyMarket.proto")
public final class CurrencyRatesGrpc {

  private CurrencyRatesGrpc() {}

  public static final String SERVICE_NAME = "CurrencyRates";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<currencyMarket.generated.WhichCurrencies,
      currencyMarket.generated.CurrencyRatesResponse> getInitCurrencyRatesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "InitCurrencyRates",
      requestType = currencyMarket.generated.WhichCurrencies.class,
      responseType = currencyMarket.generated.CurrencyRatesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<currencyMarket.generated.WhichCurrencies,
      currencyMarket.generated.CurrencyRatesResponse> getInitCurrencyRatesMethod() {
    io.grpc.MethodDescriptor<currencyMarket.generated.WhichCurrencies, currencyMarket.generated.CurrencyRatesResponse> getInitCurrencyRatesMethod;
    if ((getInitCurrencyRatesMethod = CurrencyRatesGrpc.getInitCurrencyRatesMethod) == null) {
      synchronized (CurrencyRatesGrpc.class) {
        if ((getInitCurrencyRatesMethod = CurrencyRatesGrpc.getInitCurrencyRatesMethod) == null) {
          CurrencyRatesGrpc.getInitCurrencyRatesMethod = getInitCurrencyRatesMethod = 
              io.grpc.MethodDescriptor.<currencyMarket.generated.WhichCurrencies, currencyMarket.generated.CurrencyRatesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "CurrencyRates", "InitCurrencyRates"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  currencyMarket.generated.WhichCurrencies.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  currencyMarket.generated.CurrencyRatesResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new CurrencyRatesMethodDescriptorSupplier("InitCurrencyRates"))
                  .build();
          }
        }
     }
     return getInitCurrencyRatesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<currencyMarket.generated.WhichCurrencies,
      currencyMarket.generated.CurrencyRatesResponse> getStreamCurrencyRatesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StreamCurrencyRates",
      requestType = currencyMarket.generated.WhichCurrencies.class,
      responseType = currencyMarket.generated.CurrencyRatesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<currencyMarket.generated.WhichCurrencies,
      currencyMarket.generated.CurrencyRatesResponse> getStreamCurrencyRatesMethod() {
    io.grpc.MethodDescriptor<currencyMarket.generated.WhichCurrencies, currencyMarket.generated.CurrencyRatesResponse> getStreamCurrencyRatesMethod;
    if ((getStreamCurrencyRatesMethod = CurrencyRatesGrpc.getStreamCurrencyRatesMethod) == null) {
      synchronized (CurrencyRatesGrpc.class) {
        if ((getStreamCurrencyRatesMethod = CurrencyRatesGrpc.getStreamCurrencyRatesMethod) == null) {
          CurrencyRatesGrpc.getStreamCurrencyRatesMethod = getStreamCurrencyRatesMethod = 
              io.grpc.MethodDescriptor.<currencyMarket.generated.WhichCurrencies, currencyMarket.generated.CurrencyRatesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "CurrencyRates", "StreamCurrencyRates"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  currencyMarket.generated.WhichCurrencies.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  currencyMarket.generated.CurrencyRatesResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new CurrencyRatesMethodDescriptorSupplier("StreamCurrencyRates"))
                  .build();
          }
        }
     }
     return getStreamCurrencyRatesMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CurrencyRatesStub newStub(io.grpc.Channel channel) {
    return new CurrencyRatesStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CurrencyRatesBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new CurrencyRatesBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CurrencyRatesFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new CurrencyRatesFutureStub(channel);
  }

  /**
   */
  public static abstract class CurrencyRatesImplBase implements io.grpc.BindableService {

    /**
     */
    public void initCurrencyRates(currencyMarket.generated.WhichCurrencies request,
        io.grpc.stub.StreamObserver<currencyMarket.generated.CurrencyRatesResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getInitCurrencyRatesMethod(), responseObserver);
    }

    /**
     */
    public void streamCurrencyRates(currencyMarket.generated.WhichCurrencies request,
        io.grpc.stub.StreamObserver<currencyMarket.generated.CurrencyRatesResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getStreamCurrencyRatesMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getInitCurrencyRatesMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                currencyMarket.generated.WhichCurrencies,
                currencyMarket.generated.CurrencyRatesResponse>(
                  this, METHODID_INIT_CURRENCY_RATES)))
          .addMethod(
            getStreamCurrencyRatesMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                currencyMarket.generated.WhichCurrencies,
                currencyMarket.generated.CurrencyRatesResponse>(
                  this, METHODID_STREAM_CURRENCY_RATES)))
          .build();
    }
  }

  /**
   */
  public static final class CurrencyRatesStub extends io.grpc.stub.AbstractStub<CurrencyRatesStub> {
    private CurrencyRatesStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CurrencyRatesStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CurrencyRatesStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CurrencyRatesStub(channel, callOptions);
    }

    /**
     */
    public void initCurrencyRates(currencyMarket.generated.WhichCurrencies request,
        io.grpc.stub.StreamObserver<currencyMarket.generated.CurrencyRatesResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getInitCurrencyRatesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void streamCurrencyRates(currencyMarket.generated.WhichCurrencies request,
        io.grpc.stub.StreamObserver<currencyMarket.generated.CurrencyRatesResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getStreamCurrencyRatesMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class CurrencyRatesBlockingStub extends io.grpc.stub.AbstractStub<CurrencyRatesBlockingStub> {
    private CurrencyRatesBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CurrencyRatesBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CurrencyRatesBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CurrencyRatesBlockingStub(channel, callOptions);
    }

    /**
     */
    public currencyMarket.generated.CurrencyRatesResponse initCurrencyRates(currencyMarket.generated.WhichCurrencies request) {
      return blockingUnaryCall(
          getChannel(), getInitCurrencyRatesMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<currencyMarket.generated.CurrencyRatesResponse> streamCurrencyRates(
        currencyMarket.generated.WhichCurrencies request) {
      return blockingServerStreamingCall(
          getChannel(), getStreamCurrencyRatesMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class CurrencyRatesFutureStub extends io.grpc.stub.AbstractStub<CurrencyRatesFutureStub> {
    private CurrencyRatesFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CurrencyRatesFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CurrencyRatesFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CurrencyRatesFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<currencyMarket.generated.CurrencyRatesResponse> initCurrencyRates(
        currencyMarket.generated.WhichCurrencies request) {
      return futureUnaryCall(
          getChannel().newCall(getInitCurrencyRatesMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_INIT_CURRENCY_RATES = 0;
  private static final int METHODID_STREAM_CURRENCY_RATES = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CurrencyRatesImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CurrencyRatesImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_INIT_CURRENCY_RATES:
          serviceImpl.initCurrencyRates((currencyMarket.generated.WhichCurrencies) request,
              (io.grpc.stub.StreamObserver<currencyMarket.generated.CurrencyRatesResponse>) responseObserver);
          break;
        case METHODID_STREAM_CURRENCY_RATES:
          serviceImpl.streamCurrencyRates((currencyMarket.generated.WhichCurrencies) request,
              (io.grpc.stub.StreamObserver<currencyMarket.generated.CurrencyRatesResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class CurrencyRatesBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CurrencyRatesBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return currencyMarket.generated.CurrencyMarketProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CurrencyRates");
    }
  }

  private static final class CurrencyRatesFileDescriptorSupplier
      extends CurrencyRatesBaseDescriptorSupplier {
    CurrencyRatesFileDescriptorSupplier() {}
  }

  private static final class CurrencyRatesMethodDescriptorSupplier
      extends CurrencyRatesBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CurrencyRatesMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (CurrencyRatesGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CurrencyRatesFileDescriptorSupplier())
              .addMethod(getInitCurrencyRatesMethod())
              .addMethod(getStreamCurrencyRatesMethod())
              .build();
        }
      }
    }
    return result;
  }
}
