package a2021cdanp2.demo.model.dao;

import a2021cdanp2.demo.model.beans.UserBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<UserBean, Long> {

    List<UserBean> findByName(String name);

    //Pour la suppression il faut le @Transactional
    @Transactional
    int deleteByNameIsContaining(String name);

    List<UserBean> findByNameIsContaining(String text);


}
