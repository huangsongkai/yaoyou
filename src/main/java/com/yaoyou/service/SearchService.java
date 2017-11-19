package com.yaoyou.service;

import com.yaoyou.model.dataObject.MedicineInfo;
import com.yaoyou.model.dataObject.ShopInfo;
import com.yaoyou.model.dto.SearchDTO;
import com.yaoyou.model.dto.ShopActivityDTO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by song on 16/8/12.
 */
@Service
public class SearchService {
    @Resource
    MedicineInfoService medicineInfoService;
    @Resource
    ShopInfoService shopInfoService;
    public List<SearchDTO> searchShopMergeMedicine(String keyword, int pageNum) {
        List<ShopInfo> shopInfoList = shopInfoService.getShopsByName(keyword, pageNum);
        List<ShopActivityDTO> shopActivityDTOList = shopInfoService.shopActivityDTOListWrap(shopInfoList);
        List<MedicineInfo> medicineInfoList = medicineInfoService.getMedicineByName(keyword, pageNum);
        List<SearchDTO> searchDTOList = new ArrayList<SearchDTO>();
        for(MedicineInfo medicineInfo : medicineInfoList){
            searchDTOList.add(toSearchDTO(medicineInfo));
        }
        for(ShopActivityDTO shopActivityDTO : shopActivityDTOList){
            searchDTOList.add(toSearchDTO(shopActivityDTO));
        }
        return searchDTOList;
    }

    public List<SearchDTO> searchShopMergeMedicine(int pageNum) {
        List<ShopInfo> shopInfoList = shopInfoService.getShopsByPageNum(pageNum);
        List<MedicineInfo> medicineInfoList = medicineInfoService.getMedicineByPageNum(pageNum);
        List<SearchDTO> searchDTOList = new ArrayList<SearchDTO>();
        for(MedicineInfo medicineInfo : medicineInfoList){
            searchDTOList.add(toSearchDTO(medicineInfo));
        }
        for(ShopInfo shopInfo : shopInfoList){
            searchDTOList.add(toSearchDTO(shopInfo));
        }
        return searchDTOList;
    }

    private SearchDTO toSearchDTO(MedicineInfo medicineInfo){
        SearchDTO searchDTO = new SearchDTO();
        searchDTO.setType(SearchDTO.TYPE_MEDICINE);
        searchDTO.setId(medicineInfo.getMedicineId());
        searchDTO.setName(medicineInfo.getBrandName()+"("+medicineInfo.getCadn()+")");
        searchDTO.setImgUrl(medicineInfo.getImgUrl());
        searchDTO.setAddress("");
        searchDTO.setAvgRate(medicineInfo.getAvgRate().toString());
        //searchDTO.setDescription(medicineInfo.getMedicineFuction());
        return searchDTO;
    }

    private SearchDTO toSearchDTO(ShopInfo shopInfo){
        SearchDTO searchDTO = new SearchDTO();
        searchDTO.setType(SearchDTO.TYPE_SHOP);
        searchDTO.setId(shopInfo.getShopInfoId());
        searchDTO.setName(shopInfo.getShopName());
        searchDTO.setImgUrl(shopInfo.getImgUrl());
        searchDTO.setAvgRate(shopInfo.getAvgRate().toEngineeringString());
        searchDTO.setDescription("");
        searchDTO.setAddress(shopInfo.getShopAddress());
        return searchDTO;
    }

    private SearchDTO toSearchDTO(ShopActivityDTO shopActivityDTO){
        SearchDTO searchDTO = new SearchDTO();
        searchDTO.setType(SearchDTO.TYPE_SHOP);
        searchDTO.setId(shopActivityDTO.getShopInfoId());
        searchDTO.setName(shopActivityDTO.getShopName());
        searchDTO.setImgUrl(shopActivityDTO.getImgUrl());
        searchDTO.setAvgRate(shopActivityDTO.getAvgRate().toEngineeringString());
        searchDTO.setDescription("");
        searchDTO.setAddress(shopActivityDTO.getShopAddress());
        searchDTO.setActivityId(shopActivityDTO.getActivityId());
        return searchDTO;
    }

    public int calcTotalPage(String keyword) {
        int medicinePage = medicineInfoService.getTotalPageByName(keyword);
        int shopPage = shopInfoService.getTotalPageByName(keyword);
        return medicinePage > shopPage ? medicinePage : shopPage;
    }

    public int calcTotalPage() {
        int medicinePage = medicineInfoService.getTotalPage();
        int shopPage = shopInfoService.getTotalPage();
        return medicinePage > shopPage ? medicinePage : shopPage;
    }
}
