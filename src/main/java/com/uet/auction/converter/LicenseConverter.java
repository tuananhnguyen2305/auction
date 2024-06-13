package com.uet.auction.converter;

import com.uet.auction.dto.LicenseDTO;
import com.uet.auction.entity.License;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LicenseConverter {
    @Autowired
    UserConverter userConverter;

    @Autowired
    ProvinceConverter provinceConverter;
    public License toEntity(LicenseDTO licenseDTO) {
        License license = new License();
        if (licenseDTO.getId() != 0) {
            license.setId(licenseDTO.getId());
        }
        license.setLicenseId(licenseDTO.getLicenseId());
        license.setUser(userConverter.toEntity(licenseDTO.getUserDTO()));
        license.setProvince(provinceConverter.toEntity(licenseDTO.getProvinceDTO()));
        return license;
    }

    public LicenseDTO toDTO(License license) {
        LicenseDTO licenseDTO = new LicenseDTO();
        licenseDTO.setId(license.getId());
        licenseDTO.setLicenseId(licenseDTO.getLicenseId());
        licenseDTO.setUserDTO(userConverter.toDTO(license.getUser()));
        licenseDTO.setProvinceDTO(provinceConverter.toDTO(license.getProvince()));

        return licenseDTO;
    }
}
