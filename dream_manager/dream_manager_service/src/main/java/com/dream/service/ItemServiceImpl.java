package com.dream.service;

import com.dream.common.pojo.DreamResult;
import com.dream.common.pojo.EasyUiDataGridResult;
import com.dream.common.pojo.UUIDUtil;
import com.dream.mapper.TbItemDescMapper;
import com.dream.mapper.TbItemMapper;
import com.dream.pojo.TbItem;
import com.dream.pojo.TbItemDesc;
import com.dream.pojo.TbItemExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    //商品信息
   @Autowired
   private TbItemMapper tbItemMapper;
   //商品描述
   @Autowired
   private TbItemDescMapper tbItemDescMapper;
    /**
     * 根据商品id查找商品
     * @param itemId 商品id
     * @return 商品信息
     */
    @Override
    public TbItem selectByKey(long itemId) {
        return tbItemMapper.selectByPrimaryKey(itemId);
    }

    @Override
    public EasyUiDataGridResult list(Integer pageNum, Integer pageSize) {
        //MyBatis逆向工程生成的代码是咩有提供分页功能，可以使用MyBatis提供的分页插件PageHelper
        //设置分页信息,此方法下的第一个查询会进行分页
        PageHelper.startPage(pageNum,pageSize);

        TbItemExample tbItemExample = new TbItemExample();

        tbItemExample.setOrderByClause("updated desc"); //降序排列。

        // 自动添加limit ?,?  返回的对象实际上包含了很多信息 不止查询结果，还有分页需要用的的信息
        List<TbItem> tbItems = tbItemMapper.selectByExample(tbItemExample);

        //得到数据的总数 count--total
        PageInfo<TbItem> tbItemPageInfo = new PageInfo<>(tbItems);
        long total=tbItemPageInfo.getTotal();
        return new EasyUiDataGridResult(total,tbItems);
    }

    /**
     * 批量删除
     * @param ids 删除的商品id
     * @return 状态
     */
    @Override
    public DreamResult delete(Long[] ids) {
        //批量删除
        TbItemExample tbItemExample = new TbItemExample();
        TbItemExample.Criteria criteria = tbItemExample.createCriteria();
        criteria.andIdIn(Arrays.asList(ids));
        tbItemMapper.deleteByExample(tbItemExample);
        /*for (Long id : ids) {
            tbItemMapper.deleteByPrimaryKey(id);
        }*/
        return DreamResult.ok(null);
    }

    /**
     * 增加商品
     * @param tbItem 商品信息
     * @param desc 商品描述
     * @return 状态
     */
    @Override
    public DreamResult add(TbItem tbItem, String desc) {
        //生成id
        long itemId = UUIDUtil.getItemId();
        //添加id
        tbItem.setId(itemId);
        //添加状态信息
        tbItem.setStatus((byte)1);
        //添加创建时间
        tbItem.setCreated(new Date());
        //添加修改时间
        tbItem.setUpdated(tbItem.getCreated());
        //添加商品
        tbItemMapper.insertSelective(tbItem);

        //添加商品描述
        TbItemDesc tbItemDesc = new TbItemDesc();
        //添加商品id
        tbItemDesc.setItemId(itemId);
        //添加商品的描述
        tbItemDesc.setItemDesc(desc);
        //添加商品创建时间
        tbItemDesc.setCreated(tbItem.getCreated());
        //添加商品的修改时间
        tbItemDesc.setUpdated(tbItem.getUpdated());
        //添加商品描述信息
        tbItemDescMapper.insertSelective(tbItemDesc);
        return DreamResult.ok();
    }
}
