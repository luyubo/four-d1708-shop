package com.four.d1780.shop.cartAndOrderServer.service.impl;

import com.four.d1708.shop.entityinterface.entity.ShopCart;
import com.four.d1708.shop.entityinterface.entity.ShopCartdetail;
import com.four.d1708.shop.entityinterface.entity.ShopSku;
import com.four.d1780.shop.cartAndOrderServer.entity.ShopAddrVo;
import com.four.d1780.shop.cartAndOrderServer.entity.ShopCartVo;
import com.four.d1780.shop.cartAndOrderServer.entity.ShopSkuVo;
import com.four.d1780.shop.cartAndOrderServer.mapper.ShopCartMapper;
import com.four.d1780.shop.cartAndOrderServer.mapper.ShopCartdetailMapper;
import com.four.d1780.shop.cartAndOrderServer.mapper.ShopSkuMapper;
import com.four.d1780.shop.cartAndOrderServer.service.IAddrService;
import com.four.d1780.shop.cartAndOrderServer.service.ShopCartService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wh
 * @since 2020-05-21
 */
@Service
public class ShopCartServiceImpl extends ServiceImpl<ShopCartMapper, ShopCart> implements ShopCartService {


    @Autowired
    ShopCartMapper shopCartMapper;

    @Autowired
    private ShopSkuMapper shopSkuMapper;

    @Autowired
    private IAddrService iAddrService;

    @Autowired
    ShopCartdetailMapper shopCartdetailMapper;
    /**
     * ##### 首次添加购物车
     *
     * ​		a)添加购物车
     *
     *    	    b)添加购物车商品详情     更新购物车 中的  购买商品数量   购买总金额
     *
     * ##### 再次添加购物车 查找用户uid
     *
     *  	    a)添加购物车商品详情     更新购物车 中的  购买商品数量   购买总金额 修改时间
     * @param uid
     * @param skuid
     * @return
     */
    @Transactional
    @Override
    public int addCart(Integer uid, Integer skuid) {
        ShopCart sc = shopCartMapper.selectByUid(uid);
        ShopCart shopCart = null;
        Integer cartId = 0 ;
        if(sc!=null){
            cartId=sc.getId();
        }else{
            shopCart=new ShopCart();
            shopCart.setUid(uid+"");
            shopCart.setCreatetime(new Date());
            //添加购物车
            shopCartMapper.insert(shopCart);
            //获取购物车主键id
            cartId = shopCart.getId();
        }
        ShopCartdetail shopCartdetail = shopCartdetailMapper.fandBySkuId(cartId,skuid);
        if(shopCartdetail!=null){
            int i = shopCartMapper.updateByCartIdAndSkuId(cartId,skuid);
        }else{
            //  查找商品
            ShopSku shopSku = shopSkuMapper.fandBySkuId(skuid);
            System.err.println(shopSku);
            //添加购物车详情
            ShopCartdetail cartdetail = new ShopCartdetail();
            cartdetail.setCartId(cartId);
            cartdetail.setSkuid(skuid);
            cartdetail.setTitle(shopSku.getTitle());
            cartdetail.setSell_point(shopSku.getSell_point());
            cartdetail.setPrice(shopSku.getPrice());
            cartdetail.setStock_count(shopSku.getStock_count());
            cartdetail.setImage(shopSku.getImage());
            cartdetail.setState(Integer.parseInt(shopSku.getStatus()));
            cartdetail.setCreate_time(new Date());
            cartdetail.setSpu_id(shopSku.getSpu_id());
            cartdetail.setAmount(1);//添加购物车商品数量为1
            shopCartdetailMapper.insert(cartdetail);  //
        }
        //查找订单数量和总金额
        ShopCart shopCart1 = shopCartMapper.findPnumAndSumTotalByCaridAndSkuId(cartId,skuid);
        System.err.println(shopCart1);
        ShopCart cart = null;
        if(shopCart!=null){
            cart=shopCart;
        }else{
            cart=sc;
        }
        cart.setPnum(shopCart1.getPnum());
        cart.setSum_total(shopCart1.getSum_total());
        cart.setUpdatetime(new Date());
        shopCartMapper.updateById(cart);
        //修改购物车购买数量(购物车列表  功能  )
//        shopCartMapper.updateBySkuId();

        return 1;
    }

