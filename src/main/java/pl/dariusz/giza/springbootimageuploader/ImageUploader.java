package pl.dariusz.giza.springbootimageuploader;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

@Service
public class imageUploader {


    private Cloudinary cloudinary;

    public imageUploader() throws FileNotFoundException {
        Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "diru52xmn",
                "api_key", "573988193813775",
                "api_secret", "SfO_Pf9AAybHM-LqWbW__5g1pjY"
        ));

    }

    public String get(String path) {
        try {
            File toUpload = new File(ResourceUtils.getFile("classpath:images/zrzut1.png").toURI());

            Map uploadResult = cloudinary.uploader().upload(toUpload, ObjectUtils.emptyMap());

        } catch (IOException e) {
            e.printStackTrace();
        } return "";
    }
}
