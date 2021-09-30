package apap.tutorial.cineplux.controller;

import apap.tutorial.cineplux.model.BioskopModel;
import apap.tutorial.cineplux.model.PenjagaModel;
import apap.tutorial.cineplux.service.BioskopService;
import apap.tutorial.cineplux.service.PenjagaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PenjagaController {
    @Qualifier("penjagaServiceImpl")
    @Autowired
    PenjagaService penjagaService;

    @Qualifier("bioskopServiceImpl")
    @Autowired
    BioskopService bioskopService;

    @GetMapping("/penjaga/add/{noBioskop}")
    public String addPenjagaForm(@PathVariable Long noBioskop, Model model) {
        PenjagaModel penjaga = new PenjagaModel();
        BioskopModel bioskop = bioskopService.getBioskopByNoBioskop(noBioskop);
        penjaga.setBioskop(bioskop);
        model.addAttribute("penjaga", penjaga);
        return "form-add-penjaga";
    }

    @PostMapping("/penjaga/add")
    public String addPenjagaSubmit(
            @ModelAttribute PenjagaModel penjaga,
            Model model
    ) {
        penjagaService.addPenjaga(penjaga);
        model.addAttribute("noBioskop", penjaga.getBioskop().getNoBioskop());
        model.addAttribute("namaPenjaga", penjaga.getNamaPenjaga());
        return "add-penjaga";
    }

    @GetMapping("/penjaga/update/{idPenjaga}")
    public String updatePenjagaForm(
            @PathVariable Long idPenjaga,
            Model model
    ) {
        PenjagaModel penjaga = penjagaService.getPenjagaByNoPenjaga(idPenjaga);
        model.addAttribute("penjaga", penjaga);
        return "form-update-penjaga";
    }

    @PostMapping("/penjaga/update")
    public String updatePenjagaSubmit(
            @ModelAttribute PenjagaModel penjaga,
            Model model
    ) {
        if (penjagaService.updatePenjaga(penjaga) == 1) {
            model.addAttribute("noPenjaga", penjaga.getNoPenjaga());
            model.addAttribute("noBioskop", penjaga.getBioskop().getNoBioskop());
            return "update-penjaga";
        } else {
            return "open-bioskop";
        }

    }

    @GetMapping("/penjaga/delete/{noPenjaga}")
    public String deletePenjagaForm(
            @PathVariable Long noPenjaga,
            Model model
    ) {
        PenjagaModel penjaga = penjagaService.getPenjagaByNoPenjaga(noPenjaga);
        model.addAttribute("penjaga", penjaga);
        BioskopModel bioskop = penjaga.getBioskop();
        model.addAttribute("noBioskop", bioskop.getNoBioskop());
        if(penjagaService.deletePenjaga(penjaga)==1) {
            return "delete-penjaga";
        }
        else{
            return "open-bioskop";
        }
    }

    @PostMapping("/penjaga/delete")
    public String deletePenjagaSubmit(
            @ModelAttribute BioskopModel bioskop,
            Model model
    ){
        model.addAttribute("noBioskop", bioskop.getNoBioskop());
        int res = 1;
        for (PenjagaModel penjaga:
            bioskop.getListPenjaga()) {
            res = penjagaService.deletePenjaga(penjaga);
        }
        if (res == 1){
            return "delete-penjaga";
        }
        return "error";
    }

}

