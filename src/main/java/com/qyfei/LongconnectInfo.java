package com.qyfei;


import java.util.UUID;

public class LongconnectInfo implements IRequestInfo {
        public String getAction() {
            return action;
        }

        public void setAction(String action) {
            this.action = action;
        }

        public void setTime(Long time) {
            this.time = time;
        }

        @RequestInfo(ShowName = "action", InfoType = InfoType.info, Order = 0)
        private String action;

        @RequestInfo(ShowName = "发送消息", InfoType = InfoType.info, StyleType = StyleType.json, Order = 1)
        private String sendMessage;

        @RequestInfo(ShowName = "收到消息", InfoType = InfoType.info, StyleType = StyleType.json, Order = 2)
        private String receiveMessage;

        public String getSendMessage() {
            return sendMessage;
        }

        public void setSendMessage(String sendMessage) {
            this.sendMessage = sendMessage;
        }

        public String getReceiveMessage() {
            return receiveMessage;
        }

        public void setReceiveMessage(String receiveMessage) {
            this.receiveMessage = receiveMessage;
        }


        @Override
        public String getHost() {
            return null;
        }

        @Override
        public String getClassName() {
            return "";
        }

        @Override
        public String getMethodName() {
            return "";
        }

        @Override
        public String getModule() {
            return null;
        }

        private Long time = System.currentTimeMillis();

        @Override
        public long getTime() {
            return time;
        }

        private String uuid = UUID.randomUUID().toString().replaceAll("-", "");

        public String getShow() {
            return show;
        }

        public void setShow(String show) {
            this.show = show;
        }

        @RequestInfo(ShowName = "title", InfoType = InfoType.title)
        private String show = "";

        @Override
        public String getUuid() {
            return uuid;
        }

        public void setUuid(String uuid) {
            this.uuid = uuid;
        }

        @Override
        public long getResponseTime() {
            return 0;
        }

        @Override
        public String getPath() {
            return null;
        }
    }
