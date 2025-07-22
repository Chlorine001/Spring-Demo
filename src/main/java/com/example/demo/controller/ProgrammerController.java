package com.example.demo.controller;

import com.example.demo.entity.Programmer;
import com.example.demo.param.request.CreateProgrammerRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * @Author chenglong
 * @version 1.0
 * @className ProgrammerController
 * @Description 
 * @Date 2025-07-22
 */

@Tag(name = "程序员", description = "程序员乐园")
@RestController
@RequestMapping("/api/programmers")
public class ProgrammerController {
    @GetMapping("/{id}")
    public Programmer getProgrammer(@Parameter(description = "程序员id") @PathVariable Integer id) {
        return new Programmer(1, "id测试用户",35, Arrays.asList("Java,Python,SQL"));
    }

    @Parameters(value = {
            @Parameter(name = "name", description = "姓名", in = ParameterIn.PATH),
            @Parameter(name = "age", description = "年龄", in = ParameterIn.QUERY)
    })
    @GetMapping("/{name}")
    public List<Programmer> getProgrammers(@PathVariable("name") String name, @RequestParam("age") Integer age) {
        return Arrays.asList(new Programmer(2, "姓名测试用户",35, Arrays.asList("Java,Python,SQL")));
    }
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "成功",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Programmer.class))}),
            @ApiResponse(responseCode = "405", description = "非法输入",
                    content = @Content)
    })
    @Operation(summary = "创建程序员", description = "用于创建一个闷骚的程序员")
    @PostMapping()
    public Programmer createProgrammer(@RequestBody CreateProgrammerRequest request) {
        return new Programmer(3, "创建测试用户", request.getAge(), request.getProgrammingLang());
    }

}