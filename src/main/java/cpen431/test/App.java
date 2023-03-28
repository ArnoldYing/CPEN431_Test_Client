package cpen431.test;

import com.google.protobuf.ByteString;
import cpen431.test.protobuf.KeyValueResponse;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static cpen431.test.Helpers.*;
import static cpen431.test.constants.ClientConstants.*;

/**
 * Test client for CPEN 431 G5 project
 *
 */
public class App
{

    public static List<String> nodeTable = new ArrayList<>();
    public static HashMap<String, Integer> pidTable = new HashMap<>();
    public static HashMap<ByteString, byte[]> testStore = new HashMap<>();
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
        generateTestData(10000, testStore);

        getAllPID();
        resetAllServers();

        singleFrontEndPut(nodeTable.get(0));
        System.out.println("Finished putting to " + nodeTable.get(0));
    }


    public static void getAllPID() {
        for (String node : nodeTable) {
            try {
                sendMessage(new byte[]{0},
                        createGetPidPayload(), node, testClientSocket);
                KeyValueResponse.KVResponse res = waitForResponse(new byte[]{0}, testClientSocket);
                if (res == null || res.getErrCode() != 0) {
                    System.out.println("Error in getPID");
                    continue;
                }
                pidTable.put(node, res.getPid());
                System.out.println("PID of " + node + " is " + res.getPid());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void resetAllServers() {
        for (String node : nodeTable) {
            wipeServer(node);
        }
        System.out.println("reset all servers");
    }

    public static void wipeServer(String server) {
        try {
            byte[] messageID = generateMessageID();
            sendMessage(messageID,
                    createWipeoutPayload(), server, testClientSocket);
            KeyValueResponse.KVResponse res = waitForResponse(messageID, testClientSocket);
            if (res == null || res.getErrCode() != 0) {
                System.out.println("Error in wipeout");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void singleFrontEndPut(String server) {
        try {
            for (ByteString key : testStore.keySet()) {
                byte[] messageID = generateMessageID();
                sendMessage(messageID,
                        createPutPayload(key.toByteArray(), testStore.get(key)), server, testClientSocket);
                KeyValueResponse.KVResponse res = waitForResponse(messageID, testClientSocket);
                if (res == null || res.getErrCode() != 0) {
                    System.out.println("Error in put");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
