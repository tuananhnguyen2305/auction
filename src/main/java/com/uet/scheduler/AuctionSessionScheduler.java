package com.uet.scheduler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.uet.dto.AuctionSessionDTO;
import com.uet.service.IAuctionSessionService;

@Component
public class AuctionSessionScheduler {

	@Autowired
    private IAuctionSessionService auctionService;

    @Scheduled(fixedRate = 6000) // Lên lịch kiểm tra mỗi phút
    public void checkAuctionStatus() {
        List<AuctionSessionDTO> auctions = auctionService.findAll();
        for (AuctionSessionDTO auction : auctions) {
            if (auctionService.isAuctionFinished(auction)) {
                // Xử lý khi phiên đấu giá đã kết thúc
                // Ví dụ: Cập nhật trạng thái của phiên đấu giá, gửi thông báo, v.v.
                auctionService.finishAuction(auction);
            }
        }
    }
    
    
}