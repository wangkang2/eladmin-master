package com.wk.modules.shop.rest;

import com.wk.annotation.Log;
import com.wk.base.BaseEntity;
import com.wk.exception.BadRequestException;
import com.wk.modules.shop.domain.Box;
import com.wk.modules.shop.service.BoxService;
import com.wk.modules.shop.service.dto.BoxQueryCriteria;
import com.wk.modules.system.domain.Job;
import com.wk.modules.system.service.dto.JobQueryCriteria;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@Api(tags = "盲盒：盲盒管理")
@RequestMapping("/api/box")
public class BoxController {

    private final BoxService boxService;
    private static final String ENTITY_NAME = "box";

    @ApiOperation("导出盲盒数据")
    @GetMapping(value = "/download")
    @PreAuthorize("@el.check('box:list')")
    public void exportBox(HttpServletResponse response, BoxQueryCriteria criteria) throws IOException {
        boxService.download(boxService.queryAll(criteria), response);
    }

    @ApiOperation("查询盲盒")
    @GetMapping
    @PreAuthorize("@el.check('box:list')")
    public ResponseEntity<Object> queryBox(BoxQueryCriteria criteria, Pageable pageable){
        return new ResponseEntity<>(boxService.queryAll(criteria, pageable), HttpStatus.OK);
    }

    @Log("新增盲盒")
    @ApiOperation("新增盲盒")
    @PostMapping
    @PreAuthorize("@el.check('box:add')")
    public ResponseEntity<Object> createBox(@Validated @RequestBody Box resources){
        if (resources.getId() != null) {
            throw new BadRequestException("A new "+ ENTITY_NAME +" cannot already have an ID");
        }
        boxService.create(resources);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Log("修改盲盒")
    @ApiOperation("修改盲盒")
    @PutMapping
    @PreAuthorize("@el.check('box:edit')")
    public ResponseEntity<Object> updateBox(@Validated(BaseEntity.Update.class) @RequestBody Box resources){
        boxService.update(resources);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Log("删除盲盒")
    @ApiOperation("删除盲盒")
    @DeleteMapping
    @PreAuthorize("@el.check('box:del')")
    public ResponseEntity<Object> deleteBox(@RequestBody Set<Long> ids){
        boxService.delete(ids);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
