package com.kuang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author ：ltb
 * @date ：2020/7/14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class People {

    @Autowired
    private Cat cat;
    @Autowired
    private Dog dog;
    private String name;
}
