package com.zzq.tess4j.main.sb;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.util.ImageHelper;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * 识别图片中的文字返回
 */
public class SbImg {

    public String sb(String path,String language) throws  Exception{
        ITesseract instance = new Tesseract();
        if(language.equals("CN")){
            instance.setLanguage("chi_sim");
        }else if (language.equals("EN")){
            instance.setLanguage("eng");
        }

        //如果未将tessdata放在根目录下需要指定绝对路径
        //instance.setDatapath("the absolute path of tessdata");

        //如果需要识别英文之外的语种，需要指定识别语种，并且需要将对应的语言包放进项目中


        // 指定识别图片
        File imgDir = new File(path);
        long startTime = System.currentTimeMillis();
        String ocrResult = instance.doOCR(imgDir);

        return  ocrResult;
    }


}
