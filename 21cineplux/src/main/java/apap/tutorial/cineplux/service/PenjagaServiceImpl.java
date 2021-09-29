package apap.tutorial.cineplux.service;

import apap.tutorial.cineplux.model.BioskopModel;
import apap.tutorial.cineplux.model.PenjagaModel;
import apap.tutorial.cineplux.repository.PenjagaDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalTime;
import java.util.Optional;

@Service
@Transactional
public class PenjagaServiceImpl implements PenjagaService{

    @Autowired
    PenjagaDB penjagaDB;

    @Override
    public void addPenjaga(PenjagaModel penjaga) { penjagaDB.save(penjaga); }

    @Override
    public int updatePenjaga(PenjagaModel penjaga){
        LocalTime sekarang = LocalTime.now();
        LocalTime buka = penjaga.getBioskop().getWaktuBuka();
        LocalTime tutup = penjaga.getBioskop().getWaktuTutup();

        if(sekarang.isBefore(tutup) || (sekarang.isAfter(buka))){
            return 0;
        }
        else{
            penjagaDB.save(penjaga);
            return 1;
        }
    }

    @Override
    public int deletePenjaga(PenjagaModel penjaga){
        LocalTime sekarang = LocalTime.now();
        LocalTime buka = penjaga.getBioskop().getWaktuBuka();
        LocalTime tutup = penjaga.getBioskop().getWaktuTutup();

        if(sekarang.isBefore(tutup) || (sekarang.isAfter(buka))){
            System.out.println("Bioskop open");
            return 0;
        }
        else{
            penjagaDB.delete(penjaga);
            System.out.println("bisokop tuptup");
            return 1;
        }
    }

    @Override
    public PenjagaModel getPenjagaByNoPenjaga(Long idPenjaga) {
        Optional<PenjagaModel> penjaga = penjagaDB.findByNoPenjaga(idPenjaga);
        if (penjaga.isPresent()) {
            return penjaga.get();
        }
        return null;
    }
}
