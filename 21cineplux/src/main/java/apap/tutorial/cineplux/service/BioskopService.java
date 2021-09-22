package apap.tutorial.cineplux.service;

import apap.tutorial.cineplux.model.BioskopModel;
import java.util.List;

public interface BioskopService {
    //method untuk menambah Bioskop
    void addBioskop(BioskopModel bioskop);
    void deleteBioskop(BioskopModel bioskop);

    //method untuk mendapatkan daftar Bioskop yang telah tersimpan
    List<BioskopModel> getBioskopList();

    //method untuk mendapatkan data sebuah Bioskop berdasarkan id bioskop
    BioskopModel getBioskopByIdBioskop(String idBioskop);
}
