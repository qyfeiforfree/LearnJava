package com.qyfei;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

public class testWebSocket {
public static void main(String [] args) throws URISyntaxException {
    URI uri= new URI("");
   Map hashMap= new HashMap();
   hashMap.put("","");

    TestWebSocketClient testWebSocketClient = new TestWebSocketClient(uri,hashMap);
    testWebSocketClient.connect();
    testWebSocketClient.send("");
    testWebSocketClient.getLastReceveMessage();

}

}
