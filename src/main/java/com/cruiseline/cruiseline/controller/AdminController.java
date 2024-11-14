package com.cruiseline.cruiseline.controller;

import com.cruiseline.cruiseline.dto.CabinClassDTO;
import com.cruiseline.cruiseline.dto.CountryDTO;
import com.cruiseline.cruiseline.dto.mapper.realization.*;
import com.cruiseline.cruiseline.entity.*;
import com.cruiseline.cruiseline.exception.*;
import com.cruiseline.cruiseline.service.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    private CruiseServiceImpl cruiseService;

    @Autowired
    private CruiseDTOMapper cruiseDTOMapper;

    @Autowired
    private CruiseLinerServiceImpl cruiseLinerService;

    @Autowired
    private CruiseLinerDTOMapper cruiseLinerDTOMapper;

    @Autowired
    private CityServiceImpl cityService;

    @Autowired
    private CityDTOMapper cityDTOMapper;

    @Autowired
    private CountryServiceImpl countryService;

    @Autowired
    private CountryDTOMapper countryDTOMapper;

    @Autowired
    private CabinClassServiceImpl cabinClassService;

    @Autowired
    private CabinClassDTOMapper cabinClassDTOMapper;

    //cruise------------------------------------------------------------------------------------------------------------

    @GetMapping(value = "/cruises")
    public String getAllCruises(Model model) {
        model.addAttribute("cruiseDTOList", cruiseDTOMapper.mapToDTOList(cruiseService.getAllCruises()));
        return "/admin/cruise/show-cruises";
    }

    @GetMapping(value = "/save_cruise")
    public String addCruise(Model model) {
        Cruise cruise = new Cruise();
        cruise.getDestinations().add(new Destination());
        cruise.getDestinations().add(new Destination());
        model.addAttribute("cruise", cruise);
        prepareEntities(model);
        return "/admin/cruise/add-cruise";
    }

    @PostMapping(value = "/save_cruise", params = {"addEndRow"})
    public String addCruiseDestination(@ModelAttribute("cruise") Cruise cruise,
                                       Model model) {
        cruise.getDestinations().add(cruise.getDestinations().size() - 1, new Destination());
        prepareEntities(model);
        return "/admin/cruise/add-cruise";
    }

    @PostMapping(value = "/save_cruise", params = {"addRow"})
    public String addCruiseDestination(@ModelAttribute("cruise") Cruise cruise,
                                       HttpServletRequest httpServletRequest,
                                       Model model) {
        int rowId = Integer.parseInt(httpServletRequest.getParameter("addRow"));
        cruise.getDestinations().add(rowId + 1, new Destination());
        prepareEntities(model);
        return "/admin/cruise/add-cruise";
    }

    @PostMapping(value = "/save_cruise", params = {"removeRow"})
    public String removeCruiseDestination(@ModelAttribute("cruise") Cruise cruise,
                                          HttpServletRequest httpServletRequest,
                                          Model model) {
        int rowId = Integer.parseInt(httpServletRequest.getParameter("removeRow"));
        cruise.getDestinations().remove(rowId);
        prepareEntities(model);
        return "/admin/cruise/add-cruise";
    }

    @PostMapping(value = "/save_cruise", params = {"saveCruise"})
    public String addCruise(@Valid @ModelAttribute("cruise") Cruise cruise,
                            BindingResult bindingResult,
                            Model model) {
        if (bindingResult.hasErrors()) {
            prepareEntities(model);
            return "/admin/cruise/add-cruise";
        }
        cruiseService.addCruise(cruise);
        return "redirect:/admin/cruises";
    }

    @GetMapping(value = "/update_cruise/{id}")
    public String updateCruise(@PathVariable("id") Long cruiseId,
                               Model model) {
        try {
            model.addAttribute("cruise", cruiseService.getCruiseById(cruiseId));
            prepareEntities(model);
        } catch (NoSuchCruiseExistsException e) {
            e.printStackTrace();
            return "redirect:/admin/cruises";
        }
        return "/admin/cruise/update-cruise";
    }

    @PostMapping(value = "/update_cruise/{id}", params = {"addEndRow"})
    public String addUpdatedCruiseDestination(@ModelAttribute("cruise") Cruise cruise,
                                              Model model) {
        cruise.getDestinations().add(cruise.getDestinations().size() - 1, new Destination());
        prepareEntities(model);
        return "/admin/cruise/update-cruise";
    }

    @PostMapping(value = "/update_cruise/{id}", params = {"addRow"})
    public String addUpdatedCruiseDestination(@ModelAttribute("cruise") Cruise cruise,
                                              HttpServletRequest httpServletRequest,
                                              Model model) {
        int rowId = Integer.parseInt(httpServletRequest.getParameter("addRow"));
        cruise.getDestinations().add(rowId + 1, new Destination());
        prepareEntities(model);
        return "/admin/cruise/update-cruise";
    }

    @PostMapping(value = "/update_cruise/{id}", params = {"removeRow"})
    public String removeUpdatedCruiseDestination(@ModelAttribute("cruise") Cruise cruise,
                                                 HttpServletRequest httpServletRequest,
                                                 Model model) {
        int rowId = Integer.parseInt(httpServletRequest.getParameter("removeRow"));
        cruise.getDestinations().remove(rowId);
        prepareEntities(model);
        return "/admin/cruise/update-cruise";
    }

    @PostMapping(value = "/update_cruise/{id}", params = {"updateCruise"})
    public String updateCruise(@PathVariable("id") Long cruiseId,
                               @Valid @ModelAttribute("cruise") Cruise cruise,
                               BindingResult bindingResult,
                               Model model) {
        if (bindingResult.hasErrors()) {
            prepareEntities(model);
            return "/admin/cruise/update-cruise";
        }
        try {
            cruiseService.copyAndUpdateCruiseById(cruiseId, cruise);
        } catch (NoSuchCruiseExistsException e) {
            e.printStackTrace();
            return "/admin/cruise/update-cruise";
        }
        return "redirect:/admin/cruises";
    }

    @GetMapping(value = "/delete_cruise/{id}")
    public String deleteCruise(@PathVariable("id") Long id) {
        cruiseService.removeCruiseById(id);
        return "redirect:/admin/cruises";
    }

    public void prepareEntities(Model model) {
        model.addAttribute("cruiseLiners", cruiseLinerService.getAllCruiseLiners());
        model.addAttribute("cities", cityService.getAllCities());
    }

    //cruiseLiner-------------------------------------------------------------------------------------------------------

    @GetMapping(value = "/cruise_liners")
    public String getAllCruiseLiners(Model model) {
        model.addAttribute("cruiseLinerDTOList", cruiseLinerDTOMapper.mapToDTOList(cruiseLinerService.getAllCruiseLiners()));
        return "/admin/cruise-liner/show-cruise-liners";
    }

    @GetMapping(value = "/save_cruise_liner")
    public String addCruiseLiner(Model model) {
        model.addAttribute("cruiseLiner", new CruiseLiner());
        return "/admin/cruise-liner/add-cruise-liner";
    }

    @PostMapping(value = "/save_cruise_liner", params = {"addEndRow"})
    public String addCruiseLinerCabin(@ModelAttribute("cruiseLiner") CruiseLiner cruiseLiner,
                                      Model model) {
        cruiseLiner.getCabins().add(cruiseLiner.getCabins().size() - 1, new Cabin());
        model.addAttribute("cabinClasses", cabinClassService.getAllCabinClasses());
        return "/admin/cruise-liner/add-cruise-liner";
    }

    @PostMapping(value = "/save_cruise_liner", params = {"addRow"})
    public String addCruiseLinerCabin(@ModelAttribute("cruiseLiner") CruiseLiner cruiseLiner,
                                      HttpServletRequest httpServletRequest,
                                      Model model) {
        int rowId = Integer.parseInt(httpServletRequest.getParameter("addRow"));
        cruiseLiner.getCabins().add(rowId + 1, new Cabin());
        model.addAttribute("cabinClasses", cabinClassService.getAllCabinClasses());
        return "/admin/cruise-liner/add-cruise-liner";
    }

    @PostMapping(value = "/save_cruise_liner", params = {"removeRow"})
    public String removeCruiseLinerCabin(@ModelAttribute("cruiseLiner") CruiseLiner cruiseLiner,
                                         HttpServletRequest httpServletRequest,
                                         Model model) {
        int rowId = Integer.parseInt(httpServletRequest.getParameter("removeRow"));
        cruiseLiner.getCruises().remove(rowId);
        model.addAttribute("cabinClasses", cabinClassService.getAllCabinClasses());
        return "/admin/cruise-liner/add-cruise-liner";
    }

    @PostMapping(value = "/save_cruise_liner", params = {"saveCruiseLiner"})
    public String addCruiseLiner(@Valid @ModelAttribute("cruiseLiner") CruiseLiner cruiseLiner,
                                 BindingResult bindingResult,
                                 Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("cabinClasses", cabinClassService.getAllCabinClasses());
            return "/admin/cruise-liner/add-cruise-liner";
        }
        cruiseLinerService.addCruiseLiner(cruiseLiner);
        return "redirect:/admin/cruise_liners";
    }

    @GetMapping(value = "/update_cruise_liner/{id}")
    public String updateCruiseLiner(@PathVariable("id") Long cruiseLinerId,
                                    Model model) {
        try {
            model.addAttribute("cruiseLiner", cruiseLinerService.getCruiseLinerById(cruiseLinerId));
        } catch (NoSuchCruiseLinerExistsException e) {
            e.printStackTrace();
            return "redirect:/admin/cruise_liners";
        }
        return "/admin/cruise-liner/update-cruise-liner";
    }

    @PostMapping(value = "/update_cruise_liner/{id}", params = {"addEndRow"})
    public String addUpdatedCruiseLinerCabin(@ModelAttribute("cruiseLiner") CruiseLiner cruiseLiner,
                                             Model model) {
        cruiseLiner.getCabins().add(cruiseLiner.getCabins().size() - 1, new Cabin());
        model.addAttribute("cabinClasses", cabinClassService.getAllCabinClasses());
        return "/admin/cruise-liner/update-cruise-liner";
    }

    @PostMapping(value = "/update_cruise_liner/{id}", params = {"addRow"})
    public String addUpdatedCruiseLinerCabin(@ModelAttribute("cruiseLiner") CruiseLiner cruiseLiner,
                                             HttpServletRequest httpServletRequest,
                                             Model model) {
        int rowId = Integer.parseInt(httpServletRequest.getParameter("addRow"));
        cruiseLiner.getCabins().add(rowId + 1, new Cabin());
        model.addAttribute("cabinClasses", cabinClassService.getAllCabinClasses());
        return "/admin/cruise-liner/update-cruise-liner";
    }

    @PostMapping(value = "/update_cruise_liner/{id}", params = {"removeRow"})
    public String removeUpdatedCruiseLinerCabin(@ModelAttribute("cruiseLiner") CruiseLiner cruiseLiner,
                                                HttpServletRequest httpServletRequest,
                                                Model model) {
        int rowId = Integer.parseInt(httpServletRequest.getParameter("removeRow"));
        cruiseLiner.getCruises().remove(rowId);
        model.addAttribute("cabinClasses", cabinClassService.getAllCabinClasses());
        return "/admin/cruise-liner/update-cruise-liner";
    }

    @PostMapping(value = "/update_cruise_liner/{id}", params = {"updateCruiseLiner"})
    public String updateCruiseLiner(@PathVariable("id") Long cruiseLinerId,
                                    @Valid @ModelAttribute("cruiseLiner") CruiseLiner cruiseLiner,
                                    BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/admin/cruise-liner/update-cruise-liner";
        }
        try {
            cruiseLinerService.copyAndUpdateCruiseLinerById(cruiseLinerId, cruiseLiner);
        } catch (NoSuchCruiseLinerExistsException e) {
            e.printStackTrace();
            return "/admin/cruise-liner/update-cruise-liner";
        }
        return "redirect:/admin/cruise_liners";
    }

    @GetMapping(value = "/delete_cruise_liner/{id}")
    public String deleteCruiseLiner(@PathVariable("id") Long cruiseLinerId) {
        cruiseLinerService.removeCruiseLinerById(cruiseLinerId);
        return "redirect:/admin/cruise_liners";
    }

    //city--------------------------------------------------------------------------------------------------------------

    @GetMapping(value = "/cities")
    public String getAllCities(Model model) {
        model.addAttribute("cityDTOList", cityDTOMapper.mapToDTOList(cityService.getAllCities()));
        return "/admin/city/show-cities";
    }

    @GetMapping(value = "/save_city")
    public String addCity(Model model) {
        model.addAttribute("countries", countryService.getAllCountries());
        model.addAttribute("city", new City());
        return "/admin/city/add-city";
    }

    @PostMapping(value = "/save_city")
    public String addCity(@Valid @ModelAttribute("city") City city,
                          BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/admin/city/add-city";
        }
        cityService.addCity(city);
        return "redirect:/admin/cities";
    }

    @GetMapping(value = "/update_city/{id}")
    public String updateCity(@PathVariable("id") Long cityId,
                             Model model) {
        try {
            model.addAttribute("city", cityService.getCityById(cityId));
            model.addAttribute("countries", countryService.getAllCountries());
        } catch (NoSuchCityExistsException e) {
            e.printStackTrace();
            return "redirect:/admin/cities";
        }
        return "/admin/city/update-city";
    }

    @PostMapping(value = "/update_city/{id}")
    public String updateCity(@PathVariable("id") Long cityId,
                             @Valid @ModelAttribute("city") City city,
                             BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/admin/city/update-city";
        }
        try {
            cityService.copyAndUpdateCityById(cityId, city);
        } catch (NoSuchCityExistsException e) {
            e.printStackTrace();
            return "/admin/city/update-city";
        }
        return "redirect:/admin/cities";
    }

    @GetMapping(value = "/delete_city/{id}")
    private String deleteCity(@PathVariable("id") Long cityId,
                              Model model) {
        try {
            if (cityService.isBooked(cityId)) {
                model.addAttribute("message", true);
                return "/admin/city/show-cities";
            }
        } catch (NoSuchCityExistsException e) {
            e.printStackTrace();
            return "redirect:/admin/cities";
        }
        cityService.removeCityById(cityId);
        return "redirect:/admin/cities";
    }

    //country---------------------------------------------------------------------------------------------------------

    @GetMapping(value = "/countries")
    public String getAllCountries(Model model) {
        model.addAttribute("countryDTOList", countryDTOMapper.mapToDTOList(countryService.getAllCountries()));
        return "/admin/country/show-countries";
    }

    @GetMapping(value = "/save_country")
    public String addCountry(Model model) {
        model.addAttribute("countryDTO", new CountryDTO());
        return "/admin/country/add-country";
    }

    @PostMapping(value = "/save_country")
    public String addCountry(@Valid @ModelAttribute("countryDTO") CountryDTO countryDTO,
                             BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/admin/country/add-country";
        }
        countryService.addCountry(countryDTOMapper.mapToEntity(countryDTO));
        return "redirect:/admin/countries";
    }

    @GetMapping(value = "/update_country/{id}")
    public String updateCountry(@PathVariable("id") Long countryId,
                                Model model) {
        try {
            model.addAttribute("countryDTO", countryDTOMapper.mapToDTO(countryService.getCountryById(countryId)));
        } catch (NoSuchCountryExistsException e) {
            e.printStackTrace();
            return "redirect:/admin/countries";
        }
        return "/admin/country/update-country";
    }

    @PostMapping(value = "/update_country/{id}")
    public String updateCountry(@PathVariable("id") Long countryId,
                                @Valid @ModelAttribute("countryDTO") CountryDTO countryDTO,
                                BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/admin/country/update-country";
        }
        try {
            countryService.copyAndUpdateCountryById(countryId, countryDTOMapper.mapToEntity(countryDTO));
        } catch (NoSuchCountryExistsException e) {
            e.printStackTrace();
            return "/admin/country/update-country";
        }
        return "redirect:/admin/countries";
    }

    @GetMapping(value = "/delete_country/{id}")
    private String deleteCountry(@PathVariable("id") Long countryId,
                                 Model model) {
        try {
            if (countryService.hasBookedCity(countryId)) {
                model.addAttribute("message", true);
                return "/admin/country/show-countries";
            }
        } catch (NoSuchCountryExistsException e) {
            e.printStackTrace();
            return "redirect:/admin/countries";
        }
        countryService.removeCountryById(countryId);
        return "redirect:/admin/countries";
    }

    //cabinClass--------------------------------------------------------------------------------------------------------

    @GetMapping(value = "/cabin_classes")
    private String getAllCabinClasses(Model model) {
        model.addAttribute("cabinClassDTOList", cabinClassDTOMapper.mapToDTOList(cabinClassService.getAllCabinClasses()));
        return "/admin/cabin-class/show-cabin-classes";
    }

    @GetMapping(value = "/save_cabin_class")
    private String addCabinClass(Model model) {
        model.addAttribute("cabinClassDTO", new CabinClassDTO());
        return "/admin/cabin-class/add-cabin-class";
    }

    @PostMapping(value = "/save_cabin_class")
    private String addCabinClass(@Valid @ModelAttribute("cabinClassDTO") CabinClassDTO cabinClassDTO,
                                 BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/admin/cabin-class/add-cabin-class";
        }
        cabinClassService.addCabinClass(cabinClassDTOMapper.mapToEntity(cabinClassDTO));
        return "redirect:/admin/cabin_classes";
    }

    @GetMapping(value = "/update_cabin_class/{id}")
    private String updateCabinClass(@PathVariable("id") Long cabinClassId,
                                    Model model) {
        try {
            model.addAttribute("cabinClassDTO", cabinClassDTOMapper.mapToDTO(cabinClassService.getCabinClassById(cabinClassId)));
        } catch (NoSuchCabinClassExistsException e) {
            e.printStackTrace();
            return "redirect:/admin/cabin_classes";
        }
        return "/admin/cabin-class/update-cabin-class";
    }

    @PostMapping(value = "/update_cabin_class/{id}")
    private String updateCabinClass(@PathVariable("id") Long cabinClassId,
                                    @Valid @ModelAttribute("cabinClassDTO") CabinClassDTO cabinClassDTO,
                                    BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/admin/cabin-class/update-cabin-class";
        }
        try {
            cabinClassService.copyAndUpdateCabinClassById(cabinClassId, cabinClassDTOMapper.mapToEntity(cabinClassDTO));
        } catch (NoSuchCabinClassExistsException e) {
            e.printStackTrace();
            return "/admin/cabin-class/update-cabin-class";
        }
        return "redirect:/admin/cabin_classes";
    }

    @GetMapping(value = "/delete_cabin_class/{id}")
    private String deleteCabinClass(@PathVariable("id") Long cabinClassId,
                                    Model model) {
        try {
            if (cabinClassService.isBooked(cabinClassId)) {
                model.addAttribute("message", true);
                return "/admin/cabin-class/show-cabin-classes";
            }
        } catch (NoSuchCabinClassExistsException e) {
            e.printStackTrace();
            return "redirect:/admin/cabin_classes";
        }
        cabinClassService.removeCabinClassById(cabinClassId);
        return "redirect:/admin/cabin_classes";
    }
}
