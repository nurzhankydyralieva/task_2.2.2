package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.dao.CarDaoImpl;

@Controller
public class CarsController {
    private CarDaoImpl carDao;

    public CarsController(CarDaoImpl carDao) {
        this.carDao = carDao;
    }

    @GetMapping("/cars")
    public String count(@RequestParam(value = "count", required = false) Integer count, Model model) {
        model.addAttribute("cars", carDao.getCountCar(count));
        return "cars";
    }
}
