/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managedBeans;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

/**
 *
 * @author Verónica
 */

public class ImagenesMb {

    private List<String> images;
     
    @PostConstruct
    public void init() {
        images = new ArrayList<>();
        for (int i = 1; i <= 7; i++) {
            images.add("images" + i + ".jpg");
        }
    }
 
    public List<String> getImages() {
        return images;
    }
}    

