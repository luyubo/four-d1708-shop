package com.four.d1780.shop.cartAndOrderServer.service.impl;

import com.four.d1708.shop.entityinterface.entity.*;
import com.four.d1780.shop.cartAndOrderServer.entity.*;
import com.four.d1780.shop.cartAndOrderServer.mapper.*;
import com.four.d1780.shop.cartAndOrderServer.service.IShop_payService;
import com.four.d1780.shop.cartAndOrderServer.service.ShopOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ShopOrderServiceImpl implements ShopOrderService {

    @Autowired
    ShopOrderMapper shopOrderMapper;

    @Autowired
    ShopCartMapper shopCartMapper;

    @Autowired
    ShopCartdetailMapper shopCartdetailMapper;

    @Autowired
    ShopAreaMapper shopAreaMapper;

    @Autowired
    ShopOrderdetaieMapper shopOrderdetaieMapper;

    @Autowired
    AddrMapper addrMapper;

    @Autowired
    private Shop_payMapper shop_payMapper;

    @Autowired
    private ShopSkuMapper shopSkuMapper;

    @Override
    public List<ShopOrderVo> findAll(Integer uid) {
        return shopOrderMapper.findAll(uid);
    }

    @Override
    public int generateOrder(Integer uid,String cids) {
        ShopAddr addr = shopAreaMapper.findByUidAndState(uid);
        List<ShopCartDetailVo> shopCartDetailVoList=new ArrayList<>();
        String[] split = cids.split(",");
        for (String s : split) {
            System.out.println(s+"+++++++++++++++++++++");
            ShopCartDetailVo shopCartdetailvo = shopCartdetailMapper.selectVoById(Integer.parseInt(s));
            System.out.println(shopCartdetailvo.getImage()+"----------------------");
            shopCartDetailVoList.add(shopCartdetailvo);
        }
        //查找购物车对象
        //ShopCart shopCart = shopCartMapper.findByUid(uid);
        ShopOrder shopOrder = new ShopOrder();
        shopOrder.setUid(uid);


        //根据uid查询所有与uid有关的地址
        List<ShopAddrVo> byUid = addrMapper.getByUid(uid);
        ShopAddrVo addrVo=new ShopAddrVo();


        for (ShopAddrVo shopAddrVo : byUid) {
            if(shopAddrVo.getState()==1){
                addrVo=shopAddrVo;
            }
        }

        Integer oid = shopOrder.getOid();
        ShopCartdetail shopCartdetail=new ShopCartdetail();
        //shopCartdetailMapper.findAllByUid(shopCart.getId());
        for (ShopCartDetailVo sc:shopCartDetailVoList ) {
            System.out.println(sc+"===============");
            shopOrder.setCreatetime(new Date());
            //BigDecimal pnum1 = new BigDecimal(String.valueOf(shopCart.getPnum()));
            shopOrder.setPnum(sc.getAmount());
            shopOrder.setSum(sc.getPrice());
            shopOrder.setState(0);
            shopOrder.setAddress(addrVo.getAddress());
            shopOrder.setSkuid(sc.getSkuid());
            shopOrder.setSum(sc.getPrice());
            shopOrderMapper.insert(shopOrder);


            ShopOrderdetail shopOrderdetail = new ShopOrderdetail();
            shopOrderdetail.setOrder_id(shopOrder.getOid());
            shopOrderdetail.setSku_id(sc.getSkuid());
            shopOrderdetail.setTitle(sc.getTitle());
            shopOrderdetail.setPrice(sc.getPrice());
            shopOrderdetail.setStock_count(sc.getStock_count());
            shopOrderdetail.setImage(sc.getImage());
            shopOrderdetail.setState(1);
            shopOrderdetail.setCreate_time(new Date());
            shopOrderdetail.setUpdate_time(new Date());
            shopOrderdetail.setSpu_id(sc.getSpu_id());
            shopOrderdetail.setAmount(sc.getAmount());
            shopOrderdetail.setAddr_id(addrVo.getId());

            ShopPayVo byUid1 = shop_payMapper.findByUid(uid);
            ShopPay shopPay = shop_payMapper.selectById(byUid1.getId());
            shopPay.setMoney(shopPay.getMoney().subtract(sc.getPrice()));

            shop_payMapper.updateById(shopPay);
            shopOrderdetaieMapper.insert(shopOrderdetail);
            shopCartdetailMapper.updateCartDetail(sc.getId(),2);
        }

        return 0;
    }

    @Override
    public boolean saveOrder(ShopOrder shopOrder) {
        List<ShopAddrVo> byUid1 = addrMapper.findByUid(shopOrder.getUid().toString());
        ShopAddrVo shopAddrVo=new ShopAddrVo();
        for (ShopAddrVo addrVo : byUid1) {
            System.out.println(addrVo.getAddress()+"");
            if(addrVo.getState()==1){
                shopAddrVo=addrVo;
            }
        }
        ShopSkuVo shopSkuVo = shopSkuMapper.selectSkuBySkuId(shopOrder.getSkuid());

        shopOrder.setAddress(shopAddrVo.getAddress());
        shopOrder.setCreatetime(new Date());
        int insert = shopOrderMapper.insert(shopOrder);
        ShopSku shopSku = shopSkuMapper.selectById(shopOrder.getSkuid());
        if(insert>0){
            ShopOrderdetail shopOrderdetail=new ShopOrderdetail();
            shopOrderdetail.setOrder_id(shopOrder.getOid());
            shopOrderdetail.setSku_id(shopOrder.getSkuid());
            shopOrderdetail.setTitle(shopSku.getTitle());
            shopOrderdetail.setSell_point(null);
            shopOrderdetail.setPrice(shopOrder.getSum());
            shopOrderdetail.setStock_count(shopOrder.getPnum());
            shopOrderdetail.setImage(shopSku.getImage());
            shopOrderdetail.setState(1);
            shopOrderdetail.setCreate_time(new Date());
            shopOrderdetail.setUpdate_time(new Date());
            shopOrderdetail.setSpu_id(shopSkuVo.getSpu_id());
            shopOrderdetail.setAmount(shopOrder.getPnum());
            shopOrderdetail.setAddr_id(shopAddrVo.getId());
            int insert1 = shopOrderdetaieMapper.insert(shopOrderdetail);
            if(insert1>0){
                ShopPayVo byUid = shop_payMapper.findByUid(shopOrder.getUid());
                ShopPay shopPay = byUid.setMoney(byUid.getMoney().subtract(shopOrderdetail.getPrice()));
                shop_payMapper.updateById(shopPay);
                return true;
            }
        }
        return false;
    }
}
