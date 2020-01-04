package com.husky.reposity;

import com.husky.jopo.BaseCatolog1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatelogReposity extends JpaRepository<BaseCatolog1,Integer> {
    BaseCatolog1 findById(int id);
}
