package com.example.exam.dao.implement;

import com.example.exam.dao.EmployeeDAO;
import com.example.exam.entity.EmployeeEntity;
import com.example.exam.util.PersistenceUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    EntityManager en;
    EntityTransaction tran;

    public EmployeeDAOImpl() {
        en = PersistenceUtil.createEntityManagerFactory().createEntityManager();
        tran = en.getTransaction();
    }

    @Override
    public void createEmployee(EmployeeEntity employee) {
        try{
            tran.begin();
            en.persist(employee);
            tran.commit();
        }catch (Exception ex){
            System.out.print(ex.getMessage());
            tran.rollback();
        }
    }

    @Override
    public List<EmployeeEntity> getAllEmployee() {
        List<EmployeeEntity> employees = new ArrayList<>();
        try {
            Query query = en.createQuery("select e from EmployeeEntity e");
            return query.getResultList();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return employees;
    }
}
