package cpen431.test;

import com.google.protobuf.ByteString;
import cpen431.test.protobuf.KeyValueRequest;
import cpen431.test.protobuf.KeyValueResponse;
import cpen431.test.protobuf.Message;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.zip.CRC32;

import static cpen431.test.constants.ClientConstants.*;

public class Helpers {

    public static void generateTestData(int numKeys, HashMap<ByteString, byte[]> store) {
        for (int i = 0; i < numKeys; i++) {
            byte[] key = new byte[MAX_KEY_BYTE_SIZE];
            byte[] value = new byte[MAX_VAL_BYTE_SIZE];
            new Random().nextBytes(key);
            new Random().nextBytes(value);
            store.put(ByteString.copyFrom(key), value);
        }
    }

    public static void readServersTxt(List<String> nodeTable) {

        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(FILEPATH));
            String line = reader.readLine();

            int totalNumberOfNodes = 0;
            while (line != null) {
                nodeTable.add(line);
                totalNumberOfNodes++;
                // read next line
                line = reader.readLine();
            }

            System.out.println("Total number of nodes: " + totalNumberOfNodes);

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static byte[] createPutPayload(byte[] key, byte[] value){
        KeyValueRequest.KVRequest.Builder request = KeyValueRequest.KVRequest.newBuilder();

        request.setCommand(1);
        request.setKey(ByteString.copyFrom(key));
        request.setValue(ByteString.copyFrom(value));
        request.setVersion(0);

        return request.build().toByteArray();
    }

    public static byte[] createWipeoutPayload(){
        KeyValueRequest.KVRequest.Builder request = KeyValueRequest.KVRequest.newBuilder();

        request.setCommand(WIPEOUT_REQUEST);

        return request.build().toByteArray();
    }

    public static byte[] createGetRequestPayload(byte[] key){
        KeyValueRequest.KVRequest.Builder request = KeyValueRequest.KVRequest.newBuilder();

        request.setCommand(GET_REQUEST);
        request.setKey(ByteString.copyFrom(key));
        request.setVersion(0);

        return request.build().toByteArray();
    }

    public static byte[] createGetPidPayload(){
        KeyValueRequest.KVRequest.Builder request = KeyValueRequest.KVRequest.newBuilder();

        request.setCommand(7);
        request.setVersion(0);

        return request.build().toByteArray();
    }

    public static boolean verifyCheckSum(Message.Msg msg) {
        CRC32 checksum = new CRC32();
        checksum.update(msg.getMessageID().concat(msg.getPayload()).toByteArray());
        return checksum.getValue() == msg.getCheckSum();
    }

    public static Message.Msg receiveMessage(DatagramSocket primarySocket, DatagramPacket rcv) throws IOException {
        try {
            primarySocket.receive(rcv);
        } catch (SocketTimeoutException e) {
            System.out.println("ERROR: socket timeout");
            return null;
        }

        Message.Msg rcvMsg;
        rcvMsg = Message.Msg.parseFrom(Arrays.copyOfRange(rcv.getData(), 0, rcv.getLength()));

        if (!verifyCheckSum(rcvMsg)) {
            System.out.println("ERROR: message checksum error");
            return null;
        }

        return rcvMsg;
    }

    public static byte[] generateMessageID() {
        byte[] messageID = new byte[MAX_KEY_BYTE_SIZE];
        new Random().nextBytes(messageID);
        return messageID;
    }

    public static void sendMessage(byte[] messageId, byte[] payload, String destinationAddressAndPort, DatagramSocket primarySocket) throws IOException {
        Message.Msg.Builder message = Message.Msg.newBuilder();

        message.setMessageID(ByteString.copyFrom(messageId));
        message.setPayload(ByteString.copyFrom(payload));

        CRC32 checksum = new CRC32();
        checksum.update(messageId);
        checksum.update(payload);

        message.setCheckSum(checksum.getValue());

        Message.Msg builtMessage = message.build();
        byte[] sndBuf = builtMessage.toByteArray();

        InetAddress destinationAddress = InetAddress.getByName(destinationAddressAndPort.split(":")[0]);
        int destinationPort = Integer.parseInt(destinationAddressAndPort.split(":")[1]);

        DatagramPacket snd = new DatagramPacket(sndBuf, sndBuf.length, destinationAddress, destinationPort);
        primarySocket.send(snd);
    }

    public static KeyValueResponse.KVResponse waitForResponse(byte[] messageID, DatagramSocket primarySocket) throws IOException {
        byte[] rcvBuf = new byte[1024*1024];
        DatagramPacket rcv = new DatagramPacket(rcvBuf, rcvBuf.length);
        Message.Msg rcvMsg = receiveMessage(primarySocket, rcv);

        if (rcvMsg == null) return null;

        assert Arrays.equals(messageID, rcvMsg.getMessageID().toByteArray());
        KeyValueResponse.KVResponse response = KeyValueResponse.KVResponse.parseFrom(rcvMsg.getPayload());
        return response;
    }
}
