package de.mlrdev.reactapi.api.rest;

import de.mlrdev.reactapi.api.Gem;
import de.mlrdev.reactapi.api.repo.GemsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * A simple Controller that reacts on /gems
 */
@RestController
@RequestMapping(value = "gems")
public class GemsController implements Controller<Gem> {

    private static final Logger LOG = LoggerFactory.getLogger(GemsController.class);

    @Autowired
    private GemsService gemsService;

    @Override
    @RequestMapping(method = RequestMethod.GET)
    public List<Gem> getAll() {
        return gemsService.getAll();
    }

    @Override
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Gem getById(@PathVariable String id) {
        try {
            return gemsService.getById(Integer.parseInt(id));
        } catch (NumberFormatException ex) {
            LOG.error("NumberFormatException while getById");
        }
        return null;
    }
}