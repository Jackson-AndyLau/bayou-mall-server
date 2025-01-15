package com.huazai.bayou.product.controller;

import com.huazai.bayou.common.enums.ResponseCodeEnum;
import com.huazai.bayou.common.utils.PageUtils;
import com.huazai.bayou.common.utils.R;
import com.huazai.bayou.product.entity.BrandEntity;
import com.huazai.bayou.product.service.BrandService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 * 品牌
 * <p>
 * {@code @author by} HuaZai
 * {@code @email} who.seek.me@java98k.vip
 * {@code @date} 2024-07-15
 */
@RestController
@RequestMapping("product/brand")
public class BrandController {
    @Autowired
    private BrandService brandService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = brandService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{brandId}")
    public R info(@PathVariable("brandId") Long brandId) {
        BrandEntity brand = brandService.getById(brandId);

        return R.ok().put("brand", brand);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@Valid @RequestBody BrandEntity brand, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, Object> validMap = new HashMap<>();
            bindingResult.getFieldErrors().forEach(result -> {
                String field = result.getField();
                String message = result.getDefaultMessage();

                validMap.put(field, message);
            });
            return R.error(ResponseCodeEnum.COMMON_FAILED.getCode(), "保存的产品信息不合法，请修改后重新提交！").put(validMap);
        } else {

            brandService.save(brand);
        }
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody BrandEntity brand) {
        brandService.updateById(brand);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] brandIds) {
        brandService.removeByIds(Arrays.asList(brandIds));

        return R.ok();
    }

}
