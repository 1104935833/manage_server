package hxc.manage.common.poi;

import hxc.manage.model.*;
import org.apache.poi.hpsf.DocumentSummaryInformation;
import org.apache.poi.hpsf.SummaryInformation;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hxc
 * @version 1.0
 * @date 2019/12/11 11:05
 */
public class PoiUtils {
    //导出数据
    public static ResponseEntity<byte[]> exportEmp2Excel(List<UserDetail> emps) {
        HttpHeaders headers = null;
        ByteArrayOutputStream baos = null;
        try {
            //1.创建Excel文档
            HSSFWorkbook workbook = new HSSFWorkbook();
            //2.创建文档摘要
            workbook.createInformationProperties();
            //3.获取文档信息，并配置
            DocumentSummaryInformation dsi = workbook.getDocumentSummaryInformation();
            //3.1文档类别
            dsi.setCategory("教师信息");
            //3.2设置文档管理员
            dsi.setManager("教师业绩管理");
            //3.3设置组织机构
            dsi.setCompany("XXX集团");
            //4.获取摘要信息并配置
            SummaryInformation si = workbook.getSummaryInformation();
            //4.1设置文档主题
            si.setSubject("教师信息表");
            //4.2.设置文档标题
            si.setTitle("教师信息");
            //4.3 设置文档作者
            si.setAuthor("教师业绩管理");
            //4.4设置文档备注
            si.setComments("备注信息暂无");
            //创建Excel表单
            HSSFSheet sheet = workbook.createSheet("教师信息表");
            //创建日期显示格式
            HSSFCellStyle dateCellStyle = workbook.createCellStyle();
            dateCellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy"));
            //创建标题的显示样式
            HSSFCellStyle headerStyle = workbook.createCellStyle();
            headerStyle.setFillForegroundColor(IndexedColors.YELLOW.index);
            headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            //定义列的宽度
            sheet.setColumnWidth(0, 10 * 256);
            sheet.setColumnWidth(1, 12 * 256);
            sheet.setColumnWidth(2, 10 * 256);
            sheet.setColumnWidth(3, 10 * 256);
            sheet.setColumnWidth(4, 12 * 256);
            sheet.setColumnWidth(5, 10 * 256);
            sheet.setColumnWidth(6, 10 * 256);
            sheet.setColumnWidth(7, 10 * 256);
//            sheet.setColumnWidth(8, 16 * 256);
            //5.设置表头
            HSSFRow headerRow = sheet.createRow(0);
            HSSFCell cell0 = headerRow.createCell(0);
            cell0.setCellValue("工号");
            cell0.setCellStyle(headerStyle);
            HSSFCell cell1 = headerRow.createCell(1);
            cell1.setCellValue("姓名");
            cell1.setCellStyle(headerStyle);
            HSSFCell cell2 = headerRow.createCell(2);
            cell2.setCellValue("电话号码");
            cell2.setCellStyle(headerStyle);
            HSSFCell cell3 = headerRow.createCell(3);
            cell3.setCellValue("电子邮件");
            cell3.setCellStyle(headerStyle);
            HSSFCell cell4 = headerRow.createCell(4);
            cell4.setCellValue("性别");
            cell4.setCellStyle(headerStyle);
            HSSFCell cell5 = headerRow.createCell(5);
            cell5.setCellValue("是否有效");
            cell5.setCellStyle(headerStyle);
            HSSFCell cell6 = headerRow.createCell(6);
            cell6.setCellValue("办公室");
            cell6.setCellStyle(headerStyle);
            HSSFCell cell7 = headerRow.createCell(7);
            cell7.setCellValue("教研室");
            cell7.setCellStyle(headerStyle);

            //6.装数据
            for (int i = 0; i < emps.size(); i++) {
                HSSFRow row = sheet.createRow(i + 1);
                UserDetail emp = emps.get(i);
                row.createCell(0).setCellValue(emp.getWorkID());
                row.createCell(1).setCellValue(emp.getName());
                row.createCell(2).setCellValue(emp.getPhone());
                row.createCell(3).setCellValue(emp.getEmail());
//                HSSFCell birthdayCell = row.createCell(3);
//                birthdayCell.setCellValue(emp.getOffice_id());
//                birthdayCell.setCellStyle(dateCellStyle);
                row.createCell(4).setCellValue(emp.getGender().equals("1")?"男":"女");
                row.createCell(5).setCellValue(emp.getEnable()==1?"有效":"无效");
                row.createCell(6).setCellValue(emp.getOffice_id());
                row.createCell(7).setCellValue(emp.getDepartment());
            }
            headers = new HttpHeaders();
            headers.setContentDispositionFormData("attachment",
                    new String("员工表.xls".getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1));
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            baos = new ByteArrayOutputStream();
            workbook.write(baos);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<byte[]>(baos.toByteArray(), headers, HttpStatus.CREATED);
    }

    //导入数据
    public static List<UserDetail> importEmp2List(MultipartFile file) {


        List<UserDetail> emps = new ArrayList<>();
        try {
            HSSFWorkbook workbook =
                    new HSSFWorkbook(new POIFSFileSystem(file.getInputStream()));
            int numberOfSheets = workbook.getNumberOfSheets();
            for (int i = 0; i < numberOfSheets; i++) {
                HSSFSheet sheet = workbook.getSheetAt(i);
                int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
                UserDetail userDetail;
                for (int j = 0; j < physicalNumberOfRows; j++) {
                    if (j == 0) {
                        continue;//标题行
                    }
                    HSSFRow row = sheet.getRow(j);
                    if (row == null) {
                        continue;//没数据
                    }
                    int physicalNumberOfCells = row.getPhysicalNumberOfCells();
                    userDetail = new UserDetail();
                    for (int k = 0; k < physicalNumberOfCells; k++) {
                        HSSFCell cell = row.getCell(k);
                        switch (cell.getCellTypeEnum()) {
                            case STRING: {
                                String cellValue = cell.getStringCellValue();
                                if (cellValue == null) {
                                    cellValue = "";
                                }
                                switch (k) {

                                    case 0:
                                        userDetail.setName(cellValue);
                                        break;
                                    case 1:
                                        if (cellValue.equals("男"))
                                            userDetail.setGender("1");
                                        else
                                            userDetail.setGender("0");
                                        break;
                                    case 2:
                                        userDetail.setEmail(cellValue);
                                        break;

                                    case 4:
                                        switch (cellValue){
                                            case "计算机教研室":
                                                userDetail.setTree("0101");
                                                break;
                                            case "机械教研室":
                                                userDetail.setTree("0102");
                                                break;
                                            case "工业教研室":
                                                userDetail.setTree("0103");
                                                break;
                                            case "电子教研室":
                                                userDetail.setTree("0104");
                                                break;
                                            case "高分子教研室":
                                                userDetail.setTree("0105");
                                                break;
                                            case "数学教研室":
                                                userDetail.setTree("0106");
                                                break;
                                            case "应化教研室":
                                                userDetail.setTree("0107");
                                                break;
                                        }
                                        break;
                                }
                            }
                            break;
                            default: {
                                switch (k) {

                                    case 3:
                                        userDetail.setPhone((int) cell.getNumericCellValue() + "");
                                        break;
//                case 1:
//                    SimpleDateFormat sdf = new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy",Locale.US);
//                    Date d = sdf.parse(cell.getDateCellValue().toString());
//                    userDetail.setOffice_id(d.getTime()+"");
//                    break;
                                }
                            }
                            break;
                        }
                    }
                    emps.add(userDetail);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
        return emps;
    }

    //    模板下载
    public static ResponseEntity<byte[]> template() {
        HttpHeaders headers = null;
        ByteArrayOutputStream baos = null;
        try {
            //1.创建Excel文档
            HSSFWorkbook workbook = new HSSFWorkbook();
            //2.创建文档摘要
            workbook.createInformationProperties();
            //3.获取文档信息，并配置
            DocumentSummaryInformation dsi = workbook.getDocumentSummaryInformation();
            //3.1文档类别
            dsi.setCategory("教师信息");
            //3.2设置文档管理员
            dsi.setManager("教师业绩管理");
            //3.3设置组织机构
            dsi.setCompany("XXX集团");
            //4.获取摘要信息并配置
            SummaryInformation si = workbook.getSummaryInformation();
            //4.1设置文档主题
            si.setSubject("教师信息表");
            //4.2.设置文档标题
            si.setTitle("教师信息");
            //4.3 设置文档作者
            si.setAuthor("教师业绩管理");
            //4.4设置文档备注
            si.setComments("备注信息暂无");
            //创建Excel表单
            HSSFSheet sheet = workbook.createSheet("教师信息表");
            //创建日期显示格式
            HSSFCellStyle dateCellStyle = workbook.createCellStyle();
            dateCellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy"));
            //创建标题的显示样式
            HSSFCellStyle headerStyle = workbook.createCellStyle();
            headerStyle.setFillForegroundColor(IndexedColors.YELLOW.index);
            headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            //定义列的宽度
            sheet.setColumnWidth(0, 5 * 256);
            sheet.setColumnWidth(1, 5 * 256);
            sheet.setColumnWidth(2, 10 * 256);
            sheet.setColumnWidth(3, 10 * 256);
            sheet.setColumnWidth(4, 20 * 256);
//            sheet.setColumnWidth(6, 10 * 256);
//            sheet.setColumnWidth(7, 10 * 256);
//            sheet.setColumnWidth(8, 16 * 256);
            //5.设置表头
            HSSFRow headerRow = sheet.createRow(0);
            HSSFCell cell0 = headerRow.createCell(0);
            cell0.setCellValue("姓名");
            cell0.setCellStyle(headerStyle);
//            HSSFCell cell1 = headerRow.createCell(1);
//            cell1.setCellValue("工号");
//            cell1.setCellStyle(headerStyle);
            HSSFCell cell1 = headerRow.createCell(1);
            cell1.setCellValue("性别");
            cell1.setCellStyle(headerStyle);
//            HSSFCell cell3 = headerRow.createCell(3);
//            cell3.setCellValue("出生日期");
//            cell3.setCellStyle(headerStyle);
//            HSSFCell cell4 = headerRow.createCell(4);
//            cell4.setCellValue("身份证号码");
//            cell4.setCellStyle(headerStyle);
            HSSFCell cell2 = headerRow.createCell(2);
            cell2.setCellValue("电子邮件");
            cell2.setCellStyle(headerStyle);
            HSSFCell cell3 = headerRow.createCell(3);
            cell3.setCellValue("电话号码");
            cell3.setCellStyle(headerStyle);
            HSSFCell cell4 = headerRow.createCell(4);
            cell4.setCellValue("所在教研室");
            cell4.setCellStyle(headerStyle);
//            HSSFCell cell5 = headerRow.createCell(4);
//            cell5.setCellValue("是否有效");
//            cell5.setCellStyle(headerStyle);
            //6.装数据
            HSSFRow row = sheet.createRow(1);
            row.createCell(0).setCellValue("");
            row.createCell(1).setCellValue("");
            row.createCell(2).setCellValue("");
            row.createCell(3).setCellValue("");
//                HSSFCell birthdayCell = row.createCell(4);
//                birthdayCell.setCellValue("");
//                birthdayCell.setCellStyle(dateCellStyle);
            row.createCell(4).setCellValue("");
//                row.createCell(6).setCellValue("");
//                row.createCell(7).setCellValue("");
//                row.createCell(8).setCellValue("");

            headers = new HttpHeaders();
            headers.setContentDispositionFormData("attachment",
                    new String("员工表.xls".getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1));
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            baos = new ByteArrayOutputStream();
            workbook.write(baos);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<byte[]>(baos.toByteArray(), headers, HttpStatus.CREATED);
    }


}
