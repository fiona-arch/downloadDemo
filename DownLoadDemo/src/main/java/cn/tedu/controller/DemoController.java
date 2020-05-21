package cn.tedu.controller;


import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.net.URLEncoder;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoController {
	
	@RequestMapping("/download.do")
	@ResponseBody
	public byte[] download(HttpServletResponse response) throws Exception {
		String fileName="演示图片.png";
		fileName=URLEncoder.encode(fileName, "utf-8");
		response.setContentType("image/png");
		response.setHeader("Content-Disposition","attachment; filename=\""+fileName+"\"");
		byte []bytes=createPNG();
		return bytes;
	}
	
	private byte[] createPNG()throws Exception{
		BufferedImage image=new BufferedImage(100,50,BufferedImage.TYPE_3BYTE_BGR);
		image.setRGB(50,25,0xffff00);
		ByteArrayOutputStream out=new ByteArrayOutputStream();
		ImageIO.write(image, "png", out);
		out.close();
		byte []png=out.toByteArray();
		return png;
	}
}
