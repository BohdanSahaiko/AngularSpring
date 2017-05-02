package com.service.implementationService;

import com.Entity.Publication;
import com.dao.PubliactionRepository;

import com.service.PublicationServiceImp;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Service
@Transactional
public class PublicationService implements PublicationServiceImp {
    @Resource
    private PubliactionRepository publicationRepository;
    @Override
    public List<Publication> getAll() {
        return publicationRepository.findAll();
    }

}
