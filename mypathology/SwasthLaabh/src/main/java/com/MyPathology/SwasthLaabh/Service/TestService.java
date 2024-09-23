package com.MyPathology.SwasthLaabh.Service;


import com.MyPathology.SwasthLaabh.Entity.Test;
import com.MyPathology.SwasthLaabh.Repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TestService {

    @Autowired
    private TestRepository testRepository;

    public Test addTest(Test test) {
        return testRepository.save(test);
    }

    public Optional<Test> findById(Long id) {
        return testRepository.findById(id);
    }

    public List<Test> findAllTests() {
        return testRepository.findAll();
    }
}
