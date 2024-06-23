import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.bytedeco.ffmpeg.global.avutil;
import org.bytedeco.javacv.FFmpegFrameRecorder;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.Java2DFrameConverter;

public class PhotoToVideoConverter {
    public static void main(String[] args) throws IOException {
        String inputPath = "path/to/photos/"; // 输入照片的路径
        String outputPath = "path/to/output/video.mp4"; // 输出视频的路径
        int frameRate = 30; // 视频帧率
        int videoWidth = 640; // 视频宽度
        int videoHeight = 480; // 视频高度

        // 创建FFmpegFrameRecorder对象
        FFmpegFrameRecorder recorder = new FFmpegFrameRecorder(outputPath, videoWidth, videoHeight);

        // 设置视频编码器和视频格式
        recorder.setVideoCodecName("libx264");
        recorder.setFormat("mp4");
        recorder.setFrameRate(frameRate);
        recorder.setPixelFormat(avutil.AV_PIX_FMT_YUV420P);

        // 开始录制视频
        recorder.start();

        // 读取照片并将其添加到视频中
        File[] files = new File(inputPath).listFiles();
        for (File file : files) {
            BufferedImage image = ImageIO.read(file);
            Frame frame = new Java2DFrameConverter().convert(image);
            recorder.record(frame);
        }

        // 停止录制视频
        recorder.stop();
        recorder.release();
    }
}
