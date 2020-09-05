package com.user.manager.dao.impl;

import com.user.manager.dao.UserDao;
import com.user.manager.entity.User;
import com.user.manager.utils.DruidUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UserDaoImpl implements UserDao {
    private JdbcTemplate template = new JdbcTemplate(DruidUtils.getDataSource());
    @Override
    // 从数据库中查询是否有此用户
    public User findByNameAndPassword(String name, String password) {
        String sql = "select * from user where name = ? and password = ?";
        List<User> list = template.query(sql, new BeanPropertyRowMapper<>(User.class), name, password);
        // 存在返回 用户信息
        // 不存在返回 null
        return list.size() == 0 ? null : list.get(0);
    }

    @Override
    // 从数据库中查询所有用户信息 并返回
    public List<User> selectUserAll() {
        String sql = "select * from user";
        List<User> list = template.query(sql, new BeanPropertyRowMapper<>(User.class));
        return list;
    }

    @Override
    // 在数据库中添加一条用户信息
    public void insertUser(User user) {
        String sql = "insert into user values(null,?,?,?,?,?,?,null)";
        template.update(sql,user.getName(),user.getGender(),user.getAge(),user.getAddress(),user.getQq(),user.getEmail());
    }

    @Override
    // 通过id删除数据库中的对应用户信息
    public void deleteUserById(int id) {
        String sql = "delete from user where id = ?";
        template.update(sql,id);
    }

    @Override
    // 通过id查找数据库中的对应用户信息
    public User selectUserById(int id) {
        String sql = "select * from user where id = ?";
        List<User> list = template.query(sql, new BeanPropertyRowMapper<>(User.class), id);
        return list.get(0);
    }

    @Override
    // 通过id更新数据库中的对应用户信息
    public void updateUserById(User user) {
        String sql = "update user set gender = ?, age = ?, address = ?, qq = ?, email = ? where id = ?";
        template.update(sql, user.getGender(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail(), user.getId());
    }

    @Override
    // 分页查询
    public List<User> findByPageUser(int start, int pageSize, Map<String, String[]> condition) {
        StringBuilder _sql = new StringBuilder("select * from user where 1=1");
        List<Object> params = new ArrayList<>(); // 存储 查询条件
        Set<String> keys = condition.keySet();
        // 拼接 条件sql语句
        // 存储 查询条件
        for(String key : keys) {
            if (key.equals("name") || key.equals("address") || key.equals("email")) {
                _sql.append(" and " + key + " like ? ");
                params.add("%" + condition.get(key)[0] + "%");
            }
        }
        // 拼接 分页sql语句
        // 存储 分页条件
        _sql.append(" limit ?,?");
        params.add(start);
        params.add(pageSize);
        List<User> list = template.query(_sql.toString(), new BeanPropertyRowMapper<>(User.class), params.toArray());
        return list;
    }

    @Override
    // 查询信息条数
    public int findTotalCount(Map<String, String[]> condition) {
        StringBuilder _sql = new StringBuilder("select count(*) from user where 1=1");
        List<Object> params = new ArrayList<>(); // 存储 查询条件
        Set<String> keys = condition.keySet();
        // 拼接 sql语句
        // 存储 查询条件
        for(String key : keys) {
            if (key.equals("name") || key.equals("address") || key.equals("email")) {
                _sql.append(" and " + key + " like ? ");
                params.add("%" + condition.get(key)[0] + "%");
            }
        }
        Integer totalCount = template.queryForObject(_sql.toString(), Integer.class, params.toArray());
        return totalCount;
    }
}
