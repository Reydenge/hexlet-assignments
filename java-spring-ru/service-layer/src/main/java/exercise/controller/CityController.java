package exercise.controller;

import exercise.CityNotFoundException;
import exercise.model.City;
import exercise.repository.CityRepository;
import exercise.service.WeatherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class CityController {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private WeatherService weatherService;

    // BEGIN
    @GetMapping("/cities/{id}")
    public Map<String, String> getCityWeather(@PathVariable(name = "id") long id) {
        City city = cityRepository.findById(id).orElseThrow(() -> new CityNotFoundException("City not found"));
        return weatherService.getWeather(city);
    }

    @GetMapping("/search")
    public List<Map<String, String>> getCitiesWeather(@RequestParam(required = false, defaultValue = "") String name) {
        List<City> cities = cityRepository.findByNameStartsWithIgnoreCase(name);
        return cities.stream()
                .map(c -> {
                    Map<String, String> weatherForecast = weatherService.getWeather(c);
                    Map<String, String> cityWeather = new HashMap<>();
                    cityWeather.put("temperature", weatherForecast.get("temperature"));
                    cityWeather.put("name", weatherForecast.get("name"));
                    return cityWeather;
                }).sorted(Comparator.comparing(x -> x.get("name"))).toList();
    }
    // END
}

