package com.dee.basekit.util.test;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import com.xuggle.mediatool.IMediaWriter;
import com.xuggle.mediatool.ToolFactory;
import com.xuggle.xuggler.ICodec;

public class PhotoToVideoConverter {
    public static void main(String[] args) throws IOException {
        String inputPath = "path/to/photos/"; // 输入照片的路径
        String outputPath = "path/to/output/video.mp4"; // 输出视频的路径
        int frameRate = 30; // 视频帧率
        int videoWidth = 640; // 视频宽度
        int videoHeight = 480; // 视频高度

        // 创建IMediaWriter对象
        IMediaWriter writer = ToolFactory.makeWriter(outputPath);

        // 设置视频编码器和视频格式
        writer.addVideoStream(0, 0, ICodec.ID.CODEC_ID_H264, videoWidth, videoHeight);

        // 读取照片并将其添加到视频中
        File[] files = new File(inputPath).listFiles();
        for (File file : files) {
            BufferedImage image = ImageIO.read(file);
            writer.encodeVideo(0, image, System.nanoTime() / 1000, null);
        }

        // 关闭IMediaWriter对象
        writer.close();
    }
}
