// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: reason/reason.service.proto

package com.ljzn.grpc.reason;

/**
 * Protobuf type {@code VisitorSystem_cq.ReasonDataApplyResponse}
 */
public  final class ReasonDataApplyResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:VisitorSystem_cq.ReasonDataApplyResponse)
    ReasonDataApplyResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use ReasonDataApplyResponse.newBuilder() to construct.
  private ReasonDataApplyResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ReasonDataApplyResponse() {
    code_ = 0;
    message_ = "";
    serverSecret_ = "";
    serverVersion_ = 0L;
    reasonMessages_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private ReasonDataApplyResponse(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
          case 8: {

            code_ = input.readInt32();
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            message_ = s;
            break;
          }
          case 26: {
            java.lang.String s = input.readStringRequireUtf8();

            serverSecret_ = s;
            break;
          }
          case 32: {

            serverVersion_ = input.readInt64();
            break;
          }
          case 42: {
            if (!((mutable_bitField0_ & 0x00000010) == 0x00000010)) {
              reasonMessages_ = new java.util.ArrayList<com.ljzn.grpc.reason.ReasonMessage>();
              mutable_bitField0_ |= 0x00000010;
            }
            reasonMessages_.add(
                input.readMessage(com.ljzn.grpc.reason.ReasonMessage.parser(), extensionRegistry));
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      if (((mutable_bitField0_ & 0x00000010) == 0x00000010)) {
        reasonMessages_ = java.util.Collections.unmodifiableList(reasonMessages_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.ljzn.grpc.reason.ReasonService.internal_static_VisitorSystem_cq_ReasonDataApplyResponse_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.ljzn.grpc.reason.ReasonService.internal_static_VisitorSystem_cq_ReasonDataApplyResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.ljzn.grpc.reason.ReasonDataApplyResponse.class, com.ljzn.grpc.reason.ReasonDataApplyResponse.Builder.class);
  }

  private int bitField0_;
  public static final int CODE_FIELD_NUMBER = 1;
  private int code_;
  /**
   * <code>int32 code = 1;</code>
   */
  public int getCode() {
    return code_;
  }

  public static final int MESSAGE_FIELD_NUMBER = 2;
  private volatile java.lang.Object message_;
  /**
   * <code>string message = 2;</code>
   */
  public java.lang.String getMessage() {
    java.lang.Object ref = message_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      message_ = s;
      return s;
    }
  }
  /**
   * <code>string message = 2;</code>
   */
  public com.google.protobuf.ByteString
      getMessageBytes() {
    java.lang.Object ref = message_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      message_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int SERVER_SECRET_FIELD_NUMBER = 3;
  private volatile java.lang.Object serverSecret_;
  /**
   * <code>string server_secret = 3;</code>
   */
  public java.lang.String getServerSecret() {
    java.lang.Object ref = serverSecret_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      serverSecret_ = s;
      return s;
    }
  }
  /**
   * <code>string server_secret = 3;</code>
   */
  public com.google.protobuf.ByteString
      getServerSecretBytes() {
    java.lang.Object ref = serverSecret_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      serverSecret_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int SERVERVERSION_FIELD_NUMBER = 4;
  private long serverVersion_;
  /**
   * <pre>
   *??????????????????
   * </pre>
   *
   * <code>int64 serverVersion = 4;</code>
   */
  public long getServerVersion() {
    return serverVersion_;
  }

  public static final int REASONMESSAGES_FIELD_NUMBER = 5;
  private java.util.List<com.ljzn.grpc.reason.ReasonMessage> reasonMessages_;
  /**
   * <pre>
   *????????????????????????????????????????????????
   * </pre>
   *
   * <code>repeated .VisitorSystem_cq.ReasonMessage reasonMessages = 5;</code>
   */
  public java.util.List<com.ljzn.grpc.reason.ReasonMessage> getReasonMessagesList() {
    return reasonMessages_;
  }
  /**
   * <pre>
   *????????????????????????????????????????????????
   * </pre>
   *
   * <code>repeated .VisitorSystem_cq.ReasonMessage reasonMessages = 5;</code>
   */
  public java.util.List<? extends com.ljzn.grpc.reason.ReasonMessageOrBuilder> 
      getReasonMessagesOrBuilderList() {
    return reasonMessages_;
  }
  /**
   * <pre>
   *????????????????????????????????????????????????
   * </pre>
   *
   * <code>repeated .VisitorSystem_cq.ReasonMessage reasonMessages = 5;</code>
   */
  public int getReasonMessagesCount() {
    return reasonMessages_.size();
  }
  /**
   * <pre>
   *????????????????????????????????????????????????
   * </pre>
   *
   * <code>repeated .VisitorSystem_cq.ReasonMessage reasonMessages = 5;</code>
   */
  public com.ljzn.grpc.reason.ReasonMessage getReasonMessages(int index) {
    return reasonMessages_.get(index);
  }
  /**
   * <pre>
   *????????????????????????????????????????????????
   * </pre>
   *
   * <code>repeated .VisitorSystem_cq.ReasonMessage reasonMessages = 5;</code>
   */
  public com.ljzn.grpc.reason.ReasonMessageOrBuilder getReasonMessagesOrBuilder(
      int index) {
    return reasonMessages_.get(index);
  }

  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (code_ != 0) {
      output.writeInt32(1, code_);
    }
    if (!getMessageBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, message_);
    }
    if (!getServerSecretBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, serverSecret_);
    }
    if (serverVersion_ != 0L) {
      output.writeInt64(4, serverVersion_);
    }
    for (int i = 0; i < reasonMessages_.size(); i++) {
      output.writeMessage(5, reasonMessages_.get(i));
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (code_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, code_);
    }
    if (!getMessageBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, message_);
    }
    if (!getServerSecretBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, serverSecret_);
    }
    if (serverVersion_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(4, serverVersion_);
    }
    for (int i = 0; i < reasonMessages_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(5, reasonMessages_.get(i));
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.ljzn.grpc.reason.ReasonDataApplyResponse)) {
      return super.equals(obj);
    }
    com.ljzn.grpc.reason.ReasonDataApplyResponse other = (com.ljzn.grpc.reason.ReasonDataApplyResponse) obj;

    boolean result = true;
    result = result && (getCode()
        == other.getCode());
    result = result && getMessage()
        .equals(other.getMessage());
    result = result && getServerSecret()
        .equals(other.getServerSecret());
    result = result && (getServerVersion()
        == other.getServerVersion());
    result = result && getReasonMessagesList()
        .equals(other.getReasonMessagesList());
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + CODE_FIELD_NUMBER;
    hash = (53 * hash) + getCode();
    hash = (37 * hash) + MESSAGE_FIELD_NUMBER;
    hash = (53 * hash) + getMessage().hashCode();
    hash = (37 * hash) + SERVER_SECRET_FIELD_NUMBER;
    hash = (53 * hash) + getServerSecret().hashCode();
    hash = (37 * hash) + SERVERVERSION_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getServerVersion());
    if (getReasonMessagesCount() > 0) {
      hash = (37 * hash) + REASONMESSAGES_FIELD_NUMBER;
      hash = (53 * hash) + getReasonMessagesList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.ljzn.grpc.reason.ReasonDataApplyResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.ljzn.grpc.reason.ReasonDataApplyResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.ljzn.grpc.reason.ReasonDataApplyResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.ljzn.grpc.reason.ReasonDataApplyResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.ljzn.grpc.reason.ReasonDataApplyResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.ljzn.grpc.reason.ReasonDataApplyResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.ljzn.grpc.reason.ReasonDataApplyResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.ljzn.grpc.reason.ReasonDataApplyResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.ljzn.grpc.reason.ReasonDataApplyResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.ljzn.grpc.reason.ReasonDataApplyResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.ljzn.grpc.reason.ReasonDataApplyResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.ljzn.grpc.reason.ReasonDataApplyResponse parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.ljzn.grpc.reason.ReasonDataApplyResponse prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code VisitorSystem_cq.ReasonDataApplyResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:VisitorSystem_cq.ReasonDataApplyResponse)
      com.ljzn.grpc.reason.ReasonDataApplyResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.ljzn.grpc.reason.ReasonService.internal_static_VisitorSystem_cq_ReasonDataApplyResponse_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.ljzn.grpc.reason.ReasonService.internal_static_VisitorSystem_cq_ReasonDataApplyResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.ljzn.grpc.reason.ReasonDataApplyResponse.class, com.ljzn.grpc.reason.ReasonDataApplyResponse.Builder.class);
    }

    // Construct using com.ljzn.grpc.reason.ReasonDataApplyResponse.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
        getReasonMessagesFieldBuilder();
      }
    }
    public Builder clear() {
      super.clear();
      code_ = 0;

      message_ = "";

      serverSecret_ = "";

      serverVersion_ = 0L;

      if (reasonMessagesBuilder_ == null) {
        reasonMessages_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000010);
      } else {
        reasonMessagesBuilder_.clear();
      }
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.ljzn.grpc.reason.ReasonService.internal_static_VisitorSystem_cq_ReasonDataApplyResponse_descriptor;
    }

    public com.ljzn.grpc.reason.ReasonDataApplyResponse getDefaultInstanceForType() {
      return com.ljzn.grpc.reason.ReasonDataApplyResponse.getDefaultInstance();
    }

    public com.ljzn.grpc.reason.ReasonDataApplyResponse build() {
      com.ljzn.grpc.reason.ReasonDataApplyResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.ljzn.grpc.reason.ReasonDataApplyResponse buildPartial() {
      com.ljzn.grpc.reason.ReasonDataApplyResponse result = new com.ljzn.grpc.reason.ReasonDataApplyResponse(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      result.code_ = code_;
      result.message_ = message_;
      result.serverSecret_ = serverSecret_;
      result.serverVersion_ = serverVersion_;
      if (reasonMessagesBuilder_ == null) {
        if (((bitField0_ & 0x00000010) == 0x00000010)) {
          reasonMessages_ = java.util.Collections.unmodifiableList(reasonMessages_);
          bitField0_ = (bitField0_ & ~0x00000010);
        }
        result.reasonMessages_ = reasonMessages_;
      } else {
        result.reasonMessages_ = reasonMessagesBuilder_.build();
      }
      result.bitField0_ = to_bitField0_;
      onBuilt();
      return result;
    }

    public Builder clone() {
      return (Builder) super.clone();
    }
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.ljzn.grpc.reason.ReasonDataApplyResponse) {
        return mergeFrom((com.ljzn.grpc.reason.ReasonDataApplyResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.ljzn.grpc.reason.ReasonDataApplyResponse other) {
      if (other == com.ljzn.grpc.reason.ReasonDataApplyResponse.getDefaultInstance()) return this;
      if (other.getCode() != 0) {
        setCode(other.getCode());
      }
      if (!other.getMessage().isEmpty()) {
        message_ = other.message_;
        onChanged();
      }
      if (!other.getServerSecret().isEmpty()) {
        serverSecret_ = other.serverSecret_;
        onChanged();
      }
      if (other.getServerVersion() != 0L) {
        setServerVersion(other.getServerVersion());
      }
      if (reasonMessagesBuilder_ == null) {
        if (!other.reasonMessages_.isEmpty()) {
          if (reasonMessages_.isEmpty()) {
            reasonMessages_ = other.reasonMessages_;
            bitField0_ = (bitField0_ & ~0x00000010);
          } else {
            ensureReasonMessagesIsMutable();
            reasonMessages_.addAll(other.reasonMessages_);
          }
          onChanged();
        }
      } else {
        if (!other.reasonMessages_.isEmpty()) {
          if (reasonMessagesBuilder_.isEmpty()) {
            reasonMessagesBuilder_.dispose();
            reasonMessagesBuilder_ = null;
            reasonMessages_ = other.reasonMessages_;
            bitField0_ = (bitField0_ & ~0x00000010);
            reasonMessagesBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getReasonMessagesFieldBuilder() : null;
          } else {
            reasonMessagesBuilder_.addAllMessages(other.reasonMessages_);
          }
        }
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      com.ljzn.grpc.reason.ReasonDataApplyResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.ljzn.grpc.reason.ReasonDataApplyResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private int code_ ;
    /**
     * <code>int32 code = 1;</code>
     */
    public int getCode() {
      return code_;
    }
    /**
     * <code>int32 code = 1;</code>
     */
    public Builder setCode(int value) {
      
      code_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 code = 1;</code>
     */
    public Builder clearCode() {
      
      code_ = 0;
      onChanged();
      return this;
    }

    private java.lang.Object message_ = "";
    /**
     * <code>string message = 2;</code>
     */
    public java.lang.String getMessage() {
      java.lang.Object ref = message_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        message_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string message = 2;</code>
     */
    public com.google.protobuf.ByteString
        getMessageBytes() {
      java.lang.Object ref = message_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        message_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string message = 2;</code>
     */
    public Builder setMessage(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      message_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string message = 2;</code>
     */
    public Builder clearMessage() {
      
      message_ = getDefaultInstance().getMessage();
      onChanged();
      return this;
    }
    /**
     * <code>string message = 2;</code>
     */
    public Builder setMessageBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      message_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object serverSecret_ = "";
    /**
     * <code>string server_secret = 3;</code>
     */
    public java.lang.String getServerSecret() {
      java.lang.Object ref = serverSecret_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        serverSecret_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string server_secret = 3;</code>
     */
    public com.google.protobuf.ByteString
        getServerSecretBytes() {
      java.lang.Object ref = serverSecret_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        serverSecret_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string server_secret = 3;</code>
     */
    public Builder setServerSecret(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      serverSecret_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string server_secret = 3;</code>
     */
    public Builder clearServerSecret() {
      
      serverSecret_ = getDefaultInstance().getServerSecret();
      onChanged();
      return this;
    }
    /**
     * <code>string server_secret = 3;</code>
     */
    public Builder setServerSecretBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      serverSecret_ = value;
      onChanged();
      return this;
    }

    private long serverVersion_ ;
    /**
     * <pre>
     *??????????????????
     * </pre>
     *
     * <code>int64 serverVersion = 4;</code>
     */
    public long getServerVersion() {
      return serverVersion_;
    }
    /**
     * <pre>
     *??????????????????
     * </pre>
     *
     * <code>int64 serverVersion = 4;</code>
     */
    public Builder setServerVersion(long value) {
      
      serverVersion_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     *??????????????????
     * </pre>
     *
     * <code>int64 serverVersion = 4;</code>
     */
    public Builder clearServerVersion() {
      
      serverVersion_ = 0L;
      onChanged();
      return this;
    }

    private java.util.List<com.ljzn.grpc.reason.ReasonMessage> reasonMessages_ =
      java.util.Collections.emptyList();
    private void ensureReasonMessagesIsMutable() {
      if (!((bitField0_ & 0x00000010) == 0x00000010)) {
        reasonMessages_ = new java.util.ArrayList<com.ljzn.grpc.reason.ReasonMessage>(reasonMessages_);
        bitField0_ |= 0x00000010;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.ljzn.grpc.reason.ReasonMessage, com.ljzn.grpc.reason.ReasonMessage.Builder, com.ljzn.grpc.reason.ReasonMessageOrBuilder> reasonMessagesBuilder_;

    /**
     * <pre>
     *????????????????????????????????????????????????
     * </pre>
     *
     * <code>repeated .VisitorSystem_cq.ReasonMessage reasonMessages = 5;</code>
     */
    public java.util.List<com.ljzn.grpc.reason.ReasonMessage> getReasonMessagesList() {
      if (reasonMessagesBuilder_ == null) {
        return java.util.Collections.unmodifiableList(reasonMessages_);
      } else {
        return reasonMessagesBuilder_.getMessageList();
      }
    }
    /**
     * <pre>
     *????????????????????????????????????????????????
     * </pre>
     *
     * <code>repeated .VisitorSystem_cq.ReasonMessage reasonMessages = 5;</code>
     */
    public int getReasonMessagesCount() {
      if (reasonMessagesBuilder_ == null) {
        return reasonMessages_.size();
      } else {
        return reasonMessagesBuilder_.getCount();
      }
    }
    /**
     * <pre>
     *????????????????????????????????????????????????
     * </pre>
     *
     * <code>repeated .VisitorSystem_cq.ReasonMessage reasonMessages = 5;</code>
     */
    public com.ljzn.grpc.reason.ReasonMessage getReasonMessages(int index) {
      if (reasonMessagesBuilder_ == null) {
        return reasonMessages_.get(index);
      } else {
        return reasonMessagesBuilder_.getMessage(index);
      }
    }
    /**
     * <pre>
     *????????????????????????????????????????????????
     * </pre>
     *
     * <code>repeated .VisitorSystem_cq.ReasonMessage reasonMessages = 5;</code>
     */
    public Builder setReasonMessages(
        int index, com.ljzn.grpc.reason.ReasonMessage value) {
      if (reasonMessagesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureReasonMessagesIsMutable();
        reasonMessages_.set(index, value);
        onChanged();
      } else {
        reasonMessagesBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <pre>
     *????????????????????????????????????????????????
     * </pre>
     *
     * <code>repeated .VisitorSystem_cq.ReasonMessage reasonMessages = 5;</code>
     */
    public Builder setReasonMessages(
        int index, com.ljzn.grpc.reason.ReasonMessage.Builder builderForValue) {
      if (reasonMessagesBuilder_ == null) {
        ensureReasonMessagesIsMutable();
        reasonMessages_.set(index, builderForValue.build());
        onChanged();
      } else {
        reasonMessagesBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <pre>
     *????????????????????????????????????????????????
     * </pre>
     *
     * <code>repeated .VisitorSystem_cq.ReasonMessage reasonMessages = 5;</code>
     */
    public Builder addReasonMessages(com.ljzn.grpc.reason.ReasonMessage value) {
      if (reasonMessagesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureReasonMessagesIsMutable();
        reasonMessages_.add(value);
        onChanged();
      } else {
        reasonMessagesBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <pre>
     *????????????????????????????????????????????????
     * </pre>
     *
     * <code>repeated .VisitorSystem_cq.ReasonMessage reasonMessages = 5;</code>
     */
    public Builder addReasonMessages(
        int index, com.ljzn.grpc.reason.ReasonMessage value) {
      if (reasonMessagesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureReasonMessagesIsMutable();
        reasonMessages_.add(index, value);
        onChanged();
      } else {
        reasonMessagesBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <pre>
     *????????????????????????????????????????????????
     * </pre>
     *
     * <code>repeated .VisitorSystem_cq.ReasonMessage reasonMessages = 5;</code>
     */
    public Builder addReasonMessages(
        com.ljzn.grpc.reason.ReasonMessage.Builder builderForValue) {
      if (reasonMessagesBuilder_ == null) {
        ensureReasonMessagesIsMutable();
        reasonMessages_.add(builderForValue.build());
        onChanged();
      } else {
        reasonMessagesBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <pre>
     *????????????????????????????????????????????????
     * </pre>
     *
     * <code>repeated .VisitorSystem_cq.ReasonMessage reasonMessages = 5;</code>
     */
    public Builder addReasonMessages(
        int index, com.ljzn.grpc.reason.ReasonMessage.Builder builderForValue) {
      if (reasonMessagesBuilder_ == null) {
        ensureReasonMessagesIsMutable();
        reasonMessages_.add(index, builderForValue.build());
        onChanged();
      } else {
        reasonMessagesBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <pre>
     *????????????????????????????????????????????????
     * </pre>
     *
     * <code>repeated .VisitorSystem_cq.ReasonMessage reasonMessages = 5;</code>
     */
    public Builder addAllReasonMessages(
        java.lang.Iterable<? extends com.ljzn.grpc.reason.ReasonMessage> values) {
      if (reasonMessagesBuilder_ == null) {
        ensureReasonMessagesIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, reasonMessages_);
        onChanged();
      } else {
        reasonMessagesBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <pre>
     *????????????????????????????????????????????????
     * </pre>
     *
     * <code>repeated .VisitorSystem_cq.ReasonMessage reasonMessages = 5;</code>
     */
    public Builder clearReasonMessages() {
      if (reasonMessagesBuilder_ == null) {
        reasonMessages_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000010);
        onChanged();
      } else {
        reasonMessagesBuilder_.clear();
      }
      return this;
    }
    /**
     * <pre>
     *????????????????????????????????????????????????
     * </pre>
     *
     * <code>repeated .VisitorSystem_cq.ReasonMessage reasonMessages = 5;</code>
     */
    public Builder removeReasonMessages(int index) {
      if (reasonMessagesBuilder_ == null) {
        ensureReasonMessagesIsMutable();
        reasonMessages_.remove(index);
        onChanged();
      } else {
        reasonMessagesBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <pre>
     *????????????????????????????????????????????????
     * </pre>
     *
     * <code>repeated .VisitorSystem_cq.ReasonMessage reasonMessages = 5;</code>
     */
    public com.ljzn.grpc.reason.ReasonMessage.Builder getReasonMessagesBuilder(
        int index) {
      return getReasonMessagesFieldBuilder().getBuilder(index);
    }
    /**
     * <pre>
     *????????????????????????????????????????????????
     * </pre>
     *
     * <code>repeated .VisitorSystem_cq.ReasonMessage reasonMessages = 5;</code>
     */
    public com.ljzn.grpc.reason.ReasonMessageOrBuilder getReasonMessagesOrBuilder(
        int index) {
      if (reasonMessagesBuilder_ == null) {
        return reasonMessages_.get(index);  } else {
        return reasonMessagesBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <pre>
     *????????????????????????????????????????????????
     * </pre>
     *
     * <code>repeated .VisitorSystem_cq.ReasonMessage reasonMessages = 5;</code>
     */
    public java.util.List<? extends com.ljzn.grpc.reason.ReasonMessageOrBuilder> 
         getReasonMessagesOrBuilderList() {
      if (reasonMessagesBuilder_ != null) {
        return reasonMessagesBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(reasonMessages_);
      }
    }
    /**
     * <pre>
     *????????????????????????????????????????????????
     * </pre>
     *
     * <code>repeated .VisitorSystem_cq.ReasonMessage reasonMessages = 5;</code>
     */
    public com.ljzn.grpc.reason.ReasonMessage.Builder addReasonMessagesBuilder() {
      return getReasonMessagesFieldBuilder().addBuilder(
          com.ljzn.grpc.reason.ReasonMessage.getDefaultInstance());
    }
    /**
     * <pre>
     *????????????????????????????????????????????????
     * </pre>
     *
     * <code>repeated .VisitorSystem_cq.ReasonMessage reasonMessages = 5;</code>
     */
    public com.ljzn.grpc.reason.ReasonMessage.Builder addReasonMessagesBuilder(
        int index) {
      return getReasonMessagesFieldBuilder().addBuilder(
          index, com.ljzn.grpc.reason.ReasonMessage.getDefaultInstance());
    }
    /**
     * <pre>
     *????????????????????????????????????????????????
     * </pre>
     *
     * <code>repeated .VisitorSystem_cq.ReasonMessage reasonMessages = 5;</code>
     */
    public java.util.List<com.ljzn.grpc.reason.ReasonMessage.Builder> 
         getReasonMessagesBuilderList() {
      return getReasonMessagesFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.ljzn.grpc.reason.ReasonMessage, com.ljzn.grpc.reason.ReasonMessage.Builder, com.ljzn.grpc.reason.ReasonMessageOrBuilder> 
        getReasonMessagesFieldBuilder() {
      if (reasonMessagesBuilder_ == null) {
        reasonMessagesBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            com.ljzn.grpc.reason.ReasonMessage, com.ljzn.grpc.reason.ReasonMessage.Builder, com.ljzn.grpc.reason.ReasonMessageOrBuilder>(
                reasonMessages_,
                ((bitField0_ & 0x00000010) == 0x00000010),
                getParentForChildren(),
                isClean());
        reasonMessages_ = null;
      }
      return reasonMessagesBuilder_;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:VisitorSystem_cq.ReasonDataApplyResponse)
  }

  // @@protoc_insertion_point(class_scope:VisitorSystem_cq.ReasonDataApplyResponse)
  private static final com.ljzn.grpc.reason.ReasonDataApplyResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.ljzn.grpc.reason.ReasonDataApplyResponse();
  }

  public static com.ljzn.grpc.reason.ReasonDataApplyResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<ReasonDataApplyResponse>
      PARSER = new com.google.protobuf.AbstractParser<ReasonDataApplyResponse>() {
    public ReasonDataApplyResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new ReasonDataApplyResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<ReasonDataApplyResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ReasonDataApplyResponse> getParserForType() {
    return PARSER;
  }

  public com.ljzn.grpc.reason.ReasonDataApplyResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

