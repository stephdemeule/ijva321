package a2021cdanp2.demo.model.dao;

import a2021cdanp2.demo.model.beans.CreationBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreationDao extends JpaRepository<CreationBean, Long> {


}
