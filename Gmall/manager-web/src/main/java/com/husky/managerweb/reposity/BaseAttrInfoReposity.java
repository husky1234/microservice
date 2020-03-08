package com.husky.managerweb.reposity;

import com.husky.managerweb.entity.BaseAttrInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BaseAttrInfoReposity extends JpaRepository<BaseAttrInfo,Long> {
    List<BaseAttrInfo> findByCatalog3Id(Long catalog3Id);

    @Modifying()
    @Query(value = "update base_attr_info b set b.name = ?1 where id = ?2",nativeQuery = true)
    int updateAttr(String name,Long id);
}
