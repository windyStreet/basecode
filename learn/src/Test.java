import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author windyStreet
 * @codetime 2021-03-23 11:52
 */
public class Test {
    public static void main(String[] args) {
//        public static void DrawString(BufferedImage Image, Color c, int ft, int size, String drawstring, int x, int y)
//        BufferedImage Image = new BufferedImage(10, 100, 2);

        BufferedImage image = new BufferedImage(1920, 1080, BufferedImage.TYPE_INT_RGB);
        String drawstring = "你好 啟 啓";
        Graphics2D gg = (Graphics2D) image.getGraphics();//
        gg.setColor(new Color(255, 255, 255));
        Font font = new Font("宋体", 200, 30);
        gg.setFont(font);
        gg.drawString(drawstring, 100, 1000);
        gg.dispose();
        String filePath = "./out.png";
        CompressedImg(filePath, image);
    }


    public static void CompressedImg(String FilePath, BufferedImage Image) {
        FileOutputStream out = null;
        try {
            /* 压缩之后临时存放位置 */
            out = new FileOutputStream(FilePath);

            // @huangkb 2019-8-27 08:55:45 添加根据jdk版本不同，使用不同的方法
//            if (JdkVersion.isJava8()) {
                /** 1.8 */
                ImageIO.write(Image, "jpg", out);
//            } else {
//                /** 1.6 */
//                JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
//                JPEGEncodeParam jep = JPEGCodec.getDefaultJPEGEncodeParam(Image);
//                /* 压缩质量 */
//                jep.setQuality(0.8f, true);// 1.0f最适合
//                encoder.encode(Image, jep);
//            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}

//				UtilPrint.CompressedImg(filePath,initImage);