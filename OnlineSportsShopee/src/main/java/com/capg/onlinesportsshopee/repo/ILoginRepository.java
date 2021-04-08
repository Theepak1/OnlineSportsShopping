package com.capg.onlinesportsshopee.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.onlinesportsshopee.bean.Login;
import com.capg.onlinesportsshopee.bean.User;

@Repository
public interface ILoginRepository extends JpaRepository<Login, User> {


}