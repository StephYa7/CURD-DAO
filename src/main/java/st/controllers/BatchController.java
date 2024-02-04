package st.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import st.dao.PersonDAO;

@Controller
@RequestMapping("/batch")
public class BatchController {

    private final PersonDAO personDAO;

    public BatchController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping()
    public String index() {
        return "batch/index";
    }

    @GetMapping("/without")
    public String withoutBatch() {
        personDAO.testMultipleUpdate();
        return "redirect:/people"
                ;
    }

    @GetMapping("/with")
    public String withBatch() {
        personDAO.testBatchUpdate();
        return "redirect:/people";
    }
}