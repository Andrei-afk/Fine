package com.example.fineproject.http;

import com.example.fineproject.mongo.document.Fine;
import com.example.fineproject.repository.FineRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/fines")
public class FinesController {
    private static final Logger LOGGER = LoggerFactory.getLogger(FinesController.class);
    private final FineRepository fineRepository;

    public FinesController(FineRepository fineRepository) {
        this.fineRepository = fineRepository;
    }

    @PostMapping("")
    public HttpStatus createFine(@RequestBody Fine fine) {
        LOGGER.info(String.format("Received adding fine request from policeman %s ", fine.getPolicemanName()));
        try {
            fineRepository.createFine(fine);
            return HttpStatus.OK;
        }catch (Exception e){
            LOGGER.error(e.getMessage());
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }

    @GetMapping("")
    public List<Fine> getAllFinesWithSamePNC (@RequestParam String username, @RequestParam String personalNumericCode) {
        LOGGER.info(String.format("Received get request for username %s and PNC %s", username, personalNumericCode));
        return fineRepository.findFinesWithTheSamePNC(username, personalNumericCode);
    }
}
