package com.wk.modules.shop.rest;

import com.wk.modules.shop.service.BoxService;
import com.wk.modules.shop.service.dto.BoxQueryCriteria;
import com.wk.modules.system.service.dto.JobQueryCriteria;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Api(tags = "盲盒：盲盒管理")
@RequestMapping("/api/box")
public class BoxController {

    private final BoxService boxService;

    @ApiOperation("查询盲盒")
    @GetMapping
    @PreAuthorize("@el.check('box:list')")
    public ResponseEntity<Object> queryBox(BoxQueryCriteria criteria, Pageable pageable){
        return new ResponseEntity<>(boxService.queryAll(criteria, pageable), HttpStatus.OK);
    }
}
