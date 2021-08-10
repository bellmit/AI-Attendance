package com.ljzn.grpc.department;

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
    comments = "Source: department/department.service.proto")
public final class DepartmentAuthServiceGrpc {

  private DepartmentAuthServiceGrpc() {}

  public static final String SERVICE_NAME = "VisitorSystem_cq.DepartmentAuthService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getDepartmentDataApplyMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.ljzn.grpc.department.DepartmentDataApplyRequest,
      com.ljzn.grpc.department.DepartmentDataApplyResponse> METHOD_DEPARTMENT_DATA_APPLY = getDepartmentDataApplyMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.ljzn.grpc.department.DepartmentDataApplyRequest,
      com.ljzn.grpc.department.DepartmentDataApplyResponse> getDepartmentDataApplyMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.ljzn.grpc.department.DepartmentDataApplyRequest,
      com.ljzn.grpc.department.DepartmentDataApplyResponse> getDepartmentDataApplyMethod() {
    return getDepartmentDataApplyMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.ljzn.grpc.department.DepartmentDataApplyRequest,
      com.ljzn.grpc.department.DepartmentDataApplyResponse> getDepartmentDataApplyMethodHelper() {
    io.grpc.MethodDescriptor<com.ljzn.grpc.department.DepartmentDataApplyRequest, com.ljzn.grpc.department.DepartmentDataApplyResponse> getDepartmentDataApplyMethod;
    if ((getDepartmentDataApplyMethod = DepartmentAuthServiceGrpc.getDepartmentDataApplyMethod) == null) {
      synchronized (DepartmentAuthServiceGrpc.class) {
        if ((getDepartmentDataApplyMethod = DepartmentAuthServiceGrpc.getDepartmentDataApplyMethod) == null) {
          DepartmentAuthServiceGrpc.getDepartmentDataApplyMethod = getDepartmentDataApplyMethod = 
              io.grpc.MethodDescriptor.<com.ljzn.grpc.department.DepartmentDataApplyRequest, com.ljzn.grpc.department.DepartmentDataApplyResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "VisitorSystem_cq.DepartmentAuthService", "DepartmentDataApply"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ljzn.grpc.department.DepartmentDataApplyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ljzn.grpc.department.DepartmentDataApplyResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new DepartmentAuthServiceMethodDescriptorSupplier("DepartmentDataApply"))
                  .build();
          }
        }
     }
     return getDepartmentDataApplyMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static DepartmentAuthServiceStub newStub(io.grpc.Channel channel) {
    return new DepartmentAuthServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DepartmentAuthServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new DepartmentAuthServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static DepartmentAuthServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new DepartmentAuthServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class DepartmentAuthServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void departmentDataApply(com.ljzn.grpc.department.DepartmentDataApplyRequest request,
        io.grpc.stub.StreamObserver<com.ljzn.grpc.department.DepartmentDataApplyResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getDepartmentDataApplyMethodHelper(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getDepartmentDataApplyMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.ljzn.grpc.department.DepartmentDataApplyRequest,
                com.ljzn.grpc.department.DepartmentDataApplyResponse>(
                  this, METHODID_DEPARTMENT_DATA_APPLY)))
          .build();
    }
  }

  /**
   */
  public static final class DepartmentAuthServiceStub extends io.grpc.stub.AbstractStub<DepartmentAuthServiceStub> {
    private DepartmentAuthServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DepartmentAuthServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DepartmentAuthServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DepartmentAuthServiceStub(channel, callOptions);
    }

    /**
     */
    public void departmentDataApply(com.ljzn.grpc.department.DepartmentDataApplyRequest request,
        io.grpc.stub.StreamObserver<com.ljzn.grpc.department.DepartmentDataApplyResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDepartmentDataApplyMethodHelper(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class DepartmentAuthServiceBlockingStub extends io.grpc.stub.AbstractStub<DepartmentAuthServiceBlockingStub> {
    private DepartmentAuthServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DepartmentAuthServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DepartmentAuthServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DepartmentAuthServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.ljzn.grpc.department.DepartmentDataApplyResponse departmentDataApply(com.ljzn.grpc.department.DepartmentDataApplyRequest request) {
      return blockingUnaryCall(
          getChannel(), getDepartmentDataApplyMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class DepartmentAuthServiceFutureStub extends io.grpc.stub.AbstractStub<DepartmentAuthServiceFutureStub> {
    private DepartmentAuthServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DepartmentAuthServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DepartmentAuthServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DepartmentAuthServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.ljzn.grpc.department.DepartmentDataApplyResponse> departmentDataApply(
        com.ljzn.grpc.department.DepartmentDataApplyRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDepartmentDataApplyMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_DEPARTMENT_DATA_APPLY = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final DepartmentAuthServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(DepartmentAuthServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_DEPARTMENT_DATA_APPLY:
          serviceImpl.departmentDataApply((com.ljzn.grpc.department.DepartmentDataApplyRequest) request,
              (io.grpc.stub.StreamObserver<com.ljzn.grpc.department.DepartmentDataApplyResponse>) responseObserver);
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

  private static abstract class DepartmentAuthServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DepartmentAuthServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.ljzn.grpc.department.DepartmentService.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DepartmentAuthService");
    }
  }

  private static final class DepartmentAuthServiceFileDescriptorSupplier
      extends DepartmentAuthServiceBaseDescriptorSupplier {
    DepartmentAuthServiceFileDescriptorSupplier() {}
  }

  private static final class DepartmentAuthServiceMethodDescriptorSupplier
      extends DepartmentAuthServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    DepartmentAuthServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (DepartmentAuthServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new DepartmentAuthServiceFileDescriptorSupplier())
              .addMethod(getDepartmentDataApplyMethodHelper())
              .build();
        }
      }
    }
    return result;
  }
}
