package com.example.demo.param.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @version 1.0
 * @Author chenglong
 * @className CreateProgrammerRequest
 * @Description
 * @Date 2025-07-22
 */
@Setter
@Getter
@Schema(description = "创建程序员入参")
public class CreateProgrammerRequest {
    @NotNull
    @Schema(description = "名称", example = "王二狗")
    private String name;

    @NotNull
    @Min(18)
    @Max(35)
    @Schema(description = "年龄", example = "35")
    private Integer age;

    @Schema(description = "掌握的编程语言", type = "List", example = "[\"Java\",\"Sql\"]")
    private List<String> programmingLang;
}