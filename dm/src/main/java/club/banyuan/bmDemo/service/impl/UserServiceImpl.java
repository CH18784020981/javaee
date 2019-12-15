package club.banyuan.bmDemo.service.impl;

import club.banyuan.bmDemo.bean.Bills;
import club.banyuan.bmDemo.bean.Supplier;
import club.banyuan.bmDemo.bean.Users;
import club.banyuan.bmDemo.dao.UserDao;
import club.banyuan.bmDemo.dao.impl.UserDaoImpl;
import club.banyuan.bmDemo.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * TODO
 *
 * @author HYB
 * @since 2019/12/4 1:33 下午
 **/
public class UserServiceImpl implements UserService {
    private UserDao dao = new UserDaoImpl();

    @Override
    public List<Users> findAll() {
        return dao.findAll();
    }

    @Override
    public void addUser(Users user) {
        dao.add(user);
    }

    @Override
    public void deleteUser(String id) {
        dao.delete(Integer.parseInt(id));
    }

    @Override
    public List<Supplier> findAllSup() {
        return dao.findAllSup();
    }

    @Override
    public void addSup(Supplier supplier) {
        dao.addSup(supplier);
    }

    @Override
    public void deleteSup(String id) {
        dao.deleteSup(Integer.parseInt(id));
    }

    @Override
    public List<Bills> findAllBill() {
        return dao.findAllBill();
    }

    @Override
    public void addBill(Bills bill) {
        dao.addBill(bill);
    }

    @Override
    public void deleteBill(String id) {
        dao.deleteBill(Integer.parseInt(id));
    }
}
