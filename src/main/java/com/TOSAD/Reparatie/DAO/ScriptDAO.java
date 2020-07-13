package com.TOSAD.Reparatie.DAO;

import com.TOSAD.Reparatie.Domain.Script;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScriptDAO {

    @Autowired
    ScriptRepository scriptRepository;

    public List<Script> findAll() {
        return scriptRepository.findAll();
    }

    public Script findById(Long id) {
        return scriptRepository.getOne(id);
    }

    public Script save(Script script) {
        return scriptRepository.save(script);
    }

    public void delete(Script script) {
        scriptRepository.delete(script);
    }
}