    @Transactional
    @Override
    public int modifiedAmountBySkidAndUid(Integer skid, Integer uid,Integer amount,Integer cartId) {
        //这里不要用uid查
        //ShopCart sc = shopCartMapper.selectByUid(uid);
        ShopCartVo sc = shopCartMapper.selectByCartId(cartId);

        int i = shopCartdetailMapper.modifiedAmountBySkidAndUid(skid,sc.getId(),amount);
        //查找订单数量和总金额
        ShopCart shopCart1 = shopCartMapper.findPnumAndSumTotalByCaridAndSkuId(sc.getId(),skid);
        sc.setPnum(shopCart1.getPnum());
        sc.setSum_total(shopCart1.getSum_total());
        sc.setUpdatetime(new Date());
        shopCartMapper.updateById(sc);
        return i;
    }

    @Override
    public boolean addCartAndDetail(ShopCart shopCart) {
        shopCart.setCreatetime(new Date());
        shopCart.setUpdatetime(new Date());
        ShopSkuVo shopSku = shopSkuMapper.selectSkuById(shopCart.getSkuid());
        int insert = shopCartMapper.insert(shopCart);
        if(insert>0){
            ShopCartdetail shopCartdetail=new ShopCartdetail();
            shopCartdetail.setCartId(shopCart.getId());
            shopCartdetail.setSkuid(shopSku.getId());
            shopCartdetail.setTitle(shopSku.getTitle());
            shopCartdetail.setSell_point("最新添加到购物车的sku信息");
            shopCartdetail.setPrice(shopCart.getSum_total());
            shopCartdetail.setStock_count(Integer.parseInt(shopCart.getPnum().toString()));
            shopCartdetail.setImage(shopSku.getImage());
            shopCartdetail.setState(1);
            shopCartdetail.setCreate_time(new Date());
            shopCartdetail.setUpdate_time(new Date());
            shopCartdetail.setSpu_id(shopSku.getSpu_id());
            shopCartdetail.setAmount(Integer.parseInt(shopCart.getPnum().toString()));
            List<ShopAddrVo> shopAddrVoList=iAddrService.findByUid(shopCart.getUid());
            for (ShopAddrVo shopAddrVo : shopAddrVoList) {
                if(shopAddrVo.getState()==1){
                    shopCartdetail.setAddrId(shopAddrVo.getId());
                }
            }
            shopCartdetailMapper.insert(shopCartdetail);
        }
        return true;
    }

    //查找购物车列表
    @Override
    public List<ShopCartVo> findAllByUid(Integer uid) {
        return shopCartMapper.findAllByUid(uid);
    }

    //删除购物车的某件商品
    @Override
    public int deleteById(Integer skid,Integer uid) {
        //查找购物车对象
        ShopCart shopCart = shopCartMapper.findByUid(uid);
        List<ShopCartdetail> shopCartdetailList = shopCartdetailMapper.findAllByCartId(shopCart.getId());
        for (ShopCartdetail scd : shopCartdetailList ) {
            if(scd.getSkuid()==skid){
                //        删除购物车商品
                shopCartdetailMapper.deleteById2(shopCart.getId(),skid);
                break;
            }
        }
        //查找订单数量和总金额
        ShopCart shopCart1 = shopCartMapper.findPnumAndSumTotalByCaridAndSkuId(shopCart.getId(),skid);
        shopCart.setPnum(shopCart1.getPnum());
        shopCart.setSum_total(shopCart1.getSum_total());
        shopCart.setUpdatetime(new Date());
        //修改操作
        shopCartMapper.updateById(shopCart);

        return 1;
    }

    //删除购物车  先查再删
    @Override
    public int deleteByUid(Integer uid) {
        //查找购物车对象
        ShopCart shopCart = shopCartMapper.findByUid(uid);
        List<ShopCartdetail> shopCartdetailList = shopCartdetailMapper.findAllByUid(shopCart.getId());
        for (ShopCartdetail sc:shopCartdetailList ) {
            shopCartdetailMapper.deleteById(sc.getId());
        }
        shopCartMapper.deleteById(shopCart.getId());
        return 1;
    }

    /**
     * 根据uid生成订单
     * @param uid
     * @return
     */
    @Override
    public int generateOrder(Integer uid) {
        return 0;
    }


}
