package com.uet.auction.serivce;

import com.uet.auction.dto.LicenseDTO;
import com.uet.auction.entity.License;

import java.util.Set;

public interface ILicenseService {
    Set<License> getAllLicenses();
    boolean createLicense(String licenseId, int provinceId, int transportId, int userId);
    LicenseDTO getLicenceById(String id);
}
