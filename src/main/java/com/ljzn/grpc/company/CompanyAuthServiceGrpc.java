package com.ljzn.grpc.company;

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
    value = "by gRPC proto compiler (version 1.11.0)",
    comments = "Source: company/company.service.proto")
public final class CompanyAuthServiceGrpc {

  private CompanyAuthServiceGrpc() {}

  public static final String SERVICE_NAME = "VisitorSystem_cq.CompanyAuthService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCompanyDataApplyMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.ljzn.grpc.company.CompanyDataApplyRequest,
      com.ljzn.grpc.company.CompanyDataApplyResponse> METHOD_COMPANY_DATA_APPLY = getCompanyDataApplyMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.ljzn.grpc.company.CompanyDataApplyRequest,
      com.ljzn.grpc.company.CompanyDataApplyResponse> getCompanyDataApplyMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.ljzn.grpc.company.CompanyDataApplyRequest,
      com.ljzn.grpc.company.CompanyDataApplyResponse> getCompanyDataApplyMethod() {
    return getCompanyDataApplyMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.ljzn.grpc.company.CompanyDataApplyRequest,
      com.ljzn.grpc.company.CompanyDataApplyResponse> getCompanyDataApplyMethodHelper() {
    io.grpc.MethodDescriptor<com.ljzn.grpc.company.CompanyDataApplyRequest, com.ljzn.grpc.company.CompanyDataApplyResponse> getCompanyDataApplyMethod;
    if ((getCompanyDataApplyMethod = CompanyAuthServiceGrpc.getCompanyDataApplyMethod) == null) {
      synchronized (CompanyAuthServiceGrpc.class) {
        if ((getCompanyDataApplyMethod = CompanyAuthServiceGrpc.getCompanyDataApplyMethod) == null) {
          CompanyAuthServiceGrpc.getCompanyDataApplyMethod = getCompanyDataApplyMethod = 
              io.grpc.MethodDescriptor.<com.ljzn.grpc.company.CompanyDataApplyRequest, com.ljzn.grpc.company.CompanyDataApplyResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "VisitorSystem_cq.CompanyAuthService", "CompanyDataApply"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ljzn.grpc.company.CompanyDataApplyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ljzn.grpc.company.CompanyDataApplyResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new CompanyAuthServiceMethodDescriptorSupplier("CompanyDataApply"))
                  .build();
          }
        }
     }
     return getCompanyDataApplyMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CompanyAuthServiceStub newStub(io.grpc.Channel channel) {
    return new CompanyAuthServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CompanyAuthServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new CompanyAuthServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CompanyAuthServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new CompanyAuthServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class CompanyAuthServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void companyDataApply(com.ljzn.grpc.company.CompanyDataApplyRequest request,
        io.grpc.stub.StreamObserver<com.ljzn.grpc.company.CompanyDataApplyResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getCompanyDataApplyMethodHelper(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCompanyDataApplyMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.ljzn.grpc.company.CompanyDataApplyRequest,
                com.ljzn.grpc.company.CompanyDataApplyResponse>(
                  this, METHODID_COMPANY_DATA_APPLY)))
          .build();
    }
  }

  /**
   */
  public static final class CompanyAuthServiceStub extends io.grpc.stub.AbstractStub<CompanyAuthServiceStub> {
    private CompanyAuthServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CompanyAuthServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CompanyAuthServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CompanyAuthServiceStub(channel, callOptions);
    }

    /**
     */
    public void companyDataApply(com.ljzn.grpc.company.CompanyDataApplyRequest request,
        io.grpc.stub.StreamObserver<com.ljzn.grpc.company.CompanyDataApplyResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCompanyDataApplyMethodHelper(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class CompanyAuthServiceBlockingStub extends io.grpc.stub.AbstractStub<CompanyAuthServiceBlockingStub> {
    private CompanyAuthServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CompanyAuthServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CompanyAuthServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CompanyAuthServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.ljzn.grpc.company.CompanyDataApplyResponse companyDataApply(com.ljzn.grpc.company.CompanyDataApplyRequest request) {
      return blockingUnaryCall(
          getChannel(), getCompanyDataApplyMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class CompanyAuthServiceFutureStub extends io.grpc.stub.AbstractStub<CompanyAuthServiceFutureStub> {
    private CompanyAuthServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CompanyAuthServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CompanyAuthServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CompanyAuthServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.ljzn.grpc.company.CompanyDataApplyResponse> companyDataApply(
        com.ljzn.grpc.company.CompanyDataApplyRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCompanyDataApplyMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_COMPANY_DATA_APPLY = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CompanyAuthServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CompanyAuthServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_COMPANY_DATA_APPLY:
          serviceImpl.companyDataApply((com.ljzn.grpc.company.CompanyDataApplyRequest) request,
              (io.grpc.stub.StreamObserver<com.ljzn.grpc.company.CompanyDataApplyResponse>) responseObserver);
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

  private static abstract class CompanyAuthServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CompanyAuthServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.ljzn.grpc.company.CompanyService.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CompanyAuthService");
    }
  }

  private static final class CompanyAuthServiceFileDescriptorSupplier
      extends CompanyAuthServiceBaseDescriptorSupplier {
    CompanyAuthServiceFileDescriptorSupplier() {}
  }

  private static final class CompanyAuthServiceMethodDescriptorSupplier
      extends CompanyAuthServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CompanyAuthServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (CompanyAuthServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CompanyAuthServiceFileDescriptorSupplier())
              .addMethod(getCompanyDataApplyMethodHelper())
              .build();
        }
      }
    }
    return result;
  }
}
