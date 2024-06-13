package com.uet.auction.serivce.impl;

import com.uet.auction.entity.Transport;
import com.uet.auction.repository.ITransportRepository;
import com.uet.auction.serivce.ITransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransportService implements ITransportService {
    @Autowired
    ITransportRepository transportRepository;


    @Override
    public Transport getTransportTypeById(int id) {
        Optional<Transport> transport = transportRepository.findById(id);
        return transport.get();
    }
}
