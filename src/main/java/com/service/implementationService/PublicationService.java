package com.service.implementationService;

import com.Entity.Publication;
import com.dao.PubliactionRepository;

import com.parserLogic.NoEntityObject;
import com.parserLogic.Parser;
import com.service.PublicationServiceImp;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Service
@Transactional
public class PublicationService implements PublicationServiceImp {
    List<NoEntityObject> noEntityObjectList;
    @Resource
    private PubliactionRepository publicationRepository;
    @Override
    public List<Publication> getAll() {
        return publicationRepository.findAll();
    }

    @Override
    public void changer() {
        int i=0;
        List<Publication> publications = publicationRepository.findByPoint(noEntityObjectList.get(0).getThem());
        if(publications.isEmpty()){
            for (NoEntityObject  n: noEntityObjectList) {
                Publication p = new Publication();
                p.setTittle(n.getTiitle());
                p.setAuthor(n.getAuthor());
                p.setLink(n.getLink());
                p.setPages(n.getPages());
                p.setYear(n.getYear());
                p.setPoint(n.getThem());
                p.setWords(n.getKeyss());
                //publicationRepository.save(p);
            }
        }else {
            for (Publication p : publications) {
                NoEntityObject noEntityObjects = noEntityObjectList.get(i);
                //noEntityObjects.getTiitle();
                p.setTittle(noEntityObjects.getTiitle());
                p.setAuthor(noEntityObjects.getAuthor());
                p.setLink(noEntityObjects.getLink());
                p.setPages(noEntityObjects.getPages());
                p.setPoint(noEntityObjects.getThem());
                //publicationRepository.save(p);
                i++;
            }
        }
    }

    @Override
    public List<NoEntityObject> allObject(String param) throws IOException {
      noEntityObjectList = Parser.lister(param);
            return noEntityObjectList;
    }

}
