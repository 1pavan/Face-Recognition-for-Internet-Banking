/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facerecnew1;


import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/*
 * @author mkyong
 *
 */
public class ImageTest {

	private static final int IMG_WIDTH = 100;
	private static final int IMG_HEIGHT =100;

	public static void main(String [] args){

	try{

		BufferedImage originalImage = ImageIO.read(new File("C:\\Users\\Manikandan\\Documents\\New Folder (2)\\FacDetectionOpenIMage\\src\\FaceOpenCV\\template5.jpg"));
		int type = originalImage.getType() == 0? BufferedImage.TYPE_BYTE_GRAY : originalImage.getType();

		BufferedImage resizeImageJpg = resizeImage(originalImage, type);
		ImageIO.write(resizeImageJpg, "jpg", new File("C:\\Users\\Manikandan\\Documents\\New Folder (2)\\FacDetectionOpenIMage\\src\\FaceOpenCV\\mkyong_jpg.jpg"));

		BufferedImage resizeImagePng = resizeImage(originalImage, type);
		ImageIO.write(resizeImagePng, "png", new File("C:\\Users\\Manikandan\\Documents\\New Folder (2)\\FacDetectionOpenIMage\\src\\FaceOpenCV\\mkyong_png.jpg"));

		BufferedImage resizeImageHintJpg = resizeImageWithHint(originalImage, type);
		ImageIO.write(resizeImageHintJpg, "jpg", new File("C:\\Users\\Manikandan\\Documents\\New Folder (2)\\FacDetectionOpenIMage\\src\\FaceOpenCV\\mkyong_hint_jpg.jpg"));

		BufferedImage resizeImageHintPng = resizeImageWithHint(originalImage, type);
		ImageIO.write(resizeImageHintPng, "png", new File("C:\\Users\\Manikandan\\Documents\\New Folder (2)\\FacDetectionOpenIMage\\src\\FaceOpenCV\\mkyong_hint_png.jpg"));

	}catch(IOException e){
		System.out.println(e.getMessage());
	}

    }

    private static BufferedImage resizeImage(BufferedImage originalImage, int type){
	BufferedImage resizedImage = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, type);
	Graphics2D g = resizedImage.createGraphics();
	g.drawImage(originalImage, 0, 0, IMG_WIDTH, IMG_HEIGHT, null);
	g.dispose();

	return resizedImage;
    }

    private static BufferedImage resizeImageWithHint(BufferedImage originalImage, int type){

	BufferedImage resizedImage = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, type);
	Graphics2D g = resizedImage.createGraphics();
	g.drawImage(originalImage, 0, 0, IMG_WIDTH, IMG_HEIGHT, null);
	g.dispose();
	g.setComposite(AlphaComposite.Src);

	g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
	RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	g.setRenderingHint(RenderingHints.KEY_RENDERING,
	RenderingHints.VALUE_RENDER_QUALITY);
	g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
	RenderingHints.VALUE_ANTIALIAS_ON);

	return resizedImage;
    }
    public  void resizeImg(String path,String name)
    {
    try{

		BufferedImage originalImage = ImageIO.read(new File(path+name+".jpg"));
		int type = originalImage.getType() == 0? BufferedImage.TYPE_BYTE_GRAY : originalImage.getType();

//		BufferedImage resizeImageJpg = resizeImage(originalImage, type);
//		ImageIO.write(resizeImageJpg, "jpg", new File("C:\\Users\\Manikandan\\Documents\\New Folder (2)\\FacDetectionOpenIMage\\src\\FaceOpenCV\\mkyong_jpg.jpg"));
//
//		BufferedImage resizeImagePng = resizeImage(originalImage, type);
//		ImageIO.write(resizeImagePng, "png", new File("C:\\Users\\Manikandan\\Documents\\New Folder (2)\\FacDetectionOpenIMage\\src\\FaceOpenCV\\mkyong_png.jpg"));
//
//		BufferedImage resizeImageHintJpg = resizeImageWithHint(originalImage, type);
//		ImageIO.write(resizeImageHintJpg, "jpg", new File("C:\\Users\\Manikandan\\Documents\\New Folder (2)\\FacDetectionOpenIMage\\src\\FaceOpenCV\\mkyong_hint_jpg.jpg"));

		BufferedImage resizeImageHintPng = resizeImageWithHint(originalImage, type);
		ImageIO.write(resizeImageHintPng, "png", new File(path+name+".jpg"));

	}catch(IOException e){
		System.out.println(e.getMessage());
	}
    }

}