package apap.tutorial.cineplux.service;

import apap.tutorial.cineplux.model.RoleModel;
import apap.tutorial.cineplux.repository.RoleDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
<<<<<<< HEAD
public class RoleServiceImpl implements RoleService {
=======

>>>>>>> 51154897d58f4e827f9eda373b239024c3e9b180
    @Autowired
    RoleDB roleDB;

    @Override
    public List<RoleModel> getListRole() {
        return roleDB.findAll();
    }
<<<<<<< HEAD
}
=======

>>>>>>> 51154897d58f4e827f9eda373b239024c3e9b180
