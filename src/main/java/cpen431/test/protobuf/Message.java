// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Message.proto

package cpen431.test.protobuf;

public final class Message {
  private Message() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface MsgOrBuilder extends
      // @@protoc_insertion_point(interface_extends:Msg)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>bytes messageID = 1;</code>
     */
    com.google.protobuf.ByteString getMessageID();

    /**
     * <code>bytes payload = 2;</code>
     */
    com.google.protobuf.ByteString getPayload();

    /**
     * <code>fixed64 checkSum = 3;</code>
     */
    long getCheckSum();

    /**
     * <code>int32 type = 4;</code>
     */
    int getType();
  }
  /**
   * Protobuf type {@code Msg}
   */
  public  static final class Msg extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:Msg)
      MsgOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use Msg.newBuilder() to construct.
    private Msg(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private Msg() {
      messageID_ = com.google.protobuf.ByteString.EMPTY;
      payload_ = com.google.protobuf.ByteString.EMPTY;
      checkSum_ = 0L;
      type_ = 0;
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private Msg(
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
            case 10: {

              messageID_ = input.readBytes();
              break;
            }
            case 18: {

              payload_ = input.readBytes();
              break;
            }
            case 25: {

              checkSum_ = input.readFixed64();
              break;
            }
            case 32: {

              type_ = input.readInt32();
              break;
            }
            default: {
              if (!parseUnknownFieldProto3(
                  input, unknownFields, extensionRegistry, tag)) {
                done = true;
              }
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
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return cpen431.test.protobuf.Message.internal_static_Msg_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return cpen431.test.protobuf.Message.internal_static_Msg_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              cpen431.test.protobuf.Message.Msg.class, cpen431.test.protobuf.Message.Msg.Builder.class);
    }

    public static final int MESSAGEID_FIELD_NUMBER = 1;
    private com.google.protobuf.ByteString messageID_;
    /**
     * <code>bytes messageID = 1;</code>
     */
    public com.google.protobuf.ByteString getMessageID() {
      return messageID_;
    }

    public static final int PAYLOAD_FIELD_NUMBER = 2;
    private com.google.protobuf.ByteString payload_;
    /**
     * <code>bytes payload = 2;</code>
     */
    public com.google.protobuf.ByteString getPayload() {
      return payload_;
    }

    public static final int CHECKSUM_FIELD_NUMBER = 3;
    private long checkSum_;
    /**
     * <code>fixed64 checkSum = 3;</code>
     */
    public long getCheckSum() {
      return checkSum_;
    }

    public static final int TYPE_FIELD_NUMBER = 4;
    private int type_;
    /**
     * <code>int32 type = 4;</code>
     */
    public int getType() {
      return type_;
    }

    private byte memoizedIsInitialized = -1;
    @java.lang.Override
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    @java.lang.Override
    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (!messageID_.isEmpty()) {
        output.writeBytes(1, messageID_);
      }
      if (!payload_.isEmpty()) {
        output.writeBytes(2, payload_);
      }
      if (checkSum_ != 0L) {
        output.writeFixed64(3, checkSum_);
      }
      if (type_ != 0) {
        output.writeInt32(4, type_);
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (!messageID_.isEmpty()) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(1, messageID_);
      }
      if (!payload_.isEmpty()) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(2, payload_);
      }
      if (checkSum_ != 0L) {
        size += com.google.protobuf.CodedOutputStream
          .computeFixed64Size(3, checkSum_);
      }
      if (type_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(4, type_);
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
      if (!(obj instanceof cpen431.test.protobuf.Message.Msg)) {
        return super.equals(obj);
      }
      cpen431.test.protobuf.Message.Msg other = (cpen431.test.protobuf.Message.Msg) obj;

      boolean result = true;
      result = result && getMessageID()
          .equals(other.getMessageID());
      result = result && getPayload()
          .equals(other.getPayload());
      result = result && (getCheckSum()
          == other.getCheckSum());
      result = result && (getType()
          == other.getType());
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
      hash = (37 * hash) + MESSAGEID_FIELD_NUMBER;
      hash = (53 * hash) + getMessageID().hashCode();
      hash = (37 * hash) + PAYLOAD_FIELD_NUMBER;
      hash = (53 * hash) + getPayload().hashCode();
      hash = (37 * hash) + CHECKSUM_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
          getCheckSum());
      hash = (37 * hash) + TYPE_FIELD_NUMBER;
      hash = (53 * hash) + getType();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static cpen431.test.protobuf.Message.Msg parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static cpen431.test.protobuf.Message.Msg parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static cpen431.test.protobuf.Message.Msg parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static cpen431.test.protobuf.Message.Msg parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static cpen431.test.protobuf.Message.Msg parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static cpen431.test.protobuf.Message.Msg parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static cpen431.test.protobuf.Message.Msg parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static cpen431.test.protobuf.Message.Msg parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static cpen431.test.protobuf.Message.Msg parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static cpen431.test.protobuf.Message.Msg parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static cpen431.test.protobuf.Message.Msg parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static cpen431.test.protobuf.Message.Msg parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    @java.lang.Override
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(cpen431.test.protobuf.Message.Msg prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    @java.lang.Override
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
     * Protobuf type {@code Msg}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:Msg)
        cpen431.test.protobuf.Message.MsgOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return cpen431.test.protobuf.Message.internal_static_Msg_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return cpen431.test.protobuf.Message.internal_static_Msg_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                cpen431.test.protobuf.Message.Msg.class, cpen431.test.protobuf.Message.Msg.Builder.class);
      }

      // Construct using cpen431.test.protobuf.Message.Msg.newBuilder()
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
        }
      }
      @java.lang.Override
      public Builder clear() {
        super.clear();
        messageID_ = com.google.protobuf.ByteString.EMPTY;

        payload_ = com.google.protobuf.ByteString.EMPTY;

        checkSum_ = 0L;

        type_ = 0;

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return cpen431.test.protobuf.Message.internal_static_Msg_descriptor;
      }

      @java.lang.Override
      public cpen431.test.protobuf.Message.Msg getDefaultInstanceForType() {
        return cpen431.test.protobuf.Message.Msg.getDefaultInstance();
      }

      @java.lang.Override
      public cpen431.test.protobuf.Message.Msg build() {
        cpen431.test.protobuf.Message.Msg result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public cpen431.test.protobuf.Message.Msg buildPartial() {
        cpen431.test.protobuf.Message.Msg result = new cpen431.test.protobuf.Message.Msg(this);
        result.messageID_ = messageID_;
        result.payload_ = payload_;
        result.checkSum_ = checkSum_;
        result.type_ = type_;
        onBuilt();
        return result;
      }

      @java.lang.Override
      public Builder clone() {
        return (Builder) super.clone();
      }
      @java.lang.Override
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return (Builder) super.setField(field, value);
      }
      @java.lang.Override
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return (Builder) super.clearField(field);
      }
      @java.lang.Override
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return (Builder) super.clearOneof(oneof);
      }
      @java.lang.Override
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, java.lang.Object value) {
        return (Builder) super.setRepeatedField(field, index, value);
      }
      @java.lang.Override
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return (Builder) super.addRepeatedField(field, value);
      }
      @java.lang.Override
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof cpen431.test.protobuf.Message.Msg) {
          return mergeFrom((cpen431.test.protobuf.Message.Msg)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(cpen431.test.protobuf.Message.Msg other) {
        if (other == cpen431.test.protobuf.Message.Msg.getDefaultInstance()) return this;
        if (other.getMessageID() != com.google.protobuf.ByteString.EMPTY) {
          setMessageID(other.getMessageID());
        }
        if (other.getPayload() != com.google.protobuf.ByteString.EMPTY) {
          setPayload(other.getPayload());
        }
        if (other.getCheckSum() != 0L) {
          setCheckSum(other.getCheckSum());
        }
        if (other.getType() != 0) {
          setType(other.getType());
        }
        this.mergeUnknownFields(other.unknownFields);
        onChanged();
        return this;
      }

      @java.lang.Override
      public final boolean isInitialized() {
        return true;
      }

      @java.lang.Override
      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        cpen431.test.protobuf.Message.Msg parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (cpen431.test.protobuf.Message.Msg) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private com.google.protobuf.ByteString messageID_ = com.google.protobuf.ByteString.EMPTY;
      /**
       * <code>bytes messageID = 1;</code>
       */
      public com.google.protobuf.ByteString getMessageID() {
        return messageID_;
      }
      /**
       * <code>bytes messageID = 1;</code>
       */
      public Builder setMessageID(com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        messageID_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>bytes messageID = 1;</code>
       */
      public Builder clearMessageID() {
        
        messageID_ = getDefaultInstance().getMessageID();
        onChanged();
        return this;
      }

      private com.google.protobuf.ByteString payload_ = com.google.protobuf.ByteString.EMPTY;
      /**
       * <code>bytes payload = 2;</code>
       */
      public com.google.protobuf.ByteString getPayload() {
        return payload_;
      }
      /**
       * <code>bytes payload = 2;</code>
       */
      public Builder setPayload(com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        payload_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>bytes payload = 2;</code>
       */
      public Builder clearPayload() {
        
        payload_ = getDefaultInstance().getPayload();
        onChanged();
        return this;
      }

      private long checkSum_ ;
      /**
       * <code>fixed64 checkSum = 3;</code>
       */
      public long getCheckSum() {
        return checkSum_;
      }
      /**
       * <code>fixed64 checkSum = 3;</code>
       */
      public Builder setCheckSum(long value) {
        
        checkSum_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>fixed64 checkSum = 3;</code>
       */
      public Builder clearCheckSum() {
        
        checkSum_ = 0L;
        onChanged();
        return this;
      }

      private int type_ ;
      /**
       * <code>int32 type = 4;</code>
       */
      public int getType() {
        return type_;
      }
      /**
       * <code>int32 type = 4;</code>
       */
      public Builder setType(int value) {
        
        type_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int32 type = 4;</code>
       */
      public Builder clearType() {
        
        type_ = 0;
        onChanged();
        return this;
      }
      @java.lang.Override
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFieldsProto3(unknownFields);
      }

      @java.lang.Override
      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:Msg)
    }

    // @@protoc_insertion_point(class_scope:Msg)
    private static final cpen431.test.protobuf.Message.Msg DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new cpen431.test.protobuf.Message.Msg();
    }

    public static cpen431.test.protobuf.Message.Msg getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<Msg>
        PARSER = new com.google.protobuf.AbstractParser<Msg>() {
      @java.lang.Override
      public Msg parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new Msg(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<Msg> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<Msg> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public cpen431.test.protobuf.Message.Msg getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Msg_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Msg_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\rMessage.proto\"I\n\003Msg\022\021\n\tmessageID\030\001 \001(" +
      "\014\022\017\n\007payload\030\002 \001(\014\022\020\n\010checkSum\030\003 \001(\006\022\014\n\004" +
      "type\030\004 \001(\005B \n\025cpen431.test.protobufB\007Mes" +
      "sageb\006proto3"
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
    internal_static_Msg_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_Msg_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Msg_descriptor,
        new java.lang.String[] { "MessageID", "Payload", "CheckSum", "Type", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}