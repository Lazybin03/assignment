package com.example.demo.controller;


import com.example.demo.model.Family;
import com.example.demo.model.UnivFamily;
import com.example.demo.service.UnivFamilyService;
import com.example.demo.utills.CustomResponse;
import com.example.demo.utills.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.ws.rs.POST;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("rest/univFamily")
public class UnivFamilyRestApi {
    @Autowired
    UnivFamilyService univFamilyService;

    @GetMapping("/all")
    public CustomResponse getAllUnivFamily() {
        List<UnivFamily> univFamilies = univFamilyService.getAll();
        if (univFamilies.size() != 0)
            return new CustomResponse("univFamilies", univFamilies);
        else throw new ResourceNotFoundException("univFamily", "There is univFamily data in the database");

    }

    @GetMapping("/{id}")
    public CustomResponse getUniverseById(@PathVariable(value = "id") String id) {
        Optional<UnivFamily> univFamily = univFamilyService.findUnivFamilyById(id);
        if (univFamily != null)
            return new CustomResponse("univFamily", univFamily);
        else throw new ResourceNotFoundException("univFamily", "There is univFamily with id:" + id);
    }

    @PostMapping("/universe")
    public CustomResponse createUniverse(@Valid @RequestBody UnivFamily univFamily) {
        UnivFamily savedUnivFamily = univFamilyService.createUniFamily(univFamily);
        if (savedUnivFamily != null) {
            return new CustomResponse("success", univFamily);
        } else {
            return new CustomResponse("error", "failed to save univFamily");
        }
    }

    @DeleteMapping("/{id}")
    public CustomResponse deleteUnivFamily(@PathVariable(value = "id") String id) {
        try {
            univFamilyService.deleteUnivFamilyById(id);
            return new CustomResponse("success", "successfully deleted with id:" + id);
        } catch (Exception ex) {

        }
        return new CustomResponse("error", "failed to delete univfamily with id:" + id);
    }

    @GetMapping("/familiesOfUniverse/{id}")
    public CustomResponse getFamiliesByUId(@PathVariable(value = "id") String id) {
        List<Optional<Family>> families = univFamilyService.findFamiliesByUId(id);
        if (families.size() != 0) {
            return new CustomResponse("familiesOfUniverse", families);
        } else throw new ResourceNotFoundException("Families", "there is no data found for the universe id:" + id);
    }

    @GetMapping("familyPower/{id}")
    public CustomResponse getFamiliePowerOfAllUniverses(@PathVariable(value = "id") String id) {
        List<Object[]> powerMap = univFamilyService.findFamilyPowerOfAllUniverses(id);
        if (powerMap.size() != 0)
            return new CustomResponse("familyPowerMapByUniverseKey", powerMap);
        else throw new ResourceNotFoundException("power", "there is no data of power for the family id:" + id);

    }

    @PostMapping("balanceFamily/{id}")
    public CustomResponse balanceFamily(@PathVariable(value = "id") String id) {
        boolean done = univFamilyService.balanceFamily(id);
        if (done)
            return new CustomResponse("balanceFamily", "balancing family successfull");
        else
            return new CustomResponse("balanceFamily", "Its not possible to balance the family");

    }

}
