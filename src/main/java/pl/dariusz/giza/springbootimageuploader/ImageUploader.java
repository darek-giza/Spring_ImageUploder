package pl.dariusz.giza.springbootimageuploader;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dariusz.giza.springbootimageuploader.model.Image;
import pl.dariusz.giza.springbootimageuploader.repository.ImageRepo;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@Service
public class ImageUploader {

    private Cloudinary cloudinary;
    private ImageRepo imageRepo;


    @Autowired
    public ImageUploader(ImageRepo imageRepo) {
        this.imageRepo = imageRepo;
        cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "diru52xmn",
                "api_key", "573988193813775",
                "api_secret", "SfO_Pf9AAybHM-LqWbW__5g1pjY"

        ));
    }

    public String uploadFile(String path) {
        File file = new File(path);
        Map uploadResult = null;
        try {
            uploadResult = cloudinary.uploader()
                    .upload(file, ObjectUtils.emptyMap());
        } catch (IOException e) {
            e.printStackTrace();
        }
        String result = uploadResult.get("url").toString();

        saveImage(result);

        return result;
    }

    public void saveImage(String result) {
        imageRepo.save(new Image(result));

    }
}





