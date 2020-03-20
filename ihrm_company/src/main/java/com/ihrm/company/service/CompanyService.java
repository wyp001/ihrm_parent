package com.ihrm.company.service;

import com.ihrm.common.utils.IdWorker;
import com.ihrm.company.dao.CompanyDao;
import com.ihrm.domain.company.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    @Autowired
    private CompanyDao companyDao;
    @Autowired
    private IdWorker idWorker;




    /**
     * 保存企业
     *      1.配置idwork到当前工程
     *      2.在service中注入idwork
     *      3.通过idwork生成id
     *      4.保存企业
     */
    public void add(Company company){
        String id = idWorker.nextId() + "";
        company.setId(id);
        company.setAuditState("0"); //0: 未审核    1：已审核
        company.setState(1); //0:未激活    1：已激活
        companyDao.save(company);
    }


    /**
     * 更新企业
     */
    public void  update(Company company){
        Company tmp = companyDao.findById(company.getId()).get();
        tmp.setName(company.getName());
        tmp.setCompanyPhone(company.getCompanyPhone());
        companyDao.save(tmp);//jpa中的save方法：jpa内部会先根据传的对象的id查询有没有该记录，如果没有save表示新增，如果有记录则执行更新
    }

    /**
     * 删除企业
     */
    public void deleteById(String id){
        companyDao.deleteById(id);
    }

    /**
     * 根据id企业
     */
    public Company findById(String id){
        return companyDao.findById(id).get();
    }

    /**
     * 查询企业列表
     */
    public List<Company> findAll(){
        return companyDao.findAll();
    }



}
