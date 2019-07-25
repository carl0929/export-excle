package com.hhawking.excel.demo.service;

import com.hhawking.excel.demo.dao.UserDao;
import com.hhawking.excel.demo.entity.User;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public void testExcel(HttpServletResponse response,String name) throws IOException {
        List<User> list = userDao.getUserList();

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("用户信息");
        HSSFRow title = sheet.createRow(0);
        HSSFCell title0 = title.createCell(0);
        HSSFCell title1 = title.createCell(1);
        HSSFCell title2 = title.createCell(2);
        HSSFCell title3 = title.createCell(3);
        HSSFCell title4 = title.createCell(4);
        HSSFCell title5 = title.createCell(5);
        title0.setCellValue("用户id");
        title1.setCellValue("电话");
        title2.setCellValue("姓名");
        title3.setCellValue("密码");
        title4.setCellValue("注册时间");
        title4.setCellValue("ceshi");

        SimpleDateFormat format = new SimpleDateFormat("yy-mm-dd HH:mm:ss");

        for (int i = 0; i < list.size(); i++) {
            User user = list.get(i);
            HSSFRow row = sheet.createRow(i+1);
            HSSFCell cell0 = row.createCell(0);
            HSSFCell cell1 = row.createCell(1);
            HSSFCell cell2 = row.createCell(2);
            HSSFCell cell3 = row.createCell(3);
            HSSFCell cell4 = row.createCell(4);
            HSSFCell cell5 = row.createCell(5);
            cell0.setCellValue(user.getId());
            cell1.setCellValue(user.getPhone());
            cell2.setCellValue(user.getName());
            cell3.setCellValue(user.getPassWord());
            String time = format.format(user.getRegistrationDate());
            cell4.setCellValue(time);
            cell4.setCellValue(name);
        }

        String fileName = new String("attachment;filename=用户列表.xls".getBytes(StandardCharsets.UTF_8),StandardCharsets.ISO_8859_1);
        ServletOutputStream outputStream = response.getOutputStream();
        //清空缓存
        response.reset();
        //定义浏览器响应表头，顺带定义下载名，比如students
        response.setHeader("Content-disposition", fileName);
        //定义下载的类型，标明是excel文件
        response.setContentType("application/vnd.ms-excel");
        //这时候把创建好的excel写入到输出流
        workbook.write(outputStream);
        outputStream.close();



//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
//        headers.setContentDispositionFormData("attachment",fileName);
//        return new ResponseEntity<>(workbook.getBytes(), headers, HttpStatus.OK);

    }
}
