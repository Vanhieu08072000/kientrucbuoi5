package com.example.kientrucbuoi5.controller;


import com.example.kientrucbuoi5.entity.ChuyenBay;
import com.example.kientrucbuoi5.entity.NhanVien;
import com.example.kientrucbuoi5.repository.ChuyenBayRepository;
import com.example.kientrucbuoi5.repository.MayBayRepository;
import com.example.kientrucbuoi5.repository.NhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api")
public class ApiController {
    @Autowired
    ChuyenBayRepository chuyenBayRepository;
    @Autowired
    NhanVienRepository nhanVienRepository;
    @Autowired
    MayBayRepository mayBayRepository;

    //Cau 1
    @RequestMapping(value = "/cau1/{gaden}", method = RequestMethod.GET)
    public List<ChuyenBay> timChuyenBayBoiGaDen(@PathVariable("gaden") String gaDen) {
        List<ChuyenBay> chuyenBays = chuyenBayRepository.findChuyenBayByGaDen(gaDen);
        if (chuyenBays == null) {
            ResponseEntity.notFound().build();
        }
        return chuyenBays;
    }

    //Cau 2
    @RequestMapping(value = "/maybaycotambayLonHon10000", method = RequestMethod.GET)
    public List<String> mayBayCoTamBayLonHon10000() {
        List<String> mayBays = mayBayRepository.findLoaiMayBayByTamBay();
        if (mayBays == null) {
            ResponseEntity.notFound().build();
        }
        return mayBays;
    }

    //Cau 3
    @RequestMapping(value = "/nhanvientheoluong", method = RequestMethod.GET)
    public List<NhanVien> timNhanVienTheoLuong() {
        List<NhanVien> nhanViens = nhanVienRepository.findNhanVienByLuong();
        if (nhanViens == null) {
            ResponseEntity.notFound().build();
        }
        return nhanViens;
    }

    //Cau 4
    @RequestMapping(value = "/chuyenbay", method = RequestMethod.GET)
    public List<ChuyenBay> timChuyenBayBoiDoDai() {
        List<ChuyenBay> chuyenBays = chuyenBayRepository.findChuyenBayByDoDai();
        if (chuyenBays == null) {
            ResponseEntity.notFound().build();
        }
        return chuyenBays;
    }

    //Cau 5
    @RequestMapping(value = "/chuyenbayboigadengadi", method = RequestMethod.GET)
    public List<ChuyenBay> timChuyenBayBoiGaDenVaGaDi() {
        List<ChuyenBay> chuyenBays = chuyenBayRepository.findChuyenBayByGaDiVaGaDen();
        if (chuyenBays == null) {
            ResponseEntity.notFound().build();
        }
        return chuyenBays;
    }

    //Cau 6
    @RequestMapping(value = "/cau6/{gaDi}", method = RequestMethod.GET)
    public String soChuyenBayXuatPhatTuSaiGon(@PathVariable("gaDi") String gaDi) {
        int soChuyenBay = chuyenBayRepository.findChuyenBayByGaDi(gaDi);
        if (soChuyenBay == 0) {
            ResponseEntity.notFound().build();
        }
        return "C?? " + soChuyenBay + " chuy???n bay xu???t ph??t t??? S??i G??n";
    }

    //Cau 7
    @RequestMapping(value = "/somayboeing", method = RequestMethod.GET)
    public String soLoaiMayBayBoeing() {
        int soLoaiMayBay = mayBayRepository.findLoaiMayBay();
        if (soLoaiMayBay == 0) {
            ResponseEntity.notFound().build();
        }
        return "T???ng s??? " + soLoaiMayBay + " m??y bay Boeing";
    }

    //Cau 8
    @RequestMapping(value = "/soluongnv", method = RequestMethod.GET)
    public String tongSoLuongNhanVien() {
        int soLuong = nhanVienRepository.tinhTongLuong();
        if (soLuong == 0) {
            ResponseEntity.notFound().build();
        }
        return "s??? l????ng c??c nh??n vi??n" + soLuong;
    }

    //Cau 9
    @RequestMapping(value = "/nvlaimaybayboeing", method = RequestMethod.GET)
    public List<String> maNhanVienLaiMayBayBoeing() {
        List<String> maNhanViens = nhanVienRepository.getMaByLoaiMayBay();
        if (maNhanViens == null) {
            ResponseEntity.notFound().build();
        }
        return maNhanViens;
    }

    //Cau 10
    @RequestMapping(value = "/nvmaybay747/{maMB}", method = RequestMethod.GET)
    public List<NhanVien> nhanVienLaiMayBay747(@PathVariable("maMB") int maMB) {
        List<NhanVien> nhanViens = nhanVienRepository.findNhanVienByMaMB(maMB);
        if (nhanViens == null) {
            ResponseEntity.notFound().build();
        }
        return nhanViens;
    }

    //Cau 12
    @RequestMapping(value = "/pcvualaiboeingairbus", method = RequestMethod.GET)
    public List<String> maPhiCongVuaLaiBoeingVuaLaiAirbus() {
        List<String> maPhiCongs = nhanVienRepository.getMaByLoaiMB();
        if (maPhiCongs == null) {
            ResponseEntity.notFound().build();
        }
        return maPhiCongs;
    }





}
