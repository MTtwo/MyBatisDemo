package com.etc.test;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import java.io.File;
import java.io.IOException;

public class ExceleTest {
    public static void main(String[] args) {
        //设置表头
        String[] title = {"id", "name", "sex"};
        //创建excel文件
        String fileName = "jxl_text";
        checkExist("d:/jxl_text.xls");
        File file = new File("d:/" + fileName + ".xls");
//        try {
//            file.createNewFile();
//            //创建工作簿
//            WritableWorkbook workBook = Workbook.createWorkbook(file);
//            WritableSheet sheet = workBook.createSheet("Sheet1", 0);
//            Label label = null;
//            //第一行设置列名,第一行的时候for循环中的i要为0
//            for (int i = 0; i < title.length; i++) {
//                label = new Label(i, 0, title[i]);//第几列：i，第几行：0，值：title[i]
//                sheet.addCell(label);
//            }
//            //追加数据
//            for (int i = 1; i < 10; i++) {
//                label = new Label(0, i, "a" + 1);//第几列：0，第几行：i，值：a1
//                sheet.addCell(label);
//                label = new Label(1, i, "user" + 1);//第几列：1，第几行：i，值：user1
//                sheet.addCell(label);
//                label = new Label(2, i, "男");//第几列：2，第几行：i，值：男
//                sheet.addCell(label);
//            }
//            //写入数据
//            workBook.write();
//            //关闭流
//            workBook.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (WriteException e) {
//            e.printStackTrace();
//        }
    }

    /**
     * 检查该路径下是否存在文件
     *
     * @param filepath
     * @return
     */
    public static File checkExist(String filepath) {
        File file = new File(filepath);
        try {
            if (file.exists()) {
                //判断文件目录的存在
                System.out.println("文件夹存在!");
                if (file.isDirectory()) {
                    //判断文件的存在性
                    System.out.println("文件存在!");
                } else {
                    file.createNewFile();//创建文件
                    System.out.println("文件不存在，创建文件成功!");
                }
            } else {
                System. out .println("文件夹不存在!");
                File file2 = new File(file.getParent());
                file2.mkdirs();
                System. out .println("创建文件夹成功!");
                if(file.isDirectory()){
                    System. out .println("文件存在!");
                }else{
                    file.createNewFile();//创建文件
                    System.out.println("文件不存在，创建文件成功!");}
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }
}
