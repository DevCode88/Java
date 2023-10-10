import java.awt.Graphics2D;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class RotateImage {

    public static BufferedImage rotate(BufferedImage image) {
        AffineTransform transform = new AffineTransform();
        transform.rotate(Math.PI / 2, image.getWidth() / 2, image.getHeight() / 2);
        AffineTransformOp op = new AffineTransformOp(transform, AffineTransformOp.TYPE_BICUBIC);
        return op.filter(image, null);
    }

    public static void main(String[] args) throws IOException {
        BufferedImage image = ImageIO.read(new File("image.png"));
        BufferedImage rotatedImage = rotate(image);
        ImageIO.write(rotatedImage, "png", new File("rotatedImage.png"));
    }
}
