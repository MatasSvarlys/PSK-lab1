package org.example.lab1.mybatis.dao;

import java.util.List;

import org.mybatis.cdi.Mapper;
import org.example.lab1.mybatis.model.Studentas;

@Mapper
public interface StudentasMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.STUDENTAS
     *
     * @mbg.generated Mon Mar 03 03:39:54 EET 2025
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.STUDENTAS
     *
     * @mbg.generated Mon Mar 03 03:39:54 EET 2025
     */
    int insert(Studentas record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.STUDENTAS
     *
     * @mbg.generated Mon Mar 03 03:39:54 EET 2025
     */
    Studentas selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.STUDENTAS
     *
     * @mbg.generated Mon Mar 03 03:39:54 EET 2025
     */
    List<Studentas> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.STUDENTAS
     *
     * @mbg.generated Mon Mar 03 03:39:54 EET 2025
     */
    int updateByPrimaryKey(Studentas record);
}