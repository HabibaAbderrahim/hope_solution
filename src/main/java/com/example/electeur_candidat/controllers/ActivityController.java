package com.example.electeur_candidat.controllers;


import com.example.electeur_candidat.DTO.MessageResponse;
import com.example.electeur_candidat.entities.Activity;
import com.example.electeur_candidat.entities.Candidat;
import com.example.electeur_candidat.services.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/activity")
@CrossOrigin("http://localhost:4200")
@PreAuthorize("hasAnyRole('ROLE_ADMIN' , 'ROLE_ELECTEUR')")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @GetMapping("/getAll")
    public List<Activity> getAll(){
        return activityService.findAll();
    }

    @GetMapping("/scoring/{id}")
    public float score(@PathVariable("id")Integer id) { return  activityService.scoringAct(id);}
    @GetMapping("/getAllSorted")
    public List<Activity> getAllSorted(){
        return activityService.allActivitySortedByNomberPersIn();
    }

    @PreAuthorize("haRole('ROLE_ADMIN')")
    @PostMapping("/add")
    public MessageResponse add(@RequestBody Activity activity){
        return activityService.save(activity);
    }

    @PreAuthorize("haRole('ROLE_ADMIN')")
    @PutMapping("/edit")
    public MessageResponse edit(@RequestBody Activity activity ){
        return activityService.update(activity);
    }

    @PreAuthorize("haRole('ROLE_ADMIN')")
    @DeleteMapping("del/{id}")//pathParam
    public MessageResponse delete(@PathVariable("id") Integer id){
        return activityService.delete(id);
    }

    @PreAuthorize("haRole('ROLE_ADMIN')")
    @GetMapping("find/{name}")
    public Activity findCandidat(@PathVariable String name){
        return activityService.activityByName(name);
    }


}
