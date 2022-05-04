package com.oasis.apigestmenu.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oasis.apigestmenu.models.TipoColaboradorModel;

@Repository
public interface TipoColaboradorRepository extends JpaRepository<TipoColaboradorModel, UUID> {

}
