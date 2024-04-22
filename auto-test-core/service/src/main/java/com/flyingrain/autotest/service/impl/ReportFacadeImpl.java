package com.flyingrain.autotest.service.impl;

import com.flyingrain.autotest.common.util.AutoTestResultCodeEnum;
import com.flyingrain.autotest.common.util.CommonResult;
import com.flyingrain.autotest.common.util.PageQuery;
import com.flyingrain.autotest.common.util.PageableModel;
import com.flyingrain.autotest.common.util.exception.AutoTestException;
import com.flyingrain.autotest.domain.model.ExecuteReport;
import com.flyingrain.autotest.domain.service.ReportService;
import com.flyingrain.autotest.facade.intf.model.AutoTestReport;
import com.flyingrain.autotest.facade.intf.report.ReportFacade;
import com.flyingrain.autotest.mvc.jersey.Resource;
import com.flyingrain.autotest.service.convert.ReportViewConvert;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.StreamingOutput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.stream.Collectors;

@Component
public class ReportFacadeImpl implements ReportFacade, Resource {

    private final Logger logger = LoggerFactory.getLogger(ReportFacade.class);

    @Autowired
    private ReportService reportService;

    @Override
    public CommonResult<AutoTestReport> queryDetail(Integer id) {
        return CommonResult.success(ReportViewConvert.convertToView(reportService.detail(id)));
    }

    @Override
    public CommonResult<PageableModel<AutoTestReport>> queryReportByPage(PageQuery<AutoTestReport> autoTestReportPageQuery) {
        PageQuery<ExecuteReport> pageQuery = new PageQuery<>(autoTestReportPageQuery.getCurrentPage(), autoTestReportPageQuery.getPageSize(), ReportViewConvert.convertToModel(autoTestReportPageQuery.getConditions()));
        PageableModel<ExecuteReport> reports = reportService.pageQuery(pageQuery);
        PageableModel<AutoTestReport> result = PageableModel.copy(reports);
        result.setData(reports.getData().stream().map(ReportViewConvert::convertToView).collect(Collectors.toList()));
        return CommonResult.success(result);
    }

    @Override
    public CommonResult<Boolean> updateReport(AutoTestReport autoTestReport) {
        logger.info("start to update report :[{}]", autoTestReport);
        reportService.updateReport(ReportViewConvert.convertToModel(autoTestReport));
        return CommonResult.success(true);
    }

    @Override
    public Response generateReportFile(Integer id) {
        try {
            Document document = new Document();
            PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream("test.pdf"));
            document.open();
            document.add(new Paragraph("hello world!"));
            document.close();
            InputStream outputStream = new FileInputStream("test.pdf");
            Response.ResponseBuilder response = Response.ok(outputStream);
            String fileName = "asdf.pdf";
            response.header("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
            return response.build();
        } catch (Exception e) {
            logger.error("create pdf failed!", e);
            throw new AutoTestException(AutoTestResultCodeEnum.FAIL.getCode(), "创建文件失败");
        }
    }
}
