package healthchecker.controller.api;

import healthchecker.domain.Info;
import healthchecker.domain.repository.InfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by 1004w455 on 2017. 6. 17..
 */
@RestController
public class CrudController {

    @Autowired
    private InfoRepository infoRepository;

    @GetMapping("/api/info")
    public List<Info> getAll() {
        return infoRepository.findAll();
    }

    @GetMapping("/api/info/{id}")
    public Info get(@PathVariable long id) {
        return infoRepository.findOne(id);
    }

    @Transactional
    @PostMapping("/api/info/{id}")
    public Info post(@PathVariable long id, String name) {
        Info info = infoRepository.findOne(id);
        info.setName(name);
        return info;
    }

}