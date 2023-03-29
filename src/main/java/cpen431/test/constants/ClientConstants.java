package cpen431.test.constants;

import java.util.HashMap;

public class ClientConstants {

    public static final int RETRY_COUNT = 5;
    public static final String FILEPATH = "C:\\Users\\Arnold\\Desktop\\Yikes\\2022W\\CPEN431\\cpen431_2023_project_g5\\servers.txt";
    public static final int MAX_KEY_BYTE_SIZE = 32;
    public static final int MAX_VAL_BYTE_SIZE = 10000;
    public static final int TEST_PORT = 420;


    /**
     * REQUEST IDs
     */
    public static final int PUT_REQUEST = 0x01;
    public static final int GET_REQUEST = 0x02;
    public static final int REMOVE_REQUEST = 0x03;
    public static final int SHUTDOWN_REQUEST = 0x04;
    public static final int WIPEOUT_REQUEST = 0x05;
    public static final int IS_ALIVE = 0x06;
    public static final int GET_PID = 0x07;
    public static final int GET_MEMBERSHIP_COUNT = 0x08;

    /**
     * ERROR codes
     */
    public static final int OPERATION_SUCCESSFUL = 0x00;
    public static final int NON_EXISTENT_KEY = 0x01;
    public static final int OUT_OF_SPACE = 0x02;
    public static final int TEMPORARY_SYSTEM_OVERLOAD = 0x03;
    public static final int INTERNAL_KVSTORE_FAILURE = 0x04;
    public static final int UNRECOGNIZED_COMMAND = 0x05;
    public static final int INVALID_KEY_LENGTH = 0x06;
    public static final int INVALID_VALUE_LENGTH = 0x07;

    public static final HashMap<Integer, String> ERROR_CODE_MAPPING = new HashMap<>();

    static {
        ERROR_CODE_MAPPING.put(0x00, "Success");
        ERROR_CODE_MAPPING.put(0x01, "Non-existent key");
        ERROR_CODE_MAPPING.put(0x02, "Out of space");
        ERROR_CODE_MAPPING.put(0x03, "Temporary system overload");
        ERROR_CODE_MAPPING.put(0x04, "Internal KVStore failure");
        ERROR_CODE_MAPPING.put(0x05, "Unrecognized command");
        ERROR_CODE_MAPPING.put(0x06, "Invalid key length");
        ERROR_CODE_MAPPING.put(0x07, "Invalid value length");
    }
}
