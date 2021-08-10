package com.ljzn.grpc.employee;

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
    comments = "Source: employee/employee.service.proto")
public final class EmployeeAuthServiceGrpc {

  private EmployeeAuthServiceGrpc() {}

  public static final String SERVICE_NAME = "VisitorSystem_cq.EmployeeAuthService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getEmployeeDataApplyMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.ljzn.grpc.employee.EmployeeDataApplyRequest,
      com.ljzn.grpc.employee.EmployeeDataApplyResponse> METHOD_EMPLOYEE_DATA_APPLY = getEmployeeDataApplyMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.ljzn.grpc.employee.EmployeeDataApplyRequest,
      com.ljzn.grpc.employee.EmployeeDataApplyResponse> getEmployeeDataApplyMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.ljzn.grpc.employee.EmployeeDataApplyRequest,
      com.ljzn.grpc.employee.EmployeeDataApplyResponse> getEmployeeDataApplyMethod() {
    return getEmployeeDataApplyMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.ljzn.grpc.employee.EmployeeDataApplyRequest,
      com.ljzn.grpc.employee.EmployeeDataApplyResponse> getEmployeeDataApplyMethodHelper() {
    io.grpc.MethodDescriptor<com.ljzn.grpc.employee.EmployeeDataApplyRequest, com.ljzn.grpc.employee.EmployeeDataApplyResponse> getEmployeeDataApplyMethod;
    if ((getEmployeeDataApplyMethod = EmployeeAuthServiceGrpc.getEmployeeDataApplyMethod) == null) {
      synchronized (EmployeeAuthServiceGrpc.class) {
        if ((getEmployeeDataApplyMethod = EmployeeAuthServiceGrpc.getEmployeeDataApplyMethod) == null) {
          EmployeeAuthServiceGrpc.getEmployeeDataApplyMethod = getEmployeeDataApplyMethod = 
              io.grpc.MethodDescriptor.<com.ljzn.grpc.employee.EmployeeDataApplyRequest, com.ljzn.grpc.employee.EmployeeDataApplyResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "VisitorSystem_cq.EmployeeAuthService", "EmployeeDataApply"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ljzn.grpc.employee.EmployeeDataApplyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ljzn.grpc.employee.EmployeeDataApplyResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new EmployeeAuthServiceMethodDescriptorSupplier("EmployeeDataApply"))
                  .build();
          }
        }
     }
     return getEmployeeDataApplyMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static EmployeeAuthServiceStub newStub(io.grpc.Channel channel) {
    return new EmployeeAuthServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static EmployeeAuthServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new EmployeeAuthServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static EmployeeAuthServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new EmployeeAuthServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class EmployeeAuthServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void employeeDataApply(com.ljzn.grpc.employee.EmployeeDataApplyRequest request,
        io.grpc.stub.StreamObserver<com.ljzn.grpc.employee.EmployeeDataApplyResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getEmployeeDataApplyMethodHelper(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getEmployeeDataApplyMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.ljzn.grpc.employee.EmployeeDataApplyRequest,
                com.ljzn.grpc.employee.EmployeeDataApplyResponse>(
                  this, METHODID_EMPLOYEE_DATA_APPLY)))
          .build();
    }
  }

  /**
   */
  public static final class EmployeeAuthServiceStub extends io.grpc.stub.AbstractStub<EmployeeAuthServiceStub> {
    private EmployeeAuthServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private EmployeeAuthServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EmployeeAuthServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new EmployeeAuthServiceStub(channel, callOptions);
    }

    /**
     */
    public void employeeDataApply(com.ljzn.grpc.employee.EmployeeDataApplyRequest request,
        io.grpc.stub.StreamObserver<com.ljzn.grpc.employee.EmployeeDataApplyResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getEmployeeDataApplyMethodHelper(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class EmployeeAuthServiceBlockingStub extends io.grpc.stub.AbstractStub<EmployeeAuthServiceBlockingStub> {
    private EmployeeAuthServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private EmployeeAuthServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EmployeeAuthServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new EmployeeAuthServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.ljzn.grpc.employee.EmployeeDataApplyResponse employeeDataApply(com.ljzn.grpc.employee.EmployeeDataApplyRequest request) {
      return blockingUnaryCall(
          getChannel(), getEmployeeDataApplyMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class EmployeeAuthServiceFutureStub extends io.grpc.stub.AbstractStub<EmployeeAuthServiceFutureStub> {
    private EmployeeAuthServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private EmployeeAuthServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EmployeeAuthServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new EmployeeAuthServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.ljzn.grpc.employee.EmployeeDataApplyResponse> employeeDataApply(
        com.ljzn.grpc.employee.EmployeeDataApplyRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getEmployeeDataApplyMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_EMPLOYEE_DATA_APPLY = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final EmployeeAuthServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(EmployeeAuthServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_EMPLOYEE_DATA_APPLY:
          serviceImpl.employeeDataApply((com.ljzn.grpc.employee.EmployeeDataApplyRequest) request,
              (io.grpc.stub.StreamObserver<com.ljzn.grpc.employee.EmployeeDataApplyResponse>) responseObserver);
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

  private static abstract class EmployeeAuthServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    EmployeeAuthServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.ljzn.grpc.employee.EmployeeService.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("EmployeeAuthService");
    }
  }

  private static final class EmployeeAuthServiceFileDescriptorSupplier
      extends EmployeeAuthServiceBaseDescriptorSupplier {
    EmployeeAuthServiceFileDescriptorSupplier() {}
  }

  private static final class EmployeeAuthServiceMethodDescriptorSupplier
      extends EmployeeAuthServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    EmployeeAuthServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (EmployeeAuthServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new EmployeeAuthServiceFileDescriptorSupplier())
              .addMethod(getEmployeeDataApplyMethodHelper())
              .build();
        }
      }
    }
    return result;
  }
}
