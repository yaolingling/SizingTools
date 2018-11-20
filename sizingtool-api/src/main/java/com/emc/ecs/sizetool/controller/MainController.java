package com.emc.ecs.sizetool.controller;

import com.emc.ecs.sizetool.dao.Person;
import com.emc.ecs.sizetool.service.PersonSerice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class MainController {
    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private PersonSerice personSerice;

    @PostMapping("/getResult")
    public ResponseEntity<String> getResult(HttpServletResponse response,
                                       @RequestBody Object input){
        logger.info("Process the getResult request. input: {}", input);
        //just a demo for getting data from mysql.
        for(Person person : personSerice.findByAge(20)){
            logger.info(person.toString());
        }
        return null;
    }
}
