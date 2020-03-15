package com.dream.mapper;

import com.dream.pojo.TbUser;
import com.dream.pojo.TbUserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbUserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_user
     *
     * @mbg.generated Mon Mar 09 21:57:07 CST 2020
     */
    long countByExample(TbUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_user
     *
     * @mbg.generated Mon Mar 09 21:57:07 CST 2020
     */
    int deleteByExample(TbUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_user
     *
     * @mbg.generated Mon Mar 09 21:57:07 CST 2020
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_user
     *
     * @mbg.generated Mon Mar 09 21:57:07 CST 2020
     */
    int insert(TbUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_user
     *
     * @mbg.generated Mon Mar 09 21:57:07 CST 2020
     */
    int insertSelective(TbUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_user
     *
     * @mbg.generated Mon Mar 09 21:57:07 CST 2020
     */
    List<TbUser> selectByExample(TbUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_user
     *
     * @mbg.generated Mon Mar 09 21:57:07 CST 2020
     */
    TbUser selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_user
     *
     * @mbg.generated Mon Mar 09 21:57:07 CST 2020
     */
    int updateByExampleSelective(@Param("record") TbUser record, @Param("example") TbUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_user
     *
     * @mbg.generated Mon Mar 09 21:57:07 CST 2020
     */
    int updateByExample(@Param("record") TbUser record, @Param("example") TbUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_user
     *
     * @mbg.generated Mon Mar 09 21:57:07 CST 2020
     */
    int updateByPrimaryKeySelective(TbUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_user
     *
     * @mbg.generated Mon Mar 09 21:57:07 CST 2020
     */
    int updateByPrimaryKey(TbUser record);
}