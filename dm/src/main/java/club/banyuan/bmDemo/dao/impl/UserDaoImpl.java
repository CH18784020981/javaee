package club.banyuan.bmDemo.dao.impl;

import club.banyuan.bmDemo.bean.Bills;
import club.banyuan.bmDemo.bean.Supplier;
import club.banyuan.bmDemo.bean.Users;
import club.banyuan.bmDemo.dao.UserDao;
import club.banyuan.bmDemo.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author HYB
 * @since 2019/12/4 2:20 下午
 **/
public class UserDaoImpl implements UserDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Users> findAll() {
        String sql = "select *from users";
        List<Users> users = template.query(sql, new BeanPropertyRowMapper<>(Users.class));
        return users;
    }

    @Override
    public void add(Users user) {
        //1.定义sql
        String sql = "insert into users values(null,?,?,?,?,?,?,?,?)";
        //2.执行sql
        template.update(sql, user.getLoginname(), user.getPassword(), user.getName(), user.getSex(), user.getAge(), user.getPhone(), user.getAddress(), user.getAuthority());
    }

    @Override
    public void delete(int id) {
        //1.定义sql
        String sql = "delete from users where userid = ?";
        //2.执行sql
        template.update(sql, id);
    }

    @Override
    public List<Supplier> findAllSup() {
        String sql = "select *from supplier";
        List<Supplier> supplier = template.query(sql, new BeanPropertyRowMapper<>(Supplier.class));
        return supplier;
    }

    @Override
    public void addSup(Supplier supplier) {
        //1.定义sql
        String sql = "insert into supplier values(null,?,?,?,?,?,?)";
        //2.执行sql
        template.update(sql, supplier.getName(), supplier.getDescription(), supplier.getContact(), supplier.getPhoto(), supplier.getFax(), supplier.getAddress());

    }

    @Override
    public void deleteSup(int id) {
        //1.定义sql
        String sql = "delete from supplier where supplierid = ?";
        //2.执行sql
        template.update(sql, id);
    }

    @Override
    public List<Bills> findAllBill() {
        String sql = "select *from Bill";
        List<Bills> bills = template.query(sql, new BeanPropertyRowMapper<>(Bills.class));
        return bills;
    }

    @Override
    public void addBill(Bills bill) {
        //1.定义sql
        String sql = "insert into bill values(null,?,?,?,?,?,?,?)";
        //2.执行sql
        template.update(sql, bill.getName(), bill.getAmount(), bill.getMoney(), bill.getSupplier(), bill.getDescription(), bill.getCreatDate(), bill.getPayOrNot());

    }

    @Override
    public void deleteBill(int id) {
        //1.定义sql
        String sql = "delete from bill where billid = ?";
        //2.执行sql
        template.update(sql, id);
    }

}
