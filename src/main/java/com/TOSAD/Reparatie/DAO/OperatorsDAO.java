package com.TOSAD.Reparatie.DAO;

import com.TOSAD.Reparatie.Domain.Operators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperatorsDAO {

    @Autowired
    OperatorRepository operatorRepository;

    public List<Operators> findAll() {
        return operatorRepository.findAll();
    }

    public Operators findById(Long id) {
        return operatorRepository.getOne(id);
    }

    public Operators save(Operators operators) {
        return operatorRepository.save(operators);
    }

    public void delete(Operators operators) {
        operatorRepository.delete(operators);
    }
}
