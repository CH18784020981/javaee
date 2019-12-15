package club.banyuan.bmDemo.dao;

import club.banyuan.bmDemo.bean.Bills;
import club.banyuan.bmDemo.bean.Supplier;
import club.banyuan.bmDemo.bean.Users;


import java.util.List;

/**
 * TODO
 *
 * @author HYB
 * @since 2019/12/4 1:35 下午
 **/
public interface UserDao {

//    Users addUser(Users userEntity);
//
//    Users updateUser(Users userEntity);
//
//    boolean deleteUser(Users userEntity);


    public List<Users> findAll();
    void add(Users user);

    void delete(int id);

    List<Supplier> findAllSup();


    void addSup(Supplier supplier);


    void deleteSup(int id);


    List<Bills> findAllBill();


    void addBill(Bills bill);


    void deleteBill(int id);
}

