package com.ihrm.company.dao;

import com.ihrm.domain.company.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 1.需要继承JpaRepository<T,ID>
 *     T  为要操作的实体类的类型
 *     ID当前实体类主键的类型
 *  2.需要实现JpaSpecificationExecutor<T>接口
 *      T  为要操作的实体类的类型
 */
public interface CompanyDao extends JpaRepository<Company,String>,JpaSpecificationExecutor<Company> {



}
