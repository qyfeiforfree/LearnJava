package com.qyfei;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.enums.ReadyState;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

public class TestWebSocketClient extends WebSocketClient {
    private String clientId = UUID.randomUUID().toString().replace("-", "");
    protected List<String> messageList = new ArrayList<>();
    protected List<String> receveMessageList = new ArrayList<>();
    protected List<String> sendMessageList = new ArrayList<>();
    protected LinkedBlockingDeque<String> receveQue = new LinkedBlockingDeque<>();
    private String user = "";
    private String uuid = "";
    public TestWebSocketClient(URI serverUri, Map<String, String> httpHeaders) {
        super(serverUri, httpHeaders);
    }

    public TestWebSocketClient(URI serverUri, Map<String, String> httpHeaders, String user) {
        super(serverUri, httpHeaders);
        this.user = user;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
    public void connect() {
        super.connect();
        try {
            Thread.sleep(100);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println(user + "建立连接......");
        while (!this.getReadyState().equals(ReadyState.OPEN)) {
            try {
                Thread.sleep(100);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            System.out.println(this.getReadyState());
            if (this.getReadyState().equals(ReadyState.CLOSED)) {
                return;
            }
        }
    }


    public String getLastMessage() {
        if (messageList != null && messageList.size() > 0) {
            return messageList.get(messageList.size() - 1);
        } else {
            return null;
        }

    }

    public String getLastReceveMessage() {
        if (receveMessageList != null && receveMessageList.size() > 0) {
            return receveMessageList.get(receveMessageList.size() - 1);
        } else {
            return null;
        }

    }

    public String getLastSendMessage() {
        if (sendMessageList != null && sendMessageList.size() > 0) {
            return sendMessageList.get(sendMessageList.size() - 1);
        } else {
            return null;
        }

    }

    public Object OnSendMessage(String s) {
        return null;
    }

    public Object OnReveiceMessage(String s) {
        return null;
    }

    public void send(Object text) {
        super.send(text + "");
        messageList.add(text + "");
        sendMessageList.add(text + "");
        Object action = OnSendMessage(text + "");
        System.out.println(user + "发送消息->" + text);
        LongconnectInfo lci = new LongconnectInfo();
        lci.setUuid(uuid);
        lci.setAction(action+"");
        lci.setSendMessage(text + "");
        lci.setShow(action + "->");
        System.out.println(lci.toString());
    }

    @Override
    public void onOpen(ServerHandshake serverHandshake) {
        System.out.println(user + "握手...");
        for (Iterator<String> it = serverHandshake.iterateHttpFields(); it.hasNext(); ) {
            String key = it.next();
            System.out.println(key + ":" + serverHandshake.getFieldValue(key));
        }
    }

    @Override
    public void onMessage(String s) {
        System.out.println(user + "接收到消息<-" + s);
        messageList.add(s);
        receveMessageList.add(s);
        receveQue.push(s);
        Object action = OnReveiceMessage(s);
        LongconnectInfo lci = new LongconnectInfo();
        lci.setReceiveMessage(s);
        lci.setUuid(uuid);
        lci.setAction(action+"");
        lci.setShow("<-" + action);

        System.out.println(lci.toString());
    }

    @Override
    public void onClose(int i, String s, boolean b) {
        System.out.println(user + "关闭...");
    }

    @Override
    public void onError(Exception e) {
        System.out.println(user + "异常" + e);
    }

}
