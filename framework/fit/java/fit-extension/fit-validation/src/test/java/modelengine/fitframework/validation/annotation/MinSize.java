/*---------------------------------------------------------------------------------------------
 *  Copyright (c) 2025 Huawei Technologies Co., Ltd. All rights reserved.
 *  This file is a part of the ModelEngine Project.
 *  Licensed under the MIT License. See License.txt in the project root for license information.
 *--------------------------------------------------------------------------------------------*/

package modelengine.fitframework.validation.annotation;

import modelengine.fitframework.validation.Validated;
import modelengine.fitframework.validation.constraints.Constraint;
import modelengine.fitframework.validation.validator.MinSizeValidator;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 表示集合元素数量限制的测试注解类。
 *
 * @author 李金绪
 * @since 2025-03-17
 */
@Retention(RetentionPolicy.RUNTIME)
@Constraint({MinSizeValidator.class})
@Validated
public @interface MinSize {
    /**
     * 表示集合元素的大小的下限值。
     *
     * @return 表示集合元素的大小的下限值的 {@code long}。
     */
    long min();

    /**
     * 表示校验失败的信息。
     *
     * @return 表示校验失败的信息的 {@link String}。
     */
    String message() default "must be greater than the minimum value.";

    /**
     * 表示校验的分组。
     *
     * @return 表示校验分组的 {@link Class}{@code <?>[]}。
     */
    Class<?>[] groups() default {};
}