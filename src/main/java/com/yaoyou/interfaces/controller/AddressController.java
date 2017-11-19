package com.yaoyou.interfaces.controller;

import com.yaoyou.model.dataObject.Address;
import com.yaoyou.model.dataObject.Cart;
import com.yaoyou.service.AddressService;
import com.yaoyou.util.ObjectNullCheck;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by song on 16/8/23.
 */
@Controller
@RequestMapping("/address")
public class AddressController extends BaseController {
    @Resource
    AddressService addressService;

    //TODO nonNull check 可以利用注解来实现
    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Address viewAddress(@PathVariable int id, HttpServletRequest request/*,Model model*/){
        return ObjectNullCheck.getNonNullObject(Address.class, addressService.getAddress(id));
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public Result addAddress(@RequestBody Address address, HttpServletRequest request/*,Model model*/){
        Result result = addressService.addAddress(address);
        return result;
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    @ResponseBody
    public Result updateAddress(@RequestBody Address address,HttpServletRequest request/*,Model model*/){
        int result = addressService.updateAddress(address);
        return newResult(result, "", null);
    }

    @RequestMapping(value = "", method = RequestMethod.DELETE)
    @ResponseBody
    public Result deleteAddress(@RequestBody Address address,HttpServletRequest request/*,Model model*/){
        int result = addressService.deleteAddress(address.getAddressId());
        return newResult(result, "", null);
    }

    @RequestMapping(value = "/list/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public List<Address> list(@PathVariable String userId, HttpServletRequest request/*,Model model*/){
        List<Address> addressList = addressService.getAddressList(userId);
        return addressList;
    }

    @RequestMapping(value = "/page/add", method = RequestMethod.GET)
    public String redirectAdd(){
        return "address/add";
    }
    @RequestMapping(value = "/page/edit", method = RequestMethod.GET)
    public String redirectEdit(){
        return "address/edit";
    }
    @RequestMapping(value = "/page/delete", method = RequestMethod.GET)
    public String redirectDelete(){
        return "address/delete";
    }
}
