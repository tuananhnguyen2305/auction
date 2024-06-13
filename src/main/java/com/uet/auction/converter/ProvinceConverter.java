package com.uet.auction.converter;

import com.uet.auction.dto.ProvinceDTO;
import com.uet.auction.entity.Province;
import org.springframework.stereotype.Component;

@Component
public class ProvinceConverter {
    public Province toEntity(ProvinceDTO provinceDTO) {
        Province province = new Province();
        province.setId(provinceDTO.getId());
        province.setProvinceName(provinceDTO.getProvinceName());
        return province;
    }

    public ProvinceDTO toDTO(Province province) {
        ProvinceDTO provinceDTO = new ProvinceDTO();
        provinceDTO.setId(province.getId());
        provinceDTO.setProvinceName(province.getProvinceName());
        return provinceDTO;
    }
}
