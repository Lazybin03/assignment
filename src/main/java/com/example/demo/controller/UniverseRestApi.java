package com.example.demo.controller;


import com.example.demo.model.Universe;
import com.example.demo.service.UniverseService;
import com.example.demo.utills.CustomResponse;
import com.example.demo.utills.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("rest/universe")
public class UniverseRestApi {
    @Autowired
    UniverseService universeService;

    @GetMapping("/all")
    public CustomResponse getAllUniveses() {
        List<Universe> universes = universeService.getAllUniverse();
        if (universes.size() != 0)
            return new CustomResponse("universes", universes);
        else throw new ResourceNotFoundException("universe", "There is universe data in the database");

    }

    @GetMapping("/{id}")
    public CustomResponse getUniverseById(@PathVariable(value = "id") String univID) {
        Optional<Universe> universe = universeService.findUnivreseById(univID);
        if (universe != null)
            return new CustomResponse("universe", universe);
        else throw new ResourceNotFoundException("universe", "There is no universe with id:" + univID);
    }

    @PostMapping("/universe")
    public CustomResponse createUniverse(@Valid @RequestBody Universe universe) {
        Universe savedUniverse = universeService.createUnivrese(universe);
        if (savedUniverse != null) {
            return new CustomResponse("success", universe);
        } else {
            return new CustomResponse("error", "failed to save universe");
        }
    }

    @DeleteMapping("/{id}")
    public CustomResponse deleteUniverse(@PathVariable(value = "id") String univID) {
        try {
            universeService.deleteUniverse(univID);
            return new CustomResponse("success", "successfullly deleted universe with id:" + univID);
        } catch (Exception ex) {

        }

        return new CustomResponse("error", "failed to delete universe with id:" + univID);
    }
}
