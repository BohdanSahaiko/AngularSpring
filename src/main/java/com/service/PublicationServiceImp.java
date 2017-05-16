package com.service;



import com.Entity.Publication;
import com.parserLogic.NoEntityObject;

import java.io.IOException;
import java.util.List;

/**
 * Created by bohdan on 11.03.17.
 */
public interface PublicationServiceImp {
    List<Publication> getAll();
    void changer();
    List<NoEntityObject> allObject(String param) throws IOException;
}
