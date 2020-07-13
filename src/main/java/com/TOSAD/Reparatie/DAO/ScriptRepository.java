package com.TOSAD.Reparatie.DAO;

import com.TOSAD.Reparatie.Domain.Script;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScriptRepository extends JpaRepository<Script, Long> {
}
