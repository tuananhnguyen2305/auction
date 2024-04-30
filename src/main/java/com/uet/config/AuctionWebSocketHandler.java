package com.uet.config;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class AuctionWebSocketHandler extends TextWebSocketHandler {

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        // Xử lý thông điệp từ máy khách
        String payload = message.getPayload();
        // Xử lý và gửi cập nhật trạng thái phiên đấu giá
        session.sendMessage(new TextMessage("Auction status update: " + payload));
    }
}