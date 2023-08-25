package com.example.airlineTicketing.Dao;

import com.example.airlineTicketing.Entity.TestEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestEntityDao extends CrudRepository<TestEntity, Long>
{
}
