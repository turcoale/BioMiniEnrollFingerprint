package controllers;

import models.Device;
import models.FingerprintTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import services.DeviceService;
import services.FingerprintTemplateService;

import java.util.HashSet;

/**
 * Created by Користувач on 20.06.2017.
 */
@RestController
public class MainRestController implements MainController {

    DeviceService deviceService;
    FingerprintTemplateService fingerprintTemplateService;

    @Autowired
    public MainRestController(DeviceService deviceService, FingerprintTemplateService fingerprintTemplateService) {
        this.deviceService = deviceService;
        this.fingerprintTemplateService = fingerprintTemplateService;
    }

    @Override
    @RequestMapping("/getTemplate")
    public FingerprintTemplate getTemplate() {
        return fingerprintTemplateService.captureAndGetTemplate();
    }

    @Override
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public void saveImage(@RequestBody String path) {
        fingerprintTemplateService.saveImage(path);
    }

    @Override
    @RequestMapping("/deviceList")
    public HashSet<Device> deviceList() {
        return deviceService.deviceList();
    }

    @Override
    @RequestMapping(value = "/changeDevice", method = RequestMethod.POST)
    @ResponseBody
    public void changeDevice(@RequestBody Device device){
        deviceService.changeDevice(device);
    }
}
