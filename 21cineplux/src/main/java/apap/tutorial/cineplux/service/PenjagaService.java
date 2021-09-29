package apap.tutorial.cineplux.service;

import apap.tutorial.cineplux.model.PenjagaModel;

public interface PenjagaService {
    void addPenjaga(PenjagaModel penjaga);
    int updatePenjaga(PenjagaModel penjaga);
    int deletePenjaga(PenjagaModel penjaga);
    PenjagaModel getPenjagaByNoPenjaga(Long penjaga);
}