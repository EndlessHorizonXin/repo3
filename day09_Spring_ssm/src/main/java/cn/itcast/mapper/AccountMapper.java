package cn.itcast.mapper;

import cn.itcast.domain.Account;

import java.util.List;

public interface AccountMapper {

    /**
     * 添加用户
     * @param account
     */
    public void save(Account account);

    /**
     * 查找所有用户
     * @return
     */
    public List<Account> findAll();

}
