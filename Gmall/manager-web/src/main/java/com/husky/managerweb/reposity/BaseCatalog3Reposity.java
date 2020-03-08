package com.husky.managerweb.reposity;


import com.husky.managerweb.entity.BaseCatalog3;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BaseCatalog3Reposity extends JpaRepository<BaseCatalog3,Long> {
    List<BaseCatalog3> findByCatalog2Id(Long catalog2Id);
}
