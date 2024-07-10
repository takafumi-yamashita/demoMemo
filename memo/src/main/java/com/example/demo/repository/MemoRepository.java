package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Memo;

@Repository //Repositoryクラスであることを示す
public interface MemoRepository extends JpaRepository<Memo, Integer>{

}
