package facegui;

import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import org.apache.commons.io.FileUtils;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;
import org.opencv.videoio.VideoCapture;

public class DetectFace extends Thread{
    int countg=0;
	 JFrame frame;
	 JLabel lbl;
	 ImageIcon icon;
         String name;
    public DetectFace(String name)
    {
        this.name=name;
    }
 
 public  void run()
 {
    System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

		CascadeClassifier cascadeFaceClassifier = new CascadeClassifier(
				"D:\\Face Recognition\\haarcascade_frontalface_default.xml");
		CascadeClassifier cascadeEyeClassifier = new CascadeClassifier(
				"D:\\Face Recognition\\haarcascade_lefteye_2splits.xml");
		
		VideoCapture videoDevice = new VideoCapture();
		videoDevice.open(0);
		if (videoDevice.isOpened()) {
                int i=0;
                int ii=0;
                 try { 
                     new  File("C:\\Users\\PAVAN VARMA\\Documents\\NetBeansProjects\\WebApp\\faceDb1\\"+name).mkdir();
                      new File("C:\\Users\\PAVAN VARMA\\Documents\\NetBeansProjects\\WebApp\\faceDb1\\"+name+"\\face").mkdir();
        } catch (Exception ex) {
            Logger.getLogger(ExistUser.class.getName()).log(Level.SEVERE, null, ex);
        }
                  try { 
                       new File("C:\\Users\\PAVAN VARMA\\Documents\\NetBeansProjects\\WebApp\\faceDb1\\"+name+"\\eye").mkdir();
        } catch (Exception ex) {
            Logger.getLogger(ExistUser.class.getName()).log(Level.SEVERE, null, ex);
        }
			while (true) {		
                            
				Mat frameCapture = new Mat();
                                
				videoDevice.read(frameCapture);
                                 Rect rect_Crop1=null;
				MatOfRect faces = new MatOfRect();
				cascadeFaceClassifier.detectMultiScale(frameCapture, faces);								
				
                                for (Rect rect : faces.toArray()) {
					Imgproc.putText(frameCapture, "Face", new Point(rect.x,rect.y-5), 1, 2, new Scalar(0,0,255));								
					Imgproc.rectangle(frameCapture, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height),
							new Scalar(0, 100, 0),3);
                                        
                                          rect_Crop1 = new Rect(rect.x, rect.y, rect.width, rect.height);
                                        Mat image_roi = new Mat(frameCapture,rect_Crop1);
                                          Mat gray=new Mat(image_roi.size(),CvType.CV_8UC1);
                                        Imgproc.cvtColor(image_roi, gray, Imgproc.COLOR_RGBA2GRAY,0);
                                          Mat res=resize(gray);
 
  if(i<50){
       Imgcodecs.imwrite("C:\\Users\\PAVAN VARMA\\Documents\\NetBeansProjects\\WebApp\\faceDb1\\"+name+"\\face\\"+i+".jpg",res);
  i++;
  countg++;
  }
  else{
      frame.dispose();
  }
				}
				
				MatOfRect eyes = new MatOfRect();
				cascadeEyeClassifier.detectMultiScale(frameCapture,eyes);
                                int count=0;
                                Rect rect_Crop=null;
				for (Rect rect : eyes.toArray()) {
                                        System.out.println("Size"+eyes.size());
                                        if(count<=1){
					Imgproc.putText(frameCapture, "Eye", new Point(rect.x,rect.y-5), 1, 2, new Scalar(0,0,255));				
					Imgproc.rectangle(frameCapture, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height),
							new Scalar(200, 200, 100),2);
rect_Crop = new Rect(rect.x, rect.y, rect.width, rect.height);
                                        Mat image_roi = new Mat(frameCapture,rect_Crop);
                                          Mat gray=new Mat(image_roi.size(),CvType.CV_8UC1);
                                        Imgproc.cvtColor(image_roi, gray, Imgproc.COLOR_RGBA2GRAY,0);
                                        Mat res=resize(gray);
                                        
  if(ii<50)
  {
                                        Imgcodecs.imwrite("C:\\Users\\PAVAN VARMA\\Documents\\NetBeansProjects\\WebApp\\faceDb1\\"+name+"\\eye\\"+ii+".jpg",res);
  ii++;
  countg++;
  }
  else
  {
      frame.dispose();
  }
  if(countg==100)
  {
      videoDevice.release();
  }
                                        }
                                       count++;  
                                         
				}
				
				PushImage(ConvertMat2Image(frameCapture));
			}
		} else {
			System.out.println("Video Device not ready");
			return;
		}
 }
	public static void main(String[] args) throws IOException {
	}
        public static Mat resize(Mat src_img) 
 { 
  double h = 100; 
  double w = 100; 
  Size size= new Size(100,100); 
  Imgproc.resize(src_img, src_img, size); 
  return src_img; 
 } 
 
	private static BufferedImage ConvertMat2Image(Mat kameraVerisi) {
	
		
		MatOfByte byteMatVerisi = new MatOfByte();
		Imgcodecs.imencode(".jpg", kameraVerisi, byteMatVerisi);
		byte[] byteArray = byteMatVerisi.toArray();
		BufferedImage goruntu = null;
		try {
			InputStream in = new ByteArrayInputStream(byteArray);
			goruntu = ImageIO.read(in);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return goruntu;
	}
  	
	public  void PencereHazirla() {
		frame = new JFrame();
		frame.setLayout(new FlowLayout());
		frame.setSize(700, 600);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public  void PushImage(Image img2) {
		if (frame == null)
			PencereHazirla();
		if (lbl != null)
			frame.remove(lbl);
		icon = new ImageIcon(img2);
		lbl = new JLabel();
		lbl.setIcon(icon);
		frame.add(lbl);
		frame.revalidate(); 
	}
}