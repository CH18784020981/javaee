package club.banyuan.bmDemo.service;

import club.banyuan.bmDemo.bean.Bills;
import club.banyuan.bmDemo.bean.Supplier;
import club.banyuan.bmDemo.bean.Users;


import java.util.List;

/**
 * TODO
 *
 * @author HYB
 * @since 2019/12/4 1:23 下午
 **/
public interface UserService {

    /**
     * @param
     * @return 返回对象中包含数据库的自增ID
     */

    /**
     * 查询所有用户信息
     *
     * @return
     */
    List<Users> findAll();

    /**
     * 保存User
     *
     * @param user
     */
    void addUser(Users user);

    /**
     * 根据id删除User
     *
     * @param id
     */
    void deleteUser(String id);


    //////////////

    List<Supplier> findAllSup();


    void addSup(Supplier supplier);


    void deleteSup(String id);


    List<Bills> findAllBill();


    void addBill(Bills bill);


    void deleteBill(String id);

}
