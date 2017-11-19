package com.yaoyou.service;

import com.yaoyou.dao.AddressMapper;
import com.yaoyou.interfaces.controller.Result;
import com.yaoyou.model.dataObject.Address;
import com.yaoyou.model.dataObject.AddressExample;
import com.yaoyou.util.DataTransfer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by song on 16/8/23.
 */
@Service
public class AddressService extends BaseService {

    @Resource
    AddressMapper addressMapper;

    public Result addAddress(Address address) {
        Result result = new Result();
        if(address.getIsDefault().equals("1")){
            resetDefault(address.getUserId());
        }
        result.setStatus(addressMapper.insert(address));
        result.setData(address);
        return result;
    }

    public int updateAddress(Address address) {
        if(address.getIsDefault().equals("1")){
            resetDefault(address.getUserId());
        }
        return addressMapper.updateByPrimaryKey(address);
    }

    public void resetDefault(String userId){
        AddressExample addressExample = new AddressExample();
        addressExample.or().andUserIdEqualTo(userId);
        Address address = new Address();
        address.setIsDefault("0");
        addressMapper.updateByExampleSelective(address, addressExample);
    }

    public int deleteAddress(int addressId) {
        return addressMapper.deleteByPrimaryKey(addressId);
    }

    public List<Address> getAddressList(String userId) {
        AddressExample addressExample = new AddressExample();
        addressExample.or().andUserIdEqualTo(userId);
        return addressMapper.selectByExample(addressExample);
    }

    public Address getAddress(int id) {
        return addressMapper.selectByPrimaryKey(id);
    }
}
