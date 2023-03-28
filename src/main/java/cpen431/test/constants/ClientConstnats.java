package cpen431.test.constants;

public class ClientConstnats {

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
}
