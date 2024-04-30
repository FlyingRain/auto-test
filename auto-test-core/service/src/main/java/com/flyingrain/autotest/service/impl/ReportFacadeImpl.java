package com.flyingrain.autotest.service.impl;

import com.flyingrain.autotest.common.util.*;
import com.flyingrain.autotest.common.util.exception.AutoTestException;
import com.flyingrain.autotest.domain.model.ExecuteReport;
import com.flyingrain.autotest.domain.model.RunLog;
import com.flyingrain.autotest.domain.service.ReportService;
import com.flyingrain.autotest.facade.intf.model.AutoTestReport;
import com.flyingrain.autotest.facade.intf.report.ReportFacade;
import com.flyingrain.autotest.mvc.jersey.Resource;
import com.flyingrain.autotest.service.convert.ReportViewConvert;
import com.itextpdf.kernel.colors.Color;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.HorizontalAlignment;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.UnitValue;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
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
        ExecuteReport executeReport = reportService.detail(id);
        try {

            PdfWriter pdfWriter = new PdfWriter("test.pdf");
            PdfDocument pdfdocument = new PdfDocument(pdfWriter);
            Document document = new Document(pdfdocument, PageSize.A4);
            PdfFont font = PdfFontFactory.createFont("STSongStd-Light", "UniGB-UCS2-H", PdfFontFactory.EmbeddingStrategy.PREFER_NOT_EMBEDDED);

            Paragraph paragraph = new Paragraph("测试报告").setFont(font).setFontColor(new DeviceRgb(39, 157, 241)).setFontSize(20).setTextAlignment(TextAlignment.CENTER).setBold();

            Table summaryTable = createSummaryTable(executeReport);

            document.add(paragraph);
            document.add(summaryTable.setHorizontalAlignment(HorizontalAlignment.CENTER));

            Paragraph tip = new Paragraph("执行流水").setFont(font).setFontSize(16).setFontColor(new DeviceRgb(37, 150, 82)).setTextAlignment(TextAlignment.LEFT).setMarginLeft(10);
            document.add(tip);

            Table logTable = createRunLogTable(executeReport);
            document.add(logTable.setMarginTop(10));
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

    private Table createRunLogTable(ExecuteReport executeReport) throws IOException {
        Table table = new Table(UnitValue.createPercentArray(7));
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        PdfFont font = PdfFontFactory.createFont("STSongStd-Light", "UniGB-UCS2-H", PdfFontFactory.EmbeddingStrategy.PREFER_NOT_EMBEDDED);
        table.setFont(font);
        table.addCell(new Cell().add(new Paragraph("id")).setBold());
        table.addCell(new Cell().add(new Paragraph("执行批次")).setBold());
        table.addCell(new Cell().add(new Paragraph("用例编码")).setBold());
        table.addCell(new Cell().add(new Paragraph("执行状态")).setBold());
        table.addCell(new Cell().add(new Paragraph("耗时(ms)")).setBold());
        table.addCell(new Cell().add(new Paragraph("校验结果")).setBold());
        table.addCell(new Cell().add(new Paragraph("执行时间")).setBold());
        List<RunLog> runLogList = executeReport.getRunLogs();
        if (!CollectionUtils.isEmpty(runLogList)) {
            runLogList.forEach(runLog -> {
                table.addCell(new Cell().add(new Paragraph(String.valueOf(runLog.getId()))));
                table.addCell(new Cell().add(new Paragraph(runLog.getBatchNum())));
                table.addCell(new Cell().add(new Paragraph(runLog.getCaseCode())));
                if (RunStatusEnum.SUCCESS.getCode().equals(runLog.getRunStatus())) {
                    table.addCell(new Cell().add(new Paragraph("成功").setFontColor(new DeviceRgb(8, 214, 8))));
                }else if(RunStatusEnum.FAIL.getCode().equals(runLog.getRunStatus())){
                    table.addCell(new Cell().add(new Paragraph("失败")).setFontColor(new DeviceRgb(255, 17, 17)));
                }else if(RunStatusEnum.EXECUTING.getCode().equals(runLog.getRunStatus())){
                    table.addCell(new Cell().add(new Paragraph("执行中").setFontColor(new DeviceRgb(0, 0, 238))));
                }
                table.addCell(new Cell().add(new Paragraph(String.valueOf(runLog.getCaseSpendTime()))));
                table.addCell(new Cell().add(new Paragraph(StringUtils.hasText(runLog.getMessage())?runLog.getMessage():"")));
                table.addCell(new Cell().add(new Paragraph(dateFormat.format(runLog.getExecuteTime()))));
            });

        }
        return table;
    }

    private Table createSummaryTable(ExecuteReport executeReport) throws IOException {
        Table table = new Table(UnitValue.createPercentArray(2));
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Cell cell = new Cell(1, 1).setBorder(new SolidBorder(1f));
        Color black = new DeviceRgb(0, 0, 0);
        cell.add(PDFWriteHelper.createRectangle("测试人员", executeReport.getOperator(), black, new DeviceRgb(39, 157, 241)));
        table.addCell(cell);

        table.addCell(new Cell().add(PDFWriteHelper.createRectangle("用例总数", String.valueOf(executeReport.getCaseNumber()), black, new DeviceRgb(39, 157, 241))));
        table.addCell(new Cell().add(PDFWriteHelper.createRectangle("执行时间", dateFormat.format(executeReport.getExecuteTime()), black, new DeviceRgb(39, 157, 241))));
        table.addCell(new Cell().add(PDFWriteHelper.createRectangle("成功数量", String.valueOf(executeReport.getSuccessNumber()), black, new DeviceRgb(61, 232, 64))));
        table.addCell(new Cell().add(PDFWriteHelper.createRectangle("执行耗时", String.valueOf(executeReport.getConsumeTime()) + "ms", black, new DeviceRgb(39, 157, 241))));
        table.addCell(new Cell().add(PDFWriteHelper.createRectangle("失败数量", String.valueOf(executeReport.getCaseNumber() - executeReport.getSuccessNumber()), black, new DeviceRgb(255, 0, 0))));
        table.addCell(new Cell().add(PDFWriteHelper.createRectangle("执行环境", String.valueOf(executeReport.getEnv()), black, new DeviceRgb(39, 157, 241))));
        if (RunStatusEnum.SUCCESS.getCode().equals(executeReport.getResult())) {
            table.addCell(new Cell().add(PDFWriteHelper.createRectangle("最终结论", "通过", new DeviceRgb(8, 214, 8), new DeviceRgb(39, 157, 241))));
        } else if (RunStatusEnum.FAIL.getCode().equals(executeReport.getResult())) {
            table.addCell(new Cell().add(PDFWriteHelper.createRectangle("最终结论", "不通过", new DeviceRgb(255, 17, 17), new DeviceRgb(39, 157, 241))));
        } else if (RunStatusEnum.EXECUTING.getCode().equals(executeReport.getResult())) {
            table.addCell(new Cell().add(PDFWriteHelper.createRectangle("最终结论", "执行中", new DeviceRgb(0, 0, 238), new DeviceRgb(39, 157, 241))));
        }
        table.addCell(new Cell(1, 2).add(PDFWriteHelper.createRectangle("本次总结", String.valueOf(executeReport.getDesc()), black, new DeviceRgb(39, 157, 241))));
        return table;
    }
}
