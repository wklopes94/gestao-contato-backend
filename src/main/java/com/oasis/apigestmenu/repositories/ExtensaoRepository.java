package com.oasis.apigestmenu.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oasis.apigestmenu.models.ExtensaoModel;

@Repository
public interface ExtensaoRepository extends JpaRepository<ExtensaoModel, UUID>{

}
