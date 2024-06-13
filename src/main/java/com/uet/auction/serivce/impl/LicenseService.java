package com.uet.auction.serivce.impl;

import com.uet.auction.converter.LicenseConverter;
import com.uet.auction.dto.LicenseDTO;
import com.uet.auction.entity.License;
import com.uet.auction.entity.Province;
import com.uet.auction.entity.Transport;
import com.uet.auction.entity.User;
import com.uet.auction.repository.ILicenseRepository;
import com.uet.auction.serivce.ILicenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class LicenseService implements ILicenseService {
    @Autowired
    ILicenseRepository licenseRepository;

    @Autowired
    LicenseConverter licenseConverter;

    @Override
    public Set<License> getAllLicenses() {
        return new HashSet<>(licenseRepository.findAll());
    }

    @Override
    public boolean createLicense(String licenseId, int provinceId, int transportId, int userId) {
        boolean isSuccess = false;

        Province province = new Province();
        province.setId(provinceId);

        Transport transport = new Transport();
        transport.setId(transportId);

        User user = new User();
        user.setId(userId);
        try {
            License license = new License();
            license.setLicenseId(licenseId);
            license.setUser(user);
            license.setProvince(province);
            license.setTransport(transport);

            licenseRepository.save(license);

            isSuccess = true;
        } catch (Exception e) {
            System.out.println("Error in creating license: " + e.getMessage());
        }
        return isSuccess;
    }

    @Override
    public LicenseDTO getLicenceById(String id) {
        License license = licenseRepository.findByLicenseId(id);

        return licenseConverter.toDTO(license);
    }

}
