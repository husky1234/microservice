package com.husky.managerweb.reposity;


import com.husky.managerweb.entity.BaseCatalog2;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BaseCatalog2Reposity extends JpaRepository<BaseCatalog2,Long> {
    List<BaseCatalog2> findByCatalog1Id(Long catalog1Id);
}
