package cpen431.test;

import com.google.protobuf.ByteString;
import cpen431.test.protobuf.KeyValueResponse;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.*;

import static cpen431.test.Helpers.*;
import static cpen431.test.constants.ClientConstants.*;

/**
 * Test client for CPEN 431 G5 project
 *
 */
public class App
{

    public static List<String> nodeTable = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);
    public static HashMap<String, Integer> pidTable = new HashMap<>();
    public static HashMap<ByteString, byte[]> testStore = new HashMap<>();
    public static HashMap<ByteString, byte[]> actuallyStored = new HashMap<>();
    public static DatagramSocket testClientSocket;

    static {
        try {
            testClientSocket = new DatagramSocket(TEST_PORT);
            testClientSocket.setSoTimeout(1000);
        } catch (SocketException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main( String[] args )
    {
        readServersTxt(nodeTable);
        generateTestData(500, testStore);

        getAllPID();
        resetAllServers();

        randomFrontEndPut();
        System.out.println("Finished putting to " + nodeTable.get(0));


        System.out.println("Type enter after to get");
        String line = scanner.nextLine();
        System.out.println("Starting gets");

        randomFrontEndGet();
        System.out.println("Finished getting to " + nodeTable.get(0));



//        int retryAttempt = 0;
//        Scanner scanner = new Scanner(System.in);
//
//        DatagramSocket primarySocket;
//
//        int port = 25000;
//        primarySocket = new DatagramSocket(port);
//        primarySocket.setReceiveBufferSize(RECEIVE_BUFFER_SIZE);
//        InetAddress destinationAddress = InetAddress.getByName("184.169.226.201");
//        int destinationPort = Integer.parseInt("43120");
//
//        byte[] messageID = {50};
//        byte[] key = {56}; // This goes to 43114
//        byte[] value = {50};
//
//        byte[] payload = createPutPayload(key, value);
//
//        sendMessage(messageID, payload, destinationAddress, destinationPort, primarySocket);
//
//        //Now get the response
//        byte[] rcvBuf = new byte[MAX_MESSAGE_BYTE_SIZE];
//        DatagramPacket rcv = new DatagramPacket(rcvBuf, rcvBuf.length);
//
//        Message.Msg rcvMsg = receiveMessage(primarySocket, rcv);
//
//        KeyValueResponse.KVResponse incomingRequest = KeyValueResponse.KVResponse.parseFrom(rcvMsg.getPayload().toByteArray());
//
//        System.out.println("Error Code");
//        System.out.println(incomingRequest.getErrCode());
//
//        if(incomingRequest.getErrCode() != 0){
//            System.out.println("Get not done correctly");
//        }
//
//        payload = createGetRequestPayload(key);
//
//        messageID = new byte[]{52};
//        sendMessage(messageID, payload, destinationAddress, destinationPort, primarySocket);
//
//        rcvMsg = receiveMessage(primarySocket, rcv);
//        incomingRequest = KeyValueResponse.KVResponse.parseFrom(rcvMsg.getPayload().toByteArray());
//
//        if(!Arrays.toString(incomingRequest.getValue().toByteArray()).equals(Arrays.toString(value))) {
//            System.out.println("Monka shake we have big problems");
//            return;
//        }
//
//        destinationPort = Integer.parseInt("43114");
//        payload = createGetPidPayload();
//
//        messageID = new byte[]{53};
//        sendMessage(messageID, payload, destinationAddress, destinationPort, primarySocket);
//
//        rcvMsg = receiveMessage(primarySocket, rcv);
//        incomingRequest = KeyValueResponse.KVResponse.parseFrom(rcvMsg.getPayload().toByteArray());
//
//        System.out.println("Pid is: ");
//        System.out.println(incomingRequest.getPid());
//
//        System.out.println("Use the command: kill -STOP " + incomingRequest.getPid()+ " To suspend the java process");
//
//        System.out.println("Type enter after entering the above command into your ec2 server.");
//        String line = scanner.nextLine();
//
//        System.out.println("Waiting 30 seconds");
//        TimeUnit.SECONDS.sleep(30);
//
//        System.out.println("Moving on to see if the get was replicated");
//
//        //Get all information from successor now
//        destinationPort = Integer.parseInt("43121");
//
//        payload = createGetRequestPayload(key);
//
//        messageID = new byte[]{54};
//        sendMessage(messageID, payload, destinationAddress, destinationPort, primarySocket);
//
//        rcvMsg = receiveMessage(primarySocket, rcv);
//        incomingRequest = KeyValueResponse.KVResponse.parseFrom(rcvMsg.getPayload().toByteArray());
//
//        System.out.println("Value from successor");
//        System.out.println(Arrays.toString(incomingRequest.getValue().toByteArray()));
//
//        //Now turn off server 43113
//        destinationPort = Integer.parseInt("43113");
//
//        payload = createGetPidPayload();
//        messageID = new byte[]{55};
//        sendMessage(messageID, payload, destinationAddress, destinationPort, primarySocket);
//
//        rcvMsg = receiveMessage(primarySocket, rcv);
//        incomingRequest = KeyValueResponse.KVResponse.parseFrom(rcvMsg.getPayload().toByteArray());
//
//        System.out.println("Pid is: ");
//        System.out.println(incomingRequest.getPid());
//
//        System.out.println("Use the command: kill -STOP " + incomingRequest.getPid()+ " To suspend the java process");
//
//        System.out.println("Type enter after entering the above command into your ec2 server.");
//        line = scanner.nextLine();
//
//        System.out.println("Waiting 30 seconds");
//        TimeUnit.SECONDS.sleep(30);
//
//        System.out.println("Seeing if the data was correctly replicated in new main replica 43112");
//
//        //Get all information from successor now
//        destinationPort = Integer.parseInt("43122");
//
//        payload = createGetRequestPayload(key);
//
//        messageID = new byte[]{56};
//
//        sendMessage(messageID, payload, destinationAddress, destinationPort, primarySocket);
//
//        rcvMsg = receiveMessage(primarySocket, rcv);
//        incomingRequest = KeyValueResponse.KVResponse.parseFrom(rcvMsg.getPayload().toByteArray());
//
//        System.out.println("Value from successor");
//        System.out.println(Arrays.toString(incomingRequest.getValue().toByteArray()));

    }


    public static void resetAllServers() {
        for (String node : nodeTable) {
            wipeServer(node);
        }
        System.out.println("reset all servers");
    }

    public static void getAllPID() {
        for (String node : nodeTable) {
            try {
                KeyValueResponse.KVResponse res = sendToServer(new byte[]{0},
                        createGetPidPayload(), node, testClientSocket);
                if (errorInResponse(res)) continue;
                pidTable.put(node, res.getPid());
                System.out.println("PID of " + node + " is " + res.getPid());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void wipeServer(String server) {
        try {
            byte[] messageID = generateMessageID();
            KeyValueResponse.KVResponse res = sendToServer(messageID,
                    createWipeoutPayload(), server, testClientSocket);
            errorInResponse(res);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void singleFrontEndGet(String server) {
        try {
            for (ByteString key : testStore.keySet()) {
                byte[] messageID = generateMessageID();
                KeyValueResponse.KVResponse res = sendToServer(messageID,
                        createGetRequestPayload(key.toByteArray()), server, testClientSocket);
                if (errorInResponse(res)) continue;
                assert Arrays.equals(res.getValue().toByteArray(), testStore.get(key)) && res.getVersion() == 0;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void randomFrontEndPut() {
        try {
            for (ByteString key : testStore.keySet()) {
                String server = nodeTable.get(new Random().nextInt(nodeTable.size()));
                byte[] messageID = generateMessageID();
                KeyValueResponse.KVResponse res = sendToServer(messageID,
                        createPutRequestPayload(key.toByteArray(), testStore.get(key)), server, testClientSocket);
                if (errorInResponse(res)) continue;
                actuallyStored.put(key, testStore.get(key));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void randomFrontEndGet() {
        try {
            for (ByteString key : testStore.keySet()) {
                String server = nodeTable.get(new Random().nextInt(nodeTable.size()));
                byte[] messageID = generateMessageID();
                KeyValueResponse.KVResponse res = sendToServer(messageID,
                        createGetRequestPayload(key.toByteArray()), server, testClientSocket);
                if (errorInResponse(res)) continue;
                assert Arrays.equals(res.getValue().toByteArray(), actuallyStored.get(key)) && res.getVersion() == 0;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void singleFrontEndPut(String server) {
        try {
            for (ByteString key : testStore.keySet()) {
                byte[] messageID = generateMessageID();
                KeyValueResponse.KVResponse res = sendToServer(messageID,
                        createPutRequestPayload(key.toByteArray(), testStore.get(key)), server, testClientSocket);
                if (errorInResponse(res)) continue;
                actuallyStored.put(key, testStore.get(key));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
