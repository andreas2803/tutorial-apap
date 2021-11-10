package apap.tutorial.cineplux.service;

import apap.tutorial.cineplux.model.BioskopModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BioskopInMemoryService implements BioskopService{
    private List<BioskopModel> listBioskop;

    //constructor
    public BioskopInMemoryService(){
        listBioskop = new ArrayList<>();
    }

    @Override
    public void addBioskop(BioskopModel bioskop){
        listBioskop.add(bioskop);
    }

    @Override
    public void updateBioskop(BioskopModel bioskop) {

    }

    @Override
    public void deleteBioskop(BioskopModel bioskop) {

    }

    @Override
    public String checkError(BioskopModel bioskop) {
        return null;
    }

    @Override
    public List<BioskopModel> getBioskopList(){
        return listBioskop;
    }

    @Override
    public BioskopModel getBioskopByNoBioskop(Long noBioskop) {
        return null;
    }

}
