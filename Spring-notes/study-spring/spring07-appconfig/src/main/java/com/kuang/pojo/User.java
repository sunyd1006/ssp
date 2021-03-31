package com.kuang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author ：ltb
 * @date ：2020/7/14
 */


@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class User {

    @Value("狂神")
    private String name;
}
