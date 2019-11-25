package pl.dariusz.giza.springbootimageuploader;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@Service
public class ImageUploader {

    private Cloudinary cloudinary;

    public ImageUploader(){
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
            uploadResult = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return uploadResult.get("url").toString();
    }
}





