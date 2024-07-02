package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import bean.DisplayLTCObject;
import service.CreditClassService;
import service.TeacherService;

@Controller
@RequestMapping("teacher")
public class TeacherCreditClassController {

    @RequestMapping("creditclass-management")
    public String lopTinChi(HttpServletRequest request, RedirectAttributes redirectAttributes, ModelMap model) {
        List<DisplayLTCObject> AllLTCList = TeacherService.getAllLTC();
        model.addAttribute("AllLTCList", AllLTCList);

        return "teacher/creditclass-management";
    }

    @RequestMapping("insertltc")
    public String insertCreditClass(@RequestParam("NIENKHOA") String NIENKHOA, @RequestParam("HOCKY") String hocky,
            @RequestParam("MAMH") String MAMH, @RequestParam("NHOM") String nhom,
            @RequestParam("MAGV") String MAGV, @RequestParam("MAKHOA") String MAKHOA,
            @RequestParam("SOSVTOITHIEU") String sosvtoithieu,
            RedirectAttributes redirectAttributes) {
        int HOCKY = Integer.parseInt(hocky);
        int NHOM = Integer.parseInt(nhom);
        int SOSVTOITHIEU = Integer.parseInt(sosvtoithieu);
        try {
            CreditClassService.insertCreditClass(NIENKHOA, HOCKY, MAMH, NHOM, MAGV, MAKHOA, SOSVTOITHIEU);
            redirectAttributes.addFlashAttribute("InsertLTCMsg", "Thêm lớp tín chỉ thành công");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("InsertLTCMsg", e.getMessage());
        }
        return "redirect:/teacher/creditclass-management.htm";
    }

    @RequestMapping("deleteltc")
    public String deleteCreditClass(@RequestParam("maltc") String MALTC, RedirectAttributes redirectAttributes) {
        int maltc = Integer.parseInt(MALTC);
        try {
            CreditClassService.deleteCreditClass(maltc);
            redirectAttributes.addFlashAttribute("DeleteLTCMsg", "Hủy lớp tín chỉ thành công");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("DeleteLTCMsg", e.getMessage());
        }
        return "redirect:/teacher/creditclass-management.htm";
    }

    @RequestMapping("updateltc")
    public String updateClass(@RequestParam("MALTC") String maltc, @RequestParam("NIENKHOA") String NIENKHOA,
            @RequestParam("HOCKY") String hocky, @RequestParam("NHOM") String nhom,
            @RequestParam("SOSVTOITHIEU") String sosvtoithieu, RedirectAttributes redirectAttributes) {
        int MALTC = Integer.parseInt(maltc);
        int HOCKY = Integer.parseInt(hocky);
        int NHOM = Integer.parseInt(nhom);
        int SOSVTOITHIEU = Integer.parseInt(sosvtoithieu);
        try {
            CreditClassService.updateCreditClass(MALTC, NIENKHOA, HOCKY, NHOM, SOSVTOITHIEU);
            redirectAttributes.addFlashAttribute("UpdateLTCMsg", "Sửa lớp tín chỉ thành công");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("UpdateLTCMsg", e.getMessage());
        }
        return "redirect:/teacher/creditclass-management.htm";
    }
}
