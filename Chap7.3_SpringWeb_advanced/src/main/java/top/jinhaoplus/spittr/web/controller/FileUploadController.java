package top.jinhaoplus.spittr.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/fileupload")
public class FileUploadController {

    @RequestMapping(method = RequestMethod.GET)
    public String uploadForm() {
        return "uploadForm";
    }

    // multipart类型的数据和表单相比是可以传输二进制的文件的，而且数据域会以分隔的形式传输到服务端，形如：
    /*
        ------WebKitFormBoundarybXPrMBjiDFvFEKLR
        Content-Disposition: form-data; name="firstName"

        Robert
        ------WebKitFormBoundarybXPrMBjiDFvFEKLR
        Content-Disposition: form-data; name="lastName"

        Mejia
        ------WebKitFormBoundarybXPrMBjiDFvFEKLR
        Content-Disposition: form-data; name="email"

        rocking2013@hotmail.com
        ------WebKitFormBoundarybXPrMBjiDFvFEKLR
        Content-Disposition: form-data; name="username"

        jinhaoplus
        ------WebKitFormBoundarybXPrMBjiDFvFEKLR
        Content-Disposition: form-data; name="password"

        111111
        ------WebKitFormBoundarybXPrMBjiDFvFEKLR
        Content-Disposition: form-data; name="profilePicture"; filename="aaa.png"
        Content-Type: image/png


        ------WebKitFormBoundarybXPrMBjiDFvFEKLR--
    */
    // @RequestPart用以接受multipart数据为MultipartFile类型的对象，这个对象是MultipartResolver解析出来的
    // MultipartFile还可以使用javax.servlet.http.Part来代替，而且不需要再配置MultipartResolver，因为走的是原生的serlvet 3.0的multipart数据解析
    // 1. 原生的serlvet 3.0支持会将multipart数据解析成Part对象
    // 2. Spring的MultipartResolver会将multipart数据解析成MultipartFile对象
    // 3. Jakarta Commons FileUpload的CommonsMultipartResolver会将multipart数据解析成MultipartFile对象
    @RequestMapping(method = RequestMethod.POST)
    public String processUpload(@RequestPart("file") MultipartFile file) {
        System.out.println("---->  " + file.getName() + "  ::  " + file.getSize());
        return "redirect:/";
    }

}
