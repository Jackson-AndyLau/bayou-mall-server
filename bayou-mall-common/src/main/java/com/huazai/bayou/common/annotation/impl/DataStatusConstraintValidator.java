package com.huazai.bayou.common.annotation.impl;

import com.huazai.bayou.common.annotation.valid.DataStatusValid;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.util.ObjectUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * ClassName: DataStatusConstraintValidator
 * Package: com.huazai.bayou.common.annotaion.impl
 * Description:
 *
 * @Author HuaZai
 * @Create 2025-01-16 11:20
 * @Version 1.0
 */
public class DataStatusConstraintValidator implements ConstraintValidator<DataStatusValid, Integer> {

    private Set<Integer> val = new HashSet<>();

    /**
     * 初始化数据
     *
     * @param constraintAnnotation annotation instance for a given constraint declaration
     */
    @Override
    public void initialize(DataStatusValid constraintAnnotation) {
        int[] values = constraintAnnotation.values();

        if (Optional.ofNullable(values).isPresent()) {
            Arrays.stream(values).forEach(value -> val.add(value));
        } else {

        }
    }

    /**
     * 数据合法性校验
     *
     * @param value   object to validate 需要检验的值
     * @param context context in which the constraint is evaluated
     * @return
     */
    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {

        if (ObjectUtils.isEmpty(value)) {

            return false;
        } else {

            return this.val.contains(value);
        }
    }
}
