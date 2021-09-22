package apap.tutorial.cineplux.controller;

import apap.tutorial.cineplux.model.BioskopModel;
import apap.tutorial.cineplux.service.BioskopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;


@Controller
public class BioskopController {
    @Autowired
    private BioskopService bioskopService;

    //Routing URL yang diinginkan
    @RequestMapping("/bioskop/add")
    public String addBioskop(
            //Request parameter yang ingin digunakan
            @RequestParam(value = "idBioskop", required = true) String idBioskop,
            @RequestParam(value = "namaBioskop", required = true) String namaBioskop,
            @RequestParam(value = "alamat", required = true) String alamat,
            @RequestParam(value = "noTelepon", required = true) String noTelepon,
            @RequestParam(value = "jumlahStudio", required = true) int jumlahStudio,
            Model model
    ) {
        //Membuat objek BioskopModel
        BioskopModel bioskopModel = new BioskopModel(idBioskop, namaBioskop, alamat, noTelepon, jumlahStudio);
        //Menambahkan objek BioskopModel kedalam service
        bioskopService.addBioskop(bioskopModel);

        //Add variabel id bioskop ke "idBioskop" untuk dirender ke dalam thymeleaf
        model.addAttribute("idBioskop", idBioskop);

        //Return view template yang digunakan
        return "add-bioskop";

    }

    @RequestMapping("/bioskop/viewall")
    public String listBioskop(Model model) {
        //Mendapatkan semua bioskop
        List<BioskopModel> listBioskop = bioskopService.getBioskopList();
        //Add variable semua BioskopModel ke 'ListBioskop' untuk dirender dalam thymeleaf
        model.addAttribute("listBioskop", listBioskop);
        //Return view template yang diinginkan
        return "viewall-bioskop";
    }

    @RequestMapping("/bioskop/view")
    public String detailBioskop(
            @RequestParam(value = "idBioskop", required = true) String idBioskop, Model model
    ) {
        //mendapatkan bioskop sesuai dengan idBioskop
        BioskopModel bioskopModel = bioskopService.getBioskopByIdBioskop(idBioskop);

        //handle error
        if (bioskopModel == null) {
            return "page-not-found";
        }

        //add variabel BioskopModel ke 'bioskop' untuk dirender dalam thymeleaf
        model.addAttribute("bioskop", bioskopModel);

        //Return view template yang diinginkan
        return "view-bioskop";
    }

    @RequestMapping("bioskop/view/id-bioskop/{idBioskop}")
    public String detailBioskopKedua(
            @PathVariable(value = "idBioskop") String idBioskop, Model model
    ) {
        //mendapatkan bioskop sesuai dengan idBioskop
        BioskopModel bioskopModel = bioskopService.getBioskopByIdBioskop(idBioskop);

        //handle error
        if (bioskopModel == null) {
            return "page-not-found";
        }

        //add variabel BioskopModel ke 'bioskop' untuk dirender dalam thymeleaf
        model.addAttribute("bioskop", bioskopModel);

        //Return view template yang diinginkan
        return "view-bioskop";
    }

    @RequestMapping("bioskop/update/id-bioskop/{idBioskop}/jumlah-studio/{jumlahStudio}")
    public String updateBioskop(
            @PathVariable(value = "idBioskop") String idBioskop,
            @PathVariable(value = "jumlahStudio") int jumlahStudio,
            Model model
    ) {
        //mendapatkan bioskop sesuai dengan idBioskop
        BioskopModel bioskopModel = bioskopService.getBioskopByIdBioskop(idBioskop);

        //handle error
        if (bioskopModel == null) {
            return "page-not-found";
        }

        bioskopModel.setJumlahStudio(jumlahStudio);

        //add variabel BioskopModel ke 'bioskop' untuk dirender dalam thymeleaf
        model.addAttribute("idBioskop", idBioskop);

        //Return view template yang diinginkan
        return "update-bioskop";
    }

    @RequestMapping("bioskop/delete/id-bioskop/{idBioskop}")
    public String deleteBioskop(
            @PathVariable(value = "idBioskop") String idBioskop,
            Model model
    ) {
        //mendapatkan bioskop sesuai dengan idBioskop
        BioskopModel bioskopModel = bioskopService.getBioskopByIdBioskop(idBioskop);
        //handle error
        if (bioskopModel == null) {
            return "page-not-found";
        }
        //Delete bioskop
        if (bioskopService.getBioskopList().contains(bioskopModel)) {
            bioskopService.deleteBioskop(bioskopModel);
        }
        model.addAttribute("idBioskop", idBioskop);
        //Return view template yang diinginkan
        return "delete-bioskop";
    }
}

