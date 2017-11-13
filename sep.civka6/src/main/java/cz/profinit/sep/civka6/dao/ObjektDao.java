package cz.profinit.sep.civka6.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cz.profinit.sep.civka6.model.ObjektKUlozeni;

public interface ObjektDao extends JpaRepository<ObjektKUlozeni, Long> {

	List<ObjektKUlozeni> findBySourceAbo(String iban);
	
}
